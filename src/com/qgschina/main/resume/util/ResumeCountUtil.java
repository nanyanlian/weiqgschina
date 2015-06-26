package com.qgschina.main.resume.util;

import static org.apache.commons.lang.StringUtils.isNotEmpty;


import com.qgschina.main.resume.model.ResumeApplyJob;
import com.qgschina.main.resume.model.ResumeCertificate;
import com.qgschina.main.resume.model.ResumeEdu;
import com.qgschina.main.resume.model.ResumeIT;
import com.qgschina.main.resume.model.ResumeLanguage;
import com.qgschina.main.resume.model.ResumeOtherInfo;
import com.qgschina.main.resume.model.ResumePersonInfo;
import com.qgschina.main.resume.model.ResumeProjectExp;
import com.qgschina.main.resume.model.ResumeTrain;
import com.qgschina.main.resume.model.ResumeWorkExp;

public class ResumeCountUtil {
	public static int countResume(Object obj) {
		if( obj instanceof ResumePersonInfo )
			return countPersonInfo((ResumePersonInfo)obj);
		if( obj instanceof ResumeApplyJob ) 
			return countApplyJob((ResumeApplyJob)obj);
		if( obj instanceof ResumeLanguage ) 
			return countLanguage((ResumeLanguage)obj);
		if( obj instanceof ResumeOtherInfo ) 
			return countOtherInfo((ResumeOtherInfo)obj);
		if( obj instanceof ResumeProjectExp ) 
			return countProjectExp((ResumeProjectExp)obj);
		if( obj instanceof ResumeTrain )
			return countTrain((ResumeTrain)obj);
		if( obj instanceof ResumeEdu ) 
			return countEdu((ResumeEdu)obj);
		if( obj instanceof ResumeWorkExp ) 
			return countWorkExp((ResumeWorkExp)obj);
		if( obj instanceof ResumeIT ) 
			return countIT((ResumeIT)obj);
		if( obj instanceof ResumeCertificate ) 
			return countCertificate((ResumeCertificate)obj);
		return 0;
	}
	
	private static int countCertificate(ResumeCertificate certificate) {
		int num = 0;
		if( isNotEmpty(certificate.getCertificateName())) 	num++;
		if( isNotEmpty(certificate.getGainDate())) 			num++;
		if( isNotEmpty(certificate.getScore())) 			num++;
		return num;
	}

	private static int countPersonInfo(ResumePersonInfo personInfo) {
		int num = 0;
		if( isNotEmpty(personInfo.getResumeName())) 		num++;
		if( isNotEmpty(personInfo.getOpeness())) 			num++;
		if( isNotEmpty(personInfo.getName())) 				num++;
		if( isNotEmpty(personInfo.getGender())) 			num++;
		if( isNotEmpty(personInfo.getBirthday())) 			num++;
		if( isNotEmpty(personInfo.getWorkLife())) 			num++;
		if( isNotEmpty(personInfo.getPaperType())) 			num++;
		if( isNotEmpty(personInfo.getPaperNo())) 			num++;
		if( isNotEmpty(personInfo.getPhone())) 				num++;
		if( isNotEmpty(personInfo.getLiveProvince())) 		num++;
		if( isNotEmpty(personInfo.getLiveCity())) 			num++;
		if( isNotEmpty(personInfo.getHouseProvince())) 		num++;
		if( isNotEmpty(personInfo.getHouseCity())) 			num++;
		if( isNotEmpty(personInfo.getEmail()))				num++;
		return num;
	}
	
	private static int countEdu(ResumeEdu edu) {
		int num = 0;
		if( isNotEmpty(edu.getStartDate()) ) 				num++;
		if( isNotEmpty(edu.getEndDate()) ) 					num++;
		if( isNotEmpty(edu.getSchool()) ) 					num++;
		if( isNotEmpty(edu.getCollege()) ) 					num++;
		if( isNotEmpty(edu.getSubject()) ) 					num++;
		if( isNotEmpty(edu.getLevel()) ) 					num++;
		if( isNotEmpty(edu.getDesc()) ) 					num++;
		return num;
	}
	
	private static int countWorkExp(ResumeWorkExp workExp) {
		int num = 0;
		if( isNotEmpty(workExp.getStartDate()) ) 			num++;
		if( isNotEmpty(workExp.getEndDate()) ) 				num++;
		if( isNotEmpty(workExp.getCompany()) ) 				num++;
		if( isNotEmpty(workExp.getTrade()) ) 				num++;
		if( isNotEmpty(workExp.getScale()) ) 				num++;
		if( isNotEmpty(workExp.getProperty()) ) 			num++;
		if( isNotEmpty(workExp.getDepartment()) ) 			num++;
		if( isNotEmpty(workExp.getJobType()) ) 				num++;
		if( isNotEmpty(workExp.getJob()) ) 					num++;
		if( isNotEmpty(workExp.getJobDesc()) ) 				num++;
		return num;
	}
	
	private static int countApplyJob(ResumeApplyJob applyJob) {
		int num = 0;
		if( isNotEmpty(applyJob.getWorkType()) ) 			num++;
		if( isNotEmpty(applyJob.getSalary()) ) 				num++;
		if( isNotEmpty(applyJob.getWorkDate()) ) 			num++;
		if( isNotEmpty(applyJob.getSelfDesc()) ) 			num++;
		return num;
	}
	
	private static int countTrain(ResumeTrain train) {
		int num = 0;
		if( isNotEmpty(train.getStartDate()) ) 				num++;
		if( isNotEmpty(train.getEndDate()) ) 				num++;
		if( isNotEmpty(train.getSchool()) ) 				num++;
		if( isNotEmpty(train.getSchoolPosition()) ) 		num++;
		if( isNotEmpty(train.getCourse()) ) 				num++;
		if( isNotEmpty(train.getCertificate()) ) 			num++;
		if( isNotEmpty(train.getTrainDesc()) ) 				num++;
		return num;
	}
	
	private static int countLanguage(ResumeLanguage language) {
		int num = 0;
		if( isNotEmpty(language.getLanguageType()) ) 		num++;
		if( isNotEmpty(language.getSkill()) ) 				num++;
		if( isNotEmpty(language.getWriteRead()) ) 			num++;
		if( isNotEmpty(language.getListenSpeak()) ) 		num++;
		return num;
	}
	
	private static int countIT(ResumeIT IT) {
		int num = 0;
		if( isNotEmpty(IT.getBigSkill()) ) 					num++;
		if( isNotEmpty(IT.getSkill()) ) 					num++;
		if( isNotEmpty(IT.getUseDate()) ) 					num++;
		if( isNotEmpty(IT.getLevel()) ) 					num++;
		return num;
	}
	
	private static int countProjectExp(ResumeProjectExp projectExp) {
		int num = 0;
		if( isNotEmpty(projectExp.getStartDate()) ) 		num++;
		if( isNotEmpty(projectExp.getEndDate()) ) 			num++;
		if( isNotEmpty(projectExp.getProjectName()) ) 		num++;
		if( isNotEmpty(projectExp.getDevTool()) ) 			num++;
		if( isNotEmpty(projectExp.getHardwareEnvir()) ) 	num++;
		if( isNotEmpty(projectExp.getSoftwareEnvir()) ) 	num++;
		if( isNotEmpty(projectExp.getProjectDesc()) ) 		num++;
		if( isNotEmpty(projectExp.getJobDesc()) ) 			num++;
		return num;
	}
	
	private static int countOtherInfo(ResumeOtherInfo otherInfo) {
		int num = 0;
		if( isNotEmpty(otherInfo.getSubject()) ) 			num++;
		if( isNotEmpty(otherInfo.getDesc()) ) 				num++;
		return num;
	}
}
