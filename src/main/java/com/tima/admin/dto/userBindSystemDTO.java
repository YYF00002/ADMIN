package com.tima.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * AAA请求DTO	
 * </p>
 *
 * @author YYF
 * @since 2018-08-14
 */
@Getter
@Setter
@Data
public class userBindSystemDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	@ApiModelProperty(value = "当前系统用户主键")
	private Long userId;
	
	@ApiModelProperty(value = "绑定关系表主键")
	private Long userBindSystemId;
	
	@ApiModelProperty(value = "所属系统名称对应的系统表")
	private String userBindSystemName;
	
	@ApiModelProperty(value = "对应原系统Id")
	private String originalSystemUserId;
	
	


}
