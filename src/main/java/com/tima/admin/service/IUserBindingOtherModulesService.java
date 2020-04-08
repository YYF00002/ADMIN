package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.UserBindingOtherModulesDTO;
import com.tima.admin.entity.UserBindingOtherModules;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 用户绑定其他模块信息表 服务类
 * </p>
 *
 * @author YYF
 * @since 2019-04-09
 */
public interface IUserBindingOtherModulesService extends IService<UserBindingOtherModules> {
   public ResultVO<?> searchUserBindingOtherModulesList(UserBindingOtherModulesDTO dto);
   public ResultVO<?> searchUserBindingOtherModulesListPage(UserBindingOtherModulesDTO dto);
   public ResultVO<?> searchUserBindingOtherModulesOne(UserBindingOtherModulesDTO dto);
   public ResultVO<?> addUserBindingOtherModules(UserBindingOtherModulesDTO dto);
   public ResultVO<?> updateUserBindingOtherModules(UserBindingOtherModulesDTO dto);

}
