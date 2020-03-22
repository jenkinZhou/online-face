package com.jenkin.onlineface.questions.controller;


import com.jenkin.onlineface.commons.anno.AutoDoc;
import com.jenkin.onlineface.commons.http.Response;
import com.jenkin.onlineface.questions.entity.QuestionTypes;
import com.jenkin.onlineface.questions.entity.Questions;
import com.jenkin.onlineface.questions.entity.vos.QuestionTypesVO;
import com.jenkin.onlineface.questions.service.QuestionTypesService;
import com.jenkin.onlineface.questions.service.QuestionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
@RestController
@RequestMapping("/questions/question-types")
@Api(tags = "问题类型curd")
public class QuestionTypesController {
    @Autowired
    private QuestionTypesService questionTypesService;
    @PostMapping("/addQuestion")
    @ApiOperation("添加一个问题类型")
    public Response<Integer> addQuestion(@RequestBody QuestionTypes questionTypes){
        questionTypesService.save(questionTypes);
        return Response.<Integer>ok().data(questionTypes.getId());
    }
    @PostMapping("/addQuestionsBatch")
    @ApiOperation("批量添加问题类型")
    public Response addQuestionsBatch(@RequestBody List<QuestionTypes> questionTypes){
        questionTypesService.saveBatch(questionTypes);
        return Response.ok();
    }
    @GetMapping("/getQuestionTypeByLevelAndParent")
    @AutoDoc(returnClass = QuestionTypes.class)
    @ApiOperation("获取题目类型,根据等级和父类")
    public Response<List<QuestionTypesVO>> getQuestionTypeByLevelAndParent(String level, String parent){
            return Response.<List<QuestionTypesVO>>ok()
                    .data(questionTypesService
                            .getQuestionTypeByLevelAndParent(Integer.parseInt(level),
                                    StringUtils.isEmpty(parent)?0:Integer.parseInt(parent)));
    }


    @GetMapping("/getDoc")
    public Response getDoc(){
        return Response.ok();

    }
}

