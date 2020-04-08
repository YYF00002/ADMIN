package com.tima.admin.mapper;

import com.tima.admin.dto.RolePermissionsRelationDTO;
import com.tima.admin.entity.RolePermissionsRelation;
import com.tima.admin.vo.UserPermissionsInfoVO;
import com.tima.admin.vo.UserRoleVO;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色权限关联表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-08-01
 */
@Mapper
public interface RolePermissionsRelationMapper extends BaseMapper<RolePermissionsRelation> {
    //自定义分页参考方法，需要xml里面添加该方法
    //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);

    // 根据角色查权限
    public UserPermissionsInfoVO selectPermissionsByRole(RolePermissionsRelationDTO dto);

    // 根据权限查角色
    public UserRoleVO selectRoleByPermissions(RolePermissionsRelationDTO dto);
}
