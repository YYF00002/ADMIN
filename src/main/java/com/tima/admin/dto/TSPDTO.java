package com.tima.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * TSP请求DTO	
 * </p>
 *
 * @author YYF
 * @since 2018-08-14
 */
@Getter
@Setter
public class TSPDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "头部信息集合")
	private Map<String,String> headInfo;
	
	@ApiModelProperty(value = "紧急联系人电话")
	private String urgentPersonNum;
	
	
	
	


}
