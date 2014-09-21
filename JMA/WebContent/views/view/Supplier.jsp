<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@page import="com.opensymphony.xwork2.ActionContext" %>
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
<s:head/>
<sx:head/>
</head>
<script type="text/javascript">
	function nextwindow(){
		window.open("/JMA/download.action", "Download"); 
	}
	 
</script>
<s:url id="fileDownload" namespace="/" action="download" ><s:param name="sp"></s:param></s:url>
<body>
	<div id="main">
<!-- 	<a href="/" class="open-popup-link">popup</a>  -->
	<s:form action="supplierSave" theme="simple" cssClass="bs-example form-horizontal">
	<s:token/>
	<div class="MainLayer" align="center">
		<h3 align="center">Supplier Informations
		&nbsp;&nbsp;&nbsp;&nbsp;<a href="" onclick="nextwindow();"><font size="2">[Download]</font></a>
		</h3>
		<p class="headingStatic" align="left">Basic Informations</p>
		<div class="generalInfo">
			<s:actionerror/><s:actionmessage/>
			<table width="100%" align="center" class="formtable">
				<tr>
					<td align="left">
						<s:text name="COMPANY NAME"/>
					</td>
					<td>
						<s:text name="sp.CompanyName"></s:text>
					</td>
					<td align="left">
						<s:text name="CONTACT NAME"/>
					</td>
					<td>
						<s:text name="sp.ContactName"></s:text>
					</td>	
				</tr>
				
				<tr>
					<td align="left">
						<s:text name="POSITION"/>
					</td>
					<td>
						<s:text name="sp.position"></s:text>
					</td>	
					<td align="left">
						<s:text name="ADDRESS"/>
					</td>
					<td>
						<s:text name="sp.address"></s:text>
					</td>	
				</tr>	
		
				<tr>
					<td align="left">
						<s:text name="PROVINCE"/>
					</td>
					<td>
						<s:text name="sp.province"></s:text>
					</td>
					<td align="left">
						<s:text name="POST CODE"/>
					</td>
					<td>
						<s:text name="sp.postCode"></s:text>
					</td>		
				</tr>	
				
				<tr>
					<td align="left">
						<s:text name="CITY"/>
					</td>
					<td>
						<s:text name="sp.city"></s:text>
					</td>	
				
					<td align="left">
						<s:text name="COUNTRY"/>
					</td>
					<td>
						<s:text name="sp.country"></s:text>
						<%-- <sx:autocompleter readonly="true"  list="#session.ctype" name="sp.country" listKey="Id" listValue="city" headerKey="0" headerValue="-Select Country-" ></sx:autocompleter> --%>
						<%-- <s:select list="#session.ctype" name="sp.country" listKey="Id" listValue="city" headerKey="0" headerValue="-Select Country-" /> --%>
					</td>	
				</tr>
				<tr>
					<td align="left">
						<s:text name="WEB ADDRESS"/>
					</td>
					<td>
						<s:text name="sp.webAdd"></s:text>
					</td>	
					<td align="left">
						<s:text name="FAX"/>
					</td>
					<td>
						<s:text name="sp.faxNo"></s:text>
					</td>	
				</tr>	
				<tr>
					<td align="left">
						<s:text name="EMAIL[1-2]"/>
					</td>
					<td colspan="2">
						<s:text name="sp.email1"></s:text>
						<s:text name="-"/>
						<s:text name="sp.email2"></s:text>
					</td>					
				</tr>
				<tr>
					<td align="left">
						<s:text name="TELEPHONE[1-2]"/>
					</td>
					<td colspan="2">
						<s:text name="sp.teleponeNo1"></s:text>
						<s:text name="-"/>
						<s:text name="sp.teleponeNo2"></s:text>
					</td>	
				</tr>						
			</table>
		</div>
	</div>
		<div class="layer1" align="center">
		<p class="heading" align="left"><img src="images/plus.png" width="1%" height="2%"/>&nbsp;&nbsp;Business Type</p>
		<div class="content">			
			<table width="100%" align="center" class="formtable">
				<tr>
					<td align="left" width="20%">
						<s:text name="BUSSINESS TYPE"/>
					</td>
					<td>
						<s:if test="#session.btype == null">
						</s:if>
						<s:else>
						<s:iterator value="#session.btype" status="s">
								<!-- Check Bussiness type-->
								<s:if test="%{#session.btype[#s.index].master==1}">								
									<s:set var="limit" value="'none'" />
									<s:iterator value="sp.buType" status="x">
										<!-- check it was selected -->
										<s:if test="sp.buType[#x.index] != null">
											<s:if
												test="#session.btype[#s.index].id == sp.buType[#x.index].parentId">
												<s:set var="limit" value="' '"></s:set>
											</s:if>
											<s:else>							
									</s:else>
									</s:if>
										<%-- <s:property  value="parentId" /> --%>
									</s:iterator>
									<!-- Check It is a new form -->															
									<s:if test="sp.buType != null">		
									<s:set var="check1" value="false" ></s:set><s:set var="flag" value="null" ></s:set>	
									<s:set var="position" value="0" ></s:set>																											
										<s:iterator value="sp.buType" status="j">
											<!-- check it was selected -->
											<s:if
												test="sp.buType[#j.index].parentId == #session.btype[#s.index].id">												
												<s:set var="check1" value="true"></s:set>	
												<s:set var="flag" value="%{sp.buType[#j.index].Id}"></s:set>
												<s:set var="position" value="#j.index"></s:set>
													<s:iterator value="sp.buType[#j.index].caid" status="e">
													<s:iterator value="#session.btype[#s.index].caid" status="l">													
													<%-- <s:property value="%{sp.buType[#j.index].caid[#e.index].master}" />	 --%>														 														
														<s:if
															test="sp.buType[#j.index].caid[#e.index].master == #session.btype[#s.index].caid[#l.index].Id">	
															<s:set var="check2" value="true"/>
															<s:set var="catid" value="%{sp.buType[#j.index].caid[#e.index].id}"/>																						
														</s:if> 
														</s:iterator>
													</s:iterator>										
											</s:if>																														
											<s:else>												
											</s:else>													
											</s:iterator>
											<div>
												<span>
													<s:hidden name="sp.buType.Id" value="%{flag}"></s:hidden>
													<s:checkbox disabled="true"
														fieldValue="%{Id}" name="sp.buType[%{#s.index}].parentId" value="#check1"  id="subdiv"></s:checkbox>
													<s:text name="businessType"></s:text>													
												</span>
												<div id="${Id}" class="autoUpdate" style="display:${limit};border-style: display;border-color: gray;"
													align="left">
												<span>												
												<s:iterator value="#session.btype[#s.index].caid" status="j">
													<s:set var="check2" value="null" /><s:set var="catid" value="null" />	
													<%-- <s:property value="#position" />/ --%>
													<s:iterator value="sp.buType[#position].caid" status="e">
													<%-- <s:property value="%{sp.buType[#position].caid[#e.index].master}" />	?= 	<s:property value="%{#session.btype[#s.index].caid[#j.index].Id}" /> --%>													 														
														<s:if
															test="sp.buType[#position].caid[#e.index].master == #session.btype[#s.index].caid[#j.index].Id">	
															<s:set var="check2" value="true"/>
															<s:set var="catid" value="%{sp.buType[#position].caid[#e.index].id}"/>																						
														</s:if>
														</s:iterator>												
													<span>											
														<s:hidden name="sp.buType[%{#s.index}].caid.id" value="%{catid}"></s:hidden>
														<s:checkbox fieldValue="%{Id}" disabled="true"
															name="sp.buType[%{#s.index}].caid.master" id="subdiv"
															value="#check2"></s:checkbox> 
															<s:text name="subCatalogName"></s:text>
												</span>
												</s:iterator>
												</span>
												<hr>
											</div>
											</div>
									</s:if>
									<!-- For new form -->
									<s:else>
									<div>
										<span>
										New Form										
										<s:checkbox fieldValue="%{Id}" disabled="true"
												name="sp.buType.parentId" id="subdiv"></s:checkbox>
											<s:text name="businessType"></s:text>
										</span>
									</div>
									</s:else>
								</s:if>
							</s:iterator>
						</s:else>						
					</td>
				</tr>
			</table>				
			</div>
		<p class="heading" align="left"><img src="images/plus.png" width="1%" height="2%"/>&nbsp;&nbsp;Bank Detail</p>
			<div class="content">
				<table width="100%" align="center" class="formtable">
				<tr>
					<td align="left" width="20%">
						<s:text name="BNF NMAE"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.bank.BnfName"/>																
					</td>
					<td align="left" width="20%">
						<s:text name="ACC NUMBER"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.bank.AccNo1"/>																
					</td>						
				</tr>
				<tr>
					<td align="left" width="20%">
						<s:text name="BANK NAME"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.bank.BankName"/>																
					</td>
					
					<td align="left" width="20%">
						<s:text name="ACC NUMBER2"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.bank.AccNo2"/>																
					</td>		
								
				</tr>
				<tr>
					<td align="left" width="20%">
						<s:text name="SWIFT CODE"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.bank.SwiftCode1"/>																
					</td>
					<td align="left" width="20%">
						<s:text name="SWIFT CODE2"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.bank.SwiftCode2"/>																
					</td>
								
				</tr>
				<tr>
					<td align="left" width="20%">
						<s:text name="BNF ADDRESS"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.bank.BnfAddress"/>																
					</td>
					<td align="left" width="20%">
						<s:text name="BNF ADD2"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.bank.AddBnfBank2"/>																
					</td>									
				</tr>
			</table>
			</div>
		<p class="heading" align="left"><img src="images/plus.png" width="1%" height="2%"/>&nbsp;&nbsp;Payment Type</p>
		<div class="content">
			<table width="100%" align="center" class="formtable">
				<tr>
					<td align="left" width="20%">
						<s:text name="PAYMENT TYPE"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.payment.payType"/>																
					</td>
					<td align="left" width="20%">
						<s:text name="CREDIT TERM"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.payment.creditTerm"/>																
					</td>						
				</tr>
				<tr>
					<td align="left" width="20%">
						<s:text name="CREDIT LIMIT"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.payment.creditLimit"/>																
					</td>
					<td align="left" width="20%">
						<s:text name="CURRENCY"/>
					</td>																
					<td width="20%" align="center">
						<s:text name="sp.payment.curreNcy"/>																
					</td>						
				</tr>
			</table>
		</div>
		<p class="heading" align="left"><img src="images/plus.png" width="1%" height="2%"/>&nbsp;&nbsp;Private Memo</p>
		<div class="content">
			<s:text name="PRIVATE MEMO"></s:text>
			<s:textarea readonly="true" name="sp.MeMo" cssClass="form-control" >
			</s:textarea>			
		</div>
		</div>
	</s:form>
	</div>
</body>
<s:debug></s:debug>
</html>