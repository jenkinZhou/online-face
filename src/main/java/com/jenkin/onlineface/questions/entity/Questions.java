package com.jenkin.onlineface.questions.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("face_questions")
@ApiModel(value="Questions对象", description="")
public class Questions extends Model<Questions> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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

    @ApiModelProperty(value = "逻辑删除字段")
    private String delFlag;

    @ApiModelProperty(value = "创建人")
    @TableField(fill= FieldFill.INSERT)
    private String createdBy;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill= FieldFill.INSERT)
    private LocalDateTime creationDate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime lastUpdateDate;

    @ApiModelProperty(value = "更新人")
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private String lastUpdatedBy;

    @ApiModelProperty(value = "版本号")
    @Version
    private Integer versionNumber;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
