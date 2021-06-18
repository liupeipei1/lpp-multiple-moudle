package com.example.Controller;

import com.example.Dao.UserMaper;
import com.example.Dto.Userinfo;
import com.example.Dto.ClientDTo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "其他接口文档", value = "/bb", description = "其他接口文档")
@RestController
public class QueryController {

     @Resource
     private UserMaper userMaper;


    @ApiOperation(value = "查询接口2", httpMethod = "Get", notes = "查询客户信息接口")
    @GetMapping("/bb")
    public String aa(@RequestBody @Validated ClientDTo ClientDTo) {
        return "12347";
    }


    @ApiOperation(value = "查询用户信息", httpMethod = "Get", notes = "查询用户信息接口")
    @GetMapping("/getUser")
    public List<Userinfo> getUser(@PathVariable(name = "name")  String  name) {
       return userMaper.getUser(name);
    }

}
