package com.zb.controller;

import com.zb.service.FeignUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/msicType")
public class MusicTypeController {
    @Autowired
    FeignUserService feignUserService;
    @RequestMapping("/showAllType")
    public String showAllType(Model model){
        model.addAttribute("typeMap",feignUserService.showAllType());
        return "/musicType";
    }

}
