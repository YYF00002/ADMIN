package com.tima.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户基本信息表
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class UserBaseInformationVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "用户名称")  
   private String userName;
   
    @ApiModelProperty(value = "用户名称简称")  
   private String shortUserName;
   
    @ApiModelProperty(value = "真实姓名")  
   private String userRealName;
   
    @ApiModelProperty(value = "性别 1:男 2：女")  
   private Integer sex;
   
    @ApiModelProperty(value = "用户账号")  
   private String userCode;
   
    @ApiModelProperty(value = "用户密码")
   private String password;
   
    @ApiModelProperty(value = "用户邮箱")  
   private String email;
   
    @ApiModelProperty(value = "用户手机号")  
   private String phone;

    @ApiModelProperty(value = "用户真实手机号")
    private String realPhone;
   
    @ApiModelProperty(value = "用户状态 默认0 正常态 1锁定")  
   private Integer userStatus;
   
    @ApiModelProperty(value = "身份证号")  
   private String idCards;
   
    @ApiModelProperty(value = "认证状态 0为注册用户 1为认证用户")  
   private Integer authenticationStatus;
   
    @ApiModelProperty(value = "是否为初始用户，默认0为初始用户 1为非初始用户，初始用户需要初始化信息")  
   private Integer initUser;
   
    @ApiModelProperty(value = "停用时间")  
   private Date userDownTime;
   
    @ApiModelProperty(value = "紧急联系人")  
   private String emergencyContactName;
   
    @ApiModelProperty(value = "紧急联系人电话")  
   private String emergencyContactPhone;
   
    @ApiModelProperty(value = "头像url")  
   private String headUrl;
    
    @ApiModelProperty(value = "个性签名")  
   private String personalSignature;
    
    @ApiModelProperty(value = "用户类型：01：app用户;02:后台管理用户")  
   private String userType;
    
    @ApiModelProperty(value = "用户认证token")  
    private String token;
    
    @ApiModelProperty(value = "用户认证刷新token")  
    private String refreshToken;
    
    @ApiModelProperty(value = "用户头像")  
    private String imageUrl;
   
    @ApiModelProperty(value = "备用字段1")  
   private String attribute1;
   
    @ApiModelProperty(value = "备用字段2")  
   private String attribute2;
   
    @ApiModelProperty(value = "备用字段3")  
   private String attribute3;
   
    @ApiModelProperty(value = "备用字段4")  
   private String attribute4;
   
    @ApiModelProperty(value = "备用字段5")  
   private String attribute5;
   
    @ApiModelProperty(value = "备用字段6")  
   private String attribute6;
   
//    @ApiModelProperty(value = "创建人")  
//   private String createdBy;
//   
    @ApiModelProperty(value = "创建时间")
   private Date createdDate;

    @ApiModelProperty(value = "修改人")
   private String lastModifiedBy;

    @ApiModelProperty(value = "最后修改时间")
   private Date lastModifiedDate;
//    @ApiModelProperty(value = "版本号")
//   private Long version;
//
    @ApiModelProperty(value = "逻辑删除")
   private String deleteFlag;
    
    @ApiModelProperty(value = "角色名称")  
    private String roleName;
    
    @ApiModelProperty(value = "角色id")  
    private Long roleId;


    @ApiModelProperty(value = "AAAid")
    private Long AAAId;

    @ApiModelProperty(value = "aaaToken")
    private String aaaToken;

    @ApiModelProperty(value = "TSPid")
    private Long TSPId;

    @ApiModelProperty(value = "AAA的username")
    private String AAAUserName;


    @ApiModelProperty(value = "图片验证码base64")
    private String codeImg;

    @ApiModelProperty(value = "图片验证码唯一标识")
    private String codeImgId;


    @ApiModelProperty(value = "积分")
    private String integral;


    @ApiModelProperty(value = "标签名称集合")
    private List<LabelEntityVO> entitys;

    @ApiModelProperty(value = "第三方头像")
    private String headImage;


    @ApiModelProperty(value = "第三方昵称")
    private String nick;

 }