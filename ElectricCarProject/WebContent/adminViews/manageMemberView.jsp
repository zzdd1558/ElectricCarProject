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
<style>
#manageTables tr, th, td {
	border:1px solid black;
	align:center;
}
#manageTables button {
	margin-left:10px;
}
</style>
<title>Insert title here</title>
</head>
<body>

<!-- bar -->

<div class="w3-bar w3-black" style="position: fixed; z-index: 1000;">
	<div class="w3-bar-item w3-hover-red"><a href="#home">HOME</a></div>
	<div class="w3-bar-item w3-hover-green"><a href="adminViews/manageView.jsp">MANAGE CHARGERS AND MEMBERS</a></div>
	<div class="w3-bar-item w3-hover-yellow"><a href="adminViews/statisticsView.jsp">STATISTICS</a></div>
	<div class="w3-bar-item w3-hover-pink"><a href="adminViews/modifyInfoView.jsp">MODIFY INFO</a></div>
	<div class="w3-bar-item w3-hover-grey"><a href="adminViews/emailView.jsp">E-MAIL</a ></div>
	<div class="w3-bar-item w3-hover-white"><a href="memberController?command=logout">LOGOUT</a></div>
</div>

<!-- end of bar -->

  <!-- The Band Section -->
	<div class="w3-container w3-content w3-center w3-padding-32"
		style="max-width: 80%" id="band">
		<h2 class="w3-wide">MANAGE CHARGERS AND MEMBERS</h2>
		<p class="w3-opacity">
			<i>you are the Manager!</i>
		</p>
		<hr>

			<!-- MEMBER 테이블 -->
			<div class="w3-cell w3-center" >
				<div class="w3-container" id="manageTables">
				<h2>MEMBER TABLE</h2>
					<table class="w3-table">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Points</th>
							<th>button</th>
						</tr>
						<tr>
							<td>Jill</td>
							<td>Smith</td>
							<td>50</td>
							<td><button class="w3-button w3-black">수정</button><button class="w3-button w3-black">삭제</button></td>
						</tr>
						<tr>
							<td>Eve</td>
							<td>Jackson</td>
							<td>94</td>
							<td><button class="w3-button w3-black">수정</button><button class="w3-button w3-black">삭제</button></td>
						</tr>
						<tr>
							<td>Adam</td>
							<td>Johnson</td>
							<td>67</td>
							<td><button class="w3-button w3-black">수정</button><button class="w3-button w3-black">삭제</button></td>
						</tr>
					</table>
				</div>
			</div>
	</div>




</body>
</html>








			<!-- MEMBER 테이블 -->
			<div class="w3-cell w3-center" >
				<div class="w3-container" id="manageTables">
				<h2>MEMBER TABLE</h2>
					<table class="w3-table">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Points</th>
							<th>button</th>
						</tr>
						<tr>
							<td>Jill</td>
							<td>Smith</td>
							<td>50</td>
							<td><button class="w3-button w3-black">수정</button><button class="w3-button w3-black">삭제</button></td>
						</tr>
						<tr>
							<td>Eve</td>
							<td>Jackson</td>
							<td>94</td>
							<td><button class="w3-button w3-black">수정</button><button class="w3-button w3-black">삭제</button></td>
						</tr>
						<tr>
							<td>Adam</td>
							<td>Johnson</td>
							<td>67</td>
							<td><button class="w3-button w3-black">수정</button><button class="w3-button w3-black">삭제</button></td>
						</tr>
					</table>
				</div>
			</div>