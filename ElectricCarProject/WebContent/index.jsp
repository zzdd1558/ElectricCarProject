<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="stylesheets/bar_a.css">
<link rel="stylesheet" href="stylesheets/search.css">
<script src="javascripts/script.js"></script>
<script src="javascripts/asyncEvent.js"></script>
<title>index.html</title>
</head>
<body>

	<!-- bars -->

	<!-- before bar -->
	<div class="w3-bar w3-black" style="position: fixed; z-index: 1000;">

		<%
			if (session.getAttribute("managerKey") == null) {
		%>
		<div class="w3-bar-item w3-hover-red">
			<a href="#home">HOME</a>
		</div>
		<div class="w3-bar-item w3-hover-opacity">
			<a onclick="document.getElementById('login').style.display='block'">ADMIN</a>
		</div>
		<div class="w3-bar-item w3-hover-pink">
			<a href="#search">SEARCH CHARGER</a>
		</div>
		<div class="w3-bar-item w3-hover-blue">
			<a href="#gallery">GALLERY</a>
		</div>
		<div class="w3-bar-item w3-hover-green">
			<a href="#about">ABOUT</a>
		</div>
		<div class="w3-bar-item w3-hover-yellow">
			<a href="#founders">FOUNDERS</a>
		</div>
		<div onclick="document.getElementById('login').style.display='block'"
			class="w3-bar-item w3-hover-grey">LOG IN</div>
		<div onclick="document.getElementById('signup').style.display='block'"
			class="w3-bar-item w3-hover-white">SIGN UP</div>

		<%
			} else if (session.getAttribute("managerKey").equals(new Integer(2))) {
		%>
		<div class="w3-bar-item w3-hover-red">
			<a href="#home">HOME</a>
		</div>
		<div class="w3-bar-item w3-hover-green">
			<a href="adminViews/manageChargerView.jsp">MANAGE CHARGERS</a>
		</div>
		<div class="w3-bar-item w3-hover-green">
			<a href="adminViews/manageMemberView.jsp">MANAGE MEMBERS</a>
		</div>
		<div class="w3-bar-item w3-hover-yellow">
			<a href="adminViews/statisticsView.jsp">STATISTICS</a>
		</div>
		<div class="w3-bar-item w3-hover-pink">
			<a href="adminViews/modifyInfoView.jsp">MODIFY INFO</a>
		</div>
		<div class="w3-bar-item w3-hover-grey">
			<a href="adminViews/emailView.jsp">E-MAIL</a>
		</div>
		<div class="w3-bar-item w3-hover-white">
			<a href="memberController?command=logout">LOGOUT</a>
		</div>

		<%
			} else if (session.getAttribute("managerKey").equals(new Integer(1))) {
		%>
		<div class="w3-bar-item w3-hover-red">HOME</div>
		<div class="w3-bar-item w3-hover-green">ABOUT</div>
		<div class="w3-bar-item w3-hover-blue">GALLERY</div>
		<div class="w3-bar-item w3-hover-yellow">FOUNDERS</div>
		<div class="w3-bar-item w3-hover-pink">SEARCH CHARGER</div>
		<div class="w3-bar-item w3-hover-grey">MYPAGE</div>
		<div class="w3-bar-item w3-hover-white">LOGOUT</div>
		<%
			}
		%>
	</div>

	<!-- end of bars -->

	<!-- header -->

	<!-- class="w3-display-container w3-content w3-wide"  -->

	<header style="max-width: 100%;" id="home">
		<div class="w3-display-container w3-text-white">
			<img style="width: 100%; height:;" src="images/header/header7.jpg">
			<div class="w3-display-middle w3-large">Middle</div>
			<div class="w3-display-middle w3-margin-top">
				<h1 class="w3-xxlarge w3-text-white">
					<span class="w3-xxxlarge w3-padding w3-black w3-opacity-min"><b>Xeno-Charger</b></span>
				</h1>
			</div>
		</div>
	</header>

	<!-- end of header -->


	<!-- search charger / hidden value = wordSearch / input name=str -->

	<div class="w3-container w3-content w3-center w3-padding-48"
		style="max-width: 1200px" id="search">
		<h1 class="w3-wide">SEARCH CHARGERS</h1>
		<p class="w3-opacity">
			<i>Search your nearest Charger Station for free</i>
		</p>
		<div id="googleMap" class="w3-grayscale"
			style="width: 100%; height: 450px;"></div>
		<hr style="border: 2px solid black">

		<!-- search bar -->
		<form action="${pageContext.request.contextPath}/stationController">
			<input class="search w3-center" type="text" name="str"
				placeholder="Search.."> <input type="hidden" name="command"
				value="wordSearch">

			<button type="submit" class="w3-btn w3-black"
				style="margin-left: 10px; margin-bottom: 5px;">GO!</button>
		</form>
		<!-- end of search bar  -->

	</div>


	<!-- 메인 select Box -->
	<!-- select search / hidden value = selectSearch / name:city_high, city_middle / value:1~12 -->

	<div class="w3-cell-row w3-center" style="width: 80%; margin: auto;">

		<div class="w3-container w3-cell" style="width: 35%">
			<%-- <form class="w3-container w3-card-4"
				style="padding-top: 20px; font-size: 14px;"
				action="${pageContext.request.contextPath}/stationController"> --%>
			<select class="w3-select w3-border w3-padding" id="city_high"
				name="city_high" onfocus="loadByCityHigh();"
				onchange="document.getElementById('city_middle').focus();">
				<option value="" disabled selected>도시 선택</option>

			</select> <select class="w3-select w3-border w3-padding"
				style="margin-top: 15px;" id="city_middle" name="city_middle"
				onfocus="loadByCityMiddle();">
				<option value="" disabled selected>시/군/구 선택</option>
			</select> <input type="hidden" name="command" value="selectSearch">
			<button class="w3-btn w3-black w3-right w3-margin w3-padding"
				onclick="sendSearch()">Search</button>
			<!-- </form> -->
		</div>

		<div class="w3-container w3-cell" style="width: 70%">
			<!-- 검색된 테이블 id=resultTable -->
			<div id="resultTable" class="w3-container">
				<table class="w3-table-all">
					<thead>
						<tr class="w3-black w3-text-yellow">
							<th>번호</th>
							<th>충전소</th>
							<th>충전기 명칭</th>
							<th>충전기 상태</th>
							<th>충전 방식</th>
							<th>충전기 타입</th>
							<th>장소</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<!-- for문 돌려야되는 부분  -->
							<td>a</td>
							<td>a</td>
							<td>a</td>
							<td>a</td>
							<td>a</td>
							<td>a</td>
							<td>a</td>
						</tr>
					</tbody>
				</table>
			</div>


			<!-- end of 검색된 테이블 -->

		</div>
	</div>
	<br style="line-height: 20;">

	<!-- end of select search -->

	<script>
		var map;
		function myMap() {
			myCenter = new google.maps.LatLng(37.5, 127);
			var mapOptions = {
				center : myCenter,
				zoom : 5,
				scrollwheel : true,
				draggable : true,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};
			map = new google.maps.Map(document.getElementById("googleMap"), mapOptions);
	
			var marker = new google.maps.Marker({
				position : myCenter,
			});
			marker.setMap(map);
		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBjvtC_0Hr83DsKOtKr0oamgTdwyBtcuho&callback=myMap"></script>

	<!-- end of search charger -->

	<!-- CS정보 -->
	<!-- gallery -->

	<div class="w3-container w3-content w3-center w3-padding-48"
		style="max-width: 1200px" id="gallery">
		<h2>GALLERY</h2>
		<p class="w3-opacity"></p>
		<hr style="border: 2px solid black">
	</div>

	<div class="w3-content w3-display-container">

		<div class="w3-display-containe mySlides">
			<img src="images/slideCharger/charger1.jpg"
				style="width: 980px; height: 600px;">
			<div
				class="w3-display-bottommiddle w3-xlarge w3-container w3-padding-16 w3-black">
				서울특별시 강남구 서초대로34 스테이션 <br> 평점 : ★★★★☆
			</div>
		</div>

		<div class="w3-display-containe mySlides">
			<img src="images/slideCharger/charger2.jpg"
				style="width: 980px; height: 600px;">
			<div
				class="w3-display-bottommiddle w3-xlarge w3-container w3-padding-16 w3-black">
				강원도 춘천시 효자로87 스테이션 <br> 평점 : ★★★★★
			</div>
		</div>

		<div class="w3-display-containe mySlides">
			<img src="images/slideCharger/charger3.jpg"
				style="width: 980px; height: 600px;">
			<div
				class="w3-display-bottommiddle w3-xlarge w3-container w3-padding-16 w3-black">
				전라북도 익산시 익산대로34-3 스테이션 <br> 평점 : ★★★☆
			</div>
		</div>

		<div class="w3-display-containe mySlides">
			<img src="images/slideCharger/charger4.jpg"
				style="width: 980px; height: 600px;">
			<div
				class="w3-display-bottommiddle w3-xlarge w3-container w3-padding-16 w3-black">
				강원도 강릉시 강남대로13 스테이션 <br> 평점 : ★★★☆
			</div>
		</div>

		<div class="w3-display-containe mySlides">
			<img src="images/slideCharger/charger5.jpg"
				style="width: 980px; height: 600px;">
			<div
				class="w3-display-bottommiddle w3-xlarge w3-container w3-padding-16 w3-black">
				경상남도 울산시 방이대로77 스테이션 <br> 평점 : ★★★☆
			</div>
		</div>

		<div class="w3-display-containe mySlides">
			<img src="images/slideCharger/charger6.jpg"
				style="width: 980px; height: 600px;">
			<div
				class="w3-display-bottommiddle w3-xlarge w3-container w3-padding-16 w3-black">
				경기도 안양시 만안대로7-5 스테이션 <br> 평점 : ★★★☆
			</div>
		</div>

		<button class="w3-button w3-display-left w3-black"
			onclick="plusDivs(-1)">&#10094;</button>
		<button class="w3-button w3-display-right w3-black"
			onclick="plusDivs(1)">&#10095;</button>

	</div>
	<br style="line-height: 20;">



	<!-- end of gallery -->



	<!--  설명 -->
	<!-- about -->

	<div class="w3-container w3-content w3-center w3-padding-48"
		style="max-width: 1200px" id="about">
		<h1 class="w3-wide">ABOUT US</h1>
		<p class="w3-opacity">
			<i>We Care about our Planet Earth!</i>
		</p>
		<hr style="border: 2px solid black">
		<Br> <br>
		<p class="w3-justify">We have created a fictional band website.
			Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
			eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
			ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
			aliquip ex ea commodo consequat. Duis aute irure dolor in
			reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
			pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
			culpa qui officia deserunt mollit anim id est laborum consectetur
			adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
			magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation
			ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
	</div>
	<br style="line-height: 20;">

	<!-- end of about -->


	<!-- 만든사람 -->
	<!-- founders -->

	<div id="founders"
		class="w3-container w3-content w3-center w3-padding-48"
		style="max-width: 1200px; height: 700px;">
		<h1 class="w3-wide">FOUNDERS OF XENO-CHARGER</h1>
		<p class="w3-opacity">
			<i>We have to protect our mother Earth!</i>
		</p>
		<hr style="border: 2px solid black">
		<div class="w3-row w3-padding-32">
			<div class="w3-third">
				<img src="images/founders/founder1.jpg" class="w3-round"
					alt="Random Name" style="width: 60%">
				<p>CHOI</p>
				<p class="w3-opacity">
					<i>FOUNDER, CEO, ENGINEER, PLAYBOY</i>
				</p>
			</div>
			<div class="w3-third">
				<img src="images/founders/founder1.jpg" class="w3-round"
					alt="Random Name" style="width: 60%">
				<p>HONG</p>
				<p class="w3-opacity">
					<i>FOUNDER , DESIGNER</i>
				</p>
			</div>
			<div class="w3-third">
				<img src="images/founders/founder1.jpg" class="w3-round"
					alt="Random Name" style="width: 60%">
				<p>JJONG</p>
				<p class="w3-opacity">
					<i>DOG</i>
				</p>
			</div>
		</div>
	</div>
	<br style="line-height: 20;">

	<!-- end of founders -->


	<!-- modal -->


	<!-- 로그인 모달 -->
	<!-- modal / id=login / POST : name=id, password / hidden : value-->

	<div class="w3-container w3-text-white">
		<div id="login" class="w3-modal">
			<div class="w3-modal-content w3-animate-right w3-card-4"
				style="max-width: 400px; height: 620px; background-color: black; border: 1px solid white;">
				<div class="w3-center">
					<br> <img src="images/login/login6.jpg" alt="login"
						style="width: 70%; height: 70%;" class="w3-hover-sepia w3-margin">
				</div>
				<form class="w3-container"
					action="${pageContext.request.contextPath}/memberController"
					method="POST">
					<div class="w3-section">
						<div class="w3-padding" style="margin: auto; text-align: center;">UserID</div>
						<input
							style="width: 100%; margin: auto; border: 1px solid white; background-color: white;"
							class="w3-input w3-center" type="text" name="userId" required>
						<div class="w3-padding" style="margin: auto; text-align: center;">PassWord</div>
						<input
							style="width: 100%; margin: auto; border: 1px solid white; background-color: white;"
							class="w3-input w3-center" type="password" name="userPassword"
							required> <br> <br> <br> <input
							type="hidden" name="command" value="login">
						<button style="backgrond-color:; width: 50%; float: left;"
							class="w3-button w3-padding w3-hover-black" type="submit">
							<img style="width: 90px; height: 90px;" class="w3-hover-sepia"
								src="images/login/open11.jpg">
						</button>
						<button style="background-color:; width: 50%; float: left;"
							class="w3-button w3-padding w3-hover-black"
							onclick="document.getElementById('login').style.display='none'"
							type="button">
							<img style="width: 90px; height: 90px;" class="w3-hover-sepia"
								src="images/login/exit1.jpg">
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- end of modal / id=login -->


	<!-- 회원가입 모달 -->
	<!-- modal id="signup" / hidden command="signup" / parameter name = id, password, name, phone, check1, check2 -->

	<div class="w3-container w3-text-white">
		<div id="signup" class="w3-modal">
			<div class="w3-modal-content w3-animate-right w3-card-4 w3-center"
				style="max-width: 400px; height: 760px; background-color: black; border: 1px solid white;">
				<div class="w3-center">
					<br> <img src="images/login/open8-2.JPG" alt="login"
						style="width: 70%; height: 70%;" class="w3-hover-sepia w3-margin">
				</div>
				<form class="w3-container"
					action="${pageContext.request.contextPath}/memberController"
					method="POST">
					<div class="w3-section">
						<div class="w3-padding" style="margin: auto; text-align: center;">UserID</div>
						<input
							style="width: 100%; margin: auto; border: 1px solid white; background-color: white;"
							class="w3-input" type="text" name="userId" required>

						<div class="w3-padding" style="margin: auto; text-align: center;">PassWord</div>
						<input
							style="width: 100%; margin: auto; border: 1px solid white; background-color: white;"
							class="w3-input" type="password" name="userPassword" required>
						<div class="w3-padding" style="margin: auto; text-align: center;">UserName</div>
						<input
							style="width: 100%; margin: auto; border: 1px solid white; background-color: white;"
							class="w3-input" type="text" name="userNm" required>
						<div class="w3-padding" style="margin: auto; text-align: center;">PhoneNumber</div>
						<input
							style="width: 100%; margin: auto; border: 1px solid white; background-color: white;"
							class="w3-input" type="text" name="userPhoneNo" required>
						<br>

						<div class=" w3-padding w3-center">
							<select class="w3-select w3-border w3-padding">
								<option value="1" selected>city_high</option>

							</select> <select class="w3-select w3-border w3-padding"
								style="margin-top: 15px;" name="cityMiddleNoFk">
								<option value="1" selected>city_middle</option>
							</select>
						</div>


						<input type="hidden" name="command" value="signup">
						<button style="backgrond-color:; width: 50%; float: left;"
							class="w3-button w3-padding w3-hover-black" type="submit">
							<img style="width: 90px; height: 90px;" class="w3-hover-sepia"
								src="images/login/open10.jpg" alt="open">
						</button>

						<button style="background-color:; width: 50%; float: left;"
							class="w3-button w3-padding w3-hover-black"
							onclick="document.getElementById('signup').style.display='none'"
							type="button">
							<img style="width: 90px; height: 90px;" class="w3-hover-sepia"
								src="images/login/exit1.jpg" alt="">
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- end of modal / id="sign up" / -->

	<script>
	
		var slideIndex = 1;
		showDivs(slideIndex);
	
		function plusDivs(n) {
			showDivs(slideIndex += n);
		}
	
		function showDivs(n) {
			var i;
			var x = document.getElementsByClassName("mySlides");
			if (n > x.length) {
				slideIndex = 1
			}
			if (n < 1) {
				slideIndex = x.length
			}
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			x[slideIndex - 1].style.display = "block";
		}
	</script>
</body>
</html>