package com.zb.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SchedualServiceHiHystric implements FeignUserService {
    @Override
    public Integer addUserByNameAndPwd(Map map) {
        return null;
    }

    @Override
    public Integer validatePhoneByUser(String phone) {
        return 99;
    }

    @Override
    public Map loginUser(Map map) {
        System.out.println("测试断路器");
        return null;
    }

    @Override
    public List<Object> showAllType() {
        return null;
    }
}
