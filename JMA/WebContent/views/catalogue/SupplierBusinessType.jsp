<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script  type="text/javascript" src="./js/jquery-1.9.1.js"></script>
<script  type="text/javascript" src="./js/div.js"></script>
<script src="./js/magnific-popup/jquery.magnific-popup.js"></script>
<script src="./js/popup/popupEg.js"></script>
<link href="css/divStyle.css" type="text/css" rel="stylesheet" />
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
<link rel='stylesheet prefetch' href="js/magnific-popup/magnific-popup.css">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">Supplier Business Type Sub Business Catalog Add</h3>
	<s:form action="" theme="simple" cssClass="bs-example form-horizontal">
	<s:token/>
	<s:actionmessage cssClass="alert alert-dismissable alert-success"/>
		<table width="100%" align="center" class="formtable">
				<tr>
					<td align="left">
						MASTER CATALOG NAME
					</td>
					<td align="left">
						<s:textfield name="mastercat.catalogName"></s:textfield>
					</td>
					<td align="left">
						ACTOR
					</td>
					<td align="left" width="30%">
						<s:select list="#session.actor" id="select" name="mastercat.actor" listKey="Id" listValue="name" headerKey="0" headerValue="-Select Actor-" cssStyle="width:60%;"/>
					</td>
					<td>MASTER FIELD</td>
					<td>
						<s:select id="masterfield" name="fileName" list="{'Select State'}" listKey="%{key}" listValue="%{value}" />
					</td>
					</tr>
					<tr>
						<td colspan="6" bgcolor="gray">SUB CATEGORIES</td>
					</tr>
					<tr>
					<td>
					<s:if test='currenaction == "SUCCESS"'>
						<s:submit cssClass="btn" value="SAVE" action="mastercatsave"></s:submit>
						<s:submit cssClass="btn" value="CLOSE" id="close"></s:submit>
					</s:if>
					<s:else>
						<s:submit cssClass="btn" value="SAVE" action="mastercatsave"></s:submit>
					</s:else>
					<!-- <a href="" onclick="close()" class="close()" id="close">close</a>	 -->
					</td>
				</tr>				
		</table>	
	</s:form>	
</body>
</html>