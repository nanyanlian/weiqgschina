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
		<input type="hidden" id="path" value="${path}" />
		<input type="hidden" id="page"  value="${page}" />
		<input type="text" id="rows" style="display:none;" value="${rows}"/>
		<input type="text" id="loadMode"  style="display:none;" value="${loadMode}"/>
		<input type="text" id="loadingMore" style="display:none;" value="true" />
		<input type="hidden" id="resumeId" name="resumeId" value="${resumeId}"/>
		<header><div class="back">返回</div>添加附加信息</header>
		<section>
			<article id="IT">
				<div class="img">
					<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/screen.png" />
				</div>
				<div class="title">IT技能</div>
			</article>
			<c:forEach items="${resume.iTList}" var="IT">
				<aside class="detailInfo ITAside" ITId="${IT.id}" id="IT_${IT.id}">
					<dl><dt>技能:</dt><dd>${IT.bigSkill}&nbsp;-&nbsp;${IT.skill}</dd></dl>
					<dl><dt>使用时间:</dt><dd>${IT.useDate}个月</dd></dl>
					<dl><dt>掌握程度:</dt><dd>${IT.level}</dd></dl>
				</aside>
			</c:forEach>
			<article id="projectExp">
				<div class="img">
					<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/setting.png" />
				</div>
				<div class="title">项目经验</div>
			</article>
			<c:forEach items="${resume.projectExpList}" var="projectExp">
				<aside class="detailInfo projectExpAside" projectExpId="${projectExp.id}" id="projectExp_${projectExp.id}">
					<dl><dt>开始时间:</dt><dd>${projectExp.startDate}</dd></dl>
					<dl><dt>结束时间:</dt><dd>${projectExp.endDate}</dd></dl>
					<dl><dt>项目名称:</dt><dd>${projectExp.projectName}</dd></dl>
					<dl><dt>开发工具:</dt><dd>${projectExp.devTool}</dd></dl>
					<dl><dt>硬件环境:</dt><dd>${projectExp.hardwareEnvir}</dd></dl>
					<dl><dt>软件环境:</dt><dd>${projectExp.softwareEnvir}</dd></dl>
					<dl><dt>项目描述:</dt><dd>${projectExp.projectDesc}</dd></dl>
					<dl><dt>职责描述:</dt><dd>${projectExp.jobDesc}</dd></dl>
				</aside>
			</c:forEach>
			<article id="certificate">
				<div class="img">
					<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/listview.png" />
				</div>
				<div class="title">证书</div>
			</article>
			<c:forEach items="${resume.certificateList}" var="certificate">
				<aside class="detailInfo certificateAside" certificateId="${certificate.id}" id="certificate_${certificate.id}">
					<dl><dt>证书名称:</dt><dd>${certificate.certificateName}</dd></dl>
					<dl><dt>获得时间:</dt><dd>${certificate.gainDate}</dd></dl>
					<dl><dt>成绩:</dt><dd>${certificate.score}</dd></dl>
				</aside>
			</c:forEach>
			<article id="otherInfo">
				<div class="img">
					<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/pen.png" />
				</div>
				<div class="title">其他</div>
			</article>
			<c:forEach items="${resume.otherInfoList}" var="otherInfo">
				<aside class="detailInfo otherInfoAside" otherInfoId="${otherInfo.id}" id="otherInfo_${otherInfo.id}">
					<dl><dt>主题:</dt><dd>${otherInfo.subject}</dd></dl>
					<dl><dt>内容:</dt><dd>${otherInfo.desc}</dd></dl>
				</aside>
			</c:forEach>
		</section>
	</div> 
	<script>
		$(function(){
			PATH = $("#path").val();
			bindEvent();
		});
		
		function delIT() {
			$(".detailInfo.ITAside").bind("mousedown", function() {
				var ITId = $(this).attr("ITId");
				var resumeId = $("#resumeId").val();
			    timeout = setTimeout(function() {
			        alert("是否删除此IT技能",1000*60*60*24,function(){
			        	$.ajax({
			        		url	: PATH + "/resumeIT/deleteIT.do",
			        		type: "post",
			        		dataType:"text",
			        		data: {"ITId":ITId,"resumeId":resumeId},
			        		success:function(data){
			        			if( data == "success") {
			        				$("#IT_"+ITId).remove();
			        			}
			        		}
			        	});
			        },function(){});
			    }, 400);
			});
			$(".detailInfo.ITAside").bind("mouseup", function() {
			    clearTimeout(timeout);
			});
		}
		
		function delProjectExp() {
			$(".detailInfo.projectExpAside").bind("mousedown", function() {
				var projectExpId = $(this).attr("projectExpId");
				var resumeId = $("#resumeId").val();
			    timeout = setTimeout(function() {
			        alert("是否删除此项目经历",1000*60*60*24,function(){
			        	$.ajax({
			        		url	: PATH + "/resumeProjectExp/deleteProjectExp.do",
			        		type: "post",
			        		dataType:"text",
			        		data: {"projectExpId":projectExpId,"resumeId":resumeId},
			        		success:function(data){
			        			if( data == "success") {
			        				$("#projectExp_"+projectExpId).remove();
			        			}
			        		}
			        	});
			        },function(){});
			    }, 400);
			});
			$(".detailInfo.projectExpAside").bind("mouseup", function() {
			    clearTimeout(timeout);
			});
		}
		
		function delCertificate() {
			$(".detailInfo.certificateAside").bind("mousedown", function() {
				var certificateId = $(this).attr("certificateId");
				var resumeId = $("#resumeId").val();
			    timeout = setTimeout(function() {
			        alert("是否删除此证书信息",1000*60*60*24,function(){
			        	$.ajax({
			        		url	: PATH + "/resumeCertificate/deleteCertificate.do",
			        		type: "post",
			        		dataType:"text",
			        		data: {"certificateId":certificateId,"resumeId":resumeId},
			        		success:function(data){
			        			if( data == "success") {
			        				$("#certificate_"+certificateId).remove();
			        			}
			        		}
			        	});
			        },function(){});
			    }, 400);
			});
			$(".detailInfo.certificateAside").bind("mouseup", function() {
			    clearTimeout(timeout);
			});
		}
		
		function delOtherInfo() {
			$(".detailInfo.otherInfoAside").bind("mousedown", function() {
				var otherInfoId = $(this).attr("otherInfoId");
				var resumeId = $("#resumeId").val();
			    timeout = setTimeout(function() {
			        alert("是否删除该信息",1000*60*60*24,function(){
			        	$.ajax({
			        		url	: PATH + "/resumeOtherInfo/deleteOtherInfo.do",
			        		type: "post",
			        		dataType:"text",
			        		data: {"otherInfoId":otherInfoId,"resumeId":resumeId},
			        		success:function(data){
			        			if( data == "success") {
			        				$("#otherInfo_"+otherInfoId).remove();
			        			}
			        		}
			        	});
			        },function(){});
			    }, 400);
			});
			$(".detailInfo.otherInfoAside").bind("mouseup", function() {
			    clearTimeout(timeout);
			});
		}
		
		function bindEvent() {
			delIT();
			delProjectExp();
			delCertificate();
			delOtherInfo();
			$("header div.back").click(function(){
				window.location.href = PATH + "/resume/editResume.do?resumeId="+$("#resumeId").val();
			});
			$("#IT").click(function(){
				var resumeId = $("#resumeId").val();
				window.location.href = PATH + "/resume/toAddIT.do?resumeId="+resumeId;
			});
			$(".detailInfo.ITAside").click(function(){
				var resumeId = $("#resumeId").val();
				var ITId = $(this).attr("ITId");
				window.location.href = PATH + "/resume/toEditIT.do?resumeId="+resumeId+"&ITId="+ITId;
			});
			$("#projectExp").click(function(){
				var resumeId = $("#resumeId").val();
				window.location.href = PATH + "/resume/toAddProjectExp.do?resumeId="+resumeId;
			});
			$(".detailInfo.projectExpAside").click(function(){
				var resumeId = $("#resumeId").val();
				var projectExpId = $(this).attr("projectExpId");
				window.location.href = PATH + "/resume/toEditProjectExp.do?resumeId="+resumeId+"&projectExpId="+projectExpId;
			});
			$("#certificate").click(function(){
				var resumeId = $("#resumeId").val();
				window.location.href = PATH + "/resume/toAddCertificate.do?resumeId="+resumeId;
			});
			$(".detailInfo.certificateAside").click(function(){
				var resumeId = $("#resumeId").val();
				var certificateId = $(this).attr("certificateId");
				window.location.href = PATH + "/resume/toEditCertificate.do?resumeId="+resumeId+"&certificateId="+certificateId;
			});
			$("#otherInfo").click(function(){
				var resumeId = $("#resumeId").val();
				window.location.href = PATH + "/resume/toAddOtherInfo.do?resumeId="+resumeId;
			});
			$(".detailInfo.otherInfoAside").click(function(){
				var resumeId = $("#resumeId").val();
				var otherInfoId = $(this).attr("otherInfoId");
				window.location.href = PATH + "/resume/toEditOtherInfo.do?resumeId="+resumeId+"&otherInfoId="+otherInfoId;
			});
		}
		
		window.onload = function() {
			var dlWidth = $("dl").width();
			$("dd").css("width",dlWidth-120+"px");
			setClientHeight("page_resumeType");			
		};
		window.onresize = function(){
			var dlWidth = $("dl").width();
			$("dd").css("width",dlWidth-120+"px");
			setClientHeight("page_resumeType");	
		};
	</script>
</body>
</html>