package com.tima.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tima.admin.dto.UserBindingOtherModulesDTO;
import com.tima.admin.dto.VehicleBrandDTO;
import com.tima.admin.entity.UserBindingOtherModules;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.feign.IAutoMobileService;
import com.tima.admin.mapper.UserBindingOtherModulesMapper;
import com.tima.admin.service.IUserBindingOtherModulesService;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.VehicleBrandVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;

/**
 * <p>
 * 用户绑定其他模块信息表 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2019-04-09
 */
@Slf4j
@Transactional
@Service
public class UserBindingOtherModulesServiceImpl extends ServiceImpl<UserBindingOtherModulesMapper, UserBindingOtherModules> implements IUserBindingOtherModulesService {


    @Autowired
    private UserBindingOtherModulesMapper userBindingOtherModulesMapper;

    @Autowired
    private IAutoMobileService iAutoMobileService;

    @Override
    public ResultVO<?> searchUserBindingOtherModulesList(UserBindingOtherModulesDTO dto) {
        EntityWrapper<UserBindingOtherModules> entityWrapper = new EntityWrapper<UserBindingOtherModules>();
        UserBindingOtherModules entity = new UserBindingOtherModules();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entity.setUserId(CommentUtil.getUser().getId());
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(userBindingOtherModulesMapper.selectList(entityWrapper));
    }

    @Override
    public ResultVO<?> searchUserBindingOtherModulesListPage(UserBindingOtherModulesDTO dto) {
        Page<UserBindingOtherModules> page = new Page<UserBindingOtherModules>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        EntityWrapper<UserBindingOtherModules> entityWrapper = new EntityWrapper<UserBindingOtherModules>();
        UserBindingOtherModules entity = new UserBindingOtherModules();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(page.setRecords(userBindingOtherModulesMapper.selectPage(page, entityWrapper)));
    }

    @Override
    public ResultVO<?> searchUserBindingOtherModulesOne(UserBindingOtherModulesDTO dto) {
        UserBindingOtherModules entity = new UserBindingOtherModules();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entity.setUserId(CommentUtil.getUser().getId());
        return ResultVOUtil.returnSuccess(userBindingOtherModulesMapper.selectOne(entity));
    }


    @Override
    public ResultVO<?> addUserBindingOtherModules(UserBindingOtherModulesDTO dto) {
        //调用auto根据brandNo查id
        VehicleBrandDTO vehicleBrandDTO = new VehicleBrandDTO();
        StringBuilder brandsId = new StringBuilder();
        StringBuilder brandsNo = new StringBuilder();
        List<String> brandNos = dto.getBrandNos();
        log.info("传入的brandNos:{}",brandNos.toString());
        List<VehicleBrandVO> data = iAutoMobileService.selectBrandList(vehicleBrandDTO).getData();
        if(data==null||data.size()==0){
            return ResultVOUtil.returnFail(500,"获取事业部失败");
        }
        for (VehicleBrandVO brandItem : data) {
            if(brandNos==null||brandNos.size()==0){
                brandsId.append(brandItem.getId()).append(",");
                brandsNo.append(brandItem.getNo()).append(",");
            }else{
                for (String brandNo : brandNos) {
                    if(brandNo.equals(brandItem.getNo())){
                        brandsId.append(brandItem.getId()).append(",");
                        brandsNo.append(brandItem.getNo()).append(",");
                    }
                }
            }
        }
        if(brandsId.length()>0&&brandsNo.length()>0){
            dto.setBrandsId(brandsId.substring(0,brandsId.length()-1));
            dto.setBrandsNo(brandsNo.substring(0,brandsNo.length()-1));
        }
        Long userId = CommentUtil.getUser().getId();
        UserBindingOtherModules entity = new UserBindingOtherModules();
        entity.setUserId(userId);
        UserBindingOtherModules userBindingOtherModules = userBindingOtherModulesMapper.selectOne(entity);
        if(userBindingOtherModules==null){
            BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
            entity.setNo(CodeNoEnum.USER_BINDING_OTHER_MODULES.getTableNO() + CommentUtil.createNo());
            userBindingOtherModulesMapper.insert(entity);
        }else{
            BeanCopyUtil.copyPropertiesIgnoreNull(dto, userBindingOtherModules);
            userBindingOtherModulesMapper.updateById(userBindingOtherModules);
        }
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> updateUserBindingOtherModules(UserBindingOtherModulesDTO dto) {
        UserBindingOtherModules entity = new UserBindingOtherModules();
        entity.setNo(dto.getNo());
        UserBindingOtherModules result = userBindingOtherModulesMapper.selectOne(entity);
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, result);
        userBindingOtherModulesMapper.updateById(result);
        return ResultVOUtil.returnSuccess();
    }


}
