package com.tima.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tima.admin.dto.LevelChangesRecordDTO;
import com.tima.admin.entity.LevelChangesRecord;
import com.tima.admin.enums.levelChangeEnum;
import com.tima.admin.mapper.LevelChangesRecordMapper;
import com.tima.admin.service.ILevelChangesRecordService;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.vo.LevelChangesRecordVO;
import com.tima.admin.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>
 * 会员等级变动明细表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2019-05-05
 */
@Slf4j
@Transactional
@Service
public class LevelChangesRecordServiceImpl extends ServiceImpl<LevelChangesRecordMapper, LevelChangesRecord> implements ILevelChangesRecordService {
  
   
   @Autowired
   private LevelChangesRecordMapper levelChangesRecordMapper;
   @Override
   public ResultVO<?> searchLevelChangesRecordList(LevelChangesRecordDTO dto){

       dto.setUid(CommentUtil.getUser().getId());
       dto.setIsPush(levelChangeEnum.PUSH_NOT.getCode().toString());

       return ResultVOUtil.returnSuccess(levelChangesRecordMapper.selectLevelChangesRecordList(dto));
   }
//   @Override
//   public ResultVO<?> searchLevelChangesRecordListPage(LevelChangesRecordDTO dto){
//    Page<LevelChangesRecord> page=new Page<LevelChangesRecord>();
//    page.setSize(dto.getSize());
//	page.setCurrent(dto.getCurrent());
//    EntityWrapper<LevelChangesRecord> entityWrapper=new EntityWrapper<LevelChangesRecord>();
//    LevelChangesRecord entity=new LevelChangesRecord();
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//    entityWrapper.setEntity(entity);
//    return ResultVOUtil.returnSuccess(page.setRecords(levelChangesRecordMapper.selectPage(page,entityWrapper)));
//   }
//   @Override
//   public ResultVO<?> searchLevelChangesRecordOne(LevelChangesRecordDTO dto){
//   LevelChangesRecord entity=new LevelChangesRecord();
//   dto.setUid(CommentUtil.getUser().getId());
//   	return ResultVOUtil.returnSuccess(levelChangesRecordMapper.selectOne(entity));
//   }
//   @Override
//   public ResultVO<?> addLevelChangesRecord(LevelChangesRecordDTO dto){
//   LevelChangesRecord entity=new LevelChangesRecord();
//   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//   //需要开发人员各自定义
//   entity.setNo("");
//   levelChangesRecordMapper.insert(entity);
//   	return ResultVOUtil.returnSuccess();
//   }

   @Override
   public ResultVO<?> updateLevelChangesRecord(LevelChangesRecordDTO dto){
       for (String no : dto.getNos()) {
           LevelChangesRecord entity=new LevelChangesRecord();
           entity.setNo(no);
           LevelChangesRecord result=levelChangesRecordMapper.selectOne(entity);
           BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);
           result.setDescribe(levelChangeEnum.DESCRIBE.getMessage());
           result.setIsPush(levelChangeEnum.PUSH_OK.getCode().toString());
           levelChangesRecordMapper.updateById(result);
       }
   	return ResultVOUtil.returnSuccess();
   }
//   @Override
//   public ResultVO<?> deleteLevelChangesRecord(LevelChangesRecordDTO dto){
//   LevelChangesRecord entity=new LevelChangesRecord();
//    entity.setNo(dto.getNo());
//    LevelChangesRecord result=levelChangesRecordMapper.selectOne(entity);
//    levelChangesRecordMapper.deleteById(result.getId());
//   	return ResultVOUtil.returnSuccess();
//   }
//   @Override
//   public ResultVO<?> searchLevelChangesRecordRelation(LevelChangesRecordDTO dto){
//        //自定义分页参考依据
//        //VehicleCustom vehicleCustom=new VehicleCustom();
//		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
//		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
//		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));
//   	return null;
//   }
}
