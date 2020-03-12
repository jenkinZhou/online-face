package com.jenkin.onlineface.users.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jenkin.onlineface.commons.utils.CommonUtils;
import com.jenkin.onlineface.users.entity.UserQuestions;
import com.jenkin.onlineface.users.entity.vos.UserQuestionsVO;
import com.jenkin.onlineface.users.mapper.UserQuestionsMapper;
import com.jenkin.onlineface.users.service.UserQuestionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
@Service
public class UserQuestionsServiceImpl extends ServiceImpl<UserQuestionsMapper, UserQuestions> implements UserQuestionsService {

    @Resource
    private UserQuestionsMapper userQuestionsMapper;

    /**
     * 获取题目
     * @return
     */
    @Override
    public List<UserQuestionsVO> listUserQuestions() {


        return null;
    }
    /**
     * 随机获取题目
     * @return
     */
    @Override
    public List<UserQuestionsVO> listUserQuestionsRandom(int limitNum) {
        return userQuestionsMapper.listUserQuestions(CommonUtils.getCurrentUser(),limitNum);
    }

    @Override
    public List<UserQuestionsVO> listUserQuestionsByPage(String uid, String title) {
        QueryWrapper<UserQuestionsVO> queryWrapper =
                Wrappers.<UserQuestionsVO>query().in("face_user_code", Arrays.asList(uid,title) );
        return userQuestionsMapper.listByPage(queryWrapper);
    }
}
