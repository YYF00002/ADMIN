package com.tima.admin.mapper;

import com.tima.admin.dto.MenuPermissionsRelationDTO;
import com.tima.admin.dto.UserMenuInfoDTO;
import com.tima.admin.entity.UserMenuInfo;
import com.tima.admin.vo.TreeNodeVO;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * <p>
 * 用户菜单信息表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
public interface UserMenuInfoMapper extends BaseMapper<UserMenuInfo> {
	// 自定义分页参考方法，需要xml里面添加该方法
	// public List<VehicleCustom> selectVehicleCustomList(Pagination
	// page,VehicleCustom custom);

}
