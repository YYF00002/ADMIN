package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.ThirdPartyUserLoginDTO;
import com.tima.admin.entity.ThirdPartyUserLogin;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 第三方登录信息表  服务类
 * </p>
 *
 * @author YYF
 * @since 2020-03-23
 */
public interface IThirdPartyUserLoginService extends IService<ThirdPartyUserLogin> {
   public ResultVO<?> searchBindingForWechat(ThirdPartyUserLoginDTO dto) throws Exception;
   public ResultVO<?> searchBindingForQQ(ThirdPartyUserLoginDTO dto) throws Exception;
   public ResultVO<?> bindPhone(ThirdPartyUserLoginDTO dto) throws Exception;


}
