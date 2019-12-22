package com.huawei.demo.service;

import com.huawei.demo.entity.UserBean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    /**
     *  校验用户信息
     * @param userBean
     * @return
     */
    public boolean login(UserBean userBean){

        return true;
    }


}
