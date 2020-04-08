package com.tima.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tima.admin.dto.SendMessageDTO;
import com.tima.admin.dto.UserBaseInformationDTO;
import com.tima.admin.dto.dmSVRDTO;
import com.tima.admin.entity.LabelInfo;
import com.tima.admin.entity.SendMessage;
import com.tima.admin.enums.CodeNoEnum;
import com.tima.admin.enums.SendMessageEnum;
import com.tima.admin.feign.ISVR;
import com.tima.admin.mapper.*;
import com.tima.admin.service.ISendMessageService;
import com.tima.admin.util.BeanCopyUtil;
import com.tima.admin.util.CommentUtil;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.vo.LabelEntityVO;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.vo.UserBaseInformationVO;
import com.tima.admin.vo.dmSVRVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 消息推送 服务实现类
 * </p>
 *
 * @author YYF
 * @since 2018-12-11
 */
@Slf4j
@Transactional
@Service
public class SendMessageServiceImpl extends ServiceImpl<SendMessageMapper, SendMessage> implements ISendMessageService {


    @Autowired
    private SendMessageMapper sendMessageMapper;

    @Autowired
    private UserBaseInformationMapper userBaseInformationMapper;

    @Autowired
    private SysDictDataMapper sysDictDataMapper;

    @Autowired
    private LabelInfoMapper labelInfoMapper;

    @Autowired
    private LabelEntityMapper labelEntityMapper;

    @Autowired
    private ISVR isvr;

    //   @Override
//   public ResultVO<?> searchSendMessageList(SendMessageDTO dto){
//   EntityWrapper<SendMessage> entityWrapper=new EntityWrapper<SendMessage>();
//    SendMessage entity=new SendMessage();
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//    entityWrapper.setEntity(entity);
//   	return ResultVOUtil.returnSuccess(sendMessageMapper.selectList(entityWrapper));
//   }
    @Override
    public ResultVO<?> searchSendMessageListPage(SendMessageDTO dto) {
        Page<SendMessage> page = new Page<SendMessage>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        EntityWrapper<SendMessage> entityWrapper = new EntityWrapper<SendMessage>();
        SendMessage entity = new SendMessage();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(page.setRecords(sendMessageMapper.selectPage(page, entityWrapper)));
    }
//   @Override
//   public ResultVO<?> searchSendMessageOne(SendMessageDTO dto){
//   SendMessage entity=new SendMessage();
//   BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
//
//   	return ResultVOUtil.returnSuccess(sendMessageMapper.selectOne(entity));
//   }
    @Override
    public ResultVO<?> addSendMessage(SendMessageDTO dto) {
        //查询标签
        LabelInfo labelInfoRes = new LabelInfo();
        List<Long> labels = new ArrayList<>();
        String laberNames="";
        int total=0;
        for (String no : dto.getLabels()) {
            labelInfoRes.setNo(no);
            LabelInfo labelInfoRon = labelInfoMapper.selectOne(labelInfoRes);
            laberNames=laberNames+","+labelInfoRon.getLabelName();
            if (labelInfoRon != null) {
                labels.add(labelInfoRon.getId());
            }
        }
        //查询标签用户
        List<LabelEntityVO> labelEntityVOS = labelEntityMapper.selectUserByLabel(labels);
        dmSVRDTO dmSVRDTO = new dmSVRDTO();
        dmSVRDTO.setPrject("JAC-ADMIN");
        dmSVRDTO.setTitle(dto.getType());
        dmSVRDTO.setMsg(dto.getData());
        SendMessage entity = new SendMessage();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto, entity);
        for (LabelEntityVO item : labelEntityVOS) {
            dmSVRDTO.setAccount(item.getUserNo());
            dmSVRVO dmSVRVO = isvr.sendMessages(dmSVRDTO);
            Map<String, Integer> map = (Map) JSONObject.parseObject(dmSVRVO.getData());
            if (map.get("ret_code") == 0) {
                total++;
                log.info("会员祝福推送成功，推送内容：{}", entity.toString());
            } else {
                log.info("会员祝福推送失败，推送内容：{}", entity.toString());
                log.info("失败原因：{}", dmSVRVO.getData().toString());
            }
        }
        entity.setNo(CodeNoEnum.SEND_MESSAGE.getTableNO() + CommentUtil.createNo());
        entity.setPushObject(laberNames.substring(1));
        entity.setType(SendMessageEnum.LABEL_PUSH.getCode().toString());
        sendMessageMapper.insert(entity);
        return ResultVOUtil.returnSuccess("推送消息个数",total);
    }
//   @Override
//   public ResultVO<?> updateSendMessage(SendMessageDTO dto){
//   SendMessage entity=new SendMessage();
//    entity.setNo(dto.getNo());
//    SendMessage result=sendMessageMapper.selectOne(entity);
//    BeanCopyUtil.copyPropertiesIgnoreNull(dto,result);
//    sendMessageMapper.updateById(result);
//   	return ResultVOUtil.returnSuccess();
//   }
//   @Override
//   public ResultVO<?> deleteSendMessage(SendMessageDTO dto){
//   SendMessage entity=new SendMessage();
//    entity.setNo(dto.getNo());
//    SendMessage result=sendMessageMapper.selectOne(entity);
//    sendMessageMapper.deleteById(result.getId());
//   	return ResultVOUtil.returnSuccess();
//   }
//   @Override
//   public ResultVO<?> searchSendMessageRelation(SendMessageDTO dto){
//        //自定义分页参考依据
//        //VehicleCustom vehicleCustom=new VehicleCustom();
//		//ConvertUtil<VehicleRO, VehicleCustom> convertUtil = new ConvertUtil<VehicleRO, VehicleCustom>();
//		//Page<VehicleCustom> result = convertUtil.pageCommon(ro, vehicleCustom);
//		//return ResultVOUtil.returnSuccess(result.setRecords(this.baseMapper.selectVehicleCustomList(result, convertUtil.entity(ro, vehicleCustom))));
//   	return null;
//   }

    /**
     * @Description: 用户注册周年推送提醒
     * @Author: YYF
     * @CreateDate: 2018/12/11 14:13
     * @Version: 1.0
     */
    public void sendAnniversaryBlessing() {
        UserBaseInformationDTO dto = new UserBaseInformationDTO();
        String format = new SimpleDateFormat("MM-dd").format(new Date());
        dto.setNowDate(format);
        List<UserBaseInformationVO> userBaseInformationVOS = userBaseInformationMapper.selectAnniversaryBlessing(dto);
        if (userBaseInformationVOS == null || userBaseInformationVOS.size() == 0) {
            return;
        }
        //查询推送信息
//        SysDictDataDTO sysDictDataRes = new SysDictDataDTO();
//        sysDictDataRes.setDictCode(sysDictDataEnum.MEMBER_OF_BLESSING.getDictCode());
//        SysDictDataVO sysDictDataRon = sysDictDataMapper.selectSysDictData(sysDictDataRes);

        for (UserBaseInformationVO item : userBaseInformationVOS) {
            SendMessage sendMessageRes = new SendMessage();
            sendMessageRes.setPushObject(item.getId().toString());
            sendMessageRes.setTitle(SendMessageEnum.MESSAGE_TITLE.getTitle());
            sendMessageRes.setType(SendMessageEnum.PERSONAL_PUSH.getCode().toString());
            SendMessage sendMessageRon = sendMessageMapper.selectOne(sendMessageRes);
            if (sendMessageRon != null) {
                continue;
            }
            sendMessageRes.setData(SendMessageEnum.MESSAGE_TITLE.getMessage());
            sendMessageRes.setNotificationTime(new Date());
            sendMessageRes.setNo(CodeNoEnum.SEND_MESSAGE.getTableNO() + CommentUtil.createNo());
            dmSVRDTO dmSVRDTO = new dmSVRDTO();
            dmSVRDTO.setPrject("JAC-ADMIN");
            dmSVRDTO.setTitle(SendMessageEnum.MESSAGE_TITLE.getTitle());
            dmSVRDTO.setMsg(SendMessageEnum.MESSAGE_TITLE.getMessage());
            dmSVRDTO.setAccount(item.getNo());
            dmSVRVO dmSVRVO = isvr.sendMessages(dmSVRDTO);
            Map<String, Integer> map = (Map) JSONObject.parseObject(dmSVRVO.getData());
            if (map.get("ret_code") == 0) {
                sendMessageMapper.insert(sendMessageRes);
                log.info("会员祝福推送成功，推送内容：{}", sendMessageRes.toString());
            } else {
                log.info("会员祝福推送失败，推送内容：{}", sendMessageRes.toString());
                log.info("失败原因：{}", dmSVRVO.getData().toString());
            }

        }
    }


}
