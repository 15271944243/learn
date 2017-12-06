package com.firstlesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController代替@Controller
@RestController
@RequestMapping("/ex")
@EnableConfigurationProperties({YmlPropertiesBean.class,TestForPropertySourceBean.class})
public class ExampleController {

    @Autowired
    private YmlPropertiesBean ymlPropertiesBean;
    @Autowired
    private TestForPropertySourceBean testForPropertySourceBean;

    @Value("${com.springboot.name}")
    private String uname;
    @Value("${com.springboot.title}")
    private String utitle;

    @RequestMapping("/")
    public String home(){
        return "你好，同学";
    }

    //带参数的方法处理
    @RequestMapping("/{myName}")
    public String home(@PathVariable String myName){
        return "你好,同学"+myName;
    }

    @RequestMapping("/properties")
    public String properties(){
        return "名称:"+uname+",标题:"+utitle;
    }

    @RequestMapping("/getYmlPropertiesBean")
    public String getYmlPropertiesBean(){
        return "名称:"+ymlPropertiesBean.getName()+",标题:"+ymlPropertiesBean.getTitle()+",年龄:"+ymlPropertiesBean.getAge();
    }

    @RequestMapping("/getTestForPropertySourceBean")
    public String getTestForPropertySourceBean(){
        return "名称:"+testForPropertySourceBean.getName()+",标题:"+testForPropertySourceBean.getTitle();
    }
}
