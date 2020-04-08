package com.tima.admin.mapper;

import com.tima.admin.dto.UserRoleRelationDTO;
import com.tima.admin.entity.UserRoleRelation;
import com.tima.admin.vo.UserRoleRelationVO;
import com.tima.admin.vo.UserRoleVO;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
 * 用户角色关联表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface UserRoleRelationMapper extends BaseMapper<UserRoleRelation> {
   //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
	
	 //查询角色绑定的用户集合
   public List<UserRoleRelationVO> selectUserRoleRelationListPage(Pagination page,UserRoleRelationDTO dto);
   //根据用户查角色
   public List<UserRoleRelationVO> selectUserRoleByUserListPage(Pagination page,UserRoleRelationDTO dto);
}
