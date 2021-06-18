package com.example.config.mybatis例子;

import com.example.Dao.UserMaper;
import com.example.Dto.Userinfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
创建SqlSessionFactoryBuilder对象，调用build(inputstream)方法读取并解析配置文件，返回SqlSessionFactory对象
由SqlSessionFactory创建SqlSession 对象，没有手动设置的话事务默认开启
调用SqlSession中的api，传入Statement Id和参数，内部进行复杂的处理，最后调用jdbc执行SQL语句，封装结果返回
————————————————
版权声明：本文为CSDN博主「Coder648」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_43184769/article/details/91126687
 */
public class Mybatistest {
    public static void main(String[] args) throws IOException {

       InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        String name = "tom";
      //  List<User> list = sqlSession.selectList("com.demo.mapper.UserMapper.getUserByName",name);

        InputStream  inputStream1 =Resources.getResourceAsStream("mybatis-config.xml");  //读取xml信息
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream1 );
        SqlSession  session=sqlSessionFactory.openSession();
        UserMaper userMaper= session.getMapper(UserMaper.class);   //mapper名字
        List<Userinfo> getList =userMaper.getUser("name");


    }
}
