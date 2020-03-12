package com.jenkin.onlineface.questions.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("face_question_types")
@ApiModel(value="QuestionTypes对象", description="")
public class QuestionTypes extends Model<QuestionTypes> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "题目类型的名称")
    private String faceQuestionTypeName;

    @ApiModelProperty(value = "题目类型的级别 1,2,3,4")
    private Integer faceQuestionTypeLevel;

    private Integer parentId;

    @ApiModelProperty(value = "逻辑删除字段")
    private String delFlag;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime creationDate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime lastUpdateDate;

    @ApiModelProperty(value = "更新人")
    private String lastUpdatedBy;

    @ApiModelProperty(value = "版本号")
    private Integer versionNumber;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
