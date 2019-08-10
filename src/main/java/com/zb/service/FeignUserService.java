package com.zb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient("ServiceProvision")//指向ServiceProvision远端接口
public interface FeignUserService {

    @RequestMapping("/userController/addUserByNameAndPwd")
    Integer addUserByNameAndPwd(@RequestParam Map map);

    @RequestMapping("/userController/validatePhoneByUser/{phone}")
    @ResponseBody
    Integer validatePhoneByUser(@PathVariable("phone") String phone);

    @RequestMapping("/userController/loginUser")
    Map loginUser(@RequestParam Map map);

    @RequestMapping("/musicType/showAllType")
    List<Object> showAllType();
}
