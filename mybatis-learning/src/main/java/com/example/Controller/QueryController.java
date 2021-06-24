package com.example.Controller;

import com.example.Dao.master.StudentMapper;
import com.example.Dao.second.UserMaper;
import com.example.Response.ClientDTo;
import com.example.Response.Student;
import com.example.Response.Userinfo;
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

    /*@Autowired
     private StudentMapper studentMapper;
*/

    @ApiOperation(value = "查询接口", httpMethod = "GET", notes = "json查询") //注意这里的httpMethod=后面是必须大写 不能写成Get 否则后台报错
    @GetMapping("/bb")
    public ClientDTo aa(@RequestBody @Validated ClientDTo clientDTo) {
        return clientDTo;
    }


   /* @ApiOperation(value = "查询接口", httpMethod = "GET", notes = "查询学生信息")
    @GetMapping("/getStudent")
    public List<Student> getstudent(@PathVariable(name = "name") String name) {
       return studentMapper.getStudent(name);
    }
*/

    @ApiOperation(value = "查询用户信息", httpMethod = "GET", notes = "查询用户信息接口")
    @GetMapping("/getUser")
    public List<Userinfo> getUser(@PathVariable(name = "name")  String  name) {
       return userMaper.getUser(name);
    }

}
