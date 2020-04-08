package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.LabelAttributeDTO;
import com.tima.admin.entity.LabelAttribute;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 标签属性分类 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-12-10
 */
public interface ILabelAttributeService extends IService<LabelAttribute> {
   public ResultVO<?> searchLabelAttributeList(LabelAttributeDTO dto);
   public ResultVO<?> searchLabelAttributeListPage(LabelAttributeDTO dto);
   public ResultVO<?> searchLabelAttributeOne(LabelAttributeDTO dto);
   public ResultVO<?> addLabelAttribute(LabelAttributeDTO dto);
   public ResultVO<?> updateLabelAttribute(LabelAttributeDTO dto);
   public ResultVO<?> deleteLabelAttribute(LabelAttributeDTO dto);
   public ResultVO<?> searchLabelAttributeRelation(LabelAttributeDTO dto);
}
