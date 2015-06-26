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
	<div id="mask_editResume" style="display:none;">
		<div class="maskBtnArea"></div>
	</div>
	<div id="editResume">
		<input type="hidden" id="type" value="product" name="type" />
		<input type="text" id="path" style="display:none;" value="${path}" />
		<input type="text" id="loadingMore" style="display:none;" value="true" />
		<header>
			项目经验编辑
		</header>
		<section class="${mode}">
			<form action="${path}/resumeProjectExp/saveProjectExp.do" method="post">
				<input id="oldInputNum" name="oldInputNum" value="${oldInputNum}" type="hidden" />
				<input id="id" name="id" value="${id}" type="hidden" />
				<input id="resumeId" name="resumeId" value="${resumeId}" type="hidden" />
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="开始时间" id="startDate" name="startDate" readonly="readonly"/>
					<input id="hiddenStartDate" value="${projectExp.startDate}" type="hidden"/>
					<div class="editShow">开始时间</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="结束时间(至今)" id="endDate" name="endDate" readonly="readonly"/>
					<input id="hiddenEndDate" value="${projectExp.endDate}" type="hidden"/>
					<div class="editShow">结束时间(至今)</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="项目名称" name="projectName" id="projectName" value="${projectExp.projectName}"/>
					<div class="editShow">项目名称</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="开发工具" name="devTool" id="devTool" value="${projectExp.devTool}"/>
					<div class="editShow">开发工具</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="硬件环境" name="hardwareEnvir" id="hardwareEnvir" value="${projectExp.hardwareEnvir}"/>
					<div class="editShow">硬件环境</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="软件环境" name="softwareEnvir" id="softwareEnvir" value="${projectExp.softwareEnvir}"/>
					<div class="editShow">软件环境</div>
				</div>
				<div class="inputContainer">
					<textarea placeholder="项目描述" name="projectDesc" id="projectDesc" maxlength="500">${projectExp.projectDesc}</textarea>
					<div class="numberTip"><span class="projectDesc_wordNumber">500</span>字</div>
					<div class="editShow">项目描述</div>
				</div>
				<div class="textAreaContainer">
					<textarea placeholder="责任描述" name="jobDesc" id="jobDesc" maxlength="500">${projectExp.jobDesc}</textarea>
					<div class="numberTip"><span class="jobDesc_wordNumber">500</span>字</div>
					<div class="editShow">责任描述</div>
				</div>
			</form>
		</section>
		<footer>
			<div class="submitBtn">
				<span class="icons icons_submit"></span>
				保&nbsp;存
			</div>
		</footer>
	</div> 
	<script>
		$(function(){
			PATH = $("#path").val();
			init();
			setClientHeight("mask_editResume");
		});
		
		function descInput() {
			$("textarea").bind("input propertychange",function(){
				var valLength = $(this).val().length;
				var id = $(this).attr("id");
				var showLengthText = (500-parseInt(valLength));
				$("."+id+"_wordNumber").html(showLengthText);
			});
		}
		
		function init() {
			setClientHeight("editResume");
			alertDateWindow("startDate");
			alertDateWindow("endDate");
			bindEvent();
			
			var hiddenStartDate = $("#hiddenStartDate");
			if( hiddenStartDate.val() != "" ) {
				$("#startDate").val(hiddenStartDate.val());
			}
			var hiddenEndDate = $("#hiddenEndDate");
			if( hiddenEndDate.val() != "" ) {
				$("#endDate").val(hiddenEndDate.val());
			}
			var projectDesc = $("#projectDesc").html();
			var jobDesc = $("#jobDesc").html();
			$(".projectDesc_wordNumber").html(500-projectDesc.length);
			$(".jobDesc_wordNumber").html(500-jobDesc.length);
		}
		
		function bindEvent() {
			formBind();
			submitEvent();
			descInput();
		}
		
		function submitEvent() {
			$("footer").click(function(){
				if( $("#startDate").val() == "" ) {
					alert("请选择开始时间",1000);return;
				} else if( $("#projectName").val() == "" ) {
					alert("请输入项目名称",1000);return;
				} 
				$("form").submit();
			});
		}
		
		function formBind() {
			$('form').bind('submit', function(){
		        ajaxSubmit(this, function(data){
		            alert("项目经验已成功保存",1000*60*60,function(){
		            	var resumeId = $("#resumeId").val();
		            	window.location.href = PATH + "/resume/toEditExtraInfo.do?resumeId="+resumeId;
		            });
		        });
		        return false;
		    });
		}
		
		function alertDateWindow(id) {
			var currYear = (new Date()).getFullYear();	
			var opt={};
			opt.date = {preset : 'date'};
			//opt.datetime = { preset : 'datetime', minDate: new Date(2012,3,10,9,22), maxDate: new Date(2014,7,30,15,44), stepMinute: 5  };
			opt.datetime = {preset : 'datetime'};
			opt.time = {preset : 'time'};
			opt.default = {
				theme: 'android-ics light', //皮肤样式
		        display: 'modal', //显示方式 
		        mode: 'scroller', //日期选择模式
				lang:'zh',
		        startYear:currYear - 100, //开始年份
		        endYear:currYear + 100 //结束年份
			};
			$("#"+id).val('').scroller('destroy').scroller($.extend(opt['date'], opt['default']));
		}
	</script>
</body>
</html>