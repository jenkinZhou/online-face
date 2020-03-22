package com.jenkin.onlineface.questions.service.impl;

import com.jenkin.onlineface.commons.config.MyQueryWrapper;
import com.jenkin.onlineface.commons.utils.CommonUtils;
import com.jenkin.onlineface.questions.entity.QuestionTypes;
import com.jenkin.onlineface.questions.entity.vos.QuestionTypesVO;
import com.jenkin.onlineface.questions.mapper.QuestionTypesMapper;
import com.jenkin.onlineface.questions.service.QuestionTypesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
public class QuestionTypesServiceImpl extends ServiceImpl<QuestionTypesMapper, QuestionTypes> implements QuestionTypesService {

    @Autowired
    private Mapper mapper;
    /**
     * 根据类型等级和父类获取对应的题目
     *
     * @param level
     * @param parent
     * @return
     */
    @Override
    public List<QuestionTypesVO> getQuestionTypeByLevelAndParent(int level, int parent) {
        MyQueryWrapper<QuestionTypes> queryWrapper = new MyQueryWrapper<>();
        queryWrapper.eq(QuestionTypes.Fields.faceQuestionTypeLevel,level)
                .eq(level>1,QuestionTypes.Fields.parentId,parent);
        List<QuestionTypes> list = list(queryWrapper);
        queryWrapper.clear();
        List<Integer> res = CommonUtils.CollectionToSingleField(Integer.class,list,QuestionTypes.class,QuestionTypes.Fields.id);
        queryWrapper.in(!CollectionUtils.isEmpty(res), QuestionTypes.Fields.parentId,res);
        List<QuestionTypes> parents = list(queryWrapper);
        List<Integer> parentIds = CommonUtils.CollectionToSingleField(Integer.class,parents,QuestionTypes.class,QuestionTypes.Fields.parentId);
        List<QuestionTypesVO> questionTypesVOS = CommonUtils.mapList(mapper, list, QuestionTypesVO.class);
        questionTypesVOS.forEach(item->item.setLeafFlag(!parentIds.contains(item.getId())));
        return questionTypesVOS;
    }
}
