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


function loadByCityHigh(){
	sendRequest('asyncController', 'kinds=clickHigh', cityHighAjaxDomController, 'POST');
}

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

function loadByCityMiddle(){
	var cityHigh = document.getElementById("city_high").selectedIndex;
	var optionValue = document.getElementsByTagName("option")[cityHigh].value;
	
    
	var url = 'asyncController';
    var params = 'kinds=clickMiddle&check=' + optionValue;
    var callback = cityMiddleAjaxDonController;
    var method = 'POST';
	sendRequest(url, params, callback, method);
}

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
