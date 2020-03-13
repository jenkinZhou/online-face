package com.jenkin.onlineface.users.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

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
@FieldNameConstants
@TableName("face_train_questions_suit")
@ApiModel(value="TrainQuestionsSuit对象", description="")
public class TrainQuestionsSuit extends Model<TrainQuestionsSuit> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
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
