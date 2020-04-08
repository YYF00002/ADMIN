package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.SysDictTypeDTO;
import com.tima.admin.entity.SysDictType;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 系统字典类型表 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-11-20
 */
public interface ISysDictTypeService extends IService<SysDictType> {
   public ResultVO<?> searchSysDictTypeList(SysDictTypeDTO dto);
   public ResultVO<?> searchSysDictTypeListPage(SysDictTypeDTO dto);
   public ResultVO<?> searchSysDictTypeOne(SysDictTypeDTO dto);
   public ResultVO<?> addSysDictType(SysDictTypeDTO dto);
   public ResultVO<?> updateSysDictType(SysDictTypeDTO dto);
   public ResultVO<?> deleteSysDictType(SysDictTypeDTO dto);
   public ResultVO<?> searchSysDictTypeRelation(SysDictTypeDTO dto);
}
