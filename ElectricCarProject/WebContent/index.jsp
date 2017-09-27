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
<link rel="stylesheet" href="stylesheets/ceos.css">
<link rel="stylesheet" href="stylesheets/footer.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="javascripts/script.js"></script>
<script src="javascripts/asyncEvent.js"></script>
<script src="javascripts/signUpEvent.js"></script>
<script src="javascripts/googleMapAsyncEvent.js"></script>
<script src="javascripts/jquery-3.2.1.js"></script>
	
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
			class="w3-bar-item w3-hover-grey w3-right">LOG IN</div>
		<div onclick="document.getElementById('signup').style.display='block'"
			class="w3-bar-item w3-hover-white w3-right">SIGN UP</div>

		<%
			} else if (session.getAttribute("managerKey").equals(new Integer(2))) {
		%>
		<div class="w3-bar-item w3-hover-red">
			<a href="index.jsp">HOME</a>
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
		<div class="w3-bar-item w3-hover-white w3-right">
			<a href="memberController?command=logout">LOGOUT</a>
		</div>

		<%
			} else if (session.getAttribute("managerKey").equals(new Integer(1))) {
		%>
		<div class="w3-bar-item w3-hover-red"><a href="#home">HOME</a></div>
		<div class="w3-bar-item w3-hover-pink"><a href="#search">SEARCH CHARGER</a></div>
		<div class="w3-bar-item w3-hover-blue"><a href="#gallery">GALLERY</a></div>
		<div class="w3-bar-item w3-hover-green"><a href="#about">ABOUT</a></div>
		<div class="w3-bar-item w3-hover-yellow"><a href="#founders">FOUNDERS</a></div>
		<div class="w3-bar-item w3-hover-grey"><a href="${pageContext.request.contextPath}/memberViews/myPageView.jsp">MYPAGE</a></div>
		<div class="w3-bar-item w3-hover-white w3-right"><a href="memberController?command=logout">LOGOUT</a></div>
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

		<div class="w3-bar" style="width:100%; height:70px;  text-align:left;">
			
			<div style="width:15%; margin-left:10px;" class="w3-bar-item"><select  style="width:100%" class="w3-select w3-border" 
				id="city_high" name="city_high" onfocus="loadByCityHigh();"
					onchange="document.getElementById('city_middle').focus();">
					<option value="" disabled selected>도시 선택</option>
				</select></div>
			
			<div style="width:15%;  margin-left:10px;" class="w3-bar-item"><select style="width:100%" class="w3-select w3-border"
					 id="city_middle" name="city_middle"
					onfocus="loadByCityMiddle();">
					<option value="" disabled selected>시/군/구 선택</option>
				</select> <input type="hidden" name="command" value="selectSearch"></div>
			
			<div style="width:10%;  margin-left:10px;" class="w3-bar-item"><button style="width:100%" class="w3-btn w3-black "
					onclick="sendSearch()">Search</button></div>
			
			<div style="width:10%; " class="w3-bar-item w3-right"><button type="submit" style="width:82px; border:1px solid black;" class="w3-btn w3-black">검색</button></div>
			
			<div style="width:39%;  margin-right:10px;" class="w3-bar-item w3-right"><input style="width:100%;border:1px solid black;" class="search w3-center" 
					type="text" name="str"
					placeholder="Search.."> <input type="hidden" name="command"
					value="wordSearch"></div>
		</div>

		
		<!-- end of search bar  -->

	</div>


	<!-- 메인 select Box -->
	<!-- select search / hidden value = selectSearch / name:city_high, city_middle / value:1~12 -->

	<div class="w3-cell-row w3-center" style="width: 80%; margin: auto;">
		<div class="w3-container w3-cell" style="width: 100%">
			<!-- 검색된 테이블 id=resultTable -->
			<div id="resultTable" class="w3-container">
				<table class="w3-table-all" id="cityListTable">
					<thead>
						<tr class="w3-black w3-text-yellow">
							<th style="text-align: center;">번호</th>
							<th style="text-align: center;">충전소</th>
							<th style="text-align: center;">충전기 명칭</th>
							<th style="text-align: center;">충전기 상태</th>
							<th style="text-align: center;">충전 방식</th>
							<th style="text-align: center;">충전기 타입</th>
							<th style="text-align: center;">장소</th>
							<th style="text-align: center;">보기</th>
						</tr>
					</thead>
					<tbody id="tableTbody">

					</tbody>
				</table>
			</div>


			<!-- end of 검색된 테이블 -->

		</div>
	</div>
	<br style="line-height: 20;">
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
		<div class="w3-row w3-padding-32" id="ceos">
			<div class="w3-third">
				<img src="images/founders/ceo1.jpg" class="w3-round"
					alt="Random Name">
				<p>CHOI</p>
				<p class="w3-opacity">
					<i>FOUNDER, CEO, ENGINEER, PLAYBOY</i>
				</p>
				<p style="width: 80%; margin-left: 32px;">CEO 최윤진은 '제노차저'의 전설적인
					창립자로 뛰어난 엔지니어이자 자상한 아버지 훌륭한 남편이기도 하다. 그는 이제 지구의 모든 화석연료가 친환경에너지로
					대체되어야 한다고 말하며 자신의 비전을 위해 과감한 행보를 보이는 젊은 사업가이다. 2036년 뉴욕타임스에서 선정한
					세계에서 가장 영향력있는 '100인의 CEO'에 선정되었으며 전세계에 236개 지점 5만여명의 사원이 그와 함께 나아가고
					있다.</p>
			</div>
			<div class="w3-third">
				<img src="images/founders/ceo3.jpg" class="w3-round"
					alt="Random Name">
				<p>LIELY</p>
				<p class="w3-opacity">
					<i>DOG</i>
				</p>
				<p style="width: 80%; margin-left: 32px;">라일리는 제노차저의 창업 초기부터 함께한
					임원이나 다름 없는 충견이다. 주식회사 제노차저의 지분을 13%소유하고 있다.</p>
			</div>
			<div class="w3-third">
				<img src="images/founders/ceo2.jpg" class="w3-round"
					alt="Random Name">
				<p>HONG</p>
				<p class="w3-opacity">
					<i>DESIGNER</i>
				</p>
				<p style="width: 80%; margin-left: 32px;">주식회사 제노차저의 수석 디자이너로 창업
					원년 멤버이다. 초밥을 좋아한다.</p>
			</div>
		</div>
	</div>
	<br style="line-height: 40;">

	<!-- end of founders -->

	<!-- footer -->

	<div
		style="width: 100%; height: 50px; background-color: yellow; border: 5px solid black;">
		<div class="w3-cell-row">
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
			<div class="w3-cell" id="b"></div>
			<div class="w3-cell" id="y"></div>
		</div>
	</div>

	<footer class="w3-container w3-black w3-center">

		<div>
			<img class="w3-hover-sepia"
				style="margin-top: 110px; width: 280px; height: 165px;"
				src="${pageContext.request.contextPath}/images/login/open.jpg">
		</div>
		<div style="font-size: 20px; margin-top:;">
			<i class="fa fa-battery-three-quarters"></i>&nbsp;제노차저
		</div>


	</footer>

	<!-- end of  footer -->



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
							<select class="w3-select w3-border w3-padding"
								onfocus="signUpLoadByCityHigh();"
								onchange="document.getElementById('sign_city_middle').focus();"
								id="sign_city_high" name="city_high">
								<option disabled selected>시/도</option>

							</select> <select class="w3-select w3-border w3-padding"
								style="margin-top: 15px;" id="sign_city_middle"
								name="city_middle" onfocus="signUpLoadByCityMiddle();">
								<option disabled selected>시/군/구</option>
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