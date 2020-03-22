package com.jenkin.onlineface.commons.utils;

import com.jenkin.onlineface.questions.entity.QuestionTypes;
import com.jenkin.onlineface.questions.entity.Questions;
import com.jenkin.onlineface.users.entity.vos.UserQuestionsVO;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

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
    public static List<Integer> getIntegersList(String type) {
        if (StringUtils.isEmpty(type)) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
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
    /**
     * form方式调用远程接口
     * @param postParameters
     * @param headersMap
     * @param remoteUrl
     * @return
     */
    public  static <T> T postRemoteInterface(MultiValueMap<String, Object> postParameters , Map<String,String> headersMap,
                                          String remoteUrl, MediaType mediaType,Class<T>  returnType){

        if(remoteUrl!=null) {
            RestTemplate re = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(mediaType);
            if(headersMap!=null) {
                headersMap.forEach((key, val) -> {
                    headers.set(key, val);
                });
            }
            // logger.info("请求参数===>" + postParameters.toJSONString());
            HttpEntity< MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(postParameters, headers);
            T res = re.postForObject(remoteUrl, requestEntity, returnType);
//           logger.info("远程连接返回结果====>"+ res);
            return res;
        }
        return null;

    }


    public static  String  uploadFile(File file,String targetUrl){
        FileSystemResource fileResource = new FileSystemResource(file);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("file", fileResource);
        return postRemoteInterface(param, new HashMap<>(), targetUrl, MediaType.MULTIPART_FORM_DATA, String.class);
    }

    /**
     * 从集合里面获取单个字段
     * @param rClass
     * @param list
     * @param tClass
     * @param fieldName
     * @param <R>
     * @param <T>
     * @return
     */
    public  static <R,T> List<R> CollectionToSingleField(Class<R> rClass,
                                                       Collection<T> list,
                                                  Class<T> tClass,
                                                       String fieldName) {
        List<R> res = new ArrayList<>();
        try {
            Field field = tClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            if (!CollectionUtils.isEmpty(list)) {
                for (T item : list) {
                    res.add((R) field.get(item));
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    return res;
    }

    public static <T> Set<T>  getListByIndex(int index,Class<T> tClass, List<T> ... lists) {
        Set<T> res = new HashSet<>();
        for (List<T> list : lists) {
            if (!(index>list.size()-1)) {
                res.add( list.get(index));
            }
        }
        return  res;
    }
}
