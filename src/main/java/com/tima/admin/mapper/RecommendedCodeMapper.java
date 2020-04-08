package com.tima.admin.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tima.admin.dto.RecommendedCodeDTO;
import com.tima.admin.entity.RecommendedCode;
import com.tima.admin.vo.RecommendedCodeVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户推荐码 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-08-29
 */
public interface RecommendedCodeMapper extends BaseMapper<RecommendedCode> {
	
	//根据code或用户查推荐码
	public RecommendedCodeVO  selectCode(RecommendedCodeDTO dto);

    List<RecommendedCode> selectList(EntityWrapper<Object> objectEntityWrapper);

    //自定义分页参考方法，需要xml里面添加该方法
   //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
