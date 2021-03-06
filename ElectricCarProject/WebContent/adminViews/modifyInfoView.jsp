<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/stylesheets/statisticsView.css" />
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/stylesheets/bar_a.css" />
<title>Insert title here</title>
</head>
<body>

<!-- bar -->

	<div class="w3-bar w3-black" style="position: fixed; z-index: 1000;">
		<div class="w3-bar-item w3-hover-red">
			<a href="${pageContext.request.contextPath}/index.jsp">HOME</a>
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
		<div class="w3-bar-item w3-hover-white w3-right">
			<a href="../memberController?command=logout">LOGOUT</a>
		</div>
	</div>

	<!-- end of bar -->


</body>
</html>