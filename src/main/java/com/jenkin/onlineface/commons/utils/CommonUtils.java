package com.jenkin.onlineface.commons.utils;

import com.jenkin.onlineface.questions.entity.Questions;
import com.jenkin.onlineface.users.entity.vos.UserQuestionsVO;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonUtils {
    private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
    public static String getCurrentUser(){
        return "jenkin";
    }

    public static <S, T> List<T> mapList(final Mapper mapper, List<S> sourceList, Class<T> targetObjectClass) {
        List<T> resList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(sourceList)) {
            for (S item : sourceList) {
                if (item!=null) {
                    T res = mapper.map(item, targetObjectClass);
                    resList.add(res);
                }else{
                    resList.add(null);
                }
            }
        }
        return resList;
    }
    public static Set<Integer> getIntegers(String type) {
        if (StringUtils.isEmpty(type)) {
            return new HashSet<>();
        }
        Set<Integer> res = new HashSet<>();
        String[] split = type.split(";");
        for (String s : split) {
            try {
                int i = Integer.parseInt(s);
                res.add(i);
            }catch (Exception e){
                logger.error( e.getMessage());
            }
        }
        return res;
    }
}
