package com.jenkin.onlineface.users.service.impl;

import com.jenkin.onlineface.users.entity.User;
import com.jenkin.onlineface.users.mapper.UserMapper;
import com.jenkin.onlineface.users.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jenkin
 * @since 2020-03-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
