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
			IT技能编辑
		</header>
		<section class="${mode}">
			<form action="${path}/resumeIT/saveIT.do" method="post">
				<input type="hidden" value="${oldInputNum}" id="oldInputNum" name="oldInputNum" />
				<input id="id" name="id" value="${id}" type="hidden" />
				<input id="resumeId" name="resumeId" value="${resumeId}" type="hidden" />
				<div class="inputContainer" style="width:100%;float:left;">
					<input id="viewBigSkill" readonly="readonly" placeholder="技能大类" value="${IT.bigSkill}"/>
					<input type="hidden" id="bigSkill" name="bigSkill" value="${IT.bigSkill}"/>
					<div class="editShow">技能大类</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input id="viewSkill" readonly="readonly" placeholder="技能小类" value="${IT.skill}"/>
					<input type="hidden" id="skill" name="skill" value="${IT.skill}"/>
					<div class="editShow">技能小类</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input id="useDate" name="useDate" type="text" placeholder="使用时间(月)" value="${IT.useDate}"/>
					<div class="editShow">使用时间(月)</div>
				</div>
				<div class="inputContainer">
					<input id="viewLevel" readonly="readonly" placeholder="掌握程度" value="${IT.level}"/>
					<input type="hidden" id="level" name="level" value="${IT.level}"/>
					<div class="editShow">掌握程度</div>
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
		}
		
		function bindEvent() {
			skillTypeSelect();
			skillSelect();
			levelSelect();
			formBind();
			submitEvent();
		}
		
		function submitEvent() {
			$("footer").click(function(){
				if( $("#bigSkill").val() == "" ) {
					alert("请选择技能大类",1000);return;
				} else if( $("#skill").val() == "" ) {
					alert("请输入技能小类",1000);return;
				} else if( $("#useDate").val() == "" ) {
					alert("请输入使用时间",1000);return;
				} else if( $("#level").val() == "" ) {
					alert("请选择掌握程度",1000);return;
				} 
				$("form").submit();
			});
		}
		
		function formBind() {
			$('form').bind('submit', function(){
		        ajaxSubmit(this, function(data){
		            alert("IT技能已成功保存",1000*60*60,function(){
		            	var resumeId = $("#resumeId").val();
		            	window.location.href = PATH + "/resume/toEditExtraInfo.do?resumeId="+resumeId;
		            });
		        });
		        return false;
		    });
		}
		
		function levelSelect() {
			$("#viewLevel").click(function(){
				var ary = ["了解","一般","熟练","精通"];
				var obj = createMaskBtnByAry(ary);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewLevel");
				$("#hiddenInput").val("level");
				$("#mask_editResume").css("display","block");
			});	
		}
		
		function skillTypeSelect() {
			$("#viewBigSkill").click(function(){
				var obj = createMaskBtnByAry(skillTypeAry);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewBigSkill");
				$("#hiddenInput").val("bigSkill");
				$("#subActiveInput").val("viewSkill");
				$("#subHiddenInput").val("skill");
				$("#mask_editResume").css("display","block");
			});	
		}
		
		function skillSelect() {
			$("#viewSkill").click(function(){
				var skillType = $("#bigSkill").val();
				var idx , index = "", ary;
				if( skillType == "" ) {
					ary = [];
				} 
				else {
					for( idx = 0 ; idx < skillTypeAry.length ; idx++ ) {
						if( skillType == skillTypeAry[idx] ) {
							index = idx;break;
						}
					}
					ary = skillItemAry[index];
				};
				var obj = createMaskBtnByAry(ary);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewSkill");
				$("#hiddenInput").val("skill");
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