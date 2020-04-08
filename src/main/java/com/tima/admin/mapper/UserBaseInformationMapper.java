package com.tima.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tima.admin.dto.UserBaseInformationDTO;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.vo.UserBaseInformationVO;

import java.util.List;

/**
 * <p>
 * 用户基本信息表 Mapper 接口
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
public interface UserBaseInformationMapper extends BaseMapper<UserBaseInformation> {


    public List<UserBaseInformationVO> selectAll(Page<UserBaseInformationVO> result,
                                                 UserBaseInformationDTO dto);

    public UserBaseInformationVO selectAll(UserBaseInformation entity);

    public UserBaseInformationVO selectUserDeatil(UserBaseInformation entity);

    public List<UserBaseInformationVO> searchUserBaseInformationMany(UserBaseInformationDTO dto);

    public List<UserBaseInformationVO> selectUserInformationAndIntegral(Page<UserBaseInformationVO> result,
                                                                        UserBaseInformationDTO dto);

    public List<UserBaseInformationVO> synchronizeUserInformation(Page<UserBaseInformationVO> result,
                                                                  UserBaseInformationDTO dto);


    public List<UserBaseInformationVO> selectAnniversaryBlessing(UserBaseInformationDTO dto);

    //根据用户查头像
    public UserBaseInformationVO selectUserImg(UserBaseInformation entity);

    //根据用户查头像
    public List<UserBaseInformationVO> selectUserThirdInfo(UserBaseInformationVO entity);
    //自定义分页参考方法，需要xml里面添加该方法
    //public List<VehicleCustom> selectVehicleCustomList(Pagination page,VehicleCustom custom);
}
