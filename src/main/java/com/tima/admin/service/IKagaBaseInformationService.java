package com.tima.admin.service;

import com.tima.admin.entity.KagaBaseInformation;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.KagaBaseInformationDTO;
import com.tima.admin.vo.KagaBaseInformationVO;

/**
 * <p>
 * 卡嘉用户表 服务类
 * </p>
 *
 * @author YYF
 * @since 2019-12-23
 */
public interface IKagaBaseInformationService extends IService<KagaBaseInformation> {
   public ResultVO<?> searchKagaBaseInformationList(KagaBaseInformationDTO dto);
   public ResultVO<?> searchKagaBaseInformationListPage(KagaBaseInformationDTO dto);
   public ResultVO<?> searchKagaBaseInformationOne(KagaBaseInformationDTO dto);
   public ResultVO<?> addKagaBaseInformation(KagaBaseInformationDTO dto);
   public ResultVO<?> updateKagaBaseInformation(KagaBaseInformationDTO dto);
   public ResultVO<?> deleteKagaBaseInformation(KagaBaseInformationDTO dto);
   public ResultVO<?> searchKagaBaseInformationRelation(KagaBaseInformationDTO dto);
   public ResultVO<?> login(KagaBaseInformationDTO dto);
   public ResultVO<?> quickLogin(KagaBaseInformationDTO dto);

}
