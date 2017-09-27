


function chartHigh() {
	
	sendRequest(getContextPath() + '/chartDraw',"command=high", chartHighStart , 'GET');
	
}
function chartHighStart(){
	if (httpRequest.readyState == 4 && httpRequest.status == 200) {
		var jsonData = {
		        "type": "serial",
		        "theme": "light",
		        "marginRight": 70,
		        "valueAxes": [{
		            "axisAlpha": 0,
		            "position": "left",
		            "title": "도시별 충전소 갯수"
		        }],
		        "startDuration": 1,
		        "graphs": [{
		            "balloonText": "<b>[[category]]: [[value]]</b>",
		            "fillColorsField": "color",
		            "fillAlphas": 0.9,
		            "lineAlpha": 0.2,
		            "type": "column",
		            "valueField": "visits"
		        }],
		        "chartCursor": {
		            "categoryBalloonEnabled": false,
		            "cursorAlpha": 0,
		            "zoomable": false
		        },
		        "categoryField": "country",
		        "categoryAxis": {
		            "gridPosition": "start",
		            "labelRotation": 45
		        },
		        "export": {
		            "enabled": true
		        }
		    };
		
		console.log(httpRequest.responseText);
		var requestData = JSON.parse(httpRequest.responseText);
		jsonData.dataProvider = requestData.dataProvider;
		console.log(jsonData);
		var chart = AmCharts.makeChart("chartdiv", jsonData);
	}
}

chartHigh();