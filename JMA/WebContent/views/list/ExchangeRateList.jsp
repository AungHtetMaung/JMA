<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	<% 
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy")  ;
		Date d = new Date();
	%>
	<h3 align="center">ONLINE EXCHANGE RATE PROGRAM</h3>
		<table width="100%" align="center" border="2" bordercolor="gray">
		<thead>		
			<tr>
				<td align="center" colspan="3">Exchange Rate     (<%= format.format(d) %>)</td>				
			</tr>
			<tr>
				<td>Priority #1</td>
				<td>USD</td>
				<td><s:property value="%{exRate.rates['USD']}"/></td>
			</tr>
			<tr>
				<td>Priority #2</td>
				<td>THB</td>
				<td><s:property value="%{exRate.rates['THB']}"/></td>
			</tr>			
			<tr style="background: grey">
				<td align="center">NO</td>
				<td >CURRENCY CODE</td>
				<td >RATE</td>
			</tr>
		</thead>		
		<tbody>
			<s:iterator value="exRate.rates" status="s">
					<s:if test="#s.even == true">
				    <tr class="even">				    
						<td  align="center"><s:property value="#s.count"/></td>
						<td><s:property value="key"/></td>
						<td><s:property value="value"/></td>					
					</tr>
					</s:if>
					<s:else>
					<tr class="odd">						  
						<td  align="center"><s:property value="#s.count"/></td>
						<td><s:property value="key"/></td>
						<td><s:property value="value"/></td>	
					</tr>
					</s:else>					
			</s:iterator>
		</tbody>
		<tfoot>
			<tr style="background: grey">
				<td  colspan="3" align="center">SOURCE FROM : <s:property value="exRate.description"/></td>
			</tr>
		</tfoot>
		</table>
		<s:debug></s:debug>
</body>
</html>