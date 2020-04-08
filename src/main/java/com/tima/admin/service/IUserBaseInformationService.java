package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.UserBaseInformationDTO;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 用户基本信息表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
public interface IUserBaseInformationService extends IService<UserBaseInformation> {
//   public ResultVO<?> searchUserBaseInformationList(UserBaseInformationDTO dto);
   public ResultVO<?> searchUserBaseInformationListPage(UserBaseInformationDTO dto);
   public ResultVO<?> searchUserBaseInformationOne(UserBaseInformationDTO dto);
   public ResultVO<?> addUserBaseInformation(UserBaseInformationDTO dto);
   public ResultVO<?> updateUserBaseInformation(UserBaseInformationDTO dto);
   public ResultVO<?> updateUserBaseInformationWeb(UserBaseInformationDTO dto);
   public ResultVO<?> deleteUserBaseInformation(UserBaseInformationDTO dto);
//   public ResultVO<?> searchUserBaseInformationRelation(UserBaseInformationDTO dto);
   public ResultVO<?> userLogin(UserBaseInformationDTO dto);
   public ResultVO<?> userLoginOut(UserBaseInformationDTO dto);
   public ResultVO<?> refreshUserToken(UserBaseInformationDTO dto);
   public ResultVO<?> validateUserToken(UserBaseInformationDTO dto);
   //修改密码
   public ResultVO<?> updateUserPassword(UserBaseInformationDTO dto);
   //修改密码Web
   public ResultVO<?> updateUserPasswordWeb(UserBaseInformationDTO dto);
   //忘记密码
   public ResultVO<?> forgotPassword(UserBaseInformationDTO dto);
   public ResultVO<?> searchUserBaseInformationMany(UserBaseInformationDTO dto);
   //设置紧急联系人
   public ResultVO<?> insertOrUpdateEmergencyContact(UserBaseInformationDTO dto);
   public ResultVO<?> searchUserBaseInformationAndIntegralListPageWeb(UserBaseInformationDTO dto);
   //车控调用同步用户信息
   public ResultVO<?> synchronizeUserInformation(UserBaseInformationDTO dto);
   //生成验证码图片
   public ResultVO<?> createCodeImg(UserBaseInformationDTO dto);
   //刷新验证码图片
   public ResultVO<?> refreshCodeImgWeb(UserBaseInformationDTO dto);

   //更改手机登录名和密码
   public ResultVO<?> updateUserCode(UserBaseInformationDTO dto);

   //更改手机登录名和密码
   public ResultVO<?> thirdPartyLogin(UserBaseInformationDTO dto);
   
}

