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

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 第三方请求记录表
 * </p>
 *
 * @author YYF
 * @since 2018-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("third_party_request")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThirdPartyRequest extends Model<ThirdPartyRequest> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String no;
    /**
     * 请求来源：1.DMS 2.AAA 3.TSP
     */
    @TableField("request_source")
    private Integer requestSource;
    /**
     * 请求方法
     */
    @TableField("request_method")
    private String requestMethod;
    /**
     * 请求参数
     */
    @TableField("request_json")
    private String requestJson;
    /**
     * 响应参数
     */
    @TableField("response_json")
    private String responseJson;
    
	@ApiModelProperty(value = "token")
	private String token;
	
	@ApiModelProperty(value = "授权码")
	private String authorization;
    
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
