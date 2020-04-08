package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.LabelEffectDTO;
import com.tima.admin.entity.LabelEffect;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 标签效能状态分类分类 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-12-10
 */
public interface ILabelEffectService extends IService<LabelEffect> {
   public ResultVO<?> searchLabelEffectList(LabelEffectDTO dto);
   public ResultVO<?> searchLabelEffectListPage(LabelEffectDTO dto);
   public ResultVO<?> searchLabelEffectOne(LabelEffectDTO dto);
   public ResultVO<?> addLabelEffect(LabelEffectDTO dto);
   public ResultVO<?> updateLabelEffect(LabelEffectDTO dto);
   public ResultVO<?> deleteLabelEffect(LabelEffectDTO dto);
   public ResultVO<?> searchLabelEffectRelation(LabelEffectDTO dto);
}
