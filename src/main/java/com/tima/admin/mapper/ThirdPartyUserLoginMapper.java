package com.tima.admin.mapper;

import com.tima.admin.dto.ThirdPartyUserLoginDTO;
import com.tima.admin.entity.ThirdPartyUserLogin;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 第三方登录信息表  Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2020-03-23
 */
public interface ThirdPartyUserLoginMapper extends BaseMapper<ThirdPartyUserLogin> {
   public ThirdPartyUserLogin selectUserForphoneAndopenId(ThirdPartyUserLoginDTO dto);
}
