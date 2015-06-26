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
			证书信息编辑
		</header>
		<section class="${mode}">
			<form action="${path}/resumeCertificate/saveCertificate.do" method="post">
				<input id="oldInputNum" name="oldInputNum" value="${oldInputNum}" type="hidden" />
				<input id="id" name="id" value="${id}" type="hidden" />
				<input id="resumeId" name="resumeId" value="${resumeId}" type="hidden" />
				<div class="inputContainer">
					<input placeholder="证书名称" name="certificateName" id="certificateName" value="${certificate.certificateName}" />
					<div class="editShow">证书名称</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="获得时间" id="gainDate" name="gainDate" readonly="readonly" value="${certificate.gainDate}" />
					<input id="hiddenGainDate" name="hiddenGainDate" value="${certificate.gainDate}" type="hidden" />
					<div class="editShow">获得时间</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="成绩" id="score" name="score" value="${certificate.score}" />
					<div class="editShow">成绩</div>
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
			alertDateWindow("gainDate");
			bindEvent();
			
			var hiddenGainDate = $("#hiddenGainDate");
			if( hiddenGainDate.val() != "" ) { $("#gainDate").val(hiddenGainDate.val());}
		}
		
		function bindEvent() {
			formBind();
			submitEvent();
		}
		
		function submitEvent() {
			$("footer").click(function(){
				if( $("#certificateName").val() == "" ) {
					alert("请输入证书名称",1000);return;
				} else if( $("#gainDate").val() == "" ) {
					alert("请输入获得时间",1000);return;
				} 
				$("form").submit();
			});
		}
		
		function formBind() {
			$('form').bind('submit', function(){
		        ajaxSubmit(this, function(data){
		            alert("证书信息已成功保存",1000*60*60,function(){
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