<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/stylesheets/statisticsView.css" />
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/stylesheets/bar_a.css" />
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script
	src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet"
	href="https://www.amcharts.com/lib/3/plugins/export/export.css"
	type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
<script
	src="${ pageContext.request.contextPath }/javascripts/asyncEvent.js"></script>
<script
	src="${ pageContext.request.contextPath }/javascripts/AMchart.js"></script>
<style>
#chartdiv {
	width: 100%;
	height: 500px;
}

.amcharts-export-menu-top-right {
	top: 10px;
	right: 0;
}
</style>



<title>Insert title here</title>
</head>
<body>

	<!-- bar -->

	<div class="w3-bar w3-black" style="position: fixed; z-index: 1000;">
		<div class="w3-bar-item w3-hover-red">
			<a href="#home">HOME</a>
		</div>
		<div class="w3-bar-item w3-hover-green">
			<a
				href="${ pageContext.request.contextPath }/adminViews/manageChargerView.jsp">MANAGE
				CHARGERS</a>
		</div>
		<div class="w3-bar-item w3-hover-green">
			<a
				href="${ pageContext.request.contextPath }/adminViews/manageMemberView.jsp">MANAGE
				MEMBERS</a>
		</div>
		<div class="w3-bar-item w3-hover-yellow">
			<a
				href="${ pageContext.request.contextPath }/adminViews/statisticsView.jsp">STATISTICS</a>
		</div>
		<div class="w3-bar-item w3-hover-pink">
			<a
				href="${ pageContext.request.contextPath }/adminViews/modifyInfoView.jsp">MODIFY
				INFO</a>
		</div>
		<div class="w3-bar-item w3-hover-grey">
			<a
				href="${ pageContext.request.contextPath }/adminViews/emailView.jsp">E-MAIL</a>
		</div>
		<div class="w3-bar-item w3-hover-white">
			<a
				href="${ pageContext.request.contextPath }/memberController?command=logout">LOGOUT</a>
		</div>
	</div>

	<!-- end of bar -->


	<!-- The Section -->
	<div class="w3-container w3-content w3-center w3-padding-32"
		style="max-width: 90%">
		<h1 class="w3-wide">STATISTICS</h1>
		<p class="w3-opacity">
			<i>check out latest statistics!</i>
		</p>
		<hr style="border: 2px solid black;">

		<!-- 실제 컨텐츠 시작 -->

		<div class="w3-row-padding w3-center">
			<br style="line-height: 3">
			<h2>DATA TABLES</h2>
			<br style="line-height: 4">
			
			<div class="w3-half">
				<div id="chartdiv"></div>
			</div>
		</div>
		<div class="w3-row-padding">
			<div class="w3-half">
				<div id="chartdiv"></div>
			</div>
			<div class="w3-half">
				<div id="chartdiv"></div>
			</div>
		</div>


		<!-- 실제 컨텐츠 끝 -->

	</div>

</body>
</html>