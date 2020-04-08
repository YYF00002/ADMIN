package com.tima.admin.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVOByCarControl<T> implements Serializable {

	 private static final long serialVersionUID = -3032060746893382446L;

	    // 具体内容
	    private T data;

	    private String operationId;

	    private Boolean returnSuccess;

	    private String returnErrCode;

	    private String returnErrMsg;

	    private String status;
}