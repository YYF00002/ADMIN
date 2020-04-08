package com.tima.admin.service;

import com.tima.admin.entity.SystemModule;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.SystemModuleDTO;
import com.tima.admin.vo.SystemModuleVO;

/**
 * <p>
 * 系统模块表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface ISystemModuleService extends IService<SystemModule> {
   public ResultVO<?> searchSystemModuleList(SystemModuleDTO dto);
   public ResultVO<?> searchSystemModuleListPage(SystemModuleDTO dto);
   public ResultVO<?> searchSystemModuleOne(SystemModuleDTO dto);
   public ResultVO<?> addSystemModule(SystemModuleDTO dto);
   public ResultVO<?> updateSystemModule(SystemModuleDTO dto);
   public ResultVO<?> deleteSystemModule(SystemModuleDTO dto);
   public ResultVO<?> searchSystemModuleRelation(SystemModuleDTO dto);
}
