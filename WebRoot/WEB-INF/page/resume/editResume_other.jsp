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
			其他信息编辑
		</header>
		<section class="${mode}">
			<form action="${path}/resumeOtherInfo/saveOtherInfo.do" method="post">
				<input type="hidden" value="${oldInputNum}" id="oldInputNum" name="oldInputNum" />
				<input id="id" name="id" value="${id}" type="hidden" />
				<input id="resumeId" name="resumeId" value="${resumeId}" type="hidden" />
				<div class="inputContainer" style="width:100%;float:left;">
					<input id="subject" name="subject" placeholder="主题" value="${otherInfo.subject}" />
					<div class="editShow">主题</div>
				</div>
				<div class="textAreaContainer">
					<textarea placeholder="内容" name="desc" id="desc" maxlength="500">${otherInfo.desc}</textarea>
					<div class="numberTip"><span class="wordNumber">500</span>字</div>
					<div class="editShow">内容</div>
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
		
		function init() {
			setClientHeight("editResume");
			alertDateWindow("workDate");
			bindEvent();
			
			var desc = $("textarea").html();
			$(".wordNumber").html(500-desc.length);
		}
		
		function bindEvent() {
			formBind();
			submitEvent();
			descInput();
		}
		
		function descInput() {
			$("textarea").bind("input propertychange",function(){
				var valLength = $(this).val().length;
				var showLengthText = (500-parseInt(valLength));
				$(".wordNumber").html(showLengthText);
			});
		}
		
		function submitEvent() {
			$("footer").click(function(){
				if( $("#subject").val() == "" ) {
					alert("请输入主题",1000);return;
				} else if( $("#content").val() == "" ) {
					alert("请输入内容",1000);return;
				} 
				$("form").submit();
			});
		}
		
		function formBind() {
			$('form').bind('submit', function(){
		        ajaxSubmit(this, function(data){
		            alert("该信息已成功保存",1000*60*60,function(){
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