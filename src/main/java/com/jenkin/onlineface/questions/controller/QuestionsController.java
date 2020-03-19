package com.jenkin.onlineface.questions.controller;


import com.jenkin.onlineface.commons.http.Response;
import com.jenkin.onlineface.questions.entity.Questions;
import com.jenkin.onlineface.questions.service.QuestionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@Api(tags = "问题信息CURD")
@RequestMapping("/questions/")
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;
    @PostMapping("/addQuestion")
    @ApiOperation("添加一个问题")
    public Response addQuestion(@RequestBody Questions questions){
        questionsService.save(questions);
        return Response.ok();
    }
    @PostMapping("/addQuestionsBatch")
    @ApiOperation("批量添加问题")
    public Response addQuestionsBatch(@RequestBody List<Questions> questions){
        questionsService.saveBatch(questions);
        return Response.ok();
    }

}

