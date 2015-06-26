<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/includes/allInclude.jsp" />
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
	<title>${module.title}</title>
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
	<div id="page_productInfo">
		<input type="hidden" id="path" value="${path}" />
		<div id="contentDiv" style="display:none;">${message.content }</div>
		<header>
			<div class="border">
				<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/5.png"/>
			</div>
			<div class="content">
				<div class="logo"><img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/qg_logo.jpg" /></div>
				<div class="logoFollow" id="logoFollow">
					<div class="title show" id="pageTitle" ><span>${message.title}</span></div>
					<div class="title hidden" id="hiddenTitle" style="display:none;">${message.title}</div>
					<div class="time">${message.createDate}</div>
				</div>
			</div>
			<div class="border"><img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/5.png"/></div>
		</header>
		<section>
			<iframe id="iframe" src="${path}/message/iframeInfoPage.do" style="border:0;width:100%;height:200px;"></iframe>
		</section>
		
		<jsp:include page="/WEB-INF/page/common/foot.jsp" />
	</div>
	<script type="text/javascript">
		document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
			WeixinJSBridge.call('showToolbar');
		    WeixinJSBridge.call('showOptionMenu');
		});
		$(function(){
			PATH = $("#path").val();
		});
		window.onload = function(){
			var contentHTML = $("#contentDiv").html();
			var iframe = $("iframe");
			var msgContainer = iframe.contents().find("#msgContainer");
			console.log(contentHTML);
			msgContainer.html(contentHTML);
			init();
		};
		window.onresize = function() {
			init();
		};
		function setIframeHeight() {
			var iframe = $("iframe");
			var iframeHeight = iframe.contents().height();
			iframe.css("height",iframeHeight+"px");
		}
		function init() {
			setIframeHeight();
			setClientHeight("page_productInfo");
			var logoFollow = $("#pageTitle");
			logoFollow.css("width",$("#page_productInfo").width()-110-20+"px");
			if( $('#hiddenTitle').height() > $('#pageTitle').height() ) {
				$('#pageTitle').html( $('#pageTitle').html()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				setInterval("scroll(document.getElementById('pageTitle'))",50); 
			}
			
			var articleList = $("article div.list");
			var message = $("article div.message");
			message.css("width" , articleList.width() - 50 );
			message.css("word-wrap","break-word");
		}
	</script>
</body>
</html>