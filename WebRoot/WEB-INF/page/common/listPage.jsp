<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<style type="text/css">
		div#page_productList {max-width:640px;margin:auto;position:relative; padding-bottom:60px;}
		div#page_productList header {width:100%;}
		div#page_productList header img {width:100%;}
		div#page_productList section {width:100%;margin-top:30px;}
		div#page_productList section article {position:relative;font-weight:bold;color:#000;padding-top:15px;padding-bottom:15px;padding-left:20px;cursor:pointer;}
		div#page_productList section article span {font-family:FontAwesome;position:absolute;right:10px;top:15px;}
		div#page_productList section div.splitLine {width:100%;height:0px;border-top:1px solid #0247a8;}
	</style>
</head>
<body>
	<div id="page_productList">
		<input id="path" value="${path}" type="hidden" />
		<input id="page" value="${module.page}" type="hidden" />
		<input id="rows" value="${module.rows}" type="hidden" />
		<input id="parentId" value="${module.id}" type="hidden" />
		<header><img src="${module.topPicUrl}"/></header>
		<section id="articleSection">
			<c:forEach items="${requestScope.moduleList}" var="module">
				<article moduleId="${module.id}" class="intro" url="${module.url}">
					<div class="content" >${module.title}</div><span class="fa-hand-o-right"></span>
				</article>
				<div class="splitLine"></div>
			</c:forEach>
		</section>
		
		<section>
			<c:if test="${requestScope.hasMore == 'hasMore'}">
				<div id="sortDown">查看更多内容&nbsp;<span class="fa-angle-down" ></span></div>
			</c:if>
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
			bindEvent();
		});
		window.onload = function() {
			setClientHeight("page_productList");
			$("#page").val(1);
		};
		window.onresize = function() {
			setClientHeight("page_productList");
		};
		function bindEvent() {
			$(".intro").click(function(){
				var url = $(this).attr("url");
				if( url == "" ) {
					var moduleId = $(this).attr("moduleId");
					window.location.href = PATH + "/module/turnToPage.do?moduleId="+moduleId;
				} else {
					window.location.href = PATH + url;
				}
			});
			$("#sortDown").click(function(){
				var pageInput = $("#page");
				var parentId = $("#parentId").val();
				var rows = $("#rows").val();
				var page = parseInt(pageInput.val())+1;
				pageInput.val(page);
				
				$.post(PATH + "/module/listMoreModule.do",{"id":parentId,"parentId":parentId,"page":page,"rows":rows},
					function(data,status){
						var idx , module,newObj;
						var section = $("#articleSection");
						var hasMore = data.hasMore;
						var moduleList = data.moduleList;
						for(idx = 0 ; idx < moduleList.length ; idx++) {
							module = moduleList[idx];
							newObj = "<article class='intro' moduleId="+module.id+" url='"+module.url+"'><div class='content'>"+ module.title +"</div><span class='fa-hand-o-right'></span></article><div class='splitLine'></div>";
							section.append(newObj);
						}	
						if( hasMore == "noMore") {
							$("#sortDown").css("display","none");
						}
						bindEvent();
						setClientHeight("page_productList");
				},"json");
			});
		}
		
		function setClientHeight(pageName) {
			var page = $("#"+pageName);
			var clientHeight = document.documentElement.clientHeight;
			var pageHeight = page.height();
			if( pageHeight < clientHeight ) {
				page.css("height",clientHeight);
			}
		}
	</script>
</body>
</html>