**# eureka使用**
implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server:3.1.4")
启动类加上：@EnableEurekaServer
properties文件：
server.port=8084
spring.application.name=lpp-spring-eureka
eureka.instance.hostname=localhost
eureka.client.fetch-registry=true
eureka.client.register-with-eureka=true
eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/



