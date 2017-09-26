<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/bar_a.css">
<link rel="stylesheet" href="css/search.css">
<script src="script.js"></script>
<title>index.html</title>
</head>
<body>

	<!-- bars -->

	<!-- before bar -->
	<div class="w3-bar w3-black" style="position: fixed; z-index: 1000;">
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
	</div>

	<!-- after bar -->
	<!-- <div class="w3-bar w3-black">
  <div class="w3-bar-item w3-hover-red">HOME</div>
  <div class="w3-bar-item w3-hover-green">ABOUT</div>
  <div class="w3-bar-item w3-hover-blue">GALLERY</div>
  <div class="w3-bar-item w3-hover-yellow">FOUNDERS</div>
  <div class="w3-bar-item w3-hover-pink">SEARCH CHARGER</div>
  <div class="w3-bar-item w3-hover-grey">LOGOUT</div>
  <div class="w3-bar-item w3-hover-white">MYPAGE</div>
</div> -->

	<!-- admin bar -->
	<!-- <div class="w3-bar w3-black">
  <div class="w3-bar-item w3-hover-red">HOME</div>
  <div class="w3-bar-item w3-hover-green"></div>
  <div class="w3-bar-item w3-hover-blue"></div>
  <div class="w3-bar-item w3-hover-yellow"></div>
  <div class="w3-bar-item w3-hover-pink">SEARCH CHARGER</div>
  <div class="w3-bar-item w3-hover-grey">LOGOUT</div>
  <div class="w3-bar-item w3-hover-white">MANAGE</div>
</div> -->

	<!-- end of bars -->

	<!-- header -->

	<!-- class="w3-display-container w3-content w3-wide"  -->


	<header style="max-width: 100%;" id="home">
		<div class="w3-display-container w3-text-white">
			<img style="width: 100%; height:;" src="img/header/header7.jpg">
			<div class="w3-display-middle w3-large">Middle</div>
			<div class="w3-display-middle w3-margin-top">
				<h1 class="w3-xxlarge w3-text-white">
					<span class="w3-xxxlarge w3-padding w3-black w3-opacity-min"><b>Xeno-Charger</b></span>
				</h1>
			</div>
		</div>
	</header>

	<!-- end of header -->


	<!-- search charger / hidden value = typeSearch -->

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
			<input class="search w3-center" type="text" name="search"
				placeholder="Search..">
			<input type="hidden" name="command" value="wordSearch">
			<button type="submit" class="w3-btn w3-black"
				style="margin-left: 10px; margin-bottom: 5px;">GO!</button>
		</form>
		<!-- end of search bar  -->

	</div>

	<!-- select search / hidden value = selectSearch / name:city_high, city_middle / value:1~12 -->

	<div class="w3-cell-row w3-center" style="width: 80%; margin: auto;">

		<div class="w3-container w3-cell" style="width: 35%">
			<form class="w3-container w3-card-4"
				style="padding-top: 20px; font-size: 14px;" action="${pageContext.request.contextPath}/stationController">
				<select class="w3-select w3-border w3-padding" name="city_high">
					<option value="" disabled selected>city_high</option>
					<option value="1">서울특별시</option>
					<option value="2">강원도</option>
					<option value="3">경기도</option>
					<option value="4">경상도</option>
					<option value="5">광주광역시</option>
					<option value="6">대구광역시</option>
					<option value="7">대전광역시</option>
					<option value="8">부산광역시</option>
					<option value="9">울산광역시</option>
					<option value="10">전라도</option>
					<option value="11">제주도</option>
					<option value="12">충청도</option>
				</select> <select class="w3-select w3-border w3-padding"
					style="margin-top: 15px;" name="city_middle">
					<option value="" disabled selected>city_middle</option>
				</select> <input type="hidden" name="command" value="selectSearch">
				<button class="w3-btn w3-black w3-right w3-margin w3-padding"
					type="submit">Search</button>
			</form>
		</div>

		<div class="w3-container w3-cell" style="width: 70%">
			<!-- 검색된 테이블 id=resultTable -->
			<div id="resultTable" class="w3-container">
				<table class="w3-table-all">
					<thead>
						<tr class="w3-black w3-text-yellow">
							<th>charger_NO</th>
							<th>cs_CODE_CD</th>
							<th>cp_unique_NO</th>
							<th>cp_Name_CD</th>
							<th>cp_Stat_CD</th>
							<th>cp_Type_CD</th>
							<th>charger_Type</th>
							<th>city_LOW</th>
						</tr>
					</thead>
					<tr>
						<td>a</td>
						<td>a</td>
						<td>a</td>
						<td>a</td>
						<td>a</td>
						<td>a</td>
						<td>a</td>
						<td>a</td>
					</tr>
				</table>
			</div>


			<!-- end of 검색된 테이블 -->

		</div>
	</div>
	<br style="line-height: 20;">

	<!-- end of select search -->

	<script>
		function myMap() {
			myCenter = new google.maps.LatLng(37.5, 127);
			var mapOptions = {
				center : myCenter,
				zoom : 5,
				scrollwheel : true,
				draggable : true,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};
			var map = new google.maps.Map(document.getElementById("googleMap"), mapOptions);
	
			var marker = new google.maps.Marker({
				position : myCenter,
			});
			marker.setMap(map);
		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBjvtC_0Hr83DsKOtKr0oamgTdwyBtcuho&callback=myMap"></script>

	<!-- end of search charger -->


	<!-- gallery -->

	<div class="w3-container w3-content w3-center w3-padding-48"
		style="max-width: 1200px" id="gallery">
		<h2>GALLERY</h2>
		<p class="w3-opacity"></p>
		<hr style="border: 2px solid black">
	</div>

	<div class="w3-content w3-display-container">

		<div class="w3-display-containe mySlides">
			<img src="img/slideCharger/charger1.jpg"
				style="width: 980px; height: 600px;">
			<div
				class="w3-display-bottommiddle w3-xlarge w3-container w3-padding-16 w3-black">
				서울특별시 강남구 서초대로34 스테이션 <br> 평점 : ★★★★☆
			</div>
		</div>

		<div class="w3-display-containe mySlides">
			<img src="img/slideCharger/charger2.jpg"
				style="width: 980px; height: 600px;">
			<div
				class="w3-display-bottommiddle w3-xlarge w3-container w3-padding-16 w3-black">
				강원도 춘천시 효자로87 스테이션 <br> 평점 : ★★★★★
			</div>
		</div>

		<div class="w3-display-containe mySlides">
			<img src="img/slideCharger/charger3.jpg"
				style="width: 980px; height: 600px;">
			<div
				class="w3-display-bottommiddle w3-xlarge w3-container w3-padding-16 w3-black">
				전라북도 익산시 익산대로34-3 스테이션 <br> 평점 : ★★★☆
			</div>
		</div>

		<div class="w3-display-containe mySlides">
			<img src="img/slideCharger/charger4.jpg"
				style="width: 980px; height: 600px;">
			<div
				class="w3-display-bottommiddle w3-xlarge w3-container w3-padding-16 w3-black">
				강원도 강릉시 강남대로13 스테이션 <br> 평점 : ★★★☆
			</div>
		</div>

		<div class="w3-display-containe mySlides">
			<img src="img/slideCharger/charger5.jpg"
				style="width: 980px; height: 600px;">
			<div
				class="w3-display-bottommiddle w3-xlarge w3-container w3-padding-16 w3-black">
				경상남도 울산시 방이대로77 스테이션 <br> 평점 : ★★★☆
			</div>
		</div>

		<div class="w3-display-containe mySlides">
			<img src="img/slideCharger/charger6.jpg"
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

	<!-- end of gallery -->

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
				<img src="img/founders/founder1.jpg" class="w3-round"
					alt="Random Name" style="width: 60%">
				<p>CHOI</p>
				<p class="w3-opacity">
					<i>FOUNDER, CEO, ENGINEER, PLAYBOY</i>
				</p>
			</div>
			<div class="w3-third">
				<img src="img/founders/founder1.jpg" class="w3-round"
					alt="Random Name" style="width: 60%">
				<p>HONG</p>
				<p class="w3-opacity">
					<i>FOUNDER , DESIGNER</i>
				</p>
			</div>
			<div class="w3-third">
				<img src="img/founders/founder1.jpg" class="w3-round"
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


	<!-- modal / id=login / POST : name=id, password / hidden : value-->

	<div class="w3-container w3-text-white">
		<div id="login" class="w3-modal">
			<div class="w3-modal-content w3-animate-right w3-card-4"
				style="max-width: 400px; height: 620px; background-color: black; border: 1px solid white;">
				<div class="w3-center">
					<br> <img src="img/login/login6.jpg" alt="login"
						style="width: 70%; height: 70%;" class="w3-hover-sepia w3-margin">
				</div>
				<form class="w3-container" action="${pageContext.request.contextPath}/memberController" method="POST">
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
								src="img/login/open11.jpg">
						</button>
						<button style="background-color:; width: 50%; float: left;"
							class="w3-button w3-padding w3-hover-black"
							onclick="document.getElementById('login').style.display='none'"
							type="button">
							<img style="width: 90px; height: 90px;" class="w3-hover-sepia"
								src="img/login/exit1.jpg">
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- end of modal / id=login -->

	<!-- modal id="signup" / hidden command="signup" / parameter name = id, password, name, phone, check1, check2 -->

	<div class="w3-container w3-text-white">
		<div id="signup" class="w3-modal">
			<div class="w3-modal-content w3-animate-right w3-card-4 w3-center"
				style="max-width: 400px; height: 760px; background-color: black; border: 1px solid white;">
				<div class="w3-center">
					<br> <img src="img/login/open8-2.JPG" alt="login"
						style="width: 70%; height: 70%;" class="w3-hover-sepia w3-margin">
				</div>
				<form class="w3-container" action="${pageContext.request.contextPath}/memberController" method="POST">
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

							</select>
							<select class="w3-select w3-border w3-padding"
								style="margin-top: 15px;" name="cityMiddleNoFk">
								<option value="1" selected>city_middle</option>
							</select>
						</div>


						<input type="hidden" name="command" value="signup">
						<button style="backgrond-color:; width: 50%; float: left;"
							class="w3-button w3-padding w3-hover-black" type="submit">
							<img style="width: 90px; height: 90px;" class="w3-hover-sepia"
								src="img/login/open10.jpg" alt="open">
						</button>

						<button style="background-color:; width: 50%; float: left;"
							class="w3-button w3-padding w3-hover-black"
							onclick="document.getElementById('signup').style.display='none'"
							type="button">
							<img style="width: 90px; height: 90px;" class="w3-hover-sepia"
								src="img/login/exit1.jpg" alt="">
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- end of modal / id="sign up" / -->






</body>
</html>