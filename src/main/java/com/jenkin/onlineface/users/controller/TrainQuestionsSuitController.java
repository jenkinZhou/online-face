package com.jenkin.onlineface.users.controller;


import com.jenkin.onlineface.commons.anno.AutoDoc;
import com.jenkin.onlineface.commons.anno.EnableErrorCatch;
import com.jenkin.onlineface.commons.http.Response;
import com.jenkin.onlineface.users.entity.vos.UserQuestionsVO;
import com.jenkin.onlineface.users.entity.vos.UserTrainQuestionVO;
import com.jenkin.onlineface.users.service.TrainQuestionsSuitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin
@Api(tags = "获取用户生成的一套题目")
@RequestMapping("/users/train-questions-suit")
@EnableErrorCatch("train-question-suit")
public class TrainQuestionsSuitController {

    @Autowired
    private TrainQuestionsSuitService trainQuestionsSuitService;

    @GetMapping("/beginGetQuestion")
    @ApiOperation("获取当前已经开始的第一个未完成的题目")
    @AutoDoc(returnClass = UserTrainQuestionVO.class)
    public Response<UserTrainQuestionVO> beginGetQuestion(String trainType){
        return  Response
                .<UserTrainQuestionVO>ok()
                .data(trainQuestionsSuitService.getCurrentUndoQuestionByType(trainType));

    }
    @GetMapping("/getBeforeQuestion")
    @ApiOperation("上一题")
    @AutoDoc(returnClass = UserTrainQuestionVO.class)
    public Response<UserTrainQuestionVO> getBeforeQuestion(String trainType,String index){
        return  Response.ok(trainQuestionsSuitService.getBeforeQuestionByType(trainType, Integer.parseInt(index)));

    }
    @GetMapping("/getNextQuestion")
    @ApiOperation("下一题")
    @AutoDoc(returnClass = UserTrainQuestionVO.class)
    public Response<UserTrainQuestionVO> getNextQuestion(String trainType,String index){
        return Response.ok(trainQuestionsSuitService.getNextQuestionByType(trainType,Integer.parseInt(index)));

    }
    @GetMapping("/getQuestionBySeq")
    @ApiOperation("指定序号的题目")
    @AutoDoc(returnClass = UserTrainQuestionVO.class)
    public Response<UserTrainQuestionVO> getQuestionBySeq(String trainType,String index){
        return Response.ok(trainQuestionsSuitService.getQuestionByTrainTypeAndSeq(trainType,Integer.parseInt(index)));
    }
    @GetMapping("/getUndoQuestion")
    @ApiOperation("未完成的题目序号")
    public Response<List<Integer>> getUndoQuestion(String trainType){
        return Response.ok(trainQuestionsSuitService.listUndoQuestionSeq(trainType));
    }

    @GetMapping("/getDoc")
    public Response getDoc(){
        return Response.ok();

    }

}

