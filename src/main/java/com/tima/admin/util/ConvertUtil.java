package com.tima.admin.util;
import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tima.admin.dto.BaseDTO;



public class ConvertUtil<K extends BaseDTO,V > {
	public   Page<V> pageCommon(K k ,V v){
		Page<V> page=new Page<V>();
		
		page.setSize(k.getSize());
		page.setCurrent(k.getCurrent());		
		return page;		
	}
	public  EntityWrapper<V> entityWrapper(K k ,V v){
		EntityWrapper<V> entityWrapper=new EntityWrapper<V>();
		BeanUtils.copyProperties(k,v);
		entityWrapper.setEntity(v);
		return entityWrapper;
		
	}
	public V entity(K k ,V v) {
		BeanUtils.copyProperties(k,v);
		return v;
		
	}

}
