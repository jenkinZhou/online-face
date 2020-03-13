package com.jenkin.onlineface.users.entity.vos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * @author ：jenkin
 * @date ：Created at 2020/3/13 10:31
 * @description：用户生成之后的题目
 * @modified By：
 * @version: 1.0
 */
@Data
@FieldNameConstants
public class UserTrainQuestionVO {
    private Integer id;

    @ApiModelProperty(value = "当前题目的ID")
    private Integer faceTrainQuestionId;

    @ApiModelProperty(value = "训练计划的ID")
    private Integer faceTrainId;

    @ApiModelProperty("生成的题目的序号")
    private Integer faceTrainQuestionSeq;

    @ApiModelProperty(value = "当前题目你的解答")
    private String faceTrainQuestionAnswer;

    @ApiModelProperty(value = "1-10 的整数，当前题目的困难程度")
    private Integer faceTrainDifficulty;

    @ApiModelProperty(value = "当前题目你认为是否通过（Y、N）")
    private String faceTrainPass;

    @ApiModelProperty(value = "你对当前题目做的笔记")
    private String faceTrainNote;

    @ApiModelProperty(value = "用户编码")
    private String userCode;

    @ApiModelProperty(value = "问题套餐记录ID")
    private Integer questionRecordId;

    @ApiModelProperty("当前做的题目的位置")
    private Integer faceTrainQuestionIndex;

    @ApiModelProperty(value = "当前进行的训练的类型（自定义随机）")
    private String faceTrainType;

    @ApiModelProperty(value = "题目数目，默认50")
    private Integer questionNum;

    @ApiModelProperty(value = "过滤的题目的一级分类，保存ID，分号分割")
    private String filterQuestionFirstType;

    @ApiModelProperty(value = "过滤的题目的二级分类，保存ID，分号分割")
    private String filterQuestionSecondType;

    @ApiModelProperty(value = "过滤的题目的三级分类，保存ID，分号分割")
    private String filterQuestionThirdType;

    @ApiModelProperty(value = "过滤的题目的四级分类，保存ID，分号分割")
    private String filterQuestionFourthType;

    @ApiModelProperty(value = "过滤类型：最近一次（lastOne），两次（lastTwo），三次（lastThree）做过的不做，或者做过的（LastAll）不做,为空不过滤")
    private String filterType;

    @ApiModelProperty(value = "本次训练的结果")
    private Double faceTrainResult;
    @ApiModelProperty("本次训练的状态")
    private String faceTrainStatus;
    @ApiModelProperty(value = "题目标题")
    private String faceTitle;

    @ApiModelProperty(value = "题目描述")
    private String faceContent;

    @ApiModelProperty(value = "题目标准答案")
    private String faceStandardAnswer;

    private Integer faceTypeFourth;

    @ApiModelProperty(value = "题目的三级分类（基础，并发，网络。。。）")
    private Integer faceTypeThird;

    @ApiModelProperty(value = "题目的二级分类（java，C，C++。。。）")
    private Integer faceTypeSecond;

    @ApiModelProperty(value = "题目的以及分类（计算机网络、编程语言）")
    private Integer faceTypeFirst;

    @ApiModelProperty(value = "题目标签")
    private String faceTag;

    @ApiModelProperty(value = "答案描述")
    private String answerNote;

    @ApiModelProperty(value = "题目描述")
    private String faceNote;

    @ApiModelProperty(value = "题目的审核状态")
    private String faceApproveStatus;

}
