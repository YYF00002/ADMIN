package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * tsp查询我的车辆
 * @author admin
 *
 */
@Getter
@Setter
public class TSPRequestSyncVehicle {

	@ApiModelProperty(value="tsp用户对于的id")
    private String tspUserId;
	
	@ApiModelProperty(value="用户的id")
	private String userId;

	@ApiModelProperty(value="AAA的userId")
	private String aaaUserID;
	
	@ApiModelProperty(value="用户的phone")
	private String phone;
    
}
