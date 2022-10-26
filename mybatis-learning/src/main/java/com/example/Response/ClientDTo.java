package com.example.Response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "查询客户信息实体", description = "查询客户信息实体")
public class ClientDTo {

    @ApiModelProperty(value = "id")
    private int id;

    @ApiModelProperty(value = "name名字")
    private String name;

    @ApiModelProperty(value = "age年龄")
    private int age;
}
