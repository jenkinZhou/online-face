package com.jenkin.onlineface.commons.enums;

import com.jenkin.onlineface.commons.enums.exception.ExceptionEnum;
import com.jenkin.onlineface.commons.exception.FaceException;

public enum FaceTrainEnum {
    /**
     *
     */
    FACE_TRAIN_TYPE_STAR("star","收藏类型","套题的类型为我收藏的题目"),
    FACE_TRAIN_TYPE_IGNORE("ignore","忽略类型","套题的类型为我忽略的题目"),
    FACE_TRAIN_TYPE_CHOOSE("choose","选择类型","套题的类型为我选择的类型的题目"),
    FACE_LAST_ONE("lastOne","最近一次做过的","不做最近一次做过的题目"),
    FACE_LAST_TWO("lastTwo","最近两次做过的","不做最近两次做过的题目"),
    FACE_LAST_THREE("lastThree","最近三次做过的","不做最近三次做过的题目"),
    FACE_TRAIN_RUNNING("running","运行中","正在训练"),
    FACE_TRAIN_CANCEL("cancel","cancel","训练取消"),
    FACE_TRAIN_END("end","end","训练结束");

    private FaceTrainEnum(String code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }


    private String code;
    private String name;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 检查trainType
     * @param trainType
     */
    public static void checkTrainType(String trainType){
        if(!FACE_TRAIN_TYPE_CHOOSE.getCode().equals(trainType)&&
                !FACE_TRAIN_TYPE_STAR.getCode().equals(trainType)){
            throw new FaceException(ExceptionEnum.ERROR_PARAM_EXCEPTION,"类型错误！"+trainType);
        }
    }
}
