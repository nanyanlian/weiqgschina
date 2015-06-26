<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/includes/allInclude.jsp" />
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<meta name="format-detection" content="telephone=no" />
	<meta content="no-cache,must-revalidate" http-equiv="Cache-Control" />
	<meta content="no-cache" http-equiv="pragma" />
	<meta content="0" http-equiv="expires" />
	<script type="text/javascript" src="${js_path}/swipe.js"></script>
	<link href="${css_path}/basic.css" rel="stylesheet" />
	<link href="${css_path}/styles.css" rel="stylesheet" />
</head>
<body>
	<div id="page_employList">
		<input type="hidden" id="path" value="${path}"/>
		<header>
			<div class="logo">
				<img src="http://7te8tv.com1.z0.glb.clouddn.com/img/common/qg_logo.jpg" />
			</div>
			<div class="followLogo">
				<div class="companyName">乾冠招聘</div>
			</div>
		</header>
		<section>
			<c:forEach items="${requestScope.employList}" var="employ">
				<article>
					<div class="user">
						<div class="userInfo">
							<div class="userName">${employ.name}</div>
							<div class="createDate">${employ.createDate}</div>
						</div>
					</div>
					<dl>
						<c:if test="${employ.jobDescNum != 0}">
						<dt>职位描述</dt>
						<dd>
							<ol>
								<c:forEach items="${employ.jobDesc}" var="jobDesc">
								<li>${jobDesc.content}</li>
								</c:forEach>
							</ol>
						</dd>
						</c:if>
					</dl>
					<a href="javascript:void(0);" class="lookAll" employId="${employ.id}">查看全文</a>
					<a href="javascript:void(0);" class="wantEmploy" employId="${employ.id}">我要应聘</a>
				</article>
			</c:forEach>
		</section>
	</div>
	
	<script>
		$(function(){
			path = $("#path").val();
			
			$(".lookAll").click(function(){
				var employId = $(this).attr("employId");
				window.location.href = path + "/employ/lookEmployInfo.do?employId=" + employId;
			});
			
			$(".wantEmploy").click(function(){
				var employId = $(this).attr("employId");
				window.location.href = path + "/resume/toResumeList.do?employId=" + employId;
			});
		});
		
		window.onload = function() {
			setClientHeight("page_employList");			
		};
		window.onresize = function() {
			setClientHeight("page_employList");		
		};
	</script>
</body>
</html>