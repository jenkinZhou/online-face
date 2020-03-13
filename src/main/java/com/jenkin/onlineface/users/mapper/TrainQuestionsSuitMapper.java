package com.jenkin.onlineface.users.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jenkin.onlineface.users.entity.TrainQuestionsSuit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jenkin.onlineface.users.entity.vos.UserTrainQuestionVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
public interface TrainQuestionsSuitMapper extends BaseMapper<TrainQuestionsSuit> {

    String SQL_VIEW="SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tface_user_train ut\n" +
            "LEFT JOIN face_train_questions_suit tqs ON ut.id = tqs.face_train_id\n" +
            "LEFT JOIN face_questions q ON tqs.face_train_question_id = q.id ";


    @Select(SQL_VIEW+" ${ew.customSqlSegment}")
    List<UserTrainQuestionVO> listUserTrainQuestionSuit(@Param(Constants.WRAPPER) Wrapper wrapper);


    @Select(SQL_VIEW+" ${ew.customSqlSegment}")
    UserTrainQuestionVO getUserTrainQuestionSuit(@Param(Constants.WRAPPER) Wrapper wrapper);

}
