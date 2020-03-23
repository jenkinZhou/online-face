package com.jenkin.onlineface.questions.service;

import com.jenkin.onlineface.questions.entity.QuestionTypes;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jenkin.onlineface.questions.entity.vos.QuestionTypesVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
public interface QuestionTypesService extends IService<QuestionTypes> {
    /**
     * 根据类型等级和父类获取对应的题目
     * @param level
     * @param parent
     * @return
     */
    List<QuestionTypesVO> getQuestionTypeByLevelAndParent(int level, int parent);

}
