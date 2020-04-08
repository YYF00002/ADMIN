package com.tima.admin.config;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;

public class MyMetaObjectHandler extends MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		setFieldValByName("deleteFlag", "0", metaObject);
		setFieldValByName("version",Long.valueOf(0),metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		
		
	}

}
