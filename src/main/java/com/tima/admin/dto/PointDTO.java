package com.tima.admin.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointDTO implements Serializable{
	
	private static final long serialVersionUID = -6299729485825026341L;
	private Integer no;
	private Double longitude;
	private Double latitude;
}
