package com.qgschina.main.address.service;

/**
 * Service - 微信用户通讯录匹配信息
 * */
public interface AddressBookService {
	/**
	 * 在通讯录功能中,对不同微信号以及不同的发送内容,以及回复不同内容
	 * 
	 * @param openid
	 *            微信用户账号
	 * @param content
	 *            微信用户发送信息
	 * */
	public String disposeDealAddressBook(String openid, String content);

}
