<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
</head>
<body>
	<div id="page_index">
		<input type="hidden" id="code" name="userCode" value="${code}"/>
		<input type="hidden" id="openid" name="openid" value="" />
		<input type="hidden" id="accessToken" name="accessToken" value="" />
		<!-- 图片轮播 -->
		<header id="banner_box" class="box_swipe">
			<ul>
				<li><img src="${img_path}/lunbo1.jpg"/></li>
				<li><img src="${img_path}/lunbo2.jpg"/></li>
				<li><img src="${img_path}/lunbo3.jpg"/></li>
				<li><img src="${img_path}/lunbo4.jpg"/></li>
				<li><img src="${img_path}/lunbo5.jpg"/></li>
			</ul>
			<ol><li class="on"></li><li></li><li></li><li></li><li></li></ol>
		</header>
		
		<aside>
			<div class="logo">
				<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/tran_qg_logo.png"/>
			</div>
			<span class="pcWeb">浙江乾冠信息安全研究院</span>
		</aside>
		
		<section>
			<article>
				<div class="color1 left mainModule" id="aboutCompany" moduleId="1">
					<span class="fa-home"></span>
					<p>关于乾冠</p>
					<div class="rightBottom trigger"></div>
				</div>
				<div class="color2 right mainModule" id="companyInfo" moduleId="2">
					<span class="fa-road"></span>
					<p>企业动态</p>
				</div>
			</article>
			<article>
				<div class="color3 left mainModule" id="productService" moduleId="3">
					<span class="fa-truck"></span>
					<p>产品服务</p>
				</div>
				<div class="color4 right mainModule" id="techAlliance" moduleId="4">
					<span class="fa-cog"></span>
					<p>技术联盟</p>
				</div>
			</article>
			<article>
				<div class="color5 left mainModule" id="recruitInfo" moduleId="5">
					<span class="fa-users"></span>
					<p>招贤纳士</p>
				</div>
				<div class="color6 right mainModule" id="contactUs" moduleId="6">
					<span class="fa-map-marker"></span>
					<p>联系我们</p>
				</div>
			</article>
		</section>
		<jsp:include page="/WEB-INF/page/common/foot.jsp" />
	</div>
	<script type="text/javascript">
		$(function(){
			PATH = $("#path").val();
			var code = $("#code").val();
			queryUserInfo(code);
			
			new Swipe(document.getElementById('banner_box'), {
				speed:500,
				auto:5000,
				callback: function(){
					var lis = $(this.element).next("ol").children();
					lis.removeClass("on").eq(this.index).addClass("on");
				}
			});
			
			$("aside").click(function(){
				window.location.href = "http://www.qgs-china.com/qgs/";			
			});
			
			$(".mainModule").click(function(){
				var moduleId = $(this).attr("moduleId");
				if( moduleId == 5) {
					window.location.href = "${path}/employ/toEmployList.do";
				}
				else if( moduleId == 6 ) {
					window.location.href = "${path}/module/turnToPage.do?moduleId=6";
				} else {
					window.location.href = "${path}/module/turnToPage.do?moduleId="+moduleId;
				}
			});
			
		});
		window.onload = function(){
			setClientHeight("page_index");
			initTrigger();
		};
		window.onresize = function(){
			setClientHeight("page_index");
			initTrigger();
		};
		
		function queryUserInfo(code) {
			$.ajax({
				url : "${path}/user/userEnter.do" ,
				dataType : "json" ,
				type: "post",
				data: {"code":code},
				success : function() {}
			});
		}
		
		function initTrigger() {
			var mainModel = $($(".mainModule")[0]);
			var triggerWidth = mainModel.width() * 0.14;
			var triggerHeight = mainModel.height() * 0.2;
			var triggerAry = $(".trigger");
			var idx = 0 , trigger;
			for(idx = 0 ; idx < triggerAry.length ; idx++ ) {
				trigger = $(triggerAry[idx]);
				trigger.css("borderLeftWidth",triggerWidth+"px");
				trigger.css("borderBottomWidth",triggerHeight+"px");
			}
		}
	</script>
</body>
</html>