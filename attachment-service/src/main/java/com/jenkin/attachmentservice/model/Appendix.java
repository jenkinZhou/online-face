package com.jenkin.attachmentservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@EntityListeners(AuditingEntityListener.class)
@ApiModel("附件实体")
@Table( name = "appendix")
public class Appendix {
    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "主键")
    private Integer appendixId;
    @Column(nullable = false)
    @ApiModelProperty(notes = "附件对应的音乐")
    private Integer musicId;
    @Column(nullable = false)
    @ApiModelProperty(notes = "附件编码，用于下载，删除文件")
    private String appendixCode;
    @Column(nullable = false)
    /**
     *  lyric ,logo ,music
     */
    private String appendixType;
    @Column
    private String appendixGrade;
    @CreatedDate
    @Column(nullable = false)
    private Timestamp creationDate;
    @LastModifiedDate
    @Column(nullable = false)
    private Timestamp lastUpdateDate;

    public Appendix(Integer musicId,String appendixCode,String appendixType){
        this.appendixCode =appendixCode;
        this.musicId = musicId;
        this.appendixType =appendixType;
    }
    public Appendix(){}

    public Integer getAppendixId() {
        return appendixId;
    }

    public void setAppendixId(Integer appendixId) {
        this.appendixId = appendixId;
    }

    public String getAppendixCode() {
        return appendixCode;
    }

    public void setAppendixCode(String appendixCode) {
        this.appendixCode = appendixCode;
    }

    public String getAppendixType() {
        return appendixType;
    }

    public void setAppendixType(String appendixType) {
        this.appendixType = appendixType;
    }

    public String getAppendixGrade() {
        return appendixGrade;
    }

    public void setAppendixGrade(String appendixGrade) {
        this.appendixGrade = appendixGrade;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }
}