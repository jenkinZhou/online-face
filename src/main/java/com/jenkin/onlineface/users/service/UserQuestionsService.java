package com.jenkin.onlineface.users.service;

import com.jenkin.onlineface.users.entity.UserQuestions;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jenkin.onlineface.users.entity.vos.UserQuestionsVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
public interface UserQuestionsService extends IService<UserQuestions> {
    /**
     * 获取用户收藏的问题
     * @return
     */
    @Deprecated
    List<UserQuestionsVO> listUserQuestions();
    /**
     * 随机获取用户收藏的问题
     * @return
     */
    List<UserQuestionsVO> listUserQuestionsRandom(int limitNum);
    /**
     * 获取用户收藏的问题
     * @return
     */

    List<UserQuestionsVO> listUserQuestionsByPage(String uid,String title);




}
