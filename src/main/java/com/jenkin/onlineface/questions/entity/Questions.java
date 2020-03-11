package com.jenkin.onlineface.questions.entity;

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
@TableName("face_questions")
public class Questions extends Model<Questions> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 题目序号
     */
    private Integer faceSeqNumber;

    /**
     * 题目标题
     */
    private String faceTitle;

    /**
     * 题目描述
     */
    private String faceContent;

    /**
     * 题目标准答案
     */
    private String faceStandardAnswer;

    private Integer faceTypeFourth;

    /**
     * 题目的三级分类（基础，并发，网络。。。）
     */
    private Integer faceTypeThird;

    /**
     * 题目的二级分类（java，C，C++。。。）
     */
    private Integer faceTypeSeond;

    /**
     * 题目的以及分类（计算机网络、编程语言）
     */
    private Integer faceTypeFirst;

    /**
     * 题目标签
     */
    private String faceTag;

    /**
     * 答案描述
     */
    private String answerNote;

    /**
     * 题目描述
     */
    private String faceNote;

    /**
     * 题目的审核状态
     */
    private String faceApproveStatus;

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
