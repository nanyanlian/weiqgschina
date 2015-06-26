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
	<div id="page_resumeList">
		<input type="hidden" id="loadDate" name="loadDate" value="${loadDate}" />
		<input type="hidden" id="path" value="<%=request.getContextPath() %>" />
		<input type="hidden" id="page"  value="${page}" />
		<input type="text" id="rows" style="display:none;" value="${rows}"/>
		<input type="text" id="loadMode"  style="display:none;" value="${loadMode}"/>
		<input type="text" id="loadingMore" style="display:none;" value="true" />
		<input type="hidden" id="employName" name="employName" value="${sessionScope.resumeEmploy.name}" />
		<header><div class="back">返回</div>选择简历</header>
		<section>
			<!-- <article>
				<div class="container">
					<h3>简历名称</h3>
					<dl><dt>完整度:</dt>
						<dd>
							<div class="toolBarContainer">
								<div class="toolBar"></div>
							</div>
							<label class="toolBarLabel">100%</label>
						</dd>
					</dl>
					<dl><dt>公开程度:</dt><dd>公开</dd></dl>
					<dl><dt>创建时间:</dt><dd>2014-10-31</dd></dl>
				</div>
			</article>
			<div class="footer">
				<div class="register">
					<span class="icons icons_submit">&nbsp;</span>立即申请
					<div class="footerLine"></div>
				</div>
				<div class="write">
					<span class="icons icons_write">&nbsp;</span>编辑
					<div class="footerLine"></div>
				</div>
				<div class="delete">
					<span class="icons icons_delete">&nbsp;</span>删除
				</div>
			</div> -->
			<c:forEach items="${resumeList}" var="resume">
				<article id="article_${resume.id}"><div class="container">
					<h3>${resume.name}</h3>
					<dl><dt>完整度:</dt>
						<dd>
							<div class="toolBarContainer">
								<div class="toolBar" id="toolBar_${resume.id}"></div>
							</div>
							<label class="toolBarLabel" resumeId="${resume.id}" complete="${resume.complete}">${resume.complete}%</label>
						</dd>
					</dl>
					<dl><dt>公开程度:</dt><dd>${resume.openLevel}</dd></dl>
					<dl><dt>创建时间:</dt><dd><fmt:formatDate value="${resume.createDate}" type="date"/></dd></dl>
				</div>
			</article>
			<div class="footer" id="footer_${resume.id}">
				<div class="register" resumeId="${resume.id}">
					<span class="icons icons_submit">&nbsp;</span>立即申请
					<div class="footerLine"></div>
				</div>
				<div class="write" resumeId="${resume.id}">
					<span class="icons icons_write">&nbsp;</span>编辑
					<div class="footerLine"></div>
				</div>
				<div class="delete" resumeId="${resume.id}">
					<span class="icons icons_delete">&nbsp;</span>删除
				</div>
			</div>
			</c:forEach>
			<aside>创建新简历</aside>
		</section>
	</div> 
	<script>
		$(function(){
			PATH = $("#path").val();
			initToolBar();
			bindEvent();
		});
		
		function initToolBar() {
			var toolBarAry = $(".toolBarLabel");
			var idx , resumeId , complete , resume;
			for(idx = 0 ; idx < toolBarAry.length ; idx++ ) {
				resume = $(toolBarAry[idx]);
				resumeId = resume.attr("resumeId");
				complete = resume.attr("complete");
				$("#toolBar_"+resumeId).css("width",complete+"%");
			}
		}
		
		function addNewResume() {
			$("aside").click(function(){
				var articleLength = $("article").length;
				if( articleLength == 5 ) {
					alert("个人最多只能创建5封简历,您的简历数量已满",1000);
					return;
				}
				window.location.href = PATH + "/resume/addNewResume.do";
			});
		}
		function deleteResume() {
			$(".delete").click(function(){
				var resumeId = $(this).attr("resumeId");
				$.ajax({
					url : PATH + "/resume/delResume.do",
					type: "post",
					dataType:"text",
					data: {"resumeId":resumeId},
					success:function(data) {
						if( data == "success" ) {
							$("#article_"+resumeId).remove();
							$("#footer_"+resumeId).remove();
						}
					}
				});
			}); 
		}
		
		function editResume() {
			$(".write").click(function(){
				var resumeId = $(this).attr("resumeId");
				window.location.href = PATH + "/resume/editResume.do?resumeId="+resumeId;
			});
		}
		
		function backToEmployList() {
			$("header div.back").click(function(){
				window.location.href = PATH + "/employ/toEmployList.do";
			});
		}
		
		function register() {
			$(".register").click(function(){
				var resumeId = $(this).attr("resumeId");
				$.ajax({
					url			: PATH + "/resume/queryCouldRegister.do",
					dataType	: "text",
					data		: {"resumeId":resumeId},
					type		: "post",
					success		: function(data) {
						if( data == "success" ) {
							alert("求职申请已成功发出,请等待HR给您来电",1000*60*60*24,function(){
								$("header div.back").click();
							});
						} else {
							alert("未填写个人信息及求职意向,暂不可申请",1000);
						}
					}
				});
			});
		}
		
		function bindEvent() {
			addNewResume();
			deleteResume();
			editResume();
			backToEmployList();
			register();
		}
		
		window.onload = function() {
			var dlWidth = $("dl").width();
			$("dd").css("width",dlWidth-120+"px");
			setClientHeight("page_resumeList");			
		};
		window.onresize = function(){
			var dlWidth = $("dl").width();
			$("dd").css("width",dlWidth-120+"px");
			setClientHeight("page_resumeList");	
		};
	</script>
</body>
</html>