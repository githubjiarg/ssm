package com.huawei.demo.mapper;

import com.huawei.demo.entity.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    // 查询用户信息
    int getTotal(UserBean userBean);
}
