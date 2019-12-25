package com.huawei.demo.service;

import com.huawei.demo.entity.UserBean;
import com.huawei.demo.mapper.UserMapper;
import com.huawei.demo.utils.EncryptUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl {

    @Resource
    UserMapper userMapper;

    /**
     *  校验用户信息
     * @param userBean
     * @return
     */
    public boolean login(UserBean userBean){
        boolean flag = false;
        String password = "";
        userBean.setPassword(password);
        int total = userMapper.getTotal(userBean);
        if ( total > 0 ) {
            flag = true;
        }
        return flag;
    }


}
