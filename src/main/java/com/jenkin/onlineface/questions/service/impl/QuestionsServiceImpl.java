package com.jenkin.onlineface.questions.service.impl;

import com.jenkin.onlineface.questions.entity.Questions;
import com.jenkin.onlineface.questions.mapper.QuestionsMapper;
import com.jenkin.onlineface.questions.service.QuestionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
@Service
public class QuestionsServiceImpl extends ServiceImpl<QuestionsMapper, Questions> implements QuestionsService {

}
