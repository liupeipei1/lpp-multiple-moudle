package com.example.Controller;

import com.example.Dao.second.UserMaper;
import com.example.Entity.ClientDTo;
import com.example.Response.StudentResp;
import com.example.Entity.Userinfo;
import com.example.Service.DoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "查询接口文档", value = "/test", description = "只是用于查询的接口")
@RestController
public class QueryController {

    @Autowired
    private UserMaper userMaper;

    @Resource
    private DoService doService;


    @ApiOperation(value = "查询接口", httpMethod = "GET", notes = "json查询") //注意这里的httpMethod=后面是必须大写 不能写成Get 否则后台报错
    @GetMapping("/getClientDto")
    public ClientDTo getClientDTo(@RequestBody @Validated ClientDTo clientDTo) {
        return clientDTo;
    }


    @ApiOperation(value = "查询studnet接口", httpMethod = "GET", notes = "查询学生信息", response = StudentResp.class)
    @GetMapping("/getStudent/{name}")
    public StudentResp getStudent(@RequestBody @PathVariable(name = "name") String name) {
        StudentResp studentResp = new StudentResp();
        studentResp.setStudent(doService.getStudent(name));
        return studentResp;
    }


    @ApiOperation(value = "查询用户信息", httpMethod = "GET", notes = "查询用户信息接口")
    @GetMapping("/getUser/{name}")//PathVariable用于地址上输入即可
    public List<Userinfo> getUser(@RequestBody @PathVariable(value = "name") String name) {
        return userMaper.getUser(name);
    }

}
