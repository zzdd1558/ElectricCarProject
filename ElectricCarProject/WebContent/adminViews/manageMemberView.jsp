<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</style>
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
			<a href="../memberController?command=logout w3-right">LOGOUT</a>
		</div>
	</div>

	<!-- end of bar -->

	<!-- The Band Section -->
	<div class="w3-container w3-content w3-center w3-padding-32"
		style="max-width: 70%" id="band">
		<h2 class="w3-wide">MANAGE CHARGERS AND MEMBERS</h2>
		<p class="w3-opacity">
			<i>you are the Manager!</i>
		</p>
		<hr>

		<div class="w3-cell-row w3-padding-32">

			<!-- CS 테이블 -->
			<div class="w3-cell">
				<div class="w3-container" id="manageTables">
					<h1 style="font-size:45px;">MEMBER TABLE</h1><br><br>
					
					<table class="w3-table">
						<tr>
							<th>아이디</th>
							<th>비밀번호</th>
							<th>이름</th>
							<th>연락처</th>
							<th style="width:20%"></th>
						</tr>
						<tr>
							<td>Jill</td>
							<td>Smith</td>
							<td>50</td>
							<td>Jill</td>
							<td><button class="w3-button w3-black">수정</button>
								<button class="w3-button w3-black">삭제</button></td>

						</tr>
						<tr>
							<td>Eve</td>
							<td>Jackson</td>
							<td>94</td>
							<td>Eve</td>
							<td><button class="w3-button w3-black">수정</button>
								<button class="w3-button w3-black">삭제</button></td>
						</tr>
						<tr>
							<td>Adam</td>
								<td>Johnson</td>
							<td>67</td>
							<td>Adam</td>
							<td><button class="w3-button w3-black">수정</button>
								<button class="w3-button w3-black">삭제</button></td>
						</tr>
					</table>

					<div class="w3-container" style="width: 100%; margin: auto;">
						<!-- search bar -->
						<form
							action="${pageContext.request.contextPath}/memberController">
							<input style="margin-top:20px;" class="search w3-left" type="text" name="str"
								placeholder="이름검색"	> <input type="hidden"
								name="command" value="searchName">

							<button type="submit" class="w3-btn w3-black w3-left"
								style="margin-top:25px; margin-left:10px; margin-bottom:5px;">GO!</button>
						</form>
						<!-- end of search bar  -->
						<!-- 관리자 추가 버튼 -->
							<button class="w3-button w3-black w3-right" style="margin-top:20px;">관리자추가</button>						
						<!-- 관리자 추가 버튼 -->
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>