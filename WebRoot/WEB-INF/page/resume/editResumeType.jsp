<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<jsp:include page="/includes/allInclude.jsp" />
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<meta name="format-detection" content="telephone=no" />
	<meta content="no-cache,must-revalidate" http-equiv="Cache-Control">
	<meta content="no-cache" http-equiv="pragma">
	<meta content="0" http-equiv="expires">
	<script type="text/javascript" src="${js_path}/swipe.js"></script>
	<link href="${css_path}/basic.css" rel="stylesheet" />
	<link href="${css_path}/styles.css" rel="stylesheet" />
	<link href="${css_path}/dialog.css" rel="stylesheet" />
</head>
<body>
	<div id="page_resumeType">
		<input type="hidden" id="loadDate" name="loadDate" value="${loadDate}" />
		<input type="hidden" id="employId" name="employId" value="${sessionScope.resumeEmploy.id}"/>
		<input type="hidden" id="path" value="${path}" />
		<input type="hidden" id="page"  value="${page}" />
		<input type="text" id="rows" style="display:none;" value="${rows}"/>
		<input type="text" id="loadMode"  style="display:none;" value="${loadMode}"/>
		<input type="text" id="loadingMore" style="display:none;" value="true" />
		<header>选择简历内容<div class="back">返回</div></header>
		<section>
			<input type="hidden" id="resumeId" name="resumeId" value="${resumeId}" />
			<article id="personInfo" >
				<div class="img">
					<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/male.png" />
				</div>
				<div class="title">个人信息</div>
			</article>
			<c:if test="${resume != null && resume.personInfo != null}">
				<aside class="detailInfo personInfoAside">
					<dl><dt>姓名:</dt><dd>${resume.personInfo.name}</dd></dl>
					<dl><dt>性别:</dt><dd>${resume.personInfo.gender}</dd></dl>
					<dl><dt>出生年月:</dt><dd>${resume.personInfo.birthday}</dd></dl>
					<dl><dt>${resume.personInfo.paperType}:</dt><dd>${resume.personInfo.paperNo}</dd></dl>
					<dl><dt>工作年限:</dt><dd>${resume.personInfo.workLife}</dd></dl>
					<dl><dt>手机号:</dt><dd>${resume.personInfo.phone}</dd></dl>
					<dl><dt>email:</dt><dd>${resume.personInfo.email}</dd></dl>
					<dl><dt>居住地:</dt><dd>${resume.personInfo.liveProvince}&nbsp;-&nbsp;${resume.personInfo.liveCity}</dd></dl>
					<dl><dt>户口地:</dt><dd>${resume.personInfo.houseProvince}&nbsp;-&nbsp;${resume.personInfo.houseCity}</dd></dl>
				</aside>
			</c:if>
			
			<article id="eduExper">
				<div class="img">
					<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/pencil.png" />
				</div>
				<div class="title">教育经历</div>
			</article>
			<c:forEach items="${resume.eduList}" var="edu">
				<aside class="detailInfo eduAside" eduId="${edu.id}" id="edu_${edu.id}">
					<dl><dt>开始时间:</dt><dd>${edu.startDate}</dd></dl>
					<dl><dt>结束时间:</dt><dd>${edu.endDate}</dd></dl>
					<dl><dt>学院:</dt><dd>${edu.school}&nbsp;-&nbsp;${edu.college}</dd></dl>
					<dl><dt>专业:</dt><dd>${edu.subject}</dd></dl>
					<dl><dt>学历:</dt><dd>${edu.level}</dd></dl>
					<dl><dt>专业描述:</dt><dd>${edu.desc}</dd></dl>
				</aside>
			</c:forEach>
			<article id="workExp">
				<div class="img">
					<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/setting.png" />
				</div>
				<div class="title">工作经验</div>
			</article>
			<c:forEach items="${resume.workExpList}" var="workExp">
				<aside class="detailInfo workExpAside" workExpId="${workExp.id}" id="workExp_${workExp.id}">
					<dl><dt>开始时间:</dt><dd>${workExp.startDate}</dd></dl>
					<dl><dt>结束时间:</dt><dd>${workExp.endDate}</dd></dl>
					<dl><dt>公司:</dt><dd>${workExp.company}</dd></dl>
					<dl><dt>行业:</dt><dd>${workExp.trade}</dd></dl>
					<dl><dt>规模:</dt><dd>${workExp.scale}</dd></dl>
					<dl><dt>性质:</dt><dd>${workExp.property}</dd></dl>
					<dl><dt>部门:</dt><dd>${workExp.department}</dd></dl>
					<dl><dt>职位:</dt><dd>${workExp.jobType}&nbsp;-&nbsp;${workExp.job}</dd></dl>
					<dl><dt>职位描述:</dt><dd>${workExp.jobDesc}</dd></dl>
				</aside>
			</c:forEach>
			<article id="searchForWork" >
				<div class="img">
					<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/search.png" />
				</div>
				<div class="title">求职意向</div>
			</article>
			<c:if test="${resume != null && resume.applyJob != null}">
				<aside class="detailInfo applyJobAside">
					<dl><dt>工作类型:</dt><dd>${resume.applyJob.workType}</dd></dl>
					<dl><dt>薪水:</dt><dd>${resume.applyJob.salary}</dd></dl>
					<dl><dt>到岗时间:</dt><dd>${resume.applyJob.workDate}</dd></dl>
					<dl><dt>自我评价:</dt><dd>${resume.applyJob.selfDesc}</dd></dl>
				</aside>
			</c:if>
			<article id="train">
				<div class="img">
					<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/livejournal.png" />
				</div>
				<div class="title">培训经历</div>
			</article>
			<c:forEach items="${resume.trainList}" var="train">
				<aside class="detailInfo trainAside" trainId="${train.id}" id="train_${train.id}">
					<dl><dt>开始时间:</dt><dd>${train.startDate}</dd></dl>
					<dl><dt>结束时间:</dt><dd>${train.endDate}</dd></dl>
					<dl><dt>培训机构:</dt><dd>${train.school}</dd></dl>
					<dl><dt>培训地点:</dt><dd>${train.schoolPosition}</dd></dl>
					<dl><dt>培训课程:</dt><dd>${train.course}</dd></dl>
					<dl><dt>获得证书:</dt><dd>${train.certificate}</dd></dl>
					<dl><dt>详细描述:</dt><dd>${train.trainDesc}</dd></dl>
				</aside>
			</c:forEach>
			<article id="language">
				<div class="img">
					<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/wordpress.png" />
				</div>
				<div class="title">语言能力</div>
			</article>
			<c:forEach items="${resume.languageList}" var="language">
				<aside class="detailInfo languageAside" languageId="${language.id}" id="language_${language.id}">
					<dl><dt>语言类别:</dt><dd>${language.languageType}</dd></dl>
					<dl><dt>掌握程度:</dt><dd>${language.skill}</dd></dl>
					<dl><dt>读写能力:</dt><dd>${language.writeRead}</dd></dl>
					<dl><dt>听说能力:</dt><dd>${language.listenSpeak}</dd></dl>
				</aside>
			</c:forEach>
			<article id="otherInfo">
				<div class="img">
					<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/mailback.png" />
				</div>
				<div class="title">附加信息</div>
			</article>
		</section>
	</div> 
	<script>
		$(function(){
			PATH = $("#path").val();
			timeout = undefined;
			bindEvent();
		});
		
		function delWorkExp() {
			$(".detailInfo.workExpAside").bind("mousedown", function() {
				var workExpId = $(this).attr("workExpId");
				var resumeId = $("#resumeId").val();
			    timeout = setTimeout(function() {
			        alert("是否删除此工作经验",1000*60*60*24,function(){
			        	$.ajax({
			        		url	: PATH + "/resumeWorkExp/delWorkExp.do",
			        		type: "post",
			        		dataType:"text",
			        		data: {"workExpId":workExpId,"resumeId":resumeId},
			        		success:function(data){
			        			if( data == "success") {
			        				$("#workExp_"+workExpId).remove();
			        			}
			        		}
			        	});
			        },function(){});
			    }, 400);
			});
			$(".detailInfo.workExpAside").bind("mouseup", function() {
			    clearTimeout(timeout);
			});
		}
		
		function delEdu() {
			$(".detailInfo.eduAside").bind("mousedown", function() {
				var eduId = $(this).attr("eduId");
				var resumeId = $("#resumeId").val();
			    timeout = setTimeout(function() {
			        alert("是否删除此教育经历",1000*60*60*24,function(){
			        	$.ajax({
			        		url	: PATH + "/resumeEdu/delEdu.do",
			        		type: "post",
			        		dataType:"text",
			        		data: {"eduId":eduId,"resumeId":resumeId},
			        		success:function(data){
			        			if( data == "success") {
			        				$("#edu_"+eduId).remove();
			        			}
			        		}
			        	});
			        },function(){});
			    }, 400);
			});
			$(".detailInfo.eduAside").bind("mouseup", function() {
			    clearTimeout(timeout);
			});
		}
		
		function delTrain() {
			$(".detailInfo.trainAside").bind("mousedown", function() {
				var trainId = $(this).attr("trainId");
				var resumeId = $("#resumeId").val();
			    timeout = setTimeout(function() {
			        alert("是否删除此培训经历",1000*60*60*24,function(){
			        	$.ajax({
			        		url	: PATH + "/resumeTrain/delTrain.do",
			        		type: "post",
			        		dataType:"text",
			        		data: {"trainId":trainId,"resumeId":resumeId},
			        		success:function(data){
			        			if( data == "success") {
			        				$("#train_"+trainId).remove();
			        			}
			        		}
			        	});
			        },function(){});
			    }, 400);
			});
			$(".detailInfo.eduAside").bind("mouseup", function() {
			    clearTimeout(timeout);
			});
		}
		
		function delLanguage() {
			$(".detailInfo.languageAside").bind("mousedown", function() {
				var languageId = $(this).attr("languageId");
				var resumeId = $("#resumeId").val();
			    timeout = setTimeout(function() {
			        alert("是否删除此语言能力",1000*60*60*24,function(){
			        	$.ajax({
			        		url	: PATH + "/resumeLanguage/delLanguage.do",
			        		type: "post",
			        		dataType:"text",
			        		data: {"languageId":languageId,"resumeId":resumeId},
			        		success:function(data){
			        			if( data == "success") {
			        				$("#language_"+languageId).remove();
			        			}
			        		}
			        	});
			        },function(){});
			    }, 400);
			});
			$(".detailInfo.eduAside").bind("mouseup", function() {
			    clearTimeout(timeout);
			});
		}
		
		function bindEvent() {
			delEdu();
			delWorkExp();
			delTrain();
			delLanguage();
			$("header div.back").click(function(){
				window.location.href = PATH + "/resume/toResumeList.do?employId="+$("#employId").val();
			});
			$("#personInfo").click(function(){
				var resumeId = $("#resumeId").val();
				window.location.href = PATH + "/resume/toEditPersonInfo.do?resumeId="+resumeId;
			});
			$(".detailInfo.personInfoAside").click(function(){
				var resumeId = $("#resumeId").val();
				window.location.href = PATH + "/resume/toEditPersonInfo.do?resumeId="+resumeId;
			});
			$("#eduExper").click(function(){
				var resumeId = $("#resumeId").val();
				window.location.href = PATH + "/resume/toAddEduExper.do?resumeId="+resumeId;
			});
			$(".detailInfo.eduAside").click(function(){
				var resumeId = $("#resumeId").val();
				var eduId = $(this).attr("eduId");
				window.location.href = PATH + "/resume/toEditEduExper.do?resumeId="+resumeId+"&eduId="+eduId;
			});
			$("#workExp").click(function(){
				var resumeId = $("#resumeId").val();
				var mode = "add";
				window.location.href = PATH + "/resume/toAddWorkExp.do?resumeId="+resumeId;
			});
			$(".detailInfo.workExpAside").click(function(){
				var workExpId = $(this).attr("workExpId");
				var resumeId = $("#resumeId").val();
				window.location.href = PATH + "/resume/toEditWorkExp.do?resumeId="+resumeId+"&workExpId="+workExpId;
			});
			$("#searchForWork").click(function(){
				var resumeId = $("#resumeId").val();
				var mode = "add";
				window.location.href = PATH + "/resume/toEditSearchWork.do?resumeId="+resumeId+"&mode="+mode;
			});
			$(".detailInfo.applyJobAside").click(function(){
				var resumeId = $("#resumeId").val();
				var mode = "add";
				window.location.href = PATH + "/resume/toEditSearchWork.do?resumeId="+resumeId+"&mode="+mode;
			});
			$("#train").click(function(){
				var resumeId = $("#resumeId").val();
				window.location.href = PATH + "/resume/toAddTrain.do?resumeId="+resumeId;
			});
			$(".detailInfo.trainAside").click(function(){
				var resumeId = $("#resumeId").val();
				var trainId = $(this).attr("trainId");
				window.location.href = PATH + "/resume/toEditTrain.do?resumeId="+resumeId+"&trainId="+trainId;
			});
			$("#language").click(function(){
				var resumeId = $("#resumeId").val();
				window.location.href = PATH + "/resume/toAddLanguage.do?resumeId="+resumeId;
			});
			$(".detailInfo.languageAside").click(function(){
				var resumeId = $("#resumeId").val();
				var languageId = $(this).attr("languageId");
				window.location.href = PATH + "/resume/toEditLanguage.do?resumeId="+resumeId+"&languageId="+languageId;
			});
			$("#otherInfo").click(function(){
				var resumeId = $("#resumeId").val();
				var mode = "add";
				window.location.href = PATH + "/resume/toEditExtraInfo.do?resumeId="+resumeId+"&mode="+mode;
			});
		}
		
		window.onload = function() {
			setClientHeight("page_resumeType");
			var aside = $("aside");
			var ddAry = $("aside.detailInfo dd"),dd;
			var idx = 0;
			for(idx = 0 ; idx < ddAry.length ; idx++ ) {
				dd = ddAry[idx];
				$(dd).css("width",aside.width()-110+"px");
			}
		};
		window.onresize = function(){
			setClientHeight("page_resumeType");
			var aside = $("aside");
			var ddAry = $("aside.detailInfo dd"),dd;
			var idx = 0;
			for(idx = 0 ; idx < ddAry.length ; idx++ ) {
				dd = ddAry[idx];
				$(dd).css("width",aside.width()-110+"px");
			}
		};
	</script>
</body>
</html>