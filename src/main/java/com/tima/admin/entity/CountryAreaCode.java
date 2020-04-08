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
 * 国统局区域代码
 * </p>
 *
 * @author YYF
 * @since 2018-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("country_area_code")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryAreaCode extends Model<CountryAreaCode> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 区域代码
     */
    private String code;
    /**
     * 区域名称
     */
    private String name;
    /**
     * 父级id
     */
    @TableField("parent_id")
    private Long parentId;
    /**
     * 上级区域代码
     */
    @TableField("parent_code")
    private String parentCode;
    /**
     * 层级
     */
    private Integer level;
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
