package com.tima.admin.service;

import com.tima.admin.entity.SysDictData;
import com.baomidou.mybatisplus.service.IService;

import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.SysDictDataDTO;
import com.tima.admin.vo.SysDictDataVO;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-11-20
 */
public interface ISysDictDataService extends IService<SysDictData> {
   public ResultVO<?> searchSysDictDataList(SysDictDataDTO dto);
   public ResultVO<?> searchSysDictDataListPage(SysDictDataDTO dto);
   public ResultVO<?> searchSysDictDataOne(SysDictDataDTO dto);
   public ResultVO<?> addSysDictData(SysDictDataDTO dto);
   public ResultVO<?> updateSysDictData(SysDictDataDTO dto);
   public ResultVO<?> deleteSysDictData(SysDictDataDTO dto);
   public ResultVO<?> searchSysDictDataRelation(SysDictDataDTO dto);
}
