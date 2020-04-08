package com.tima.admin.service;

import com.tima.admin.entity.Demo;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.DemoDTO;
import com.tima.admin.vo.DemoVO;

/**
 * <p>
 * demo表 服务类
 * </p>
 *
 * @author zwh
 * @since 2018-07-12
 */
public interface IDemoService extends IService<Demo> {
   public ResultVO<?> searchDemoList(DemoDTO dto);
   public ResultVO<?> searchDemoListPage(DemoDTO dto);
   public ResultVO<?> searchDemoOne(DemoDTO dto);
   public ResultVO<?> addDemo(DemoDTO dto);
   public ResultVO<?> updateDemo(DemoDTO dto);
   public ResultVO<?> deleteDemo(DemoDTO dto);
   public ResultVO<?> searchDemoRelation(DemoDTO dto);
}
