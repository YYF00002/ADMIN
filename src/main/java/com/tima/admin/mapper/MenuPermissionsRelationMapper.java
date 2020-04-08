package com.tima.admin.mapper;

import com.tima.admin.dto.MenuPermissionsRelationDTO;
import com.tima.admin.entity.MenuPermissionsRelation;
import com.tima.admin.vo.MenuPermissionsRelationVO;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.TreeNodeVO;
import com.tima.admin.vo.UserMenuInfoVO;
import com.tima.admin.vo.UserPermissionsInfoVO;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
 * 菜单权限关联表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface MenuPermissionsRelationMapper extends BaseMapper<MenuPermissionsRelation> {
    // 自定义分页参考方法，需要xml里面添加该方法
    // public List<VehicleCustom> selectVehicleCustomList(Pagination
    // page,VehicleCustom custom);

    // 根据用户查菜单
    List<TreeNodeVO> selectMenuByPermission(MenuPermissionsRelationDTO dto);

    // 根据角色查菜单
    List<TreeNodeVO> selectMenuByRole(MenuPermissionsRelationDTO dto);

    //查出所有有权限的接口地址
    List<TreeNodeVO> selectAllRoleInterfaceAddress();
}
