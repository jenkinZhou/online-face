package com.jenkin.onlineface.users.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jenkin.onlineface.commons.config.MyQueryWrapper;
import com.jenkin.onlineface.commons.enums.FaceTrainEnum;
import com.jenkin.onlineface.commons.utils.CommonUtils;
import com.jenkin.onlineface.users.entity.TrainQuestionsSuit;
import com.jenkin.onlineface.users.entity.UserTrain;
import com.jenkin.onlineface.users.entity.vos.UserTrainQuestionVO;
import com.jenkin.onlineface.users.mapper.TrainQuestionsSuitMapper;
import com.jenkin.onlineface.users.service.TrainQuestionsSuitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
@Service
public class TrainQuestionsSuitServiceImpl extends ServiceImpl<TrainQuestionsSuitMapper, TrainQuestionsSuit> implements TrainQuestionsSuitService {
    @Resource
    private TrainQuestionsSuitMapper trainQuestionsSuitMapper;

    /**
     * 获取用户当前类型正在进行的一道未完成的题目
     *
     * @param trainType
     * @return
     */
    @Override
    public UserTrainQuestionVO getCurrentUndoQuestionByType(String trainType) {
        FaceTrainEnum.checkTrainType(trainType);

        MyQueryWrapper<UserTrainQuestionVO> queryWrapper = MyQueryWrapper.query();
        queryWrapper
                .eq(UserTrainQuestionVO.Fields.faceTrainType, trainType)
                .eq(UserTrainQuestionVO.Fields.userCode, CommonUtils.getCurrentUser())
                .apply(" face_Train_Question_Index = face_Train_Question_Seq ");
        return trainQuestionsSuitMapper.getUserTrainQuestionSuit(queryWrapper);
    }

    /**
     * 获取用户当前类型正在进行的一道未完成的题目
     *
     * @param trainType
     * @return
     */
    @Override
    public UserTrainQuestionVO getBeforeQuestionByType(String trainType,int index) {
        return getQuestionByTrainTypeAndSeq(trainType,index-1);

    }

    /**
     * 获取用户当前类型正在进行的一道未完成的题目
     *
     * @param trainType
     * @return
     */
    @Override
    public UserTrainQuestionVO getNextQuestionByType(String trainType,int index) {

        return getQuestionByTrainTypeAndSeq(trainType,index+1);
    }

    /**
     * 获取用户当前类型正在进行的一道未完成的题目
     *
     * @param trainType
     * @return
     */
    @Override
    public UserTrainQuestionVO getQuestionByTrainTypeAndSeq(String trainType,int index) {
        if (StringUtils.isEmpty(trainType)) {
            return null;
        }
        MyQueryWrapper<UserTrainQuestionVO> queryWrapper = MyQueryWrapper.query();
        queryWrapper
                .eq(UserTrainQuestionVO.Fields.faceTrainType, trainType)
                .eq(UserTrainQuestionVO.Fields.userCode, CommonUtils.getCurrentUser())
                .eq(UserTrainQuestionVO.Fields.faceTrainQuestionSeq,index);
        return trainQuestionsSuitMapper.getUserTrainQuestionSuit(queryWrapper);
    }

    /**
     * 获取未完成的题目的编号
     *
     * @param trainType
     * @return
     */
    @Override
    public List<Integer> listUndoQuestionSeq(String trainType) {
        if (StringUtils.isEmpty(trainType)) {
            return null;
        }
        MyQueryWrapper<UserTrainQuestionVO> queryWrapper = MyQueryWrapper.query();
        queryWrapper
                .eq(UserTrainQuestionVO.Fields.faceTrainType, trainType)
                .eq(UserTrainQuestionVO.Fields.userCode, CommonUtils.getCurrentUser())
                .isNull(UserTrainQuestionVO.Fields.faceTrainPass)
                .orderByAsc(UserTrainQuestionVO.Fields.faceTrainQuestionSeq);
        List<UserTrainQuestionVO> userTrainQuestionVOS = trainQuestionsSuitMapper.listUserTrainQuestionSuit(queryWrapper);
        List<Integer> res = new ArrayList<>();
        if (!CollectionUtils.isEmpty(userTrainQuestionVOS)) {
            userTrainQuestionVOS.forEach(item->res.add(item.getFaceTrainQuestionSeq()));
        }
        return res;
    }
}
