package com.tima.admin.service;

import com.tima.admin.entity.ResourcePermissionsRelation;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.ResourcePermissionsRelationDTO;
import com.tima.admin.vo.ResourcePermissionsRelationVO;

/**
 * <p>
 * 资源权限关联表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface IResourcePermissionsRelationService extends IService<ResourcePermissionsRelation> {
   public ResultVO<?> searchResourcePermissionsRelationList(ResourcePermissionsRelationDTO dto);
   public ResultVO<?> searchResourcePermissionsRelationListPage(ResourcePermissionsRelationDTO dto);
   public ResultVO<?> searchResourcePermissionsRelationOne(ResourcePermissionsRelationDTO dto);
   public ResultVO<?> addResourcePermissionsRelation(ResourcePermissionsRelationDTO dto);
   public ResultVO<?> updateResourcePermissionsRelation(ResourcePermissionsRelationDTO dto);
   public ResultVO<?> deleteResourcePermissionsRelation(ResourcePermissionsRelationDTO dto);
   public ResultVO<?> searchResourcePermissionsRelationRelation(ResourcePermissionsRelationDTO dto);
}
