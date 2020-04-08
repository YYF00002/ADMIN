package com.tima.admin.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * <p>
 * 用户菜单信息表
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_menu_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserMenuInfo extends Model<UserMenuInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 编码
     */
    private String no;
    /**
     * 菜单编码（根据需要使用）
     */
    @TableField("menu_code")
    private String menuCode;
    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;
    /**
     * 菜单类型 0为后台系统菜单 1为前台业务菜单
     */
    @TableField("menu_type")
    private Integer menuType;
    /**
     * 上级菜单id
     */
    @TableField("menu_parent_id")
    private Long menuParentId;
    /**
     * 内部序号供排序使用
     */
    @TableField("order_num")
    private String orderNum;
    /**
     * 菜单url地址
     */
    @TableField("menu_url")
    private String menuUrl;
    /**
     * 是否末级 Y为末级 N或者空为非末级 默认为N(根据需要使用)
     */
    @TableField("is_end")
    private String isEnd;
    /**
     * 是否是菜单：0：不是：1：是
     */
    @TableField("is_menu")
    private Integer isMenu;
    /**
     * 菜单级别
     */
    @TableField("menu_level")
    private Integer menuLevel;
    /**
     * 菜单图标
     */
    @TableField("menu_ico")
    private String menuIco;
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
