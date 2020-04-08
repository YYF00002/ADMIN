package com.tima.admin.service.impl;

import com.tima.admin.entity.MenuPermissionsRelation;
import com.tima.admin.entity.RolePermissionsRelation;
import com.tima.admin.entity.UserMenuInfo;
import com.tima.admin.entity.UserPermissionsInfo;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.mapper.MenuPermissionsRelationMapper;
import com.tima.admin.mapper.RolePermissionsRelationMapper;
import com.tima.admin.service.IMenuPermissionsRelationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.TreeNodeVO;
import com.tima.admin.vo.UserMenuInfoVO;
import com.tima.admin.vo.UserRoleRelationVO;
import com.tima.admin.dto.MenuPermissionsRelationDTO;
import com.tima.admin.dto.UserRoleRelationDTO;
import com.tima.admin.vo.MenuPermissionsRelationVO;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CollectionUtil;
import com.tima.admin.util.CommentUtil;
import com.tima.admin.util.ConvertUtil;
import com.tima.admin.util.JsonUtil;
import com.tima.admin.util.ListCopyUtil;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.util.TreeNode;
import com.tima.admin.util.TreeUtils;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 菜单权限关联表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Transactional
@Service
public class MenuPermissionsRelationServiceImpl extends
        ServiceImpl<MenuPermissionsRelationMapper, MenuPermissionsRelation> implements IMenuPermissionsRelationService {

    @Autowired
    private MenuPermissionsRelationMapper menuPermissionsRelationMapper;

    @Autowired
    private RolePermissionsRelationMapper rolePermissionsRelationMapper;
//	@Override
//	public ResultVO<?> searchMenuPermissionsRelationList(MenuPermissionsRelationDTO dto) {
//		EntityWrapper<MenuPermissionsRelation> entityWrapper = new EntityWrapper<MenuPermissionsRelation>();
//		MenuPermissionsRelation entity = new MenuPermissionsRelation();
//		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
//		entityWrapper.setEntity(entity);
//		return ResultVOUtil.returnSuccess(menuPermissionsRelationMapper.selectList(entityWrapper));
//	}

    // @Override
    // public ResultVO<?>
    // searchMenuPermissionsRelationListPage(MenuPermissionsRelationDTO dto){
    // Page<MenuPermissionsRelation> page=new Page<MenuPermissionsRelation>();
    // page.setSize(dto.getSize());
    // page.setCurrent(dto.getCurrent());
    // EntityWrapper<MenuPermissionsRelation> entityWrapper=new
    // EntityWrapper<MenuPermissionsRelation>();
    // MenuPermissionsRelation entity=new MenuPermissionsRelation();
    // BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    // entityWrapper.setEntity(entity);
    // return
    // ResultVOUtil.returnSuccess(page.setRecords(menuPermissionsRelationMapper.selectPage(page,entityWrapper)));
    // }
    // @Override
    // public ResultVO<?>
    // searchMenuPermissionsRelationOne(MenuPermissionsRelationDTO dto){
    // MenuPermissionsRelation entity=new MenuPermissionsRelation();
    // BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
    //
    // return
    // ResultVOUtil.returnSuccess(menuPermissionsRelationMapper.selectOne(entity));
    // }
    @Override
    public ResultVO<?> addMenuPermissionsRelation(List<MenuPermissionsRelationDTO> dto) {
        RolePermissionsRelation rprRes = new RolePermissionsRelation();
        rprRes.setRoleId(dto.get(0).getRoleId());
        //根据角色查权限
        RolePermissionsRelation rprRon = rolePermissionsRelationMapper.selectOne(rprRes);
        //根据权限查菜单
        EntityWrapper<MenuPermissionsRelation> entity = new EntityWrapper<MenuPermissionsRelation>();
        MenuPermissionsRelation mpr = new MenuPermissionsRelation();
        mpr.setPermissionsId(rprRon.getPermissionsId());
        entity.setEntity(mpr);
        List<MenuPermissionsRelation> mprList = menuPermissionsRelationMapper.selectList(entity);
        for (MenuPermissionsRelation menuPermissionsRelation : mprList) {
            menuPermissionsRelationMapper.deleteById(menuPermissionsRelation);
        }
        //菜单权限
        MenuPermissionsRelation mprRes = null;
        for (MenuPermissionsRelationDTO mprDTO : dto) {
            mprRes = new MenuPermissionsRelation();
            mprRes.setMenuId(mprDTO.getMenuId());
            mprRes.setPermissionsId(rprRon.getPermissionsId());
            mprRes.setNo(CodeNoEnum.MENU_PERMISSIONS_RELATION.getTableNO() + CommentUtil.createNo());
            menuPermissionsRelationMapper.insert(mprRes);
        }
        return ResultVOUtil.returnSuccess();
    }

    // @Override
    // public ResultVO<?> updateMenuPermissionsRelation(MenuPermissionsRelationDTO
    // dto){
    // MenuPermissionsRelation entity=new MenuPermissionsRelation();
    // entity.setNo(dto.getNo());
    // MenuPermissionsRelation
    // result=menuPermissionsRelationMapper.selectOne(entity);
    // BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);
    // menuPermissionsRelationMapper.updateById(result);
    // return ResultVOUtil.returnSuccess();
    // }
    @Override
    public ResultVO<?> deleteMenuPermissionsRelation(MenuPermissionsRelationDTO dto) {
        MenuPermissionsRelation entity = new MenuPermissionsRelation();
        entity.setNo(dto.getNo());
        MenuPermissionsRelation result = menuPermissionsRelationMapper.selectOne(entity);
        menuPermissionsRelationMapper.deleteById(result.getId());
        return ResultVOUtil.returnSuccess();
    }
    // @Override
    // public ResultVO<?>
    // searchMenuPermissionsRelationRelation(MenuPermissionsRelationDTO dto){
    // //自定义分页参考依据
    // //VehicleCustom vehicleCustom=new VehicleCustom();
    // //ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new
    // ConvertUtil<VehicleRO, VehicleCustom>();
    // //Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
    // //return
    // ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result,
    // convertUtil.entity(ro, vehicleCustom))));
    // return null;
    // }

    @Override
    public ResultVO<?> selectMenuByPermission(MenuPermissionsRelationDTO dto) {
        TreeNodeVO tnVORes = new TreeNodeVO();
        List<TreeNodeVO> tnsVORon = menuPermissionsRelationMapper.selectMenuByPermission(dto);
        List<TreeNodeVO> tnsVO = CollectionUtil.removeDuplicateTree(tnsVORon);
        List<TreeNode> treeNodes = new ArrayList<>();
        TreeNode tn = null;
        for (TreeNodeVO treeNodeVO : tnsVO) {
            tn = new TreeNode();
            BeanCopyUtil.copyPropertiesIgnoreNull(treeNodeVO, tn);
            treeNodes.add(tn);
        }
        return ResultVOUtil.returnSuccess(TreeUtils.genTreeExtendList(treeNodes));
    }

    @Override
    public ResultVO<?> selectMenuByUserId(MenuPermissionsRelationDTO dto) {
        List<TreeNodeVO> tnsVORon = menuPermissionsRelationMapper.selectMenuByPermission(dto);
        List<TreeNodeVO> tnsVO = CollectionUtil.removeDuplicateTree(tnsVORon);
        List<TreeNode> treeNodes = new ArrayList<>();
        TreeNode tn = null;
        for (TreeNodeVO treeNodeVO : tnsVO) {
            tn = new TreeNode();
            BeanCopyUtil.copyPropertiesIgnoreNull(treeNodeVO, tn);
            treeNodes.add(tn);
        }
        return ResultVOUtil.returnSuccess(treeNodes);
    }

    @Override
    public ResultVO<?> selectMenuByRoleWeb(MenuPermissionsRelationDTO dto) {
        TreeNodeVO tnVORes = new TreeNodeVO();
        List<TreeNodeVO> tnsVORon = menuPermissionsRelationMapper.selectMenuByRole(dto);
        List<TreeNodeVO> tnsVO = CollectionUtil.removeDuplicateTree(tnsVORon);
        List<TreeNode> treeNodes = new ArrayList<>();
        TreeNode tn = null;
        for (TreeNodeVO treeNodeVO : tnsVO) {
            tn = new TreeNode();
            BeanCopyUtil.copyPropertiesIgnoreNull(treeNodeVO, tn);
            treeNodes.add(tn);
        }
        return ResultVOUtil.returnSuccess(TreeUtils.genTreeExtendList(treeNodes));
    }

    @Override
    public ResultVO<?> selectAllRoleInterfaceAddress() {
        List<TreeNodeVO> tnsVORon = menuPermissionsRelationMapper.selectAllRoleInterfaceAddress();
        return ResultVOUtil.returnSuccess(tnsVORon);
    }

}
