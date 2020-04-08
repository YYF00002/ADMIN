package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.ThirdPartyRequestDTO;
import com.tima.admin.dto.ThirdPartyUserBaseInformationDTO;
import com.tima.admin.dto.UserBaseInformationDTO;
import com.tima.admin.entity.ThirdPartyRequest;
import com.tima.admin.entity.ThirdPartyUserBaseInformation;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 第三方请求记录表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-08-14
 */
public interface IThirdPartyRequestService extends IService<ThirdPartyRequest> {
	// public ResultVO<?> searchThirdPartyRequestList(ThirdPartyRequestDTO dto);
//	public ResultVO<?> searchThirdPartyRequestListPage(ThirdPartyRequestDTO dto);

	// public ResultVO<?> searchThirdPartyRequestOne(ThirdPartyRequestDTO dto);
	// public ResultVO<?> addThirdPartyRequest(ThirdPartyRequestDTO dto);
	// public ResultVO<?> updateThirdPartyRequest(ThirdPartyRequestDTO dto);
	// public ResultVO<?> deleteThirdPartyRequest(ThirdPartyRequestDTO dto);
	// public ResultVO<?> searchThirdPartyRequestRelation(ThirdPartyRequestDTO dto);

	// 获得企业token
	public ThirdPartyRequestDTO getEnterpriseToken();
	
	// AAA用户注册接口
	public ThirdPartyRequestDTO registerUserByAAA(UserBaseInformationDTO param);

	// AAA用户登录授权接口
	public ThirdPartyRequestDTO loginUserByAAA(ThirdPartyRequestDTO dto);

	// AAA用户刷新token
	public ThirdPartyRequestDTO refreshToken(ThirdPartyUserBaseInformation param);

	// 验证TOKEN
	public ThirdPartyRequestDTO checkToken(ThirdPartyRequestDTO dto);

	// 用户信息查询
	public ThirdPartyRequestDTO searchUserInfo(ThirdPartyRequestDTO dto);

	// 修改密码
	public ThirdPartyRequestDTO updatePasswordByAAA(ThirdPartyUserBaseInformation param);

	// 修改密码
	public ThirdPartyRequestDTO updateUserInfoByAAA(UserBaseInformationDTO param);

	// 修改登录名和手机号
	public ThirdPartyRequestDTO updateUserCode(ThirdPartyUserBaseInformation param);
	
	// 修改紧急联系人
//	public ThirdPartyRequestDTO updateInfoByAAA(UserBaseInformationDTO dto);

	// 删除用户
	public ThirdPartyRequestDTO deleteUserByAAA(ThirdPartyRequestDTO dto);

	// 发送短信验证码
	public boolean sendSMS(ThirdPartyRequestDTO dto);

	// 发送强制短信验证码
	public boolean sendNewSMS(ThirdPartyRequestDTO dto);

	// 验证短信验证码
	public ResultVO<?> validateSMS(ThirdPartyRequestDTO dto);

	// AAA用户登出接口
	public ThirdPartyRequestDTO logoutUserByAAA(ThirdPartyUserBaseInformationDTO dto);

	// 用户新增系统绑定
	public ThirdPartyRequestDTO bingSystemByAAA(ThirdPartyRequestDTO dto);
	
	
	// TSP设置紧急联系人
	public boolean setEmergencyContact(UserBaseInformation dto);
//
//	// 用户修改系统绑定
//	public ResultVO<?> updatebingSystemByAAA(ThirdPartyRequestDTO dto);
//
//	// 用户删除系统绑定
//	public ResultVO<?> deletebingSystemByAAA(ThirdPartyRequestDTO dto);
}
