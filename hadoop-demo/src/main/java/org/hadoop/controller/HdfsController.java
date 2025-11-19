package org.hadoop.controller;

import org.hadoop.service.HdfsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/hdfs")
public class HdfsController {

    @Autowired
    private HdfsService hdfsService;

    // 创建目录
    @PostMapping("/directory")
    public ResponseEntity<String> createDirectory(@RequestParam String path) {
        try {
            boolean result = hdfsService.createDirectory(path);
            return result ? ResponseEntity.ok("目录创建成功") :
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("目录创建失败");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("错误: " + e.getMessage());
        }
    }

    // 上传文件
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam String hdfsPath) {
        try {
            String tempFilePath = "/tmp/" + file.getOriginalFilename();
            file.transferTo(new java.io.File(tempFilePath));
            hdfsService.uploadFile(tempFilePath, hdfsPath);
            java.io.File tempFile = new java.io.File(tempFilePath);
            tempFile.delete();
            return ResponseEntity.ok("文件上传成功");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("错误: " + e.getMessage());
        }
    }

    // 下载文件
    @GetMapping("/download")
    public ResponseEntity<String> downloadFile(@RequestParam String hdfsPath,
                                               @RequestParam String localPath) {
        try {
            hdfsService.downloadFile(hdfsPath, localPath);
            return ResponseEntity.ok("文件下载成功");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("错误: " + e.getMessage());
        }
    }

    // 读取文件内容
    @GetMapping("/read")
    public ResponseEntity<String> readFile(@RequestParam String path) {
        try {
            String content = hdfsService.readFile(path);
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("错误: " + e.getMessage());
        }
    }

    // 列出目录内容
    @GetMapping("/list")
    public ResponseEntity<List<String>> listDirectory(@RequestParam String path) {
        try {
            List<String> fileList = hdfsService.listDirectory(path);
            return ResponseEntity.ok(fileList);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 删除文件或目录
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam String path,
                                         @RequestParam(defaultValue = "false") boolean recursive) {
        try {
            boolean result = hdfsService.delete(path, recursive);
            return result ? ResponseEntity.ok("删除成功") :
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("删除失败");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("错误: " + e.getMessage());
        }
    }
}