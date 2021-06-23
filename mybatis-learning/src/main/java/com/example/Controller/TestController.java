package com.example.Controller;
import com.example.Response.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "本地接口文档",value = "/aa", description = "本地接口文档")
@RestController
public class TestController {

    @Resource
    private com.example.Service.DoService DoService;

    @ApiOperation(value = "查询接口",httpMethod = "Get",notes = "查询学生信息")
    @GetMapping("/getStudent")
    public List<Student> aa(@RequestBody  @Validated String  name){
        return  DoService.getStudent(name);
    }

}
