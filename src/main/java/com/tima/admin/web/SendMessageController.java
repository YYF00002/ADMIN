package com.tima.admin.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.tima.admin.dto.SendMessageDTO;
import com.tima.admin.entity.SendMessage;
import com.tima.admin.service.ISendMessageService;
import com.tima.admin.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 消息推送 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-12-11
 */
@Slf4j
@Api(tags = { "消息推送API" })
@RestController
@RequestMapping("/admin/sendMessage")
public class SendMessageController {
    
   @Autowired
   private ISendMessageService  iSendMessageService; 
   
//    @ApiOperation(value = "消息推送列表查询", notes = "消息推送API")
//	@RequestMapping(value = "/searchSendMessageList",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<List<SendMessage>> searchSendMessageList(@RequestBody SendMessageDTO dto){
//		return (ResultVO<List<SendMessage>>)iSendMessageService.searchSendMessageList(dto);
//	}
	@ApiOperation(value = "消息推送列表分页查询(Web)", notes = "消息推送API")
	@RequestMapping(value = "/searchSendMessageListPageWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<Page<SendMessage>> searchSendMessageListPageWeb(@RequestBody SendMessageDTO dto){
		return (ResultVO<Page<SendMessage>>)iSendMessageService.searchSendMessageListPage(dto);
	}
//	@ApiOperation(value = "消息推送详细查询", notes = "消息推送API")
//	@RequestMapping(value = "/searchSendMessageOne",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<SendMessage> searchSendMessageOne(@RequestBody SendMessageDTO dto){
//		return (ResultVO<SendMessage>)iSendMessageService.searchSendMessageOne(dto);
//	}
	@ApiOperation(value = "根据标签推送消息", notes = "消息推送API")
	@RequestMapping(value = "/addSendMessageWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addSendMessageWeb(@RequestBody SendMessageDTO dto){
		return iSendMessageService.addSendMessage(dto);
	}
//	@ApiOperation(value = "消息推送更新", notes = "消息推送API")
//	@RequestMapping(value = "/updateSendMessage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> updateSendMessage(@RequestBody SendMessageDTO dto){
//		return iSendMessageService.updateSendMessage(dto);
//	}
//	@ApiOperation(value = "消息推送删除", notes = "消息推送API")
//	@RequestMapping(value = "/deleteSendMessage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<?> deleteSendMessage(@RequestBody SendMessageDTO dto){
//		return iSendMessageService.deleteSendMessage(dto);
//	}
//	@ApiOperation(value = "消息推送关联查询", notes = "消息推送API")
//	@RequestMapping(value = "/searchSendMessageRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<SendMessageVO> searchSendMessageRelation(@RequestBody SendMessageDTO dto){
//		return (ResultVO<SendMessageVO>)iSendMessageService.searchSendMessageRelation(dto);
//	}


}

