package com.jenkin.onlineface.questions.service;

import com.jenkin.onlineface.questions.entity.Questions;
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
public interface QuestionsService extends IService<Questions> {
    /**
     * 根据类型，和过滤方式获取问题
     * @param filterQuestionFirstType
     * @param filterQuestionSecondType
     * @param filterQuestionThirdType
     * @param filterQuestionFourthType
     * @param questionNum
     * @param didIds
     * @return
     */
    List<Questions> listQuestionByChoose(String filterQuestionFirstType,
                                         String filterQuestionSecondType,
                                         String filterQuestionThirdType,
                                         String filterQuestionFourthType,
                                         Integer questionNum,
                                         List<Integer> didIds);

}
