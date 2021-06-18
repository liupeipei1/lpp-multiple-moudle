package com.example.Controller;

import com.example.Dto.ClientDTo;
import com.example.Dto.StudentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "本地接口文档",value = "/aa", description = "本地接口文档")
@RestController
public class TestController {

    @Resource
    private com.example.Service.DoService DoService;

    @ApiOperation(value = "查询接口",httpMethod = "Get",notes = "查询客户信息接口")
    @GetMapping("/aa")
    public StudentResponse aa(@RequestBody  @Validated ClientDTo clientDTo){
        return  DoService.getStudent(clientDTo);
    }

}
