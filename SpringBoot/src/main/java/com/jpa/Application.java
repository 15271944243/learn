package com.jpa;

import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class Application {

    //SpringApplication是springBoot框架中描述spring应用的类
    //它的run()方法会创建一个spring应用上下文(ApplicationContext)
    //另一个方面它会扫描当前路径上的依赖
    //发现spring-webmvc  (由spring-boot-starter-web传递引入)在类路径中，那么
    //springboot会判断这是一个web应用，并启动一个内嵌的servlet容器(默认的是tomcat)
    public static void main(String[] args) {
        // @SpringBootApplication继承了@Configuration、@EnableAutoConfiguration、@ComponentScan这三个注解
        // 默认扫描的包是以SpringApplication.run(Springrun.class, args) 参数springrun.class所在的包作为base package。
        // 注意：如果想要启动整个程序，这个类必须要放到根包里面去。
        SpringApplication.run(Application.class,args);
    }
}
