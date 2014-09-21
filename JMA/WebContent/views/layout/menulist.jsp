<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script  type="text/javascript" src="./js/jquery-1.9.1.js"></script>
<script src="./js/popup/popupEmp.js"></script>
<link rel='stylesheet prefetch' href="js/magnific-popup/magnific-popup.css">
<link type="text/css" href="css/theme_interiorNavigation/ui.all.css" rel="Stylesheet" />
<title>Insert title here</title>
<sj:head/>
</head>
<script>
jQuery(document).ready(function() {
$("#accordion > li > div").click(function(){
	 
    if(false == $(this).next().is(':visible')) {
        $('#accordion ul').slideUp(300);
    }
    $(this).next().slideToggle(300);
});
 
$('#accordion ul:eq(0)').show();
});

</script>
	<%-- <style type="text/css">
		.note:hover,
		.note:focus {
		  color: white;
		  background-color: gray;
		  text-decoration: none;font-weight: normal;
		}
		.note{
		  color: white;
		   background-color: gray;		  
		  text-decoration: none;font-weight: normal;
		}
		.note:normal{
		  color: white;
		   background-color: gray;
		  text-decoration: none;font-weight: normal;
		}
		 .ui-state-default a, .ui-state-default a:link, .ui-state-default a:visited {
			 color: white; 
			text-decoration: none;
			}
		.ui-accordion .ui-accordion-content {
				padding: 4px 1px;
				border-top: 0;
				margin-top: -2px;
				position: relative;
				top: 1px;
				margin-bottom: 2px;
				overflow: auto;
				display: none;
				zoom: 1;
				} 
	</style> --%>
<body>
<s:url id="suppliertoadd" action="save"></s:url>
<s:url id="emp" action="emp"></s:url>
<s:url id="product" action="product"></s:url>
<s:url id="supplierlist" action="sups"></s:url>
<s:url id="emplist" action="emps"></s:url>
<s:url id="productlist" action="products"></s:url>
<s:url id="supdetailmaintain" action="supdetailtomaintain"></s:url>
<s:url id="empdetailmaintain" action="empdetailtomaintain"></s:url>
<s:url id="ratelist" action="ratelist"></s:url>
<s:url id="catsaveroute" action="mastercatsaveroute.action"></s:url>
<s:url id="catlist" action="mastercats"></s:url>
 	<ul id="accordion">
		<li><div><font size="3">SUPPLIER</font></div>
			<ul>
				<li><a href="${suppliertoadd }" ><font size="2">SUPPLIER ADD</font></a></li>
				<li><a href="${supdetailmaintain }" ><font size="2">SUPPLIER UPDATE</font></a></li>
				<li><a href="${supplierlist }" ><font size="2">SUPPLIER LIST</font></a></li>
			</ul>
		</li>
		<li><div><font size="3">EMPLOYEE</font></div>
			<ul>
				<li><a href="${emp }" ><font size="2">EMPLOYEE ADD</font></a></li>
				<li><a href="${empdetailmaintain }" ><font size="2">EMPLOYEE UPDATE</font></a></li>
				<li><a href="${emplist }"><font size="2">EMPLOYEE LIST</font></a></li>
			</ul>
		</li>
		<li><div><font size="3">PRODUCT</font></div>
			<ul>
				<li><a href="${product }" ><font size="2">PRODUCT ADD</font></a></li>
				<li><a href="${producttomaintain }" ><font size="2">PRODUCT UPDATE</font></a></li>
				<li><a href="${productlist }" ><font size="2">PRODUCT LIST</font></a></li>
			</ul>
		</li>	
		<li><div><font size="3">SALE</font></div>
			<ul>
				<li><a href="${product }" ><font size="2">PRODUCT ADD</font></a></li>
				<li><a href="${product }" ><font size="2">PRODUCT UPDATE</font></a></li>
				<li><a href="${productlist }" ><font size="2">PRODUCT LIST</font></a></li>
			</ul>	
		</li>	
		<li><div><font size="3">FX RATE</font></div>
			<ul>
				<li><a href="${ratelist }" ><font size="2">TODAY RATES LIST</font></a></li>
				<li><a href="${product }" ><font size="2">RATE HISTORY</font></a></li>
			</ul>
		</li>	
		<li><div><font size="3">SETTING</font></div>
			<ul>
				<li><a class="open-popup-link" href="${catsaveroute }" ><font size="2">CATEGORY ADD</font></a></li>
				<li><a href="${catlist }" ><font size="2">CATEGORY LIST</font></a></li>
			</ul>
		</li>	
	</ul>
</body>
<style type="text/css">
#accordion {
    list-style: none;
    padding: 0 0 0 0;
    width: 170px;
}
#accordion div {
    display: block;
    font-weight: bold;
    margin: 1px;
    cursor: pointer;
    padding: 5 5 5 7px;
    list-style: circle;
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    color: white;
	background-color: gray;		  
	text-decoration: none;font-weight: normal;
}
#accordion ul {
    list-style: none;
    padding: 0 0 0 0;
    border-style: solid;
    border-width: 1px;
    border-color: gray;
}
#accordion ul{
    display: none;
}
#accordion ul li {
    font-weight: normal;
    cursor: auto;
    background-color: #fff;
    padding: 0 0 0 7px;
}
#accordion a {
    text-decoration: none;
    
}
#accordion a:hover {
    text-decoration: none;
}
</style>
</html>