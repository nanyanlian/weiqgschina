package com.qgschina.main.address.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.nyl.wxframework.util.MapUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgschina.main.address.service.AddressBookService;

/**
 * Controller - 通讯录
 * */
@Controller
@RequestMapping("/addressBook")
public class AddressBookController {
	@Resource
	private AddressBookService addressBookService;

	/**
	 * 查找员工的通讯信息,参数需要先进行Hex编码再进行Base64编码
	 * 
	 * @param fromUsername
	 *            - 微信用户发送方的openid
	 * @param content
	 *            - 微信用户发送方的输入内容
	 * 
	 * @return map {"data" : data}
	 * */
	@RequestMapping("/queryAddressBook.do")
	@ResponseBody
	public Map<String, Object> queryAddressBook(String fromUsername,
			String content) {
		fromUsername = new String(Hex.decode(Base64
				.decodeToString(fromUsername).getBytes()));
		content = new String(Hex.decode(Base64.decodeToString(content)
				.getBytes()));
		System.out.println(content);
		return MapUtil.createHashMap("data", addressBookService
				.disposeDealAddressBook(fromUsername, content));
	}

}
