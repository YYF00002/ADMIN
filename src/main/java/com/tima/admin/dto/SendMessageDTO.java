package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * 消息推送
 * </p>
 *
 * @author YYF
 * @since 2018-12-11
 */
@Getter
@Setter
 public class SendMessageDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
    private Long id;

    private String no;

    @ApiModelProperty(value = "服务通知类型（0 用户推送  1 标签推送）")
    private String type;

    @ApiModelProperty(value = "推送对象")
    private String pushObject;

    @ApiModelProperty(value = "推送的时间")
    private Date notificationTime;

    @ApiModelProperty(value = "是否推送")
    private Integer pushFlag;

    @ApiModelProperty(value = "推送标题")
    private String title;

    @ApiModelProperty(value = "推送的详细数据")
    private String data;

    @ApiModelProperty(value = "读取状态  0 - 未读取  1 - 已读取")
    private Integer readStatus;

    @ApiModelProperty(value = "是否成功 0 成功  1未成功")
    private Integer isSuccess;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "创建时间")
    private Date createdDate;

    @ApiModelProperty(value = "修改人")
    private String lastModifiedBy;

    @ApiModelProperty(value = "最后修改时间")
    private Date lastModifiedDate;

    @ApiModelProperty(value = "版本号")
    private Long version;

    @ApiModelProperty(value = "逻辑删除")
    private String deleteFlag;


    @ApiModelProperty(value = "推送的用户标签集合")
    private List<String> labels;
   
 }
