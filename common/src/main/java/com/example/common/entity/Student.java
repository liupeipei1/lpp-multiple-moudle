package com.example.common.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;

@Data
@ApiModel(value = "查询学生实体", description = "查询学生信息")
public class Student {
    /*
     * @Excel:
     *       name:指excel报表中的标题
     *       width:指这一列单元格占多少宽度
     * 一般只设置name属性即可
     *
     * */
    private int id;
    @Excel(name="学生名字",width = 100)
    private String name;
    @Excel(name="年龄",width = 100)
    private int age;
    @Excel(name="课程",width = 100)
    private String course;

}
