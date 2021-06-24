package com.example.Response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/*
刘佩佩
2021/6/17
*/
@Data
@ApiModel(value = "查询Userinfo实体",description = "查询Userinfo")
public class Userinfo {
    private int id;
    private  String usernam;
    private  String userpwd;
    private  String Email;
    private Date   regdate;
}
