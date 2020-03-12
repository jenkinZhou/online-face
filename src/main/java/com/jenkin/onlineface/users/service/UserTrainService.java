package com.jenkin.onlineface.users.service;

import com.jenkin.onlineface.users.entity.UserTrain;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
public interface UserTrainService extends IService<UserTrain> {
    /**
     * 开始一个训练计划
     * @param userTrain
     */
    void startTrain(UserTrain userTrain);

    /**
     * 获取最近几次做过的题目id
     * @param lastTimes
     * @return
     */
    List<Integer> lastDidQuestionId(String lastTimes);

}
