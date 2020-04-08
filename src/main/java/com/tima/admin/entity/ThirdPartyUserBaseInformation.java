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
 * 第三方用户信息表
 * </p>
 *
 * @author YYF
 * @since 2018-08-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("third_party_user_base_information")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThirdPartyUserBaseInformation extends Model<ThirdPartyUserBaseInformation> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String no;
    
    /**
     * AAA用户id
     */
    @TableField("AAA_id")
    private Long AAAId;
    /**
     * tsp用户id
     */
    @TableField("tsp_id")
    private Long tspId;
    /**
     * APP用户ID
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 登录用户名
     */
    private String username;
    /**
     * 密码（MD5）
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;
    /**
     * 地址
     */
    private String address;
    /**
     * AAA用户token
     */
    private String token;
    /**
     * AAA用户刷新token
     */
    @TableField("refresh_token")
    private String refreshToken;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别 1 男 2 女
     */
    private Integer sex;
    /**
     * 过期 1 过期   0 可用
     */
    private Integer expired;
    /**
     * 不可用 1不可用 0可用
     */
    private Integer disabled;
    /**
     * 用户信息json字符串
     */
    @TableField("user_bind_systems")
    private String userBindSystems;
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
