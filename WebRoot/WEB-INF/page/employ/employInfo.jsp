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
	<style>
		
	</style>
</head>
<body>
	<div id="page_employInfo">
		<input type="hidden" id="path" value="${path}"/>
		<section>
			<article>
				<div class="user">
					<div class="userInfo">
						<div class="userName">${employ.name}</div>
						<div class="createDate">${employ.createDate}</div>
					</div>
				</div>
				<dl>
					<c:if test="${employ.employNum != 0 && employ.employNum != null}">
						<dt>招聘数量&nbsp;:&nbsp;<c:if test="${employ.employNum == -1}">若干</c:if>
							<c:if test="${employ.employNum != -1}">${employ.employNum}名</c:if>
						</dt>
					</c:if>
					<c:if test="${employ.workExp != null && employ.workExp != ''}">
						<dt>年龄要求</dt>
						<dd><ul><li>${employ.workExp}</li></ul></dd>
					</c:if>
					<c:if test="${employ.ageLimit != null && employ.ageLimit != ''}">
						<dt>年龄要求</dt>
						<dd><ul><li>${employ.ageLimit}</li></ul></dd>
					</c:if>
					<c:if test="${employ.specialtyRequest != null && employ.specialtyRequest != ''}">
						<dt>专业要求</dt>
						<dd><ul><li>${employ.specialtyRequest}</li></ul></dd>
					</c:if>
					<c:if test="${employ.educationRequest != null && employ.educationRequest != ''}">
						<dt>学历要求</dt>
						<dd><ul><li>${employ.educationRequest}</li></ul></dd>
					</c:if>
					
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
					<c:if test="${employ.jobRequestNum != 0}">
						<dt>职位要求</dt>
						<dd>
							<ol>
								<c:forEach items="${employ.jobRequest}" var="jobRequest">
								<li>${jobRequest.content}</li>
								</c:forEach>
							</ol>
						</dd>
					</c:if>
				</dl>
				<a href="javascript:void(0);" class="wantEmploy" employId="${employ.id}">我要应聘</a>
			</article>
		</section>
		
	</div>
	
	<script>
		$(function(){
			path = $("#path").val();
			
			$(".wantEmploy").click(function(){
				var employId = $(this).attr("employId");
				window.location.href = path + "/resume/toResumeList.do?employId=" + employId;
			});
		});
		
		window.onload = function() {
			setClientHeight("page_employInfo");			
		};
		window.onresize = function() {
			setClientHeight("page_employInfo");		
		};
	</script>
</body>
</html>