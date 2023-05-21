package com.example.common.entity;

import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

import java.io.Serializable;
import java.util.List;

@Data
public class CourseEntity implements Serializable {
    /** 主键 */
    private String id;
    /** 课程名称 */
    @Excel(name = "课程名称", orderNum = "1", needMerge = true)
    private String name;

    @ExcelCollection(name = "选课学生", orderNum = "4")
    private List<Student> students;
}
