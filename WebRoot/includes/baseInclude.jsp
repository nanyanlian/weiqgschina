 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//String path 	= "http://weiqgschina.aliapp.com";
	String path = request.getContextPath();
	String img_path = path + "/img";
	String res_path = path + "/res";
	String css_path = path + "/style";
	String js_path 	= path + "/js"; 
	
	request.setAttribute("path" 	, path);
	request.setAttribute("img_path" , img_path);
	request.setAttribute("res_path" , res_path);
	request.setAttribute("css_path"	, css_path);
	request.setAttribute("js_path"	, js_path);
	
%>
<script type="text/javascript">
	PATH 		= ${path};
	IMG_PATH 	= ${img_path};
	RES_PATH 	= ${res_path};
	CSS_PATH	= ${css_path};
	JS_PATH		= ${js_path};
</script>
