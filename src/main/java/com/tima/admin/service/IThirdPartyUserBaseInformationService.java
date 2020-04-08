package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.ThirdPartyRequestDTO;
import com.tima.admin.dto.ThirdPartyUserBaseInformationDTO;
import com.tima.admin.dto.UserBaseInformationDTO;
import com.tima.admin.entity.ThirdPartyUserBaseInformation;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 第三方用户信息表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-08-30
 */
public interface IThirdPartyUserBaseInformationService extends IService<ThirdPartyUserBaseInformation> {
//   public ResultVO<?> searchThirdPartyUserBaseInformationList(ThirdPartyUserBaseInformationDTO dto);
//   public ResultVO<?> searchThirdPartyUserBaseInformationListPage(ThirdPartyUserBaseInformationDTO dto);
	//根据用户id查tspid
   public ResultVO<?> searchThirdPartyUserBaseInformationOne(ThirdPartyUserBaseInformationDTO dto);
   //根据tspid查用户No
   public ResultVO<?> selectuserNoByTSPID(ThirdPartyUserBaseInformationDTO dto);
   //根据aaaid查带三方用户信息
   public ResultVO<?> searchThirdPartyUserBaseInformationOneByAAAID(ThirdPartyUserBaseInformationDTO dto);
   
   
 //根据AAAid查询用户头像
   public ResultVO<?>  selectuserImageByTSPID(ThirdPartyUserBaseInformationDTO dto);
   
   //更改或添加
	public ResultVO<?> addThirdPartyUserBaseInformation(ThirdPartyUserBaseInformationDTO dto);
	//插入
   public boolean insertThirdPartyUserBaseInformation(ThirdPartyRequestDTO dto,Long userId);
   //更改密码
   public ThirdPartyRequestDTO updatePassword(UserBaseInformation param);
    //更改用户名和手机号
    public ThirdPartyRequestDTO updateUserCode(UserBaseInformation param);
   	//忘记密码
   public ThirdPartyRequestDTO forgetPassword(UserBaseInformationDTO param);
	//登录
   public ThirdPartyRequestDTO  longIn(UserBaseInformationDTO param);
  	//登出
  public ThirdPartyRequestDTO  longOut(UserBaseInformationDTO param);
  
  //刷新token
  public ResultVO<?>  refreshToken(UserBaseInformationDTO param);
  
  
   
//   public ResultVO<?> deleteThirdPartyUserBaseInformation(ThirdPartyUserBaseInformationDTO dto);
//   public ResultVO<?> searchThirdPartyUserBaseInformationRelation(ThirdPartyUserBaseInformationDTO dto);
}
