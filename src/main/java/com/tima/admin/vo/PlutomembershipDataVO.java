package com.tima.admin.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PlutomembershipDataVO implements Serializable {
	private Integer id;
	private Long uid;
	private Integer count;
	private Integer levelId;

}
