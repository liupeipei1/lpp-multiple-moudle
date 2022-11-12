**1.druid数据源设置**
a.访问地址：http://localhost:8082/druid/login.html    admin/1234
描述：可以查看mysql oracle等数据库的连接数以及耗时  参考地址:[https://blog.csdn.net/lizhiqiang1217/article/details/90573534]()
引入：
// <!-- druid 数据库连接池   -->
`implementation 'com.alibaba:druid-spring-boot-starter:1.2.9'`
**2.springboot actuator的使用**
访问地址：[http://localhost:8082/actuator]
health:[http://localhost:8082/actuator/health](http://localhost:8082/actuator/health)
a. 引入jar 
`org.springframework.boot:spring-boot-starter-actuator:2.6.11`
b. application.property文件上加上下面配置
`management.server.port=8082
#默认值访问health,info端点  用*可以包含全部端点
management.endpoints.web.exposure= include: "*"
#修改访问路径 2.0之前默认是/; 2.0默认是/actuator可以通过这个属性值修改
management.endpoints.web.base-path= /actuator
#打开shutdown端点
management.endpoint.shutdown.enabled=true
#获得健康检查中所有指标的详细信息
management.endpoint.health.show-details=always
management.endpoints.web.exposure.include=health,info`

**3.整合mysql**
a.引入jar
<!--MySQL连接Java的驱动程序-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
    <version>8.0.13</version>
</dependency>
<!--支持通过jdbc连接数据库库-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
引入druid连接池
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.6</version>
</dependency>
property文件：
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/db1?serverTimezone=Asia/Shanghai&characterEncoding=utf-8&useSSL=false
    username: root
    password: root
    #指定数据源
   type: com.alibaba.druid.pool.DruidDataSource

