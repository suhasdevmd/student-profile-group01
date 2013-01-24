<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
   "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>

<link href="default.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="language" content="english">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">

<title></title>



<script type="text/javascript">
	var preloads = [];

	function preload() {
		for ( var c = 0; c < arguments.length; c++) {
			preloads[preloads.length] = new Image();
			preloads[preloads.length - 1].src = arguments[c];

		}

	}
	preload(
			'images/img04.jpg',
			'images/img04.jpg',
			'images/img04.jpg',
			'images/img04.jpg'); /* add your images here*/

	function init() {

		url = [ '#', '#', '#', '#', '#', '#' ]; /* add your  links here */

		speed = 100; /* this is the scroll speed */
		boxWidth = 5/ preloads.length; /* this is the scroller box width controller */

		pic = [];
		anc = [];
		dv = [];
		obj1 = document.getElementById('out');

		for (i = 0; i < 2; i++) {
			dv[i] = document.createElement('div');
			dv[i].setAttribute('id', 'inner' + i);
			for (c = 0; c < preloads.length; c++) {
				pic[c] = document.createElement('img');
				pic[c].setAttribute('src', preloads[c].src);
				anc[c] = document.createElement('a');
				anc[c].setAttribute('href', url[c]);
				anc[c].appendChild(pic[c]);
				dv[i].appendChild(anc[c]);
			}
			obj1.appendChild(dv[i])
		}
		obj1.style.display = 'block';

		obj2 = document.getElementById('inner0');
		obj3 = document.getElementById('inner1');

		k = obj3.offsetWidth;

		obj2.style.width = obj3.style.right = obj3.style.width = k + 'px';

		obj1.style.width = k * boxWidth + 'px';
		obj1.style.height = obj2.offsetHeight + 'px';

		j = 0;
		n = k;

		scroll();

		obj1.onmouseover = function() {
			clearTimeout(scroller);

		}

		obj1.onmouseout = function() {
			return scroll();
		}
	}

	function scroll() {
		if (j == -n) {
			j = n;
		}
		j--;
		if (k == -n) {
			k = n;
		}
		k--;

		obj2.style.left = j + 'px';
		obj3.style.left = k + 'px';

		scroller = setTimeout(function() {
			scroll()
		}, speed);
	}
	if (window.addEventListener) {
		window.addEventListener('load', init, false);
	} else {
		if (window.attachEvent) {
			window.attachEvent('onload', init);
		}
	}
</script>

</head>
<body>
	<div id="out"></div>

</body>
</html>