package com.jenkin.onlineface.questions.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jenkin.onlineface.commons.config.MyQueryWrapper;
import com.jenkin.onlineface.commons.utils.CommonUtils;
import com.jenkin.onlineface.questions.entity.Questions;
import com.jenkin.onlineface.questions.mapper.QuestionsMapper;
import com.jenkin.onlineface.questions.service.QuestionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jenkin.onlineface.users.entity.UserQuestions;
import com.jenkin.onlineface.users.service.UserQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.jenkin.onlineface.commons.enums.FaceTrainEnum.FACE_TRAIN_TYPE_IGNORE;

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

    @Autowired
    private UserQuestionsService userQuestionsService;
    /**
     * 根据类型，和过滤方式获取问题
     *
     * @param filterQuestionFirstType
     * @param filterQuestionSecondType
     * @param filterQuestionThirdType
     * @param filterQuestionFourthType
     * @param questionNum
     * @param didIds
     * @return
     */
    @Override
    public List<Questions> listQuestionByChoose(String filterQuestionFirstType, String filterQuestionSecondType,
                                                String filterQuestionThirdType, String filterQuestionFourthType,
                                                Integer questionNum, List<Integer> didIds) {
        //用户题目黑名单
        List<UserQuestions> userQuestions = userQuestionsService.list(Wrappers.<UserQuestions>query()
                .eq("face_User_Code", CommonUtils.getCurrentUser())
                .ne("face_question_flag", FACE_TRAIN_TYPE_IGNORE.getCode())
        );
//        Set<Integer> ignoreList = new HashSet<>();
        if (!CollectionUtils.isEmpty(userQuestions)) {
            userQuestions.forEach(item->didIds.add(item.getFaceQuestionId()));
        }
        List<Integer> first = CommonUtils.getIntegersList(filterQuestionFirstType);
        List<Integer> second = CommonUtils.getIntegersList(filterQuestionSecondType);
        List<Integer> third = CommonUtils.getIntegersList(filterQuestionThirdType);
        List<Integer> fourth = CommonUtils.getIntegersList(filterQuestionFourthType);
        Set<Integer> list1 = CommonUtils.getListByIndex(0, Integer.class, first, second, third, fourth);
        Set<Integer> list2 = CommonUtils.getListByIndex(1,Integer.class,first,second,third,fourth);
        Set<Integer> list3 = CommonUtils.getListByIndex(2,Integer.class,first,second,third,fourth);
        Set<Integer> list4 = CommonUtils.getListByIndex(3,Integer.class,first,second,third,fourth);

        MyQueryWrapper<Questions> queryWrapper = MyQueryWrapper.query();
            queryWrapper.and(i ->
                i.or().in(!CollectionUtils.isEmpty(list1),"face_type_first",list1 )
                .or().in(!CollectionUtils.isEmpty(list2),"face_type_second", list2)
                .or().in(!CollectionUtils.isEmpty(list3),"face_type_third", list3)
                .or().in(!CollectionUtils.isEmpty(list4),"face_type_fourth", list4)
        ).notIn(!CollectionUtils.isEmpty(didIds),"id", didIds)
                .last(" order by rand() limit " + questionNum);
        return list(queryWrapper);
    }


}
