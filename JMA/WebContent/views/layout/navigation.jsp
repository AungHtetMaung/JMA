<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./css/DropDownDiv.css" type="text/css" rel="stylesheet" />
<title>Insert title here</title>
<%-- <script type="text/javascript">
/* var currenttime = 'March 31, 2012 04:55:07'; */
var currenttime = <%= new Date().getTime() %>
var serverdate=new Date(currenttime);

function padlength(what){

	var output=(what.toString().length==1)? "0"+what : what;

	return output;

}

function displaytime(){

	serverdate.setSeconds(serverdate.getSeconds()+1);

	var timestring=padlength(serverdate.getHours())+":"+padlength(serverdate.getMinutes())+":"+padlength(serverdate.getSeconds());
	var datestring=serverdate.getDay();
	document.getElementById("servertime").innerHTML=timestring;
	document.getElementById("serverday").innerHTML=datestring;
}

window.onload=function(){

	setInterval("displaytime()", 1000);

}
</script> --%>
<script>
function startTime() {
	var serverdate = "<%= new Date(System.currentTimeMillis()).toLocaleString().toString() %>";	 
    var today=new Date();
    var h=today.getHours();
    var m=today.getMinutes();
    var s=today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('txt').innerHTML =h+":"+m+":"+s+"<br> Server Time:"+serverdate;
    var t = setTimeout(function(){startTime()},500);
}

function checkTime(i) {
    if (i<10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}
</script>
</head>
<body onload="startTime()">
<s:url action="fetch" var="fetch"></s:url>
<s:url action="viewItem" var="viewitem"></s:url>
<s:url action="adminLogin" var="home"></s:url>
<s:url action="reportGenerate" var="report"></s:url>
<s:url action="logout" var="logout"></s:url>


<div id="menu_div" align="left" class="navbar navbar-default">
	<div align="left">	
	<ul class="nav navbar-nav">
		<li>
			<a href=""><img alt="Logo" width="40%" height="35%" src="img/layer.png"></a>
		</li>
		<li><a href="" >Sales</a>

		<ul class="sub-menu">
			<li><a href="">Pages</a></li>
			<li><a href="">Archives</a></li>
			<li><a href="">New Posts</a></li>
			<li><a href="">Recent Comments</a></li>
		</ul>

		</li>

		<li><a href="">Item</a>

		<ul class="sub-menu">
			<li><a href="">Get to know us</a></li>
			<li><a href="">Find out what we do</a></li>
		</ul>

		</li>

		<li><a href="">Tools</a>

		<ul class="sub-menu">
			<li><a href="">E-mail Us</a></li>
			<li><a href="">Use Our Contact Form</a></li>
		</ul>

		</li>
		<li><a href="">Inventory</a>

		<ul class="sub-menu">
			<li><a href="">E-mail Us</a></li>
			<li><a href="">Use Our Contact Form</a></li>
		</ul>

		</li>
		<li><a href="">Report</a>

		<ul class="sub-menu">
			<li><a href="">E-mail Us</a></li>
			<li><a href="">Use Our Contact Form</a></li>
		</ul>

		</li>
		<li><a href="">Aung Htet Maung</a>

		<ul class="sub-menu">
			<li><a href="logout.action">Log Out</a></li>
			<li><a href="">User Setting</a></li>
		</ul>

		</li>
	</ul>
	<div align="right" id="txt" class="date">
	
	</div>
	</div>
</div>
</body>
</html>