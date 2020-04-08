package com.tima.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.tima.admin.dto.SendMessageDTO;
import com.tima.admin.entity.SendMessage;
import com.tima.admin.vo.ResultVO;

/**
 * <p>
 * 消息推送 服务类
 * </p>
 *
 * @author YYF
 * @since 2018-12-11
 */
public interface ISendMessageService extends IService<SendMessage> {
//   public ResultVO<?> searchSendMessageList(SendMessageDTO dto);
   public ResultVO<?> searchSendMessageListPage(SendMessageDTO dto);
//   public ResultVO<?> searchSendMessageOne(SendMessageDTO dto);
   public ResultVO<?> addSendMessage(SendMessageDTO dto);
//   public ResultVO<?> updateSendMessage(SendMessageDTO dto);
//   public ResultVO<?> deleteSendMessage(SendMessageDTO dto);
//   public ResultVO<?> searchSendMessageRelation(SendMessageDTO dto);
}
