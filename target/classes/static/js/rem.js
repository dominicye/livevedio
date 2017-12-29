	(function(win, lib) {
		var doc = win.document;
		var docEl = doc.documentElement;
		var metaEl = doc.querySelector('meta[name="viewport"]');
		var flexibleEl = doc.querySelector('meta[name="flexible"]');
		var dpr = 0;
		var scale = 0;
		var tid;
		var flexible = lib.flexible || (lib.flexible = {});

		if(metaEl) {
			console.warn('将根据已有的meta标签来设置缩放比例');
			var match = metaEl.getAttribute('content').match(/initial\-scale=([\d\.]+)/);
			if(match) {
				scale = parseFloat(match[1]);
				dpr = parseInt(1 / scale);
			}
		} else if(flexibleEl) {
			var content = flexibleEl.getAttribute('content');
			if(content) {
				var initialDpr = content.match(/initial\-dpr=([\d\.]+)/);
				var maximumDpr = content.match(/maximum\-dpr=([\d\.]+)/);
				if(initialDpr) {
					dpr = parseFloat(initialDpr[1]);
					scale = parseFloat((1 / dpr).toFixed(2));
				}
				if(maximumDpr) {
					dpr = parseFloat(maximumDpr[1]);
					scale = parseFloat((1 / dpr).toFixed(2));
				}
			}
		}

		if(!dpr && !scale) {
			var isAndroid = win.navigator.appVersion.match(/android/gi);
			var isIPhone = win.navigator.appVersion.match(/iphone/gi);
			var devicePixelRatio = win.devicePixelRatio;
			if(isIPhone) {
				// iOS下，对于2和3的屏，用2倍的方案，其余的用1倍方案
				if(devicePixelRatio >= 3 && (!dpr || dpr >= 3)) {
					dpr = 3;
				} else if(devicePixelRatio >= 2 && (!dpr || dpr >= 2)) {
					dpr = 2;
				} else {
					dpr = 1;
				}
			} else {
				// 其他设备下，仍旧使用1倍的方案
				dpr = 1;
			}
			scale = 1 / dpr;
		}

		docEl.setAttribute('data-dpr', dpr);
		if(!metaEl) {
			metaEl = doc.createElement('meta');
			metaEl.setAttribute('name', 'viewport');
			metaEl.setAttribute('content', 'initial-scale=' + scale + ', maximum-scale=' + scale + ', minimum-scale=' + scale + ', user-scalable=no');
			if(docEl.firstElementChild) {
				docEl.firstElementChild.appendChild(metaEl);
			} else {
				var wrap = doc.createElement('div');
				wrap.appendChild(metaEl);
				doc.write(wrap.innerHTML);
			}
		}

		function refreshRem() {
			var width = docEl.getBoundingClientRect().width;
			if(width / dpr > 750) {
				width = 750 * dpr;
			}
			var rem = width / 10;
			docEl.style.fontSize = rem + 'px';
			flexible.rem = win.rem = rem;
		}

		win.addEventListener('resize', function() {
			clearTimeout(tid);
			tid = setTimeout(refreshRem, 300);
		}, false);
		win.addEventListener('pageshow', function(e) {
			if(e.persisted) {
				clearTimeout(tid);
				tid = setTimeout(refreshRem, 300);
			}
		}, false);

		if(doc.readyState === 'complete') {
			doc.body.style.fontSize = 12 * dpr + 'px';
		} else {
			doc.addEventListener('DOMContentLoaded', function(e) {
				doc.body.style.fontSize = 12 * dpr + 'px';
			}, false);
		}

		refreshRem();

		flexible.dpr = win.dpr = dpr;
		flexible.refreshRem = refreshRem;
		flexible.rem2px = function(d) {
			var val = parseFloat(d) * this.rem;
			if(typeof d === 'string' && d.match(/rem$/)) {
				val += 'px';
			}
			return val;
		}
		flexible.px2rem = function(d) {
			var val = parseFloat(d) / this.rem;
			if(typeof d === 'string' && d.match(/px$/)) {
				val += 'rem';
			}
			return val;
		}
		//console.log(doc.body.style.fontSize)
	})(window, window['lib'] || (window['lib'] = {}));

	//ajax 地址前缀前缀
	function localhost() {
		if(window.location.protocol == "http:") {
			 var localhost = "http://192.168.14.251:8888/"
			  		// var localhost="http://192.168.0.202:8010/xyjr-font-web/"
			//  		var localhost="http://192.168.0.55/xyjr-font-web/"
//			var localhost = "http://192.168.0.8:8080/xyjr-font-web/"
//			var localhost = "http://192.168.0.37:8080/xyjr-font-web/"
		} else {
						//  var localhost = "https://192.168.0.202/xyjr-font-web/"
						 var localhost = "http://192.168.14.251:8888/"
			//			 var localhost = "https://192.168.0.55/xyjr-font-web/"
//			var localhost = "https://192.168.0.8/xyjr-font-web/"
//			var localhost = "https://192.168.0.37/xyjr-font-web/"
		}
		//		var localhost = "http://192.168.0.202:8010/xyjr-font-web/userInfo/";
		//	 var localhost = "http://xyjr.xianyulc.com/XYJRWeb/userInfo/";
		//	var localhost="http://192.168.0.6:8080/XYJRWeb/userInfo/";
		// var localhost="http://192.168.0.55:80/xyjr-font-web"
		return localhost;
	}


	



	//url切割
	var url = window.location.href;

	function parseQueryString(url) {
		var obj = {};
		var keyvalue = [];
		var key = "",
			value = "";
		var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
		for(var i in paraString) {
			keyvalue = paraString[i].split("=");
			key = keyvalue[0];
			value = keyvalue[1];
			obj[key] = value;
		}
		return obj;
	}
		/* 当前页面高度 */
		function bodyHeight() {
			return document.body.scrollHeight;
		}
		/* 当前页面宽度 */
		function bodyWidth() {
			return document.body.scrollWidth;
		}

		function screenWidth() {
			return window.screen.width;
		}

		function screenHeight() {
			return window.screen.height;
		}

		function pageHeight() {
			return window.screen.availHeight;
		}

		function pageWidth() {
			return window.screen.availWidth;
		}


//		获取特定时间时间戳
function time(stringTime){
	var timestamp2 = Date.parse(new Date(stringTime))/ 1000;
//	console.log(stringTime + "的时间戳为：" + timestamp2);
	return timestamp2;
}

// 获取窗口高度
if (window.innerHeight)
winHeight = window.innerHeight;
else if ((document.body) && (document.body.clientHeight))
winHeight = document.body.clientHeight;
console.log(winHeight)
//s为数字
//n为保留几位小数
function fmoney(s, n) {
	n = n > 0 && n <= 20 ? n : 2;
	s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
	var l = s.split(".")[0].split("").reverse(),
		r = s.split(".")[1];
	t = "";
	for(i = 0; i < l.length; i++) {
		t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
	}
	return t.split("").reverse().join("") + "." + r;
}
//       获取当前时间戳(以s为单位)
var todayTime = Date.parse(new Date())/ 1000;
todayTime = parseInt(todayTime);
	var Time1 = time("2017-09-18 00:00:00");
	var Time2 = time("2017-09-22 00:00:00");
	var Time3 = time("2017-10-13 00:00:00");
	var Time4 = time("2017-10-28 00:00:00");

    var Time1 = parseInt(1505664000);                   					//"2017-09-18 00:00:00"
    var Time2 = parseInt(1506528000);										//"2017-09-28 00:00:00"
    var Time3 = parseInt(1507824000);										//"2017-10-13 00:00:00"
    var Time4 = parseInt(1509120000);										//"2017-10-28 00:00:00"

		console.log(Time1+" 2017-09-18 00:00:00")
		console.log(Time2+" 2017-09-27 00:00:00")
		console.log(Time3+" 2017-10-13 00:00:00" )
		console.log(Time4+" 2017-10-27 00:00:00")
		console.log("当前时----间戳为：" + todayTime);


		// var Time1 = parseInt(1505664000);                   //"2017-09-18 00:00:00"
		// var Time2 = parseInt(1506009600);										//"2017-09-28 00:00:00"
		// var Time3 = parseInt(1507824000);										//"2017-10-13 00:00:00"
		// var Time4 = parseInt(1509120000);										//"2017-10-28 00:00:00"



