package com.jenkin.onlineface.users.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jenkin.onlineface.commons.utils.CommonUtils;
import com.jenkin.onlineface.questions.entity.Questions;
import com.jenkin.onlineface.questions.service.QuestionsService;
import com.jenkin.onlineface.users.entity.TrainQuestionsSuit;
import com.jenkin.onlineface.users.entity.UserTrain;
import com.jenkin.onlineface.users.entity.vos.UserQuestionsVO;
import com.jenkin.onlineface.users.mapper.UserTrainMapper;
import com.jenkin.onlineface.users.service.TrainQuestionsSuitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jenkin.onlineface.users.service.UserQuestionsService;
import com.jenkin.onlineface.users.service.UserTrainService;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.jenkin.onlineface.commons.enums.FaceTrainEnum.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
@Service
public class UserTrainServiceImpl extends ServiceImpl<UserTrainMapper, UserTrain> implements UserTrainService {

    private Logger logger = LoggerFactory.getLogger(UserTrainServiceImpl.class);
    @Autowired
    private Mapper mapper;
    @Autowired
    private TrainQuestionsSuitService trainQuestionsSuitService;
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private UserQuestionsService userQuestionsService;

    /**
     * 根据类型创建一套题目
     * @param userTrain
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void startTrain(UserTrain userTrain) {
        this.save(userTrain);
        if (userTrain.getId()==null) {
            logger.info("ID为空");
        }
        createQuestionSuit(userTrain);
    }

    /**
     * 获取最近几次做过的题目id
     *
     * @param lastTimes
     * @return
     */
    @Override
    public List<Integer> lastDidQuestionId(String lastTimes) {
        if (StringUtils.isEmpty(lastTimes)) {
            return new ArrayList<>();
        }
        int limit = 0;
        if (FACE_LAST_ONE.getCode().equals(lastTimes)){
            limit=1;
        }else if(FACE_LAST_TWO.getCode().equals(lastTimes)){
            limit=2;
        }else if(FACE_LAST_THREE.getCode().equals(lastTimes)){
            limit=3;
        }
        if (limit==0) {
            return new ArrayList<>();
        }
        QueryWrapper<UserTrain> queryWrapper = Wrappers.<UserTrain>query()
                .eq("user_code", CommonUtils.getCurrentUser())
                .eq("face_train_status", FACE_TRAIN_END.getCode())
                .orderByDesc("last_update_date")
                .last("limit " + limit);
        List<UserTrain> userTrains = list(queryWrapper);
        if(CollectionUtils.isEmpty(userTrains)){
            return new ArrayList<>();
        }else{
            List<Integer> ids = new ArrayList<>();
            userTrains.forEach(item->ids.add(item.getId()));
            QueryWrapper<TrainQuestionsSuit> suitQueryWrapper = Wrappers.<TrainQuestionsSuit>query().in("face_trainId", ids);
            List<TrainQuestionsSuit> questions = trainQuestionsSuitService.list(suitQueryWrapper);
            ids.clear();
            questions.forEach(item->ids.add(item.getFaceTrainQuestionId()));
            return ids;
        }

    }

    /**
     * 目前类型分为自定义选择分类（choose）和收藏（star）的题目
     * 随机10-100个一级分类后面的某些分类的题目（分类可以有多个）
     * 可选择最近一次，两次或三次或者做过的题目不做
     * 根据分类过滤
     * @param userTrain
     */
    private void createQuestionSuit(UserTrain userTrain) {



        //根据类型获取题目
        List<Questions> questions= getQuestionByType(userTrain);
       List<TrainQuestionsSuit>  trainQuestionsSuits = new ArrayList<>();
        if (!CollectionUtils.isEmpty(questions)) {
            questions.forEach(item->{
                TrainQuestionsSuit trainQuestionsSuit = new TrainQuestionsSuit();
                trainQuestionsSuit.setFaceTrainId(userTrain.getId());
                trainQuestionsSuit.setFaceTrainQuestionId(item.getId());
                trainQuestionsSuits.add(trainQuestionsSuit);
            });
            trainQuestionsSuitService.saveBatch(trainQuestionsSuits);
        }


    }

    private List<Questions> getQuestionByType(UserTrain userTrain) {

        String faceTrainType = userTrain.getFaceTrainType();
        if (!StringUtils.isEmpty(faceTrainType)) {
            //收藏的类型
            if (FACE_TRAIN_TYPE_STAR.getCode().equals(faceTrainType)){
                List<UserQuestionsVO> userQuestionsVOS =
                        userQuestionsService.listUserQuestionsRandom(userTrain.getQuestionNum());
                return CommonUtils.mapList(mapper,userQuestionsVOS,Questions.class);
                //选择的类型
            }else{

                return questionsService.listQuestionByChoose(
                        userTrain.getFilterQuestionFirstType(),
                        userTrain.getFilterQuestionSecondType(),
                        userTrain.getFilterQuestionThirdType(),
                        userTrain.getFilterQuestionFourthType(),
                        userTrain.getQuestionNum(),
                        lastDidQuestionId(userTrain.getFilterType()));

            }
        }
        return new ArrayList<>();
    }
}
