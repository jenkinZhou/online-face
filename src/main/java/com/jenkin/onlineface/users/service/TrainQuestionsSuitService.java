package com.jenkin.onlineface.users.service;

import com.jenkin.onlineface.users.entity.TrainQuestionsSuit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jenkin.onlineface.users.entity.vos.UserTrainQuestionVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
public interface TrainQuestionsSuitService extends IService<TrainQuestionsSuit> {
    /**
     * 获取用户当前类型正在进行的一道未完成的题目
     * @param trainType
     * @return
     */
    UserTrainQuestionVO getCurrentUndoQuestionByType(String trainType);

    /**
     * 获取用户当前类型正在进行的上一个题目
     * @param trainType
     * @return
     */
    UserTrainQuestionVO getBeforeQuestionByType(String trainType,int index);


    /**
     * 获取用户当前类型正在进行下一个题目
     * @param trainType
     * @return
     */
    UserTrainQuestionVO getNextQuestionByType(String trainType,int index);

    /**
     * 获取用户当前类型正在进行某一个的题目
     * @param trainType
     * @return
     */
    UserTrainQuestionVO getQuestionByTrainTypeAndSeq(String trainType,int index);

    /**
     * 获取未完成的题目的编号
     * @param trainType
     * @return
     */
    List<Integer> listUndoQuestionSeq(String trainType);




}
