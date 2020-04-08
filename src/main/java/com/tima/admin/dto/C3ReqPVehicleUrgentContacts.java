package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * tsp修改紧急联系人数据传输对象
 * @author admin
 *
 */
@Getter
@Setter
public class C3ReqPVehicleUrgentContacts {


    @ApiModelProperty(value = "紧急联系人电话")
    private String urgentPersonNum;
    
}
