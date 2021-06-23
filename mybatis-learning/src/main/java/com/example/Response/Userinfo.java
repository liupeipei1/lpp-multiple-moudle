package com.example.Response;

import lombok.Data;

import java.util.Date;

/*
刘佩佩
2021/6/17
*/
@Data
public class Userinfo {
    private int id;
    private  String usernam;
    private  String userpwd;
    private  String Email;
    private Date   regdate;
}
