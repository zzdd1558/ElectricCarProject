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

	<!-- The Band Section -->
	<div class="w3-container w3-content w3-center w3-padding-32"
		style="max-width: 80%" id="band">
		<h2 class="w3-wide">MANAGE CHARGERS AND MEMBERS</h2>
		<p class="w3-opacity">
			<i>you are the Manager!</i>
		</p>
		<hr>

		<div class="w3-cell-row w3-padding-32">

			<!-- CS 테이블 -->
			<div class="w3-cell">
				<div class="w3-container" id="manageTables">
					<h1 style="font-size:45px;">CHARGER TABLE</h1><br>
					<div><button style="margin-right:1;" class="w3-button w3-black w3-right w3-margin">추가</button></div>
					
					<table class="w3-table">
						<tr>
							<th>charger_NO</th>
							<th>cs_CODE_CD</th>
							<th>cp_unique_NO</th>
							<th>cp_Name_CD</th>
							<th>cp_Stat_CD</th>
							<th>cp_Type_CD</th>
							<th>charger_Type</th>
							<th>city_LOW</th>
							<th>buttons</th>
						</tr>
						<tr>
							<td>Jill</td>
							<td>Smith</td>
							<td>50</td>
							<td>Jill</td>
							<td>Smith</td>
							<td>50</td>
							<td>Smith</td>
							<td>50</td>
							<td><button class="w3-button w3-black">수정</button>
								<button class="w3-button w3-black">삭제</button></td>

						</tr>
						<tr>
							<td>Eve</td>
							<td>Jackson</td>
							<td>94</td>
							<td>Eve</td>
							<td>Jackson</td>
							<td>94</td>
							<td>Jackson</td>
							<td>94</td>
							<td><button class="w3-button w3-black">수정</button>
								<button class="w3-button w3-black">삭제</button></td>
						</tr>
						<tr>
							<td>Adam</td>
							<td>Johnson</td>
							<td>67</td>
							<td>Adam</td>
							<td>Johnson</td>
							<td>67</td>
							<td>Johnson</td>
							<td>67</td>
							<td><button class="w3-button w3-black">수정</button>
								<button class="w3-button w3-black">삭제</button></td>
						</tr>
					</table>

					<div class="w3-container" style="width:100%; margin:auto;" >
						<form class="w3-container w3-card-4"
							style="font-size: 14px; margin-top: 30px;"
							action="${pageContext.request.contextPath}/stationController">
							
							<select style="width:40%" class="w3-margin w3-select w3-border w3-padding" name="city_high" id="city_high"
								onfocus="loadByCityHigh();" onchange="document.getElementById('city_middle').focus();">
								<option value="" disabled selected>city_high</option>
								<option value="1">서울특별시</option>
							</select> 
							
							<select class="w3-margin w3-select w3-border w3-padding"
								style="width:40%; margin-top:15px;" name="city_middle" id="city_middle"
								onfocus="loadByCityMiddle();">
								<option value="" disabled selected>city_middle</option>
							</select> 
							
							<input type="hidden" name="command" value="selectSearch">
							
							<button style="width:10%" class="w3-btn w3-black w3-right w3-margin w3-padding" type="submit">Search</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>