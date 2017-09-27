<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</head>
<body>
	
	<!-- bar -->
	
	<div class="w3-bar w3-black" style="position: fixed; z-index: 1000;">
		<a href="../index.jsp"><div class="w3-bar-item w3-hover-red">메인으로</div></a>
		<a href="informationView.jsp"><div class="w3-bar-item w3-hover-pink">회원정보</div></a>
		<a href="modifyInformationView.jsp"><div class="w3-bar-item w3-hover-blue">회원정보수정</div></a>
		<a href="myFavoriteView.jsp"><div class="w3-bar-item w3-hover-green">즐겨찾기</div></a>
		<a href="../memberController?command=logout"><div class="w3-bar-item w3-hover-white w3-right">LOGOUT</div></a>
	</div>
	
	<!--end of bar  -->
	
	<!-- The Section -->
	
	<div class="w3-container w3-content w3-center w3-padding-32"
		style="max-width: 90%">
		<h2 class="w3-wide">MY PAGE</h2>
		<p class="w3-opacity">
			<i>This is my Page. You can check out your own Stuff!</i>
		</p>
		<hr style="border:2px solid black;">

	<!-- 실제 컨텐츠 시작 -->



	<!-- 실제 컨텐츠 끝 -->

	</div>

	<!-- end of The Section -->
	
	
</body>
</html>