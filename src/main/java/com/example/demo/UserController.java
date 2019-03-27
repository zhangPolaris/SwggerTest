package com.example.demo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

@SpringBootApplication(scanBasePackages = {"com"})
//该注解包含了@Controller和@ResponseBody两个注解
@RestController
public class UserController{
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * 以下函数的注释,不增加注解了,将在下面统一做描述
     */


    @ApiOperation(value = "测试post请求",notes="注意事项")
    @ApiImplicitParam(dataType = "User",name = "user",value = "用户信息",required = true)
    @RequestMapping(value = "/testPost",method = RequestMethod.POST)
    public String testPost(@RequestBody User user){
        return "success";
    }


    @ApiOperation(value = "测试get请求",notes="注意事项")
    @ApiImplicitParam(name = "id",value = "用户id",dataType = "int",paramType = "path")
    @RequestMapping(value = "/testGet/{id}",method = RequestMethod.GET)
    public List<User> testGet(@PathVariable int id){
        List<User> u=new ArrayList<>();
        User user=new User();
        user.setId(1);
        user.setName("张三");
        user.setAge("18");
        User user1=new User();
        user1.setId(2);
        user1.setName("李四");
        user1.setAge("王五");
        u.add(user);
        u.add(user1);
        return u;
    }

    @ApiOperation(value = "测试组合注解",notes="注意事项")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "User",name = "user",value = "用户信息",required = true,paramType = "body"),
            @ApiImplicitParam(dataType = "string",name = "id",value = "用户id",required = true,paramType = "path")
    })
    @RequestMapping(value = "/joinAnnotation/{id}",method = RequestMethod.POST)
    public User joinAnnotation(@PathVariable String id,@RequestBody User user){
        return user;
    }

    @ApiIgnore
    public String testIgnore(){
        return "success";
    }
}