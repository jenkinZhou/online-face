package com.jenkin.onlineface.users.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jenkin
 * @since 2020-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("face_train_questions_suit")
public class TrainQuestionsSuit extends Model<TrainQuestionsSuit> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 当前题目的ID
     */
    private Integer faceTrainQuestionId;

    /**
     * 当前题目你的解答
     */
    private String faceTrainQuestonAnswer;

    /**
     * 1-10 的整数，当前题目的困难程度
     */
    private Integer faceTrainDifficulty;

    /**
     * 当前题目你认为是否通过（Y、N）
     */
    private String faceTrainPass;

    /**
     * 你对当前题目做的笔记
     */
    private String faceTrainNote;

    /**
     * 逻辑删除字段
     */
    private String delFlag;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime creationDate;

    /**
     * 更新时间
     */
    private LocalDateTime lastUpdateDate;

    /**
     * 更新人
     */
    private LocalDateTime lastUpdatedBy;

    /**
     * 版本号
     */
    private Integer versionNumber;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
