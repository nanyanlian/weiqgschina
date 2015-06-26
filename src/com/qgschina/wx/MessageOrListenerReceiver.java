package com.qgschina.wx;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.nyl.wxframework.annotation.MessageOrEventListener;
import org.nyl.wxframework.exception.WechatInterfaceException;
import org.nyl.wxframework.propertyoptions.StandardMessageOrEventListenerType;
import org.nyl.wxframework.support.message.req.ContentMessage;
import org.nyl.wxframework.util.HttpRequestUtil;
import org.nyl.wxframework.util.wechat.RespMessageUtil;

import com.alibaba.fastjson.JSONObject;

/**
 * Receiver - 消息或响应接收者
 * */
public class MessageOrListenerReceiver {

	/**
	 * 任命为被动接收文本消息
	 * */
	@MessageOrEventListener(appoint = true, value = StandardMessageOrEventListenerType.MESSAGE_CONTENT)
	public String receiverContentMessage(HttpServletRequest request,
			ContentMessage message) {
		try {
			String url = request.getScheme()
					+ "://"
					+ request.getServerName()
					+ ":"
					+ request.getServerPort()
					+ request.getContextPath()
					+ "/addressBook/queryAddressBook.do?fromUsername="
					+ Base64.encodeToString(Hex.encodeToString(
							message.getFromUserName().getBytes()).getBytes())
					+ "&content="
					+ Base64.encodeToString(Hex.encodeToString(
							message.getContent().getBytes()).getBytes());
			JSONObject jsonObject = HttpRequestUtil.get(url);
			return RespMessageUtil.createContentMessage(message,
					jsonObject.getString("data"));
		} catch (WechatInterfaceException e) {
			e.printStackTrace();
		}
		return "";
	}
}
