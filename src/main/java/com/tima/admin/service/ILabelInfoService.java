package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.LabelInfoDTO;
import com.tima.admin.entity.LabelInfo;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 标签信息 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
public interface ILabelInfoService extends IService<LabelInfo> {
   public ResultVO<?> searchLabelInfoList(LabelInfoDTO dto);
   public ResultVO<?> searchLabelInfoListPage(LabelInfoDTO dto);
   public ResultVO<?> searchLabelInfoOne(LabelInfoDTO dto);
   public ResultVO<?> addLabelInfo(LabelInfoDTO dto);
   public ResultVO<?> updateLabelInfo(LabelInfoDTO dto);
   public ResultVO<?> deleteLabelInfo(LabelInfoDTO dto);
   public ResultVO<?> searchLabelInfoRelation(LabelInfoDTO dto);
}
