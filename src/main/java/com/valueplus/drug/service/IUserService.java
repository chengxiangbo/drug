package com.valueplus.drug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.valueplus.drug.entity.User;

/**
 * 用户表service接口
 */
public interface IUserService extends IService<User> {
    /**
     * 根据用户名查询对象
     */
    public User queryUserByUsername(User user);
}
