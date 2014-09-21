
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

<!--
Copyright (c) 2013 by Dmitry Semenov (http://codepen.io/dimsemenov/pen/GEKgb)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
-->

  <title>Inline popup - CodePen</title>

  <link rel='stylesheet prefetch' href="../js/magnific-popup/magnific-popup.css">
  <script  type="text/javascript"  src="../js/jquery-1.9.1.js"></script>
  <script src="../js/magnific-popup/jquery.magnific-popup.js"></script>

  <style>.white-popup {
  position: relative;
  background: #FFF;
  padding: 20px;
  width:auto;
  margin: 20px auto;
}</style>

</head>

<body>

  <a href="#test-popup" class="open-popup-link">Show inline popup</a>
  <a href="/views/Login.jsp" class="open-popup-link">JSP</a>
<!--
Alternative markup with data-mfp-src attribute:
<a href="mobile-friendly-page.html" data-mfp-src="#test-popup" class="open-popup-link">Show inline popup</a>
-->

<!-- Popup itself -->
<div id="test-popup" class="white-popup mfp-hide">
  Popup content
</div>

<br/><br/>
<button>Dynamically create and show popup</button>

  


  <script>
    // Example 1: From an element in DOM
    $(function(){
		$('.open-popup-link').magnificPopup({
		  type:'inline',
		  midClick: true // allow opening popup on middle mouse click. Always set it to true if you don't provide alternative source.
		});
		
		// Example: 2 Dynamically created
		$('button').magnificPopup({
			items: {
			    src: '../views/Login.jsp'
			  },
			  type: 'iframe',
			  closeBtnInside: false
		 }); 
		
    }); 
</script>

</body>

</html>