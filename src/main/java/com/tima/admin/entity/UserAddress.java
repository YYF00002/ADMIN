package com.tima.admin.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.Version;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户收货地址
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_address")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAddress extends Model<UserAddress> {

    private static final long serialVersionUID = 1L;

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
     * 用户编码
     */
    @TableField("user_no")
    private String userNo;
    /**
     * 收货人姓名
     */
    @TableField("receive_name")
    private String receiveName;
    /**
     * 收货人联系电话
     */
    @TableField("receive_mobile")
    private String receiveMobile;
    /**
     * 是否默认地址
     */
    @TableField("is_default")
    private Integer isDefault;
    /**
     * 收货人地址
     */
    private String address;
    /**
     * 邮编
     */
    private String zipcode;
    /**
     * 省份id
     */
    @TableField("province_id")
    private Long provinceId;
    /**
     * 省份编码
     */
    @TableField("province_code")
    private String provinceCode;
    /**
     * 省份名称
     */
    @TableField("province_name")
    private String provinceName;
    /**
     * 城市id
     */
    @TableField("city_id")
    private Long cityId;
    /**
     * 城市编码
     */
    @TableField("city_code")
    private String cityCode;
    /**
     * 城市名称
     */
    @TableField("city_name")
    private String cityName;
    /**
     * 区域id
     */
    @TableField("country_id")
    private Long countryId;
    /**
     * 区域编码
     */
    @TableField("country_code")
    private String countryCode;
    /**
     * 区域名称
     */
    @TableField("country_name")
    private String countryName;
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
