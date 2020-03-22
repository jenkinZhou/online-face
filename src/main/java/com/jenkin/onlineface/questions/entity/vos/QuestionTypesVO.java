package com.jenkin.onlineface.questions.entity.vos;

import com.jenkin.onlineface.questions.entity.QuestionTypes;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author jenkin
 */
@ApiModel("问题类型视图")
@Data
public class QuestionTypesVO  extends QuestionTypes {
    private boolean leafFlag ;
}
