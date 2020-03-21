package com.jenkin.onlineface.users.controller;


import com.jenkin.onlineface.commons.anno.AutoDoc;
import com.jenkin.onlineface.commons.anno.EnableErrorCatch;
import com.jenkin.onlineface.commons.http.Response;
import com.jenkin.onlineface.users.entity.vos.UserVO;
import com.jenkin.onlineface.users.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

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
@Api( tags = "用户操作")
@RequestMapping("/users/user")
@EnableErrorCatch("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/createUser")
    @ApiOperation("创建用户")
    @AutoDoc(returnClass = UserVO.class)
    public Response<UserVO> createUser(UserVO userVO){
        return Response.ok(userService.addUser(userVO));
    }

    @GetMapping("/deleteUser")
    @ApiOperation("删除用户")
    public Response deleteUser(String userCode){
        if(userService.deleteUser(userCode)){
            return Response.ok();
        }else{
            return Response.error();
        }
    }

    @GetMapping("/updateUser")
    @ApiOperation("更新用户")
    @AutoDoc(returnClass = UserVO.class)
    public Response<UserVO> updateUser(UserVO userVO){
        return Response.ok(userService.updateUser(userVO));
    }

    @GetMapping("getUser")
    @ApiOperation("查询用户")
    @AutoDoc(returnClass = UserVO.class)
    public Response<UserVO> getUser(String userCode){
        return Response.ok(userService.getUser(userCode));
    }

    @GetMapping("/getDoc")
    public Response getDoc(){
        return Response.ok();

    }

}

