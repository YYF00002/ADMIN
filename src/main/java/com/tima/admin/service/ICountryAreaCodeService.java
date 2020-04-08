package com.tima.admin.service;

import com.tima.admin.entity.CountryAreaCode;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.CountryAreaCodeDTO;
import com.tima.admin.vo.CountryAreaCodeVO;

/**
 * <p>
 * 国统局区域代码 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-08-01
 */
public interface ICountryAreaCodeService extends IService<CountryAreaCode> {
//   public ResultVO<?> searchCountryAreaCodeList(CountryAreaCodeDTO dto);
   public ResultVO<?> searchCountryAreaCodeListPage(CountryAreaCodeDTO dto);
//   public ResultVO<?> searchCountryAreaCodeOne(CountryAreaCodeDTO dto);
//   public ResultVO<?> addCountryAreaCode(CountryAreaCodeDTO dto);
//   public ResultVO<?> updateCountryAreaCode(CountryAreaCodeDTO dto);
//   public ResultVO<?> deleteCountryAreaCode(CountryAreaCodeDTO dto);
//   public ResultVO<?> searchCountryAreaCodeRelation(CountryAreaCodeDTO dto);
}
