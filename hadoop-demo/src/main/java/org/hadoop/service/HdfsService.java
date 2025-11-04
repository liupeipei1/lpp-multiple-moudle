package org.hadoop.service;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HdfsService {

    @Autowired
    private FileSystem fileSystem;

    // 创建目录
    public boolean createDirectory(String path) throws IOException {
        return fileSystem.mkdirs(new Path(path));
    }

    // 上传文件
    public void uploadFile(String localPath, String hdfsPath) throws IOException {
        fileSystem.copyFromLocalFile(new Path(localPath), new Path(hdfsPath));
    }

    // 下载文件
    public void downloadFile(String hdfsPath, String localPath) throws IOException {
        fileSystem.copyToLocalFile(false, new Path(hdfsPath), new Path(localPath), true);
    }

    // 读取文件内容
    public String readFile(String path) throws IOException {
        Path hdfsPath = new Path(path);
        try (FSDataInputStream inputStream = fileSystem.open(hdfsPath)) {
            return new String(inputStream.readAllBytes());
        }
    }

    // 列出目录内容
    public List<String> listDirectory(String path) throws IOException {
        List<String> fileList = new ArrayList<>();
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path(path));
        for (FileStatus status : fileStatuses) {
            fileList.add(status.getPath().toString());
        }
        return fileList;
    }

    // 删除文件或目录
    public boolean delete(String path, boolean recursive) throws IOException {
        return fileSystem.delete(new Path(path), recursive);
    }
}
