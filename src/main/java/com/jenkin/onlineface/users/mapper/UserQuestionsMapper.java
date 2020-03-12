package com.jenkin.onlineface.users.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jenkin.onlineface.users.entity.UserQuestions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jenkin.onlineface.users.entity.vos.UserQuestionsVO;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
@Mapper
public interface UserQuestionsMapper extends BaseMapper<UserQuestions> {
      String VIEW_SQL="select * from (SELECT\n" +
            "\tu.face_question_flag,\n" +
            "\tu.face_question_id,\n" +
            "\tu.face_user_id,\n" +
            "\tu.id,\n" +
            "\tq.answer_note,\n" +
            "\tfu.face_user_code,\n" +
            "\tq.face_approve_status,\n" +
            "\tq.face_content,\n" +
            "\tq.face_note,\n" +
            "\tq.face_seq_number,\n" +
            "\tq.face_standard_answer,\n" +
            "\tq.face_tag,\n" +
            "\tq.face_title, \n" +
            "\tq.face_type_first,\n" +
            "\tq.face_type_fourth,\n" +
            "\tq.face_type_seond,\n" +
            "\tq.face_type_third\n" +
            "FROM\n" +
            "\tface_user_questions u\n" +
            "LEFT JOIN face_questions q ON u.face_question_id = q.id " +
            "LEFT JOIN face_user fu ON u.face_user_id = fu.id ) h  ";








    @Select( VIEW_SQL+" where face_user_code=#{userCode} order by  RAND() limit #{limit}" )
    List<UserQuestionsVO> listUserQuestions(@Param("userCode") String userCode ,@Param("limit") int limit);

    @Select(VIEW_SQL +
            "  ${ew.customSqlSegment}  ")
//    @Results(id="res",value = {@Result(column = "face_title",property = "faceTitle")})
    List<UserQuestionsVO> listByPage(@Param(Constants.WRAPPER) Wrapper wrapper);

}
