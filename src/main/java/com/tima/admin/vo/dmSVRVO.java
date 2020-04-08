package com.tima.admin.vo;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * <p>
 * 调用SVR项目vo
 * </p>
 *
 * @author YYF
 * @since 2018-12-11
 */
@Getter
@Setter
 public class dmSVRVO implements Serializable{
   private static final long serialVersionUID = 1L;


   private int status;
   private String errorMsg;
   private String data;

 }
