<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<footer id="footBar">
	<!-- <div>
		<div class="leftLine"></div>
		<div class="content comment">
			<span class="fa-comment"></span>
			<label>留言乾冠</label>
		</div>
		<div class="rightLine"></div>
	</div> -->
	<div>
		<div class="leftLine"></div>
		<div class="content phone">
			<span class="fa-phone"></span>
			<label>联系乾冠</label>
		</div>
		<div class="rightLine"></div>
	</div>
	<div>
		<div class="leftLine"></div>
		<div class="content address">
			<span class="fa-map-marker"></span>
			<label>乾冠地图</label>
		</div>
		<div class="rightLine"></div>
	</div>
	<div>
		<div class="leftLine"></div>
		<div class="content backIndex">
			<span class="fa-mail-reply-all"></span>
			<label>返回主页</label>
		</div>
		<div class="rightLine"></div>
	</div>
</footer>

<script>
	var addressUrl = "http://map.baidu.com/mobile/webapp/place/marker/qt=inf&vt=map&act=read_share&code=158/third_party=uri_api&point=13371841.53%7C3518597.79&title=%E8%93%9D%E6%B5%B7%E6%97%B6%E4%BB%A3%E5%9B%BD%E9%99%85%E5%A4%A7%E5%8E%A6&content=%E6%B5%99%E6%B1%9F%E4%B9%BE%E5%86%A0%E4%BF%A1%E6%81%AF%E5%AE%89%E5%85%A8%E7%A0%94%E7%A9%B6%E9%99%A2&l=";
	$(".phone").click(function(){
		window.location.href = "tel:0571-88371988";
	});
	$(".backIndex").click(function(){
		window.location.href = PATH + "/index/index.do";
	});
	$(".address").click(function(){
		window.location.href = addressUrl;
	});
	$(".comment").click(function(){
		//addVisitNum();
	});
	
	function addVisitNum() {
		$.ajax({
			url:PATH + "/communityControl/addVisitNum.do",
			type:"post",
			dataType:"json",
			success:function(data) {
				window.location.href = PATH + "/community/toCommunityList.do";
			},
			error:function() {
				window.location.href = PATH + "/community/toCommunityList.do";
			}
		});	
	}
</script>