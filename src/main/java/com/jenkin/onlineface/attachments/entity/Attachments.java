package com.jenkin.onlineface.attachments.entity;

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
@TableName("face_attachments")
@ApiModel(value="Attachments对象", description="")
public class Attachments extends Model<Attachments> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "附件编码")
    private String attachmentCode;

    @ApiModelProperty(value = "附件名称")
    private String attachmentName;

    @ApiModelProperty(value = "附件格式（目前只能是图片）")
    private String attachmentFormat;

    @ApiModelProperty(value = "附件路径")
    private String attachmentPath;

    @ApiModelProperty(value = "附件归档年")
    private String attachmentLocateYear;

    @ApiModelProperty(value = "附件归档月")
    private String attachmentLocateMonth;

    @ApiModelProperty(value = "附件归档日")
    private String attachmentLocateDay;

    @ApiModelProperty(value = "附件类型（评论附件，题目附件）")
    private String attachmentType;

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
