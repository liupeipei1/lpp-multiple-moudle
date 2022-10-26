package com.example.common.Config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.SQLException;

/*
刘佩佩
2021/6/17
*/
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void setDataSource() throws SQLException {
        System.out.printf("!!" + dataSource.getConnection());
    }


}
