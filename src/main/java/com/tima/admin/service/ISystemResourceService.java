package com.tima.admin.service;

import com.tima.admin.entity.SystemResource;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.SystemResourceDTO;
import com.tima.admin.vo.SystemResourceVO;

/**
 * <p>
 * 系统资源表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface ISystemResourceService extends IService<SystemResource> {
   public ResultVO<?> searchSystemResourceList(SystemResourceDTO dto);
   public ResultVO<?> searchSystemResourceListPage(SystemResourceDTO dto);
   public ResultVO<?> searchSystemResourceOne(SystemResourceDTO dto);
   public ResultVO<?> addSystemResource(SystemResourceDTO dto);
   public ResultVO<?> updateSystemResource(SystemResourceDTO dto);
   public ResultVO<?> deleteSystemResource(SystemResourceDTO dto);
   public ResultVO<?> searchSystemResourceRelation(SystemResourceDTO dto);
}
