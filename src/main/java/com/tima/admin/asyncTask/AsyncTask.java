package com.tima.admin.asyncTask;

import com.tima.admin.dto.*;
import com.tima.admin.entity.ImageRelation;
import com.tima.admin.entity.UserBaseInformation;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.enums.ImageEnum;
import com.tima.admin.feign.IPlutomembership;
import com.tima.admin.mapper.ImageRelationMapper;
import com.tima.admin.mapper.UserBaseInformationMapper;
import com.tima.admin.service.IThirdPartyRequestService;
import com.tima.admin.service.impl.LabelEntityServiceImpl;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.tima.admin.vo.PlutomembershipVO;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.UserBaseInformationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;


/**
* @Description:    异步任务方法
* @Author:         YYF
* @CreateDate:     2018/12/24 17:41
* @Version:        1.0
*/
@Component
@Slf4j
public class AsyncTask {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private IPlutomembership plutomembership;

    @Autowired
    private IThirdPartyRequestService thirdPartyRequest;

    @Autowired
    private LabelEntityServiceImpl labelEntityService;

    @Autowired
    private UserBaseInformationMapper userBaseInformationMapper;
    @Autowired
    private ImageRelationMapper imageRelationMapper;

    /**
     * 存储日志到mongoDB
     * @param dto
     */
    @Async
    public void insertLogToMongo(ServiceLogsDTO dto) {
        mongoTemplate.insert(dto);
    }

    /**
     * 登录成功后同步信息到AAA和为新用户增加积分
     * 走异步
     * @param dto
     */
    @Async
    public void userLoginAsyncInfo(UserBaseInformationVO item, PlutomembershipDTO pmsDTO) {
        PlutomembershipVO pmsVO = plutomembership.addIntegralByRegistered(pmsDTO);
        if (0 != pmsVO.getCode()) {
            log.info(pmsVO.getMsg());
        }

        this.updateUserInfo(item);

        ThirdPartyRequestDTO thirdPartyRequestDTO=new ThirdPartyRequestDTO();
        if (item.getHeadUrl() != null || item.getUserName() != null || item.getPersonalSignature() != null) {
            UserBaseInformationDTO userBaseInformationDTO = new UserBaseInformationDTO();
            BeanCopyUtil.copyPropertiesIgnoreNull(item, userBaseInformationDTO);
            thirdPartyRequestDTO = thirdPartyRequest.updateUserInfoByAAA(userBaseInformationDTO);
            if (thirdPartyRequestDTO.getErrorCode() != 200) {
                log.info("登录同步信息到AAA失败：{}",thirdPartyRequestDTO.getErrorDescription());
            }
        }
        LabelEntityDTO labelEntityDTO = new LabelEntityDTO();
        labelEntityDTO.setUid(item.getId());
        ResultVO<?> resultVO = labelEntityService.addLabelEntityToUser(labelEntityDTO);

        log.info("用户登录异步方法执行完毕，执行结果--增加积分:{}，同步AAA:{}，同步标签：{}",pmsVO.getMsg(),thirdPartyRequestDTO.getErrorDescription(),resultVO.getMsg());


    }


    private void updateUserInfo(UserBaseInformationVO user) {
        List<UserBaseInformationVO> userBaseInformationList = userBaseInformationMapper.selectUserThirdInfo(user);

        if(userBaseInformationList==null||userBaseInformationList.size()>1){
            return;
        }
        UserBaseInformationVO userBaseInformation = userBaseInformationList.get(0);
        boolean flag = false;
        if (userBaseInformation.getHeadUrl() == null && userBaseInformation.getHeadImage() != null) {
            ImageRelation imageRelation = new ImageRelation();
            imageRelation.setNo(CodeNoEnum.IMAGE_RELATION.getTableNO() + CommentUtil.createNo());
            imageRelation.setImageUrl(userBaseInformation.getHeadImage());
            imageRelation.setImageTypeId(userBaseInformation.getId());
            imageRelation.setImageTypeNo(userBaseInformation.getNo());
            imageRelation.setImageType(ImageEnum.HAEDURL.getCode().toString());
            imageRelationMapper.insert(imageRelation);
        }
        if (user.getUserName() == null && userBaseInformation.getNick() != null) {
            user.setUserName(userBaseInformation.getNick());
            flag = true;
        }
        if (user.getSex() == null && userBaseInformation.getSex() != null) {
            user.setSex(new Integer(userBaseInformation.getSex()));
            flag = true;
        }
        if (flag) {
            UserBaseInformation item = new UserBaseInformation();
            BeanCopyUtil.copyPropertiesIgnoreNull(user, item);
            userBaseInformationMapper.updateById(item);
        }
    }

}
