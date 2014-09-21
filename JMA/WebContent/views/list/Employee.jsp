<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script  type="text/javascript" src="./js/jquery-1.9.1.js"></script>
<script  type="text/javascript" src="./js/div.js"></script>
<script src="./js/magnific-popup/jquery.magnific-popup.js"></script>
<script src="./js/popup/popupEmp.js"></script>
<link href="css/divStyle.css" type="text/css" rel="stylesheet" />
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="css/displaytag.css" type="text/css" rel="stylesheet" />
<link rel='stylesheet prefetch' href="js/magnific-popup/magnific-popup.css">
<link type="text/css" href="css/theme_interiorNavigation/ui.all.css" rel="Stylesheet" />
<title>Insert title here</title>
</head><script type="text/javascript">		
	 $(document).ready(function(){	 			
		$( "a[id^=close]" ).click( function() {          
			var confirmed = confirm("Are you sure?");
            if (!confirmed) {
                return false;
            }		 
			});
	 }); 
</script>
<body>
<s:url id="home" action="emps"></s:url>
<h3 align="center">EMPLOYEE LIST</h3>
<a href="${home}"><img alt="HOME" width="2%" height="4%" src="./img/home.png"></a>
			<display:table id="i" name="emps" export="true" requestURI="empsexport" pagesize="10" cellpadding="2px;" cellspacing="2px;" style="width:97%;margin-left:2%;"> 
				<display:column title="No">${i_rowNum}</display:column> 
		 		<display:column property="id" title="ID" sortable="true"/>
				<display:column property="ENmae" title="NAME" sortable="true"/>
				<display:column property="EPosition" group="1" title="POSITIOIN" sortable="true"/>
				<display:column property="EEmail" title="EMAIL" style=""/>
				<display:column property="ETel" title="Tel" media="excel"/>
				<display:column media="html"><a  class="open-popup-link" href="empdetail.action?currenaction=${i.id}">DETAIL</a></display:column>
				<display:column media="html"><a  class="open-popup-link" href="reportEmployee.action?currenaction=${i.id}">REPORT</a></display:column>
				<display:column media="html"><a id="close${i_rowNum }" href="mastercatdelete.action?currenaction=${i.id}/employee">Delete</a></display:column> 
				<display:setProperty name="export.excel.filename" value="person.xls"/>  
			</display:table>
			

</body>
</html>