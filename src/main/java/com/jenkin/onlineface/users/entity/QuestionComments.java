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
@TableName("face_question_comments")
@ApiModel(value="QuestionComments对象", description="")
public class QuestionComments extends Model<QuestionComments> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "题目的ID")
    private Integer questionId;

    @ApiModelProperty(value = "回复的评论的ID")
    private Integer replyCommentId;

    @ApiModelProperty(value = "评论内容")
    private String questionComment;

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
