package com.jenkin.crawldatautil.demo;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */

public class QuestionTypes   {

    private Integer id;
    private String faceQuestionTypeName;
    private Integer faceQuestionTypeLevel;
    private Integer parentId;
    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFaceQuestionTypeName() {
        return faceQuestionTypeName;
    }

    public void setFaceQuestionTypeName(String faceQuestionTypeName) {
        this.faceQuestionTypeName = faceQuestionTypeName;
    }

    public Integer getFaceQuestionTypeLevel() {
        return faceQuestionTypeLevel;
    }

    public void setFaceQuestionTypeLevel(Integer faceQuestionTypeLevel) {
        this.faceQuestionTypeLevel = faceQuestionTypeLevel;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "QuestionTypes{" +
                "id=" + id +
                ", faceQuestionTypeName='" + faceQuestionTypeName + '\'' +
                ", faceQuestionTypeLevel=" + faceQuestionTypeLevel +
                ", parentId=" + parentId +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
