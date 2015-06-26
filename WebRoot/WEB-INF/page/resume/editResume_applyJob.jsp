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
		<input type="hidden" id="activeInput" name="activeInput" value="" />
		<input type="hidden" id="hiddenInput" name="hiddenInput" value="" />
		<input type="hidden" id="subActiveInput" name="activeInput" value="" />
		<input type="hidden" id="subHiddenInput" name="hiddenInput" value="" />
		<header>
			求职意向编辑
		</header>
		<section class="${mode}">
			<form action="${path}/resumeApplyJob/saveApplyJob.do" method="post">
				<input id="oldInputNum" name="oldInputNum" value="${oldInputNum}" type="hidden" />
				<input id="resumeId" name="resumeId" value="${resumeId}" type="hidden" />
				<input id="id" name="id" value="${id}" type="hidden" />
				<div class="inputContainer" style="width:50%;float:left;">
					<input id="viewWorkType" readonly="readonly" placeholder="工作类型" value="${applyJob.workType}"/>
					<input type="hidden" id="workType" name="workType" value="${applyJob.workType}" />
					<div class="editShow">工作类型</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input id="viewSalary" readonly="readonly" placeholder="期望薪水" value="${applyJob.salary}" />
					<input type="hidden" id="salary" name="salary" value="${applyJob.salary}"/>
					<div class="editShow">期望薪水</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input id="viewWorkDate" readonly="readonly" placeholder="到岗时间" value="${applyJob.workDate}" />
					<input type="hidden" id="workDate" name="workDate" value="${applyJob.workDate}" />
					<div class="editShow">到岗时间</div>
				</div>
				<div class="textareaContainer">
					<textarea placeholder="自我评价" name="selfDesc" id="selfDesc" maxlength="500">${applyJob.selfDesc}</textarea>
					<div class="numberTip"><span class="wordNumber">500</span>字</div>
					<div class="editShow">自我评价</div>
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
			bindEvent();
			var desc = $("textarea").html();
			$(".wordNumber").html(500-desc.length);
		}
		
		function bindEvent() {
			workTypeSelect();
			salarySelect();
			workDateSelect();
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
				if( $("#workType").val() == "" ) {
					alert("请选择工作类型",1000);return;
				} else if( $("#salary").val() == "" ) {
					alert("请选择期望薪水",1000);return;
				} else if( $("#workDate").val() == "" ) {
					alert("请选择到岗时间",1000);return;
				} 
				$("form").submit();
			});
		}
		
		function formBind() {
			$('form').bind('submit', function(){
		        ajaxSubmit(this, function(data){
		            alert("求职意向已成功保存",1000*60*60,function(){
		            	var resumeId = $("#resumeId").val();
		            	window.location.href = PATH + "/resume/editResume.do?resumeId="+resumeId;
		            });
		        });
		        return false;
		    });
		}
		
		function workDateSelect() {
			$("#viewWorkDate").click(function(){
				ary = ["即时","一周以内","一月以内","1-3个月","3个月以后","待定"];
				var obj = createMaskBtnByAry(ary);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewWorkDate");
				$("#hiddenInput").val("workDate");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function salarySelect() {
			$("#viewSalary").click(function(){
				ary = ["面议","1500以下","1500-1999","2000-2999","3000-4499","4500-5999",
				       "6000-7999","8000-9999","10000-14999","15000-19999","20000-29999",
				       "30000-49999","50000以上"];
				var obj = createMaskBtnByAry(ary);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewSalary");
				$("#hiddenInput").val("salary");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function workTypeSelect() {
			$("#viewWorkType").click(function(){
				ary = ["全职","兼职","实习","全兼职"];
				var obj = createMaskBtnByAry(ary);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewWorkType");
				$("#hiddenInput").val("workType");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function maskCancelEvent() {
			$("#cancel").click(function(){
				$(".maskBtnArea").empty();
				$("#mask_editResume").css("display","none");
			});
		}
		
		function maskBtnEvent() {
			$(".itemList.maskBtn").click(function(){
				var hiddenInput = $("#hiddenInput").val();
				var activeInput = $("#activeInput").val();
				var subHiddenInput = $("#subHiddenInput").val();
				var subActiveInput = $("#subActiveInput").val();
				$("#subHiddenInput").val("");
				$("#subActiveInput").val("");
				var text = $(this).html();
				var oldVal = $("#"+hiddenInput).val();
				if( oldVal != text ) {
					$("#"+hiddenInput).val(text);
					$("#"+activeInput).val(text);
					if( subHiddenInput != "" ) {
						$("#"+subHiddenInput).val("");
						$("#"+subActiveInput).val("");
					}
				}
				$(".maskBtnArea").empty();
				$("#mask_editResume").css("display","none");
			});
		}
		
		function createMaskBtnByAry(ary) {
			var idx = 0;
			var obj = "";
			for(idx = 0 ; idx < ary.length ; idx++) {
				obj = obj + "<div class='itemList maskBtn'>"+ary[idx]+"</div>";
			}
			obj = obj + "<div class='splitLine'></div>";
			obj = obj + "<div class='cancelBtn maskBtn' id='cancel'>取消</div>";
			return obj;
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