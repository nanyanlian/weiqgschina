package com.qgschina.main.address.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.common.util.StringUtil;
import com.qgschina.main.address.dao.AddressBookDao;
import com.qgschina.main.address.dao.UserHasAddressBookDao;
import com.qgschina.main.address.model.AddressBook;
import com.qgschina.main.address.model.UserHasAddressBook;
import com.qgschina.main.address.service.AddressBookService;

/**
 * Service - 微信用户通讯录匹配信息
 * */
@Service("/addressBookService")
public class AddressBookServiceImpl implements AddressBookService {
	@Resource
	private AddressBookDao addressBookDao;
	@Resource
	private UserHasAddressBookDao userHasAddressBookDao;

	/**
	 * 在通讯录功能中,对不同微信号以及不同的发送内容,以及回复不同内容
	 * 
	 * @param openid
	 *            微信用户账号
	 * @param content
	 *            微信用户发送信息
	 * */
	public String disposeDealAddressBook(String openid, String content) {
		UserHasAddressBook userHasAddressBook = null;
		boolean userExist = userHasAddressBookDao.openIdExists(openid);
		// 如果用户不存在,那么提醒绑定
		if (!userExist) {
			userHasAddressBook = new UserHasAddressBook(openid);
			userHasAddressBookDao.save(userHasAddressBook);
			return "您的账户未进行绑定,请输入 \"工号姓名\" 进行绑定,例如 :0289张三";
		}
		userHasAddressBook = userHasAddressBookDao.queryByOpenid(openid);
		if (StringUtil.outofnull(userHasAddressBook.getJobNo()).equals("")) {
			// 如果用户存在但没有工号,则该操作为绑定操作
			return disposeBindFunc(userHasAddressBook, openid, content);
		}
		return disposeProvideContactInfo(content);
	}

	/**
	 * 根据输入的姓名,对数据库进行查询并返回结果
	 * 
	 * @param name
	 *            员工姓名(可拼音)
	 * */
	public String disposeProvideContactInfo(String name) {
		if (StringUtil.containChinese(name)) {
			List<AddressBook> addressBookList = addressBookDao
					.queryByName(name);
			if (addressBookList.size() == 0)
				return "查无此人,您可以通过输入对方姓名拼音首字母进行查找\n\n";
			return convertContactInfoFromAddressBookList(addressBookList)
					.toString();
		} else {
			List<AddressBook> addressBookList = addressBookDao
					.queryByPinYin(name);
			if (addressBookList.size() == 0)
				return "查无此人,您可以通过输入对方完整姓名进行查找\n\n";
			return convertContactInfoFromAddressBookList(addressBookList)
					.toString();
		}
	}

	/**
	 * 根据一组通讯录对象生成一条消息
	 * 
	 * @param addressBookList
	 *            通讯录列表
	 * */
	private StringBuffer convertContactInfoFromAddressBookList(
			List<AddressBook> addressBookList) {
		if (addressBookList.size() == 1)
			return convertAContactInfoFromAddressBook(addressBookList.get(0));
		else {
			StringBuffer buf = new StringBuffer("找到").append(
					addressBookList.size()).append("名员工的通讯信息\n");
			buf.append("您可以输入员工的完整姓名进行查询");
			for (AddressBook addressBook : addressBookList) {
				buf.append(convertAContactInfoFromAddressBook(addressBook))
						.append("\n\n");
			}
			return buf;
		}
	}

	/**
	 * 根据单个通讯录对象生成一条消息
	 * 
	 * @param addressBook
	 *            通讯录对象
	 * */
	public StringBuffer convertAContactInfoFromAddressBook(
			AddressBook addressBook) {
		String text = "";
		StringBuffer contactInfo = new StringBuffer("姓名:").append(addressBook
				.getName());
		text = addressBook.getTelePhone();
		if (!StringUtil.outofnull(text).equals("")) {
			contactInfo.append("\n座机:").append(text);
		}
		text = addressBook.getMobilePhone();
		if (!StringUtil.outofnull(text).equals("")) {
			contactInfo.append("\n手机1:").append(text);
		}
		text = addressBook.getMobilePhoneBak();
		if (!StringUtil.outofnull(text).equals("")) {
			contactInfo.append("\n手机2:").append(text);
		}
		text = addressBook.getEmail();
		if (!StringUtil.outofnull(text).equals("")) {
			contactInfo.append("\n邮箱:").append(text);
		}
		return contactInfo;
	}

	/**
	 * 执行用户的绑定操作
	 * 
	 * @param userHasAddressBook
	 *            微信用户通讯录匹配对象
	 * @param openid
	 *            用户的微信帐号
	 * @param content
	 *            用户输入的信息
	 * */
	public String disposeBindFunc(UserHasAddressBook userHasAddressBook,
			String openid, String content) {
		if (!disposeJudgebindMessageIsValid(content)) {
			return "您输入的信息有误,请输入 \"工号姓名\" 进行绑定,例如 :0289张三";
		}
		String jobNo = content.substring(0, 4);
		String name = content.substring(4);
		// 查看这个工号是否已经被绑定,如果已被绑定,则提示
		if (disposeJudgeJobNoIsBind(jobNo)) {
			return "该工号已被绑定,请检查,或联系管理员(管理员微信号:jasmlove0729)";
		}
		// 如果工号与姓名在公司通讯录中存在
		if (addressBookDao.queryExist(jobNo, name)) {
			userHasAddressBookDao
					.updateJobNo(userHasAddressBook.getId(), jobNo);
			return "绑定成功";
		} else {
			return new StringBuffer("您输入的信息有误,工号为").append(jobNo)
					.append(" ,姓名为").append(name)
					.append("的人员不存在,请勿非法操作或询问公司人事").toString();
		}
	}

	/**
	 * 判断工号是否已经被绑定
	 * 
	 * @param jobNo
	 *            工号
	 * @return true-已绑定,false-未绑定
	 * */
	public boolean disposeJudgeJobNoIsBind(String jobNo) {
		return userHasAddressBookDao.queryExist(jobNo);
	}

	/**
	 * 判断用户输入的绑定信息是否合法
	 * 
	 * @param message
	 *            用户输入的信息
	 * 
	 * @return true-合法,false-不合法
	 * */
	public boolean disposeJudgebindMessageIsValid(String message) {
		if (message.length() <= 4) {
			return false;
		} else if (message.contains(" ")) {
			return false;
		}
		return true;
	}

}
