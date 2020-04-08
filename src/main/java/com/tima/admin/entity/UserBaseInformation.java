package com.tima.admin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.*;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户基本信息表
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_base_information")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserBaseInformation extends Model<UserBaseInformation> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 编码
     */
    private String no;
    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户名称简称
     */
    @TableField("short_user_name")
    private String shortUserName;
    /**
     * 真实姓名
     */
    @TableField("user_real_name")
    private String userRealName;
    /**
     * 性别 1:男 2：女
     */
    private Integer sex;
    /**
     * 用户账号
     */
    @TableField("user_code")
    private String userCode;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户真实手机号
     */
    private String realPhone;
    /**
     * 用户状态 默认0 正常态 1锁定
     */
    @TableField("user_status")
    private Integer userStatus;
    /**
     * 身份证号
     */
    @TableField("id_cards")
    private String idCards;
    /**
     * 认证状态 0为注册用户 1为认证用户
     */
    @TableField("authentication_status")
    private Integer authenticationStatus;
    /**
     * 是否为初始用户，默认0为初始用户 1为非初始用户，初始用户需要初始化信息
     */
    @TableField("init_user")
    private Integer initUser;
    /**
     * 停用时间
     */
    @TableField("user_down_time")
    private Date userDownTime;
    /**
     * 紧急联系人
     */
    @TableField("emergency_contact_name")
    private String emergencyContactName;
    /**
     * 紧急联系人电话
     */
    @TableField("emergency_contact_phone")
    private String emergencyContactPhone;
    /**
     * 头像url
     */
    @TableField("head_url")
    private String headUrl;
    /**
     * 个性签名
     */
    @TableField("personal_signature")
    private String personalSignature;
    /**
     * 用户类型：01：app用户;02:后台管理用户
     */
    @TableField("user_type")
    private String userType;
    /**
     * 备用字段1
     */
    private String attribute1;
    /**
     * 备用字段2
     */
    private String attribute2;
    /**
     * 备用字段3
     */
    private String attribute3;
    /**
     * 备用字段4
     */
    private String attribute4;
    /**
     * 备用字段5
     */
    private String attribute5;
    /**
     * 备用字段6
     */
    private String attribute6;
    /**
     * 创建人
     */
    @TableField("created_by")
    private String createdBy;
    /**
     * 创建时间
     */
    @TableField("created_date")
    private Date createdDate;
    /**
     * 修改人
     */
    @TableField("last_modified_by")
    private String lastModifiedBy;
    /**
     * 最后修改时间
     */
    @TableField("last_modified_date")
    private Date lastModifiedDate;
    /**
     * 版本号
     */
    @Version
    private Long version;
    /**
     * 逻辑删除
     */
    @TableField("delete_flag")
    @TableLogic
    private String deleteFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
