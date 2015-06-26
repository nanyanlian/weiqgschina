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
			教育经历编辑
		</header>
		<section class="${mode}">
			<form action="${path}/resumeEdu/saveEdu.do" method="post">
				<input type="hidden" value="${oldInputNum}" id="oldInputNum" name="oldInputNum" />
				<input type="hidden" value="${resumeId}" id="resumeId" name="resumeId" />
				<input type="hidden" value="${eduId}" id="id" name="id" />
				<input type="hidden" value="${mode}" id="mode" name="mode" />
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="开始时间" value="${edu.startDate}" id="startDate" name="startDate" readonly="readonly"/>
					<input id="hiddenStartDate" value="${edu.startDate}" type="hidden" />
					<div class="editShow">开始时间</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="结束时间(至今)" value="${edu.endDate}" id="endDate" name="endDate" readonly="readonly"/>
					<input id="hiddenEndDate" value="${edu.endDate}" type="hidden" />
					<div class="editShow">结束时间(至今)</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="学校" value="${edu.school}" name="school" id="school" />
					<div class="editShow">学校</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="学院" value="${edu.college}" id="viewCollege" readonly="readonly" />
					<input type="hidden" id="college" name="college" value="${edu.college}"/>
					<div class="editShow">学院</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="专业" id="viewSubject" readonly="readonly" value="${edu.subject}"/>
					<input type="hidden" id="subject" name="subject" value="${edu.subject}"/>
					<div class="editShow">专业</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="学历" id="viewLevel" readonly="readonly" value="${edu.level}"/>
					<input type="hidden" id="level" name="level" value="${edu.level}"/>
					<div class="editShow">学历</div>
				</div>
				<div class="textareaContainer">
					<textarea placeholder="专业描述" name="desc" id="desc" maxlength="500">${edu.desc}</textarea>
					<div class="numberTip"><span class="wordNumber">500</span>字</div>
					<div class="editShow">专业描述</div>
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
			bindEvent();
		});
		
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
		
		function bindEvent() {
			collegeSelect();
			subjectSelect();
			levelSelect();
			submitEvent();
			formBind();
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
				if( $("#startDate").val() == "" ) {
					alert("请输入开始时间",1000);return;
				} else if( $("#school").val() == "" ) {
					alert("请输入学校",1000);return;
				} else if( $("#college").val() == "" ) {
					alert("请选择学院",1000);return;
				} else if( $("#subject").val() == "" ) {
					alert("请选择专业",1000);return;
				} else if( $("#level").val() == "" ) {
					alert("请选择学历",1000);return;
				} 
				$("form").submit();
			});
		}
		
		function levelSelect() {
			$("#viewLevel").click(function(){
				var ary = ["初中","高中","中技","中专","大专","本科","MBA","硕士","博士","其它"];
				var obj = createMaskBtnByAry(ary);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewLevel");
				$("#hiddenInput").val("level");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function collegeSelect() {
			$("#viewCollege").click(function(){
				var obj = createMaskBtnByAry(collegeAry);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewCollege");
				$("#hiddenInput").val("college");
				$("#subHiddenInput").val("subject");
				$("#subActiveInput").val("viewSubject");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function subjectSelect() {
			$("#viewSubject").click(function(){
				var currCollege = $("#college").val();
				var obj = "" , index = "" , idx = "";
				if( currCollege == "")
					obj = createMaskBtnByAry([]);
				else {
					for(idx = 0 ; idx < provinceAry.length ; idx++ ) {
						if( collegeAry[idx] == currCollege ) {
							index = idx;break;
						}
					}
					obj = createMaskBtnByAry(subjectAry[index]);
				}
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewSubject");
				$("#hiddenInput").val("subject");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function init() {
			setClientHeight("editResume");
			alertDateWindow("startDate");
			alertDateWindow("endDate");
			
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