package com.zb.controller;


import com.zb.service.FeignUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@RequestMapping("/feignUser")
public class FeignUserController {

    @Autowired
    FeignUserService feignUserService;//通过FeignUserService调用远端接口ServiceProvision

    @RequestMapping("/showMain")//跳转注册页
    public String showMain() {
        return "/mgRegister";
    }

    @RequestMapping("/main")//跳转主页
    public String main() {
        return "/homepage";
    }

    @RequestMapping("/login")//跳转登录页
    public String login(){

        return "/login";
    }
    @RequestMapping("/addUserByNameAndPwd")//注册用户
    public String addUserByNameAndPwd(@RequestParam Map map) {
        System.out.println(map.get("phone"));
        String phone = (String) map.get("phone");
        //注册用户判断用户插入是否成功如果成功就跳入主页否则返回注册页
        if (feignUserService.addUserByNameAndPwd(map) > 0) {
            return "/homepage";
        } else {
            return "/mgRegister";
        }
    }

    @RequestMapping("/validatePhoneByUser/{phone}")//验证用户名是否注册过
    @ResponseBody
    public Integer validatePhoneByUser(@PathVariable("phone") String phone) {
        System.out.println(phone);
        return feignUserService.validatePhoneByUser(phone);
    }
    @RequestMapping("/loginUser")//登录用户
    public String loginUser(@RequestParam Map map, HttpSession session){
        if(feignUserService.loginUser(map)!=null){
            session.setAttribute("SESSION_USER",feignUserService.loginUser(map));
            session.setMaxInactiveInterval(3600);
            return "/homepage";
        }else{
            return "/login";
        }
    }
    @RequestMapping("/logOffUser")//注销用户
    public String logOffUser(HttpSession session){
        System.out.println("111");
        session.removeAttribute("SESSION_USER");
        session.invalidate();
        return "/homepage";
    }
}
