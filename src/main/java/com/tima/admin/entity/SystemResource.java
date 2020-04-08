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
 * 系统资源表
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("system_resource")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SystemResource extends Model<SystemResource> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 编码
     */
    private String no;
    /**
     * 模块id
     */
    @TableField("module_id")
    private Long moduleId;
    /**
     * 模块编码
     */
    @TableField("module_no")
    private String moduleNo;
    /**
     * 模块名称
     */
    @TableField("module_name")
    private String moduleName;
    /**
     * 服务名称
     */
    @TableField("serivce_name")
    private String serivceName;
    /**
     * 接口名称
     */
    @TableField("api_name")
    private String apiName;
    /**
     * 方法名称
     */
    @TableField("method_name")
    private String methodName;
    /**
     * 模块路径
     */
    @TableField("module_path")
    private String modulePath;
    /**
     * 方法路径
     */
    @TableField("method_path")
    private String methodPath;
    /**
     * 接口地址
     */
    private String url;
    /**
     * 备注
     */
    private String remark;
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
