<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
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
<!-- <link href="css/bootstrap.css" type="text/css" rel="stylesheet" /> -->
<title>Insert title here</title>
<sj:head  />
<sx:head />
</head>
<style type="text/css">		
		.note:hover,
		.note:focus {
		  color: black;
		  text-decoration: none;font-weight: normal;
		}
		.note{
		  color: white;
		  text-decoration: none;font-weight: normal;
		}
		.note:normal{
		  color: white;
		  text-decoration: none;font-weight: normal;
		}
	</style>
<body>
<div id="main">
	<!-- <a href="/" class="open-popup-link">popup</a> -->
	
	<div class="MainLayer" align="center">
		<h3 align="center">Employee Informations
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="" onclick="nextwindow();"><font size="2">[Download]</font></a>
		</h3>	
		<p class="headingStatic" align="left">Basic Informations</p>
		<div class="generalInfo">	
		<s:form action="empSave" theme="simple" cssClass="bs-example form-horizontal" enctype="multipart/form-data"> 
	<s:token/>		
			<s:actionerror/><s:actionmessage/>
			<table width="100%" align="center" class="formtable">
				<tr>
					<td align="left">
						<s:text name="NAME"/>
					</td>
					<td>
						<s:textfield name="emp.ENmae"></s:textfield>
					</td>
					<td align="left">
						<s:text name="FATHER'S NAME"/>
					</td>
					<td>
						<s:textfield name="emp.EFather"></s:textfield>
					</td>	
				</tr>
				
				<tr>
					<td align="left">
						<s:text name="POSITION"/>
					</td>
					<td>
						<s:textfield name="emp.EPosition"></s:textfield>
					</td>	
					<td align="left">
						<s:text name="ADDRESS"/>
					</td>
					<td>
						<s:textfield name="emp.ECity"></s:textfield>
					</td>	
				</tr>	
		
				<tr>
					<td align="left">
						<s:text name="COUNTRY"/>
					</td>
					<td>
						<sx:autocompleter  list="#session.ctype" name="sp.ECountry" listKey="Id" listValue="city" headerKey="0" headerValue="-Select Country-" ></sx:autocompleter>
					</td>
					<td align="left">
						<s:text name="MOBILE"/>
					</td>
					<td>
						<s:textfield name="emp.EMobile"></s:textfield>
					</td>		
				</tr>	
				
				<tr>
					<td align="left">
						<s:text name="TEL"/>
					</td>
					<td>
						<s:textfield name="emp.ETel"></s:textfield>
					</td>	
				
					<td align="left">
						<s:text name="EMAIL"/>
					</td>
					<td>
						<s:textfield name="emp.EEmail"></s:textfield>
					</td>	
				</tr>
				<tr>
						
					<td align="left">					
						<s:text name="DUE DATE"/>
					</td>
					<td>								
						<sx:datetimepicker name="emp.EDateOut" cssStyle="width:50%" />															
					</td>
					<td align="left">
						<s:text name="HIRE DATE"/>
					</td>
					<td width="25%">
						<sx:datetimepicker cssStyle="width:80%" name="emp.EHireDate" /> 						 
					</td>	
				</tr>	
				
				<tr>
					 
					<td align="left">
						<s:text name="PERSONAL DOC"/>
					</td>
					<td width="30%">
						<s:file name="files.upload" cssClass="btnfile btn-default"></s:file>
					</td>
					<td align="left">
						<s:text name="PHOTO"/>
					</td>
					<td>
						<s:file name="files.upload" cssClass="btnfile btn-default"></s:file>
					</td>		
				</tr>					
			</table>
		</div>
	</div>
		<div class="layer1" align="center">
		<p class="heading" align="left"><img src="images/plus.png" width="1%" height="2%"/>&nbsp;&nbsp;Income Detail</p>
		<div class="content">			
			<table width="100%" align="center" class="formtable">
				<tr>
					<td align="left" width="20%">
						<s:text name="BUSSINESS TYPE"/>
					</td>
					<td>
						<s:textfield name="emp.income.Tax"></s:textfield>
					</td>

					<td align="left" width="20%">
						<s:text name="SOCIAL INSURANCE"/>
					</td>
					<td>
						<s:textfield name="emp.income.socialIns"></s:textfield>
					</td>
				</tr>
					<tr>
					<td align="left" width="20%">
						<s:text name="PAYMENT TYPE"/>
					</td>
					<td>
						<s:select list="#session.ptype" name="emp.income.payBy" listKey="Id" listValue="paymentType" headerKey="0" headerValue="-Select Category-" />
					</td>

					<td align="left" width="20%">
						<s:text name="NOTE"/>
					</td>
					<td>
						<s:textfield name="emp.income.Note"></s:textfield>
					</td>
				</tr>
			</table>
		</div>
		<p class="heading" align="left"><img src="images/plus.png" width="1%" height="2%"/>&nbsp;&nbsp;Bank Detail</p>
			<div class="content">
				<table width="100%" align="center" class="formtable">
				<tr>
					<td align="left" width="20%">
						<s:text name="BANK NMAE"/>
					</td>																
					<td width="20%" align="center">
						<s:textfield name="emp.bank.bankName"/>																
					</td>
					<td align="left" width="20%">
						<s:text name="ACC NUMBER"/>
					</td>																
					<td width="20%" align="center">
						<s:textfield name="emp.bank.accNo"/>																
					</td>						
				</tr>
				<tr>
					<td align="left" width="20%">
						<s:text name="BRANCH"/>
					</td>																
					<td width="20%" align="center">
						<s:textfield name="emp.bank.Branch"/>																
					</td>
					
					<td align="left" width="20%">
						<s:text name="CURRENCY"/>
					</td>																
					<td width="20%" align="center">
						<s:textfield name="emp.bank.Curreny"/>																
					</td>		
								
				</tr>
				<tr>
					<td align="left" width="20%">
						<s:text name="CITY"/>
					</td>																
					<td width="20%" align="center">
						<s:textfield name="emp.bank.City"/>																
					</td>
								
				</tr>				
			</table>
			</div>
		<p class="heading" align="left"><img src="images/plus.png" width="1%" height="2%"/>&nbsp;&nbsp;Private Memo</p>
		<div class="content">
			<s:text name="PRIVATE MEMO"></s:text>
			<s:textarea name="emp.privateNote" cssClass="form-control" >
			</s:textarea>
			<s:submit value="SAVE" cssClass="btn" disabled=""/>
		</div>
		</div>
		<%-- <s:token/> --%>
	</s:form>
	</div>
</body>
</html>