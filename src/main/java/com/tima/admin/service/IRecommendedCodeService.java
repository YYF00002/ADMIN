package com.tima.admin.service;

import com.tima.admin.entity.RecommendedCode;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.RecommendedCodeDTO;
import com.tima.admin.vo.RecommendedCodeVO;

/**
 * <p>
 * 用户推荐码 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-08-29
 */
public interface IRecommendedCodeService extends IService<RecommendedCode> {
   public ResultVO<?> searchRecommendedCodeList(RecommendedCodeDTO dto);
   public ResultVO<?> searchRecommendedCodeListPage(RecommendedCodeDTO dto);
   public ResultVO<?> searchRecommendedCodeOne(RecommendedCodeDTO dto);
   public ResultVO<?> addRecommendedCode(RecommendedCodeDTO dto);
   public ResultVO<?> updateRecommendedCode(RecommendedCodeDTO dto);
   public ResultVO<?> deleteRecommendedCode(RecommendedCodeDTO dto);
   public ResultVO<?> searchRecommendedCodeRelation(RecommendedCodeDTO dto);
   
   //验证推荐码是否正确
   public ResultVO<?> validateCode(RecommendedCodeDTO dto);
}
