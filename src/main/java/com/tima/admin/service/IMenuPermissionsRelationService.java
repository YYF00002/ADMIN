package com.tima.admin.service;

import com.tima.admin.entity.MenuPermissionsRelation;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.MenuPermissionsRelationDTO;

/**
 * <p>
 * 菜单权限关联表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface IMenuPermissionsRelationService extends IService<MenuPermissionsRelation> {
    //   public ResultVO<?> searchMenuPermissionsRelationList(MenuPermissionsRelationDTO dto);
//   public ResultVO<?> searchMenuPermissionsRelationListPage(MenuPermissionsRelationDTO dto);
//   public ResultVO<?> searchMenuPermissionsRelationOne(MenuPermissionsRelationDTO dto);
    public ResultVO<?> addMenuPermissionsRelation(List<MenuPermissionsRelationDTO> dto);

    //   public ResultVO<?> updateMenuPermissionsRelation(MenuPermissionsRelationDTO dto);
    public ResultVO<?> deleteMenuPermissionsRelation(MenuPermissionsRelationDTO dto);

    //   public ResultVO<?> searchMenuPermissionsRelationRelation(MenuPermissionsRelationDTO dto);
    //根据用户查菜单
    public ResultVO<?> selectMenuByPermission(MenuPermissionsRelationDTO dto);

    public ResultVO<?> selectMenuByUserId(MenuPermissionsRelationDTO dto);

    //根据角色查菜单
    public ResultVO<?> selectMenuByRoleWeb(MenuPermissionsRelationDTO dto);

    //查出所有有权限的接口地址
    public ResultVO<?> selectAllRoleInterfaceAddress();

}
