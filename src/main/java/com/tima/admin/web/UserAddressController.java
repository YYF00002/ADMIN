package com.tima.admin.web;


import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import com.tima.admin.vo.ResultVO;
import com.tima.admin.dto.UserAddressDTO;
import com.tima.admin.vo.UserAddressVO;
import com.tima.admin.service.IUserAddressService;
import com.tima.admin.entity.UserAddress;
import java.util.List;
import com.baomidou.mybatisplus.plugins.Page;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户收货地址 前端控制器
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
@Slf4j
@Api(tags = { "用户收货地址API" })
@RestController
@RequestMapping("/admin/userAddress")
public class UserAddressController {
    
   @Autowired
   private IUserAddressService  iUserAddressService; 
   
    @ApiOperation(value = "用户收货地址列表查询", notes = "用户收货地址API")
	@RequestMapping(value = "/searchUserAddressList",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<List<UserAddress>> searchUserAddressList(@RequestBody UserAddressDTO dto){		
		return (ResultVO<List<UserAddress>>)iUserAddressService.searchUserAddressList(dto);
	}
//	@ApiOperation(value = "用户收货地址列表分页查询", notes = "用户收货地址API")
//	@RequestMapping(value = "/searchUserAddressListPage",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<Page<UserAddress>> searchUserAddressListPage(@RequestBody UserAddressDTO dto){		
//		return (ResultVO<Page<UserAddress>>)iUserAddressService.searchUserAddressListPage(dto);
//	}
	@ApiOperation(value = "用户收货地址详细查询", notes = "用户收货地址API")
	@RequestMapping(value = "/searchUserAddressOne",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<UserAddress> searchUserAddressOne(@RequestBody UserAddressDTO dto){		
		return (ResultVO<UserAddress>)iUserAddressService.searchUserAddressOne(dto);
	}
	@ApiOperation(value = "用户收货地址详细查询（Web）", notes = "用户收货地址Web")
	@RequestMapping(value = "/searchUserAddressOneWeb",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<UserAddress> searchUserAddressOneWeb(@RequestBody UserAddressDTO dto){		
		return (ResultVO<UserAddress>)iUserAddressService.searchUserAddressOne(dto);
	}
	@ApiOperation(value = "用户收货地址添加", notes = "用户收货地址API")
	@RequestMapping(value = "/addUserAddress",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> addUserAddress(@RequestBody UserAddressDTO dto){		
		return iUserAddressService.addUserAddress(dto);
	}	
	@ApiOperation(value = "用户收货地址更新", notes = "用户收货地址API")
	@RequestMapping(value = "/updateUserAddress",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> updateUserAddress(@RequestBody UserAddressDTO dto){		
		return iUserAddressService.updateUserAddress(dto);
	}	
	@ApiOperation(value = "用户收货地址删除", notes = "用户收货地址API")
	@RequestMapping(value = "/deleteUserAddress",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> deleteUserAddress(@RequestBody UserAddressDTO dto){		
		return iUserAddressService.deleteUserAddress(dto);
	}
	
	@ApiOperation(value = "设置默认地址", notes = "用户收货地址API")
	@RequestMapping(value = "/setDefaultAddress",method = RequestMethod.POST)
	@ResponseBody
	public ResultVO<?> setDefaultAddress(@RequestBody UserAddressDTO dto){		
		return iUserAddressService.setDefaultAddress(dto);
	}
	
//	@ApiOperation(value = "用户收货地址关联查询", notes = "用户收货地址API")
//	@RequestMapping(value = "/searchUserAddressRelation",method = RequestMethod.POST)
//	@ResponseBody
//	public ResultVO<UserAddressVO> searchUserAddressRelation(@RequestBody UserAddressDTO dto){		
//		return (ResultVO<UserAddressVO>)iUserAddressService.searchUserAddressRelation(dto);
//	}		
}

