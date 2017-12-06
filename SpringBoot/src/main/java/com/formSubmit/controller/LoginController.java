package com.formSubmit.controller;

import com.formSubmit.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    /*@RequestMapping(value="/",method=RequestMethod.GET)*/
    @GetMapping("/")
    public String showForm(User user){
        return "login";
    }

    /*@RequestMapping(value="/check",method=RequestMethod.POST)*/
    @PostMapping("/check")
    public String checkForm(@Valid User user, BindingResult bindingResult){
        //假如有错误的话
        if(bindingResult.hasErrors()){
            return "login";
        }
        //否则返回正确信息
        return "results";
    }

    @PostMapping("/resultSub")
    public  String sumitForm(@Valid User user,BindingResult bindingResult){
        //假如有错误的话
        if(bindingResult.hasErrors()){
            List<ObjectError> error=bindingResult.getAllErrors();
            for(ObjectError e:error){
                System.out.println(e);
            }
            return  "loginSumit";
        }
        return  "resultsSub";
    }
}
