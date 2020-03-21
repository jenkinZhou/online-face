package com.jenkin.onlineface.users.service.impl;

import com.jenkin.onlineface.commons.config.MyQueryWrapper;
import com.jenkin.onlineface.users.entity.User;
import com.jenkin.onlineface.users.entity.vos.UserVO;
import com.jenkin.onlineface.users.mapper.UserMapper;
import com.jenkin.onlineface.users.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserVO getUser(String userCode) {
        MyQueryWrapper<UserVO> myQueryWrapper = MyQueryWrapper.query();
        myQueryWrapper.eq(UserVO.Fields.faceUserCode,userCode);
        return userMapper.getUser(myQueryWrapper);
    }

    @Override
    public UserVO addUser(UserVO userVO) {
        userMapper.insert(userVO);
        return userVO;
    }

    @Override
    public boolean deleteUser(String userCode) {
        MyQueryWrapper<User> myQueryWrapper = MyQueryWrapper.query();
        myQueryWrapper.eq(User.Fields.faceUserCode,userCode);
        if(userMapper.delete(myQueryWrapper)>0)
            return true;
        else
            return false;
    }

    @Override
    public UserVO updateUser(UserVO userVO) {
        if(userVO.getId() == null){
            userVO.setId(this.getUser(userVO.getFaceUserCode()).getId());
        }
        if(userMapper.updateById(userVO) > 0)
            return getUser(userVO.getFaceUserCode());
        else
            return null;
    }
}
