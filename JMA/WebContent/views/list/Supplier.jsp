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
<title>Insert title here</title>
</head>
<script type="text/javascript">		
	 $(document).ready(function(){	 			
		$( "a[id^=close]" ).click( function() {          
			var confirmed = confirm("Are you sure?");
            if (!confirmed) {
                return false;
            }		 
			});
	 }); 
</script>
<style type="text/css">
 #topconer{
 	position:absolute;
   top:0;
   right:0;
   width: 100px;
 }
</style>
<body>
<s:url id="home" action="sups"></s:url>
<h3 align="center">SUPPLIER LIST</h3>
<div id="topconer" align="right">
	<a href="${home}"><img alt="HOME" width="20px" height="20px" src="./images/flipin.png"></a>	
</div>
			<display:table id="i" name="sups" export="true" requestURI="supsexport" pagesize="10" cellpadding="2px;" cellspacing="2px;" style="width: 97%; margin-left:2%;"> 
				<display:column title="No">${i_rowNum}</display:column> 
		 		<display:column property="id" title="ID" sortable="true"/>
				<display:column property="companyName" title="COMPANY" sortable="true"/>
				<display:column property="contactName" title="CONTACT" sortable="true"/>
				<display:column property="email1" title="EMAIL-1" style=""/>
				<display:column property="email1" title="EMAIL-2" media="excel"/>
				<display:column property="teleponeNo1" title="TELEPHONE-1" style=""/>
				<display:column property="teleponeNo2" title="TELEPHONE-2" media="excel"/>
				<display:column property="webAdd" title="WEB" media="excel"/>
				<display:column media="html"><a  class="open-popup-link" href="supdetail.action?currenaction=${i.id}">DETAIL</a></display:column>
				<display:column media="html">					
					<a  class="open-popup-link" href="reportSupplier.action?currenaction=${i.id}">REPORT</a>					
				</display:column>
				<display:column media="html"><a id="close${i_rowNum }" href="mastercatdelete.action?currenaction=${i.id}/supplier">Delete</a></display:column> 				
				<display:setProperty name="export.excel.filename" value="suppliers.xls"/>  
			</display:table>
			

</body>
</html>