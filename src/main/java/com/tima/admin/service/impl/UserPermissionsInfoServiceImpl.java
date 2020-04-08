package com.tima.admin.service.impl;

import com.tima.admin.entity.UserPermissionsInfo;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.mapper.UserPermissionsInfoMapper;
import com.tima.admin.service.IUserPermissionsInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.UserPermissionsInfoDTO;
import com.tima.admin.vo.UserPermissionsInfoVO;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.util.ResultVOUtil;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 权限信息表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Slf4j
@Transactional
@Service
public class UserPermissionsInfoServiceImpl extends ServiceImpl<UserPermissionsInfoMapper, UserPermissionsInfo>
		implements IUserPermissionsInfoService {

	@Autowired
	private UserPermissionsInfoMapper userPermissionsInfoMapper;

	// @Override
	// public ResultVO<?> searchUserPermissionsInfoList(UserPermissionsInfoDTO dto){
	// EntityWrapper<UserPermissionsInfo> entityWrapper=new
	// EntityWrapper<UserPermissionsInfo>();
	// UserPermissionsInfo entity=new UserPermissionsInfo();
	// BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
	// entityWrapper.setEntity(entity);
	// return
	// ResultVOUtil.returnSuccess(userPermissionsInfoMapper.selectList(entityWrapper));
	// }
	@Override
	public ResultVO<?> searchUserPermissionsInfoListPage(UserPermissionsInfoDTO dto) {
		Page<UserPermissionsInfo> page = new Page<UserPermissionsInfo>();
		page.setSize(dto.getSize());
		page.setCurrent(dto.getCurrent());
		EntityWrapper<UserPermissionsInfo> entityWrapper = new EntityWrapper<UserPermissionsInfo>();
		UserPermissionsInfo entity = new UserPermissionsInfo();
		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
		entityWrapper.setEntity(entity);
		return ResultVOUtil.returnSuccess(page.setRecords(userPermissionsInfoMapper.selectPage(page, entityWrapper)));
	}

//	@Override
//	public ResultVO<?> searchUserPermissionsInfoOne(UserPermissionsInfoDTO dto) {
//		UserPermissionsInfo entity = new UserPermissionsInfo();
//		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
//
//		return ResultVOUtil.returnSuccess(userPermissionsInfoMapper.selectOne(entity));
//	}

//	@Override
//	public ResultVO<?> addUserPermissionsInfo(UserPermissionsInfoDTO dto) {
//		UserPermissionsInfo entity = new UserPermissionsInfo();
//		BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
//		// 需要开发人员各自定义
//		entity.setNo(CodeNoEnum.USER_PERMISSIONS_INFO.getTableNO() + CommentUtil.createNo());
//		userPermissionsInfoMapper.insert(entity);
//		return ResultVOUtil.returnSuccess();
//	}
//
//	@Override
//	public ResultVO<?> updateUserPermissionsInfo(UserPermissionsInfoDTO dto) {
//		UserPermissionsInfo entity = new UserPermissionsInfo();
//		entity.setNo(dto.getNo());
//		UserPermissionsInfo result = userPermissionsInfoMapper.selectOne(entity);
//		BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
//		userPermissionsInfoMapper.updateById(result);
//		return ResultVOUtil.returnSuccess();
//	}
//
//	@Override
//	public ResultVO<?> deleteUserPermissionsInfo(UserPermissionsInfoDTO dto) {
//		UserPermissionsInfo entity = new UserPermissionsInfo();
//		entity.setNo(dto.getNo());
//		UserPermissionsInfo result = userPermissionsInfoMapper.selectOne(entity);
//		userPermissionsInfoMapper.deleteById(result.getId());
//		return ResultVOUtil.returnSuccess();
//	}
//	 @Override
//	 public ResultVO<?> searchUserPermissionsInfoRelation(UserPermissionsInfoDTO
//	 dto){
//	 //自定义分页参考依据
//	 //VehicleCustom vehicleCustom=new VehicleCustom();
//	 //ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new
//	 ConvertUtil<VehicleRO, VehicleCustom>();
//	 //Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
//	 //return
//	 ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result,
//	 convertUtil.entity(ro, vehicleCustom))));
//	 return null;
//	 }
}
