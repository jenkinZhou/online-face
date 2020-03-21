package com.jenkin.onlineface.users.service;

import com.jenkin.onlineface.users.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jenkin.onlineface.users.entity.vos.UserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
public interface UserService extends IService<User> {
        UserVO getUser(String userCode);
        UserVO addUser(UserVO userVO);
        boolean deleteUser(String userCode);
        UserVO updateUser(UserVO userVO);
}
