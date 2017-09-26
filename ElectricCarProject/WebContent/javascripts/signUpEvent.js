/**
 * 
 */
/* CITY_HIGH_TB에 있는 시의 정보 리스트 가져오는 비동기 함수*/
function signUpLoadByCityHigh(){
	sendRequest(getContextPath() + '/asyncController', 'kinds=clickHigh', signUpCityHighAjaxDomController, 'POST');
}

/* loadByCityHigh()에서 사용하는 콜백 함수 */
function signUpCityHighAjaxDomController(){
    if(httpRequest.readyState ==4 && httpRequest.status == 200){
    	document.getElementById("sign_city_high").innerHTML = '';
        var jsonData = JSON.parse(httpRequest.responseText);
        var msg = '';
        for(var i = 0 ; i< jsonData.data.length; i++){
        	msg = msg + `<option value='${jsonData.data[i].cityHighNoPk}'>${jsonData.data[i].cityHighNm}</option>`;
        }
        
        document.getElementById("sign_city_high").innerHTML = msg;
        
    }
}


/* CITY_MIDDLE_TB에 있는 시군구 정보 리스트 가져오는 비동기 함수*/
function signUpLoadByCityMiddle(){
	var cityHigh = document.getElementById("sign_city_high").selectedIndex;
	var optionValue = document.getElementsByTagName("option")[cityHigh].value;
	sendRequest(getContextPath() + '/asyncController', 'kinds=clickMiddle&check=' + optionValue, signUpCityMiddleAjaxDonController, 'POST');
}

/* loadByCityMiddle()에서 사용하는 콜백 함수 */
function signUpCityMiddleAjaxDonController(){
	document.getElementById("sign_city_middle").innerHTML = '';
    var jsonData = JSON.parse(httpRequest.responseText);
    var msg = '';
    for(var i = 0 ; i< jsonData.data.length; i++){
    	msg = msg + `<option value='${jsonData.data[i].cityMiddleNoPk}'>${jsonData.data[i].cityMiddleNm}</option>`;
    }
    
    document.getElementById("sign_city_middle").innerHTML = msg;
}
