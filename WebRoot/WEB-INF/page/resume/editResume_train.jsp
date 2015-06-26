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
	<style>
		
	</style>
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
			培训经历编辑
		</header>
		<section class="${mode}">
			<form action="${path}/resumeTrain/saveTrain.do" method="post">
				<input type="hidden" id="oldInputNum" name="oldInputNum" value="${oldInputNum}" />
				<input id="id" name="id" value="${id}" type="hidden" />
				<input id="resumeId" name="resumeId" value="${resumeId}" type="hidden" />
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="开始时间" id="startDate" name="startDate" readonly="readonly" value="${train.startDate}"/>
					<input id="hiddenStartDate" value="${train.startDate}" type="hidden"/>
					<div class="editShow">开始时间</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="结束时间(至今)" id="endDate" name="endDate" readonly="readonly" value="${train.endDate}"/>
					<input id="hiddenEndDate" value="${train.endDate}" type="hidden"/>
					<div class="editShow">结束时间(至今)</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="培训机构" name="school" id="school" value="${train.school}"/>
					<div class="editShow">培训机构</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="培训地点" name="schoolPosition" id="schoolPosition" value="${train.schoolPosition}"/>
					<div class="editShow">培训地点</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="培训课程" name="course" id="course" value="${train.course}"/>
					<div class="editShow">培训课程</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="获得证书" name="certificate" id="certificate" value="${train.certificate}"/>
					<div class="editShow">获得证书</div>
				</div>
				<div class="textareaContainer">
					<textarea placeholder="详细描述" name="trainDesc" id="trainDesc" maxlength="500">${train.trainDesc}</textarea>
					<div class="numberTip"><span class="wordNumber">500</span>字</div>
					<div class="editShow">详细描述</div>
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
		
		function bindEvent() {
			formBind();
			descInput();
			submitEvent();
		}
		
		function submitEvent() {
			$("footer").click(function(){
				if( $("#startDate").val() == "" ) {
					alert("请输入开始时间",1000);return;
				} else if( $("#school").val() == "" ) {
					alert("请输入培训机构",1000);return;
				} else if( $("#schoolPosition").val() == "" ) {
					alert("请输入培训地点",1000);return;
				} else if( $("#course").val() == "" ) {
					alert("请输入培训课程",1000);return;
				} 
				$("form").submit();
			});
		}
		
		function descInput() {
			$("textarea").bind("input propertychange",function(){
				var valLength = $(this).val().length;
				var showLengthText = (500-parseInt(valLength));
				$(".wordNumber").html(showLengthText);
			});
		}
		
		function formBind() {
			$('form').bind('submit', function(){
		        ajaxSubmit(this, function(data){
		            alert("培训经历已成功保存",1000*60*60,function(){
		            	var resumeId = $("#resumeId").val();
		            	window.location.href = PATH + "/resume/editResume.do?resumeId="+resumeId;
		            });
		        });
		        return false;
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
			var desc = $("textarea").html();
			$(".wordNumber").html(500-desc.length);
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