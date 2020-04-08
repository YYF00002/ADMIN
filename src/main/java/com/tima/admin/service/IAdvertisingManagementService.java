package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.AdvertisingManagementDTO;
import com.tima.admin.entity.AdvertisingManagement;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 广告页管理 服务类
 * </p>
 *
 * @author YYF
 * @since 2020-02-18
 */
public interface IAdvertisingManagementService extends IService<AdvertisingManagement> {
   public ResultVO<?> searchAdvertisingManagementListPage(AdvertisingManagementDTO dto);
   public ResultVO<?> searchAdvertisingManagementOne(AdvertisingManagementDTO dto);
   public ResultVO<?> addAdvertisingManagement(AdvertisingManagementDTO dto);
   public ResultVO<?> updateAdvertisingManagement(AdvertisingManagementDTO dto);
   public ResultVO<?> deleteAdvertisingManagement(AdvertisingManagementDTO dto);
}
