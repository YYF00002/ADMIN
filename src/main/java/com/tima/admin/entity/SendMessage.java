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
 * 消息推送
 * </p>
 *
 * @author YYF
 * @since 2018-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("send_message")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMessage extends Model<SendMessage> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String no;
    /**
     * 服务通知类型（0 用户推送  1 标签推送）
     */
    private String type;
    /**
     * 推送对象
     */
    @TableField("push_object")
    private String pushObject;
    /**
     * 推送的时间
     */
    @TableField("notification_time")
    private Date notificationTime;
    /**
     * 是否推送
     */
    @TableField("push_flag")
    private Integer pushFlag;
    /**
     * 推送标题
     */
    private String title;
    /**
     * 推送的详细数据
     */
    private String data;
    /**
     * 读取状态  0 - 未读取  1 - 已读取
     */
    @TableField("read_status")
    private Integer readStatus;
    /**
     * 是否成功 0 成功  1未成功
     */
    @TableField("is_success")
    private Integer isSuccess;
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
