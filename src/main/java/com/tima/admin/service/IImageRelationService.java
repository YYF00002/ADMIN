package com.tima.admin.service;

import com.tima.admin.entity.ImageRelation;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.ImageRelationDTO;
import com.tima.admin.vo.ImageRelationVO;

/**
 * <p>
 * 图片关联表 服务类
 * </p>
 *
 * @author zwh
 * @since 2018-07-17
 */
public interface IImageRelationService extends IService<ImageRelation> {
//   public ResultVO<?> searchImageRelationList(ImageRelationDTO dto);
//   public ResultVO<?> searchImageRelationListPage(ImageRelationDTO dto);
//   public ResultVO<?> searchImageRelationOne(ImageRelationDTO dto);
   public ResultVO<?> addImageRelation(ImageRelationDTO dto);
   public ResultVO<?> updateImageRelation(ImageRelationDTO dto);
//   public ResultVO<?> deleteImageRelation(ImageRelationDTO dto);
//   public ResultVO<?> searchImageRelationRelation(ImageRelationDTO dto);
}
