package com.jenkin.onlineface.users.entity;

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
@TableName("face_user")
@ApiModel(value="User对象", description="")
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户编号")
    private String faceUserCode;

    @ApiModelProperty(value = "用户名称")
    private String faceUserName;

    @ApiModelProperty(value = "用户邮箱")
    private String faceUserEmail;

    @ApiModelProperty(value = "用户密码")
    private String faceUserPassword;

    @ApiModelProperty(value = "用户状态")
    private String faceUserStatus;

    @ApiModelProperty(value = "用户的积分")
    private Integer faceUserPoints;

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
