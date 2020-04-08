package com.tima.admin.service.impl;

import com.tima.admin.entity.MenuPermissionsRelation;
import com.tima.admin.entity.RolePermissionsRelation;
import com.tima.admin.entity.UserMenuInfo;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.mapper.MenuPermissionsRelationMapper;
import com.tima.admin.mapper.RolePermissionsRelationMapper;
import com.tima.admin.mapper.UserMenuInfoMapper;
import com.tima.admin.service.IUserMenuInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.TreeNodeVO;
import com.tima.admin.dto.UserMenuInfoDTO;
import com.tima.admin.vo.UserMenuInfoVO;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.util.TreeNode;
import com.tima.admin.util.TreeUtils;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 用户菜单信息表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Transactional
@Service
public class UserMenuInfoServiceImpl extends ServiceImpl<UserMenuInfoMapper, UserMenuInfo>
		implements IUserMenuInfoService {

	@Autowired
	private UserMenuInfoMapper userMenuInfoMapper;

	@Autowired
	private MenuPermissionsRelationMapper menuPermissionsRelationMapper;

	@Override
	public ResultVO<?> searchUserMenuInfoList(UserMenuInfoDTO dto) {
		EntityWrapper<UserMenuInfo> entityWrapper = new EntityWrapper<UserMenuInfo>();
		UserMenuInfo entity = new UserMenuInfo();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		entityWrapper.setEntity(entity);
		List<UserMenuInfo> umiList=userMenuInfoMapper.selectList(entityWrapper);
		List<TreeNode> treeNodes=new ArrayList<>();
		TreeNode tn=null;
		for (UserMenuInfo umi : umiList) {
			tn=new TreeNode();
			BeanCopyUtil.copyPropertiesIgnoreNull(umi,tn);
			tn.setParentId(umi.getMenuParentId());
			tn.setUrl(umi.getMenuUrl());
			treeNodes.add(tn);
		}
		
		return ResultVOUtil.returnSuccess(TreeUtils.genTreeExtendList(treeNodes));
	}
	// @Override
	// public ResultVO<?> searchUserMenuInfoListPage(UserMenuInfoDTO dto) {
	// Page<UserMenuInfo> page = new Page<UserMenuInfo>();
	// page.setSize(dto.getSize());
	// page.setCurrent(dto.getCurrent());
	// EntityWrapper<UserMenuInfo> entityWrapper = new
	// EntityWrapper<UserMenuInfo>();
	// UserMenuInfo entity = new UserMenuInfo();
	// BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
	// entityWrapper.setEntity(entity);
	// return
	// ResultVOUtil.returnSuccess(page.setRecords(userMenuInfoMapper.selectPage(page,
	// entityWrapper)));
	// }

	@Override
	public ResultVO<?> searchUserMenuInfoOne(UserMenuInfoDTO dto) {
		UserMenuInfo entity = new UserMenuInfo();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);

		return ResultVOUtil.returnSuccess(userMenuInfoMapper.selectOne(entity));
	}

	@Override
	public ResultVO<?> addUserMenuInfo(UserMenuInfoDTO dto) {
		UserMenuInfo entity = new UserMenuInfo();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		// 需要开发人员各自定义
		entity.setNo(CodeNoEnum.USER_MENU_INFO.getTableNO() + CommentUtil.createNo());
		userMenuInfoMapper.insert(entity);
		return ResultVOUtil.returnSuccess();
	}

	@Override
	public ResultVO<?> updateUserMenuInfo(UserMenuInfoDTO dto) {
		UserMenuInfo entity = new UserMenuInfo();
		entity.setNo(dto.getNo());
		UserMenuInfo result = userMenuInfoMapper.selectOne(entity);
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
		userMenuInfoMapper.updateById(result);
		return ResultVOUtil.returnSuccess();
	}

	@Override
	public ResultVO<?> deleteUserMenuInfo(UserMenuInfoDTO dto) {
		UserMenuInfo entity = new UserMenuInfo();
		entity.setNo(dto.getNo());
		UserMenuInfo result = userMenuInfoMapper.selectOne(entity);
		if(null==result) {
			return ResultVOUtil.returnFail(500, "该菜单不存在");
		}
		MenuPermissionsRelation mprRes = null;
		EntityWrapper<MenuPermissionsRelation> entityWrapper=null;
		List<MenuPermissionsRelation> listRon =null;
		//删除本节点及关联关系
		mprRes = new MenuPermissionsRelation();
		mprRes.setMenuId(result.getId());
		entityWrapper = new EntityWrapper<MenuPermissionsRelation>();
		entityWrapper.setEntity(mprRes);
		listRon = menuPermissionsRelationMapper.selectList(entityWrapper);
		if(null!=listRon) {
			for (MenuPermissionsRelation menuPermissionsRelation : listRon) {
				menuPermissionsRelationMapper.deleteById(menuPermissionsRelation);
			}
		}
		userMenuInfoMapper.deleteById(result);
		return ResultVOUtil.returnSuccess();
	}
	// @Override
	// public ResultVO<?> searchUserMenuInfoRelation(UserMenuInfoDTO dto){
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


}
