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

public class Questions {


    private Integer id;

    private Integer faceSeqNumber;

    private String faceTitle;

    private String faceContent;

    private String faceStandardAnswer;

    private Integer faceTypeFourth;

    private Integer faceTypeThird;

    private Integer faceTypeSecond;

    private Integer faceTypeFirst;

    private String faceTag;

    private String answerNote;

    private String faceNote;

    private String faceApproveStatus;

    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFaceSeqNumber() {
        return faceSeqNumber;
    }

    public void setFaceSeqNumber(Integer faceSeqNumber) {
        this.faceSeqNumber = faceSeqNumber;
    }

    public String getFaceTitle() {
        return faceTitle;
    }

    public void setFaceTitle(String faceTitle) {
        this.faceTitle = faceTitle;
    }

    public String getFaceContent() {
        return faceContent;
    }

    public void setFaceContent(String faceContent) {
        this.faceContent = faceContent;
    }

    public String getFaceStandardAnswer() {
        return faceStandardAnswer;
    }

    public void setFaceStandardAnswer(String faceStandardAnswer) {
        this.faceStandardAnswer = faceStandardAnswer;
    }

    public Integer getFaceTypeFourth() {
        return faceTypeFourth;
    }

    public void setFaceTypeFourth(Integer faceTypeFourth) {
        this.faceTypeFourth = faceTypeFourth;
    }

    public Integer getFaceTypeThird() {
        return faceTypeThird;
    }

    public void setFaceTypeThird(Integer faceTypeThird) {
        this.faceTypeThird = faceTypeThird;
    }

    public Integer getFaceTypeSecond() {
        return faceTypeSecond;
    }

    public void setFaceTypeSecond(Integer faceTypeSecond) {
        this.faceTypeSecond = faceTypeSecond;
    }

    public Integer getFaceTypeFirst() {
        return faceTypeFirst;
    }

    public void setFaceTypeFirst(Integer faceTypeFirst) {
        this.faceTypeFirst = faceTypeFirst;
    }

    public String getFaceTag() {
        return faceTag;
    }

    public void setFaceTag(String faceTag) {
        this.faceTag = faceTag;
    }

    public String getAnswerNote() {
        return answerNote;
    }

    public void setAnswerNote(String answerNote) {
        this.answerNote = answerNote;
    }

    public String getFaceNote() {
        return faceNote;
    }

    public void setFaceNote(String faceNote) {
        this.faceNote = faceNote;
    }

    public String getFaceApproveStatus() {
        return faceApproveStatus;
    }

    public void setFaceApproveStatus(String faceApproveStatus) {
        this.faceApproveStatus = faceApproveStatus;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", faceSeqNumber=" + faceSeqNumber +
                ", faceTitle='" + faceTitle + '\'' +
                ", faceContent='" + faceContent + '\'' +
                ", faceStandardAnswer='" + faceStandardAnswer + '\'' +
                ", faceTypeFourth=" + faceTypeFourth +
                ", faceTypeThird=" + faceTypeThird +
                ", faceTypeSecond=" + faceTypeSecond +
                ", faceTypeFirst=" + faceTypeFirst +
                ", faceTag='" + faceTag + '\'' +
                ", answerNote='" + answerNote + '\'' +
                ", faceNote='" + faceNote + '\'' +
                ", faceApproveStatus='" + faceApproveStatus + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
