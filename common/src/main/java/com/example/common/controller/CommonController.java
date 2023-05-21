package com.example.common.controller;
import com.example.common.entity.Student;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
/*
用于常用的接口调用
1. redis调用
2. excel的导入导出功能
3.
 */

@RestController
public class CommonController {

    @RequestMapping("/toImport")
    public String toImport(){
        return "importExcel";
    }

    @RequestMapping("/importExcel")
    public String importExcel(@RequestParam("file") MultipartFile file) {
        List<Student> Students = null;
        try {
            ImportParams params = new ImportParams();
            //表格标题所在行，计数从0开始
            params.setTitleRows(1);
            //head头部所在行，计数从0开始
            params.setHeadRows(1);
            //表格sheet数量
            params.setSheetNum(1);
            InputStream inputStream = null;
            inputStream = file.getInputStream();
            Students = ExcelImportUtil.importExcel(inputStream, Student.class, params);
            //把导入的信息输出到控制台
            for(Student student:Students) {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "importExcel";
    }

}
