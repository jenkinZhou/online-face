package com.jenkin.onlineface.users.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("face_user_train")
@ApiModel(value="UserTrain对象", description="")
public class UserTrain extends Model<UserTrain> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户编码")
    private String userCode;

    @ApiModelProperty(value = "问题套餐记录ID")
    private Integer questionRecordId;

    @ApiModelProperty(value = "当前进行的训练的类型（自定义随机）")
    private String faceTrainType;

    @ApiModelProperty(value = "题目数目，默认50")
    private Integer questionNum;

    @ApiModelProperty(value = "过滤的题目的一级分类，保存ID，分号分割")
    private String filterQuestionFirstType;

    @ApiModelProperty(value = "过滤的题目的二级分类，保存ID，分号分割")
    private String filterQuestionSecondType;

    @ApiModelProperty(value = "过滤的题目的三级分类，保存ID，分号分割")
    private String filterQuestionThirdType;

    @ApiModelProperty(value = "过滤的题目的四级分类，保存ID，分号分割")
    private String filterQuestionFourthType;

    @ApiModelProperty(value = "过滤类型：最近一次（lastOne），两次（lastTwo），三次（lastThree）做过的不做，或者做过的（LastAll）不做,为空不过滤")
    private String filterType;

    @ApiModelProperty(value = "本次训练的结果")
    private Double faceTrainResult;
    @ApiModelProperty("本次训练的状态")
    private String faceTrainStatus;

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
