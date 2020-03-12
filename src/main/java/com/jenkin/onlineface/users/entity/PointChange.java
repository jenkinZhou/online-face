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
@TableName("face_point_change")
public class PointChange extends Model<PointChange> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户编码
     */
    private String faceUserCode;

    /**
     * 积分变动数目
     */
    private Integer pointChangeNum;

    /**
     * 积分变动时间
     */
    private LocalDateTime pointChangeDate;

    /**
     * 积分变动类型，上传题目？做题？。。。
     */
    private String pointChangeType;

    /**
     * 积分变动详情
     */
    private String pointChangeContent;

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
