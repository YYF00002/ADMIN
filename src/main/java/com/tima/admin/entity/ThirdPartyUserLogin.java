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
 * 第三方登录信息表 
 * </p>
 *
 * @author YYF
 * @since 2020-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("third_party_user_login")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThirdPartyUserLogin extends Model<ThirdPartyUserLogin> {

    private static final long serialVersionUID = 1L;

    /**
     *  id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 编码
     */
    private String no;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 第三方标识
     */
    @TableField("open_id")
    private String openId;
    /**
     * 第三方token
     */
    private String token;
    /**
     * 第三方refresh_token
     */
    @TableField("refresh_token")
    private String refreshToken;
    /**
     * 第三方性别
     */
    private String sex;
    /**
     * 第三方类型 0.微信 1.QQ
     */
    private String type;
    /**
     * 第三方头像
     */
    @TableField("head_img")
    private String headImg;
    /**
     * 昵称
     */
    private String nick;
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
