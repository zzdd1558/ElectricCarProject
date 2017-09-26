<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../stylesheets/bar_a.css">
<link rel="stylesheet" href="../stylesheets/search.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="../javascripts/script.js"></script>
<script src="../javascripts/asyncEvent.js"></script>
<style>
#manageTables tr, th, td {
	border: 1px solid black;
	align: center;
}
#manageTables button {
	margin-left: 10px;
}
.w3-third {
	min-height: 400px;
	max-height:500px;
	border:1px solid black;
	padding:10px 10px 10px 10px;
	background-color:gray;
	
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
			<a href="../adminViews/manageChargerView.jsp">MANAGE CHARGERS</a>
		</div>
		<div class="w3-bar-item w3-hover-green">
			<a href="../adminViews/manageMemberView.jsp">MANAGE MEMBERS</a>
		</div>
		<div class="w3-bar-item w3-hover-yellow">
			<a href="../adminViews/statisticsView.jsp">STATISTICS</a>
		</div>
		<div class="w3-bar-item w3-hover-pink">
			<a href="../adminViews/modifyInfoView.jsp">MODIFY INFO</a>
		</div>
		<div class="w3-bar-item w3-hover-grey">
			<a href="../adminViews/emailView.jsp">E-MAIL</a>
		</div>
		<div class="w3-bar-item w3-hover-white">
			<a href="../memberController?command=logout">LOGOUT</a>
		</div>
	</div>

	<!-- end of bar -->

	<!-- The Section -->
	<div class="w3-container w3-content w3-center w3-padding-32"
		style="max-width: 90%">
		<h2 class="w3-wide">STATISTICS</h2>
		<p class="w3-opacity">
			<i>check out latest statistics!</i>
		</p>
		<hr style="border:2px solid black;">

	<!-- 실제 컨텐츠 시작 -->

		<div class="w3-row-padding w3-center" >
			<br style="line-height:3"><h1>DATA TABLES</h1><br style="line-height:7">
			<div class="w3-third ">
			<!-- 그래프자리 -->
			</div>
			<div class="w3-third">
			<!-- 그래프자리 -->
			</div>
			<div class="w3-third">
			<!-- 그래프자리 -->
			</div>
		</div>
		<div class="w3-row-padding">
			<div class="w3-third">
			<!-- 그래프자리 -->
			</div>
			<div class="w3-third">
			<!-- 그래프자리 -->
			</div>
			<div class="w3-third">
			<!-- 그래프자리 -->
			</div>
		</div>


		<!-- 실제 컨텐츠 끝 -->

	</div>

</body>
</html>