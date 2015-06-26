package com.qgschina.main.resume.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgschina.main.resume.model.ResumeCertificate;
import com.qgschina.main.resume.service.ResumeCertificateService;
import com.qgschina.main.resume.service.ResumeService;

/**
 * Controller - 简历证书
 * */
@Controller
@RequestMapping("/resumeCertificate")
public class ResumeCertificateController {
	@Resource
	private ResumeCertificateService resumeCertificateService;
	@Resource
	private ResumeService resumeService;

	/**
	 * 删除证书
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param certificateId
	 *            证书编号
	 * */
	@RequestMapping("/deleteCertificate.do")
	@ResponseBody
	public String deleteCertificate(int resumeId, int certificateId) {
		resumeService.disposeFeebBackInputNum(resumeId, certificateId,
				new ResumeCertificate());
		resumeCertificateService.disposeDelById(certificateId);
		return "success";
	}

	/**
	 * 保存证书
	 * 
	 * @param certificateId
	 *            证书编号
	 * @param oldInputNum
	 *            编辑或保存前,现有证书的输入域的最大数
	 * */
	@RequestMapping("/saveCertificate.do")
	@ResponseBody
	public String saveCertificate(ResumeCertificate certificate, int oldInputNum) {
		if (certificate.getId() == 0) {
			resumeCertificateService.disposeSave(certificate);
		} else {
			resumeCertificateService.disposeUpdate(certificate);
		}
		resumeService.disposeFeebBackInputNum(certificate, oldInputNum);
		return "success";
	}
}
