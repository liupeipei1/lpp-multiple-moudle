package com.example.springbootproject.Controller;

import com.example.springbootproject.Request.ClientDTo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "其他接口文档", value = "/bb", description = "其他接口文档")
@RestController
public class QueryController {

    @ApiOperation(value = "查询接口2", httpMethod = "Get", notes = "查询客户信息接口")
    @GetMapping("/bb")
    public String aa(@RequestBody @Validated ClientDTo ClientDTo) {
        return "12347";
    }
}
