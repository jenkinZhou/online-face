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
 * @since 2020-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("face_user")
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户编号
     */
    private String faceUserCode;

    /**
     * 用户名称
     */
    private String faceUserName;

    /**
     * 用户邮箱
     */
    private String faceUserEmail;

    /**
     * 用户密码
     */
    private String faceUserPassword;

    /**
     * 用户状态
     */
    private String faceUserStatus;

    /**
     * 用户的积分
     */
    private Integer faceUserPoints;

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
    private String lastUpdatedBy;

    /**
     * 版本号
     */
    private Integer versionNumber;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
