var httpRequest = null;

function sendRequest(url, params, callback, method) {
    httpRequest = new XMLHttpRequest();
    var httpMethod = method.toUpperCase();
    if (httpMethod != 'GET' && httpMethod != 'POST') {
        httpMethod = 'GET';
    }
    var httpParams = (params == null || params == '') ? null : params;
    var httpUrl = url;
    if (httpMethod == 'GET' && httpParams != null) {
        httpUrl = httpUrl + "?" + httpParams;
    }
    httpRequest.open(httpMethod, httpUrl, true);
    httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    httpRequest.onreadystatechange = callback;
    httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}


/* CITY_HIGH_TB에 있는 시의 정보 리스트 가져오는 비동기 함수*/
function loadByCityHigh(){
	sendRequest(getContextPath() + '/asyncController', 'kinds=clickHigh', cityHighAjaxDomController, 'POST');
}

/* loadByCityHigh()에서 사용하는 콜백 함수 */
function cityHighAjaxDomController(){
    if(httpRequest.readyState ==4 && httpRequest.status == 200){
    	document.getElementById("city_high").innerHTML = '';
        var jsonData = JSON.parse(httpRequest.responseText);
        var msg = '';
        for(var i = 0 ; i< jsonData.data.length; i++){
        	msg = msg + `<option value='${jsonData.data[i].cityHighNoPk}'>${jsonData.data[i].cityHighNm}</option>`;
        }
        
        document.getElementById("city_high").innerHTML = msg;
        
    }
}


/* CITY_MIDDLE_TB에 있는 시군구 정보 리스트 가져오는 비동기 함수*/
function loadByCityMiddle(){
	var cityHigh = document.getElementById("city_high").selectedIndex;
	var optionValue = document.getElementsByTagName("option")[cityHigh].value;
	
	sendRequest(getContextPath() + '/asyncController', 'kinds=clickMiddle&check=' + optionValue, cityMiddleAjaxDonController, 'POST');
}

/* loadByCityMiddle()에서 사용하는 콜백 함수 */
function cityMiddleAjaxDonController(){
	document.getElementById("city_middle").innerHTML = '';
    var jsonData = JSON.parse(httpRequest.responseText);
    console.log(jsonData);
    var msg = '';
    for(var i = 0 ; i< jsonData.data.length; i++){
    	msg = msg + `<option value='${jsonData.data[i].cityMiddleNoPk}'>${jsonData.data[i].cityMiddleNm}</option>`;
    }
    
    document.getElementById("city_middle").innerHTML = msg;
}

/* search 버튼 클릭시 이벤트*/
function sendSearch(){
	
	sendRequest(stationController,a,b,c);
	
}


/* 절대 경로 구하기 */
function getContextPath(){
    var offset=location.href.indexOf(location.host)+location.host.length;
    var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}
