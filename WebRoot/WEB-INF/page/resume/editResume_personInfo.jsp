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
		<input type="hidden" id="activeInput" name="activeInput" value="" />
		<input type="hidden" id="hiddenInput" name="hiddenInput" value="" />
		<input type="hidden" id="subActiveInput" name="activeInput" value="" />
		<input type="hidden" id="subHiddenInput" name="hiddenInput" value="" />
		<input type="hidden" id="type" value="product" name="type" />
		<input type="text" id="path" style="display:none;" value="${path}" />
		<input type="text" id="loadingMore" style="display:none;" value="true" />
		<header>
			个人信息编辑
		</header>
		<section class="${mode}">
			<form action="${path}/resumePersonalInfo/savePersonalInfo.do" method="post">
				<input id="oldInputNum" name="oldInputNum" value="${oldInputNum}" type="hidden" />
				<input id="id" name="id" type="hidden" value="${personInfo.id }">
				<input id="resumeId" value="${resumeId}" type="hidden" name="resumeId" />
				<div class="inputContainer" style="width:70%;float:left;">
					<input placeholder="简历名称" id="resumeName" name="resumeName" value="${personInfo.resumeName}" />
					<div class="editShow">简历名称</div>
				</div>
				<div class="inputContainer" style="width:30%;float:left;">
					<input placeholder="公开程度" id="viewOpenEss" readonly="readonly" value="${personInfo.openess}"/>
					<input id="openess" type="hidden" name="openess" value="${personInfo.openess}" />
					<div class="editShow">公开程度</div>
				</div>
				<div class="inputContainer" style="width:70%;float:left;">
					<input placeholder="姓名" name="name" id="name" value="${personInfo.name}"/>
					<div class="editShow">姓名</div>
				</div>
				<div class="inputContainer" style="width:30%;float:left;">
					<input placeholder="性别" id="viewGender" readonly="readonly" value="${personInfo.gender}"/>
					<input id="gender" name="gender" type="hidden" value="${personInfo.gender}"/>
					<div class="editShow">性别</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="出生年月" id="birthday" name="birthday" value="${personInfo.birthday}"/>
					<input id="hiddenBirthday" value="${personInfo.birthday}" type="hidden" />
					<div class="editShow">出生年月</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="工作年限" id="viewWorkLife" readonly="readonly" value="${personInfo.workLife}"/>
					<input id="workLife" name="workLife" type="hidden" value="${personInfo.workLife}"/>
					<div class="editShow">工作年限</div>
				</div>
				<div class="inputContainer" style="width:40%;float:left;">
					<input placeholder="证件类型" id="viewPaperType" readonly="readonly" value="${personInfo.paperType}"/>
					<input id="paperType" name="paperType" type="hidden" value="${personInfo.paperType}"/>
					<div class="editShow">证件类型</div>
				</div>
				<div class="inputContainer" style="width:60%;float:left;">
					<input placeholder="证件号" id="paperNo" name="paperNo" value="${personInfo.paperNo}"/>
					<div class="editShow" value="${personInfo.paperNo}">证件号</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="手机号" id="phone" name="phone" value="${personInfo.phone}"/>
					<div class="editShow">手机号</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="居住省" id="viewLiveProvince" readonly="readonly" value="${personInfo.liveProvince}"/>
					<input type="hidden" name="liveProvince" id="liveProvince" value="${personInfo.liveProvince}"/>
					<div class="editShow">居住省</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="居住市" id="viewLiveCity" readonly="readonly" value="${personInfo.liveCity}"/>
					<input type="hidden" name="liveCity" id="liveCity" value="${personInfo.liveCity}"/>
					<div class="editShow">居住市</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="户口省" id="viewHouseProvince" readonly="readonly" value="${personInfo.houseProvince}"/>
					<input type="hidden" name="houseProvince" id="houseProvince" value="${personInfo.houseProvince}"/>
					<div class="editShow">户口省</div>
				</div>
				<div class="inputContainer" style="width:50%;float:left;">
					<input placeholder="户口市" id="viewHouseCity" readonly="readonly" value="${personInfo.houseCity}"/>
					<input type="hidden" name="houseCity" id="houseCity" value="${personInfo.houseCity}"/>
					<div class="editShow">户口市</div>
				</div>
				<div class="inputContainer" style="width:100%;float:left;">
					<input placeholder="email" id="email" name="email" value="${personInfo.email}"/>
					<div class="editShow">email</div>
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
		
		function bindEvent() {
			openLevelSelect();
			genderSelect();
			workLifeSelect();
			paperTypeSelect();
			liveProvinceSelect();
			liveCitySelect();
			houseProvinceSelect();
			houseCitySelect();
			formBind();
			submitEvent();
		}
		
		function submitEvent() {
			$("footer").click(function(){
				if( $("#resumeName").val() == "" ) {
					alert("请输入简历名称,方便您管理简历",1000);return;
				} else if( $("#openess").val() == "" ) {
					alert("请选择公开程度,完成简历查看权限",1000);return;
				} else if( $("#name").val() == "" ) {
					alert("请输入姓名",1000);return;
				} else if( $("#gender").val() == "" ) {
					alert("请选择性别",1000);return;
				} else if( $("#birthday").val() == "" ) {
					alert("请选择出生年月",1000);return;
				} else if( $("#birthday").val() == "" ) {
					alert("请选择出生年月",1000);return;
				} else if( $("#workLife").val() == "" ) {
					alert("请选择工作年限",1000);return;
				} else if( $("#paperType").val() == "" ) {
					alert("请选择证件类型",1000);return;
				} else if( $("#paperNo").val() == "" ) {
					alert("请输入证件号",1000);return;
				} else if( $("#phone").val() == "" ) {
					alert("请输入手机号,让客服能够通知你",1000);return;
				} 
				$("form").submit();
			});
		}
		
		function formBind() {
			$('form').bind('submit', function(){
		        ajaxSubmit(this, function(data){
		            alert("个人信息已成功保存",1000*60*60,function(){
		            	var resumeId = $("#resumeId").val();
		            	window.location.href = PATH + "/resume/editResume.do?resumeId="+resumeId;
		            });
		        });
		        return false;
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
		
		function openLevelSelect() {
			$("#viewOpenEss").click(function(){
				var ary = ["保密","公开"];
				var obj = createMaskBtnByAry(ary);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewOpenEss");
				$("#hiddenInput").val("openess");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function liveProvinceSelect() {
			$("#viewLiveProvince").click(function(){
				var obj = createMaskBtnByAry(provinceAry);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewLiveProvince");
				$("#hiddenInput").val("liveProvince");
				$("#subHiddenInput").val("liveCity");
				$("#subActiveInput").val("viewLiveCity");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function liveCitySelect() {
			$("#viewLiveCity").click(function(){
				var liveProvince = $("#liveProvince").val();
				var obj = "" , index = "" , idx = "";
				if( liveProvince == "")
					obj = createMaskBtnByAry([]);
				else {
					for(idx = 0 ; idx < provinceAry.length ; idx++ ) {
						if( provinceAry[idx] == liveProvince ) {
							index = idx;break;
						}
					}
					obj = createMaskBtnByAry(cityAry[index]);
				}
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewLiveCity");
				$("#hiddenInput").val("liveCity");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function houseProvinceSelect() {
			$("#viewHouseProvince").click(function(){
				var obj = createMaskBtnByAry(provinceAry);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewHouseProvince");
				$("#hiddenInput").val("houseProvince");
				$("#subHiddenInput").val("houseCity");
				$("#subActiveInput").val("viewHouseCity");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function houseCitySelect() {
			$("#viewHouseCity").click(function(){
				var liveProvince = $("#houseProvince").val();
				var obj = "" , index = "" , idx = "";
				if( liveProvince == "")
					obj = createMaskBtnByAry([]);
				else {
					for(idx = 0 ; idx < provinceAry.length ; idx++ ) {
						if( provinceAry[idx] == liveProvince ) {
							index = idx;break;
						}
					}
					obj = createMaskBtnByAry(cityAry[index]);
				}
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewHouseCity");
				$("#hiddenInput").val("houseCity");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function genderSelect() {
			$("#viewGender").click(function(){
				var ary = ["男","女"];
				var obj = createMaskBtnByAry(ary);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewGender");
				$("#hiddenInput").val("gender");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function paperTypeSelect() {
			$("#viewPaperType").click(function(){
				var ary = ["身份证","护照","军人证","香港身份证","其他"];
				var obj = createMaskBtnByAry(ary);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewPaperType");
				$("#hiddenInput").val("paperType");
				$("#mask_editResume").css("display","block");
			});
		}
		
		function workLifeSelect() {
			$("#viewWorkLife").click(function(){
				var ary = ["在校学生","应届毕业生","1年","2年","3-4年","5-7年","8-9年","10年以上"];
				var obj = createMaskBtnByAry(ary);
				$(".maskBtnArea").append(obj);
				maskCancelEvent();
				maskBtnEvent();
				$("#activeInput").val("viewWorkLife");
				$("#hiddenInput").val("workLife");
				$("#mask_editResume").css("display","block");
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
		
		function init() {
			setClientHeight("editResume");
			alertDateWindow("birthday");
			var birthday = $("#hiddenBirthday").val();
			if( birthday != "" ) {
				$("#birthday").val( birthday );
			};
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