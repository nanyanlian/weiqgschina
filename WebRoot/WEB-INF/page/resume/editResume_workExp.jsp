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
		<input type="hidden" id="activeInput" name="activeInput" value="" />
		<input type="hidden" id="hiddenInput" name="hiddenInput" value="" />
		<input type="hidden" id="subActiveInput" name="activeInput" value="" />
		<input type="hidden" id="subHiddenInput" name="hiddenInput" value="" />
		<header>
			工作经验编辑
		</header>
		<section class="${mode}">
			<form action="${path}/resumeWorkExp/saveWorkExp.do" method="post">
				<input id="oldInputNum" name="oldInputNum" value="${oldInputNum}" type="hidden" />
				<input id="resumeId" name="resumeId" value="${resumeId}" type="hidden"/>
				<input id="id" name="id" value="${id}" type="hidden" />
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="开始时间" id="startDate" name="startDate" readonly="readonly"/>
					<input id="hiddenStartDate" value="${workExp.startDate}" type="hidden"/>
					<div class="editShow">开始时间</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="结束时间(至今)" id="endDate" name="endDate" readonly="readonly"/>
					<input id="hiddenEndDate" value="${workExp.endDate}" type="hidden"/>
					<div class="editShow">结束时间(至今)</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="公司" name="company" id="company" value="${workExp.company}"/>
					<div class="editShow">公司</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="行业" id="viewTrade" readonly="readonly" value="${workExp.trade}" />
					<input type="hidden" id="trade" name="trade" value="${workExp.trade}"/>
					<div class="editShow">行业</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="公司规模" id="viewScale" readonly="readonly" value="${workExp.scale}"/>
					<input type="hidden" id="scale" name="scale" value="${workExp.scale}"/>
					<div class="editShow">公司规模</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="公司性质" id="viewProperty" readonly="readonly" value="${workExp.property}"/>
					<input type="hidden" id="property" name="property" value="${workExp.property}"/>
					<div class="editShow">公司性质</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="部门" id="department" name="department" value="${workExp.department}"/>
					<div class="editShow">部门</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="职位大类" id="viewJobType" readonly="readonly" value="${workExp.jobType}"/>
					<input type="hidden" id="jobType" name="jobType" value="${workExp.jobType}"/>
					<div class="editShow">职位大类</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="职位小类" id="viewJob" readonly="readonly" value="${workExp.job}"/>
					<input type="hidden" id="job" name="job" value="${workExp.job}"/>
					<div class="editShow">职位小类</div>
				</div>
				<div class="textareaContainer">
					<textarea placeholder="工作描述" name="jobDesc" id="jobDesc" maxlength="500">${workExp.jobDesc}</textarea>
					<div class="numberTip"><span class="wordNumber">500</span>字</div>
					<div class="editShow">工作描述</div>
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
			tradeSelect();
			scaleSelect();
			propertySelect();
			jobTypeSelect();
			jobSelect();
			formBind();
			submitEvent();
			descInput();
		}
		
		function submitEvent() {
			$("footer").click(function(){
				if( $("#startDate").val() == "" ) {
					alert("请输入开始时间",1000);return;
				} else if( $("#company").val() == "" ) {
					alert("请输入公司名",1000);return;
				} else if( $("#trade").val() == "" ) {
					alert("请选择行业",1000);return;
				} else if( $("#scale").val() == "" ) {
					alert("请选择公司规模",1000);return;
				} else if( $("#property").val() == "" ) {
					alert("请选择公司性质",1000);return;
				} else if( $("#department").val() == "" ) {
					alert("请输入你所在的部门",1000);return;
				} else if( $("#jobType").val() == "" ) {
					alert("请选择职位大类",1000);return;
				} else if( $("#job").val() == "" ) {
					alert("请选择职位小类",1000);return;
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
		            alert("教育经历已成功保存",1000*60*60,function(){
		            	var resumeId = $("#resumeId").val();
		            	window.location.href = PATH + "/resume/editResume.do?resumeId="+resumeId;
		            });
		        });
		        return false;
		    });
		}
		
		function jobTypeSelect() {
			$("#viewJobType").click(function(){
				var obj = createMaskBtnByAry(jobTypeAry);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewJobType");
				$("#hiddenInput").val("jobType");
				$("#subActiveInput").val("viewJob");
				$("#subHiddenInput").val("job");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function jobSelect() {
			$("#viewJob").click(function(){
				var jobType = $("#jobType").val();
				var idx , index = "", ary;
				if( jobType == "" ) {
					ary = [];
				} 
				else {
					for( idx = 0 ; idx < jobTypeAry.length ; idx++ ) {
						if( jobType == jobTypeAry[idx] ) {
							index = idx;break;
						}
					}
					ary = jobItemAry[index];
				};
				var obj = createMaskBtnByAry(ary);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewJob");
				$("#hiddenInput").val("job");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function propertySelect() {
			$("#viewProperty").click(function(){
				var obj = createMaskBtnByAry(companyPropertyAry);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewProperty");
				$("#hiddenInput").val("property");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function tradeSelect() {
			$("#viewTrade").click(function(){
				var obj = createMaskBtnByAry(tradeAry);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewTrade");
				$("#hiddenInput").val("trade");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function scaleSelect() {
			$("#viewScale").click(function(){
				var obj = createMaskBtnByAry(companyScaleAry);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewScale");
				$("#hiddenInput").val("scale");
				$("#mask_editResume").css("display","block");
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