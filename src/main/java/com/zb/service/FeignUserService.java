package com.zb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient("ServiceProvision")//指向ServiceProvision远端接口
public interface FeignUserService {

    @RequestMapping("/addUserByNameAndPwd")
    Integer addUserByNameAndPwd(@RequestParam Map map);

    @RequestMapping("/validatePhoneByUser/{phone}")
    @ResponseBody
    Integer validatePhoneByUser(@PathVariable("phone") String phone);

    @RequestMapping("/loginUser")
    Map loginUser(@RequestParam Map map);

    @RequestMapping("/showAllType")
    Map showAllType();
}
