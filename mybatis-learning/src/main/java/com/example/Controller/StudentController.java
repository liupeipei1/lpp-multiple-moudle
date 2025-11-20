package com.example.Controller;

import com.example.Entity.Student;
import com.example.Service.DoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Api(tags = "本地接口文档", value = "/aa", description = "本地接口文档")
@RestController
public class StudentController {

    @Resource
    private DoService doService;

    @ApiOperation(value = "新增学生", httpMethod = "POST", notes = "新增学生信息")
    @PostMapping("/addStudent")
    public void insertStudent(@RequestBody @Validated Student student) {
        doService.insertStudent(student);
    }

    @ApiOperation(value = "修改学生", httpMethod = "POST", notes = "修改学生信息")
    @PostMapping("/updateStudent")
    public void updateStudent(@RequestBody @Validated Student student) {
        doService.updateStudent(student);
    }

    @ApiOperation(value = "删除学生信息", httpMethod = "POST")
    @PostMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable(value = "id") int id) {
        doService.deleteStudent(id);
    }

}
