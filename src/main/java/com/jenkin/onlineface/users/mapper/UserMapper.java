package com.jenkin.onlineface.users.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jenkin.onlineface.users.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jenkin.onlineface.users.entity.vos.UserVO;
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
public interface UserMapper extends BaseMapper<User> {

    String SQL_VIEW="SELECT * from face_user ";

    @Select( SQL_VIEW + " ${ew.customSqlSegment}")
    List<UserVO> getListUser(@Param(Constants.WRAPPER) Wrapper wrapper);

    @Select( SQL_VIEW + " ${ew.customSqlSegment}")
    UserVO getUser(@Param(Constants.WRAPPER) Wrapper wrapper);
}
