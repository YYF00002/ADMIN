package com.tima.admin.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * <p>
 * 调用SVR项目DTO
 * </p>
 *
 * @author YYF
 * @since 2018-12-11
 */
@Getter
@Setter
 public class dmSVRDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;


   private String prject;
   private String msg;
   private String account;
   private String title;
   
 }
