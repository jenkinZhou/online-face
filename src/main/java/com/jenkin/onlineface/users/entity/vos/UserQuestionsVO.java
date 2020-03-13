package com.jenkin.onlineface.users.entity.vos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
@ApiModel("用户收藏的题目")
public class UserQuestionsVO {

    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer faceUserId;

    @ApiModelProperty(value = "用户需要忽略的问题ID")
    private Integer faceQuestionId;
    @ApiModelProperty(value = "用户编码")
    private String faceUserCode;
    @ApiModelProperty(value = "忽略（ignore）还是 收藏（star）")
    private String faceQuestionFlag;

    @ApiModelProperty(value = "题目序号")
    private Integer faceSeqNumber;

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
    private Integer faceTypeSeond;

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
