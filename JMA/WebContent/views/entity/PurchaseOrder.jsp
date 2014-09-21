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
<link rel='stylesheet prefetch' href="js/magnific-popup/magnific-popup.css">
<title>Insert title here</title>
<sj:head/>
</head>
<style type="text/css">
td{
	font-size: 100%;
	width: 20%; 
}
input[type="text"] {
    width: 100%;
}
</style>
<body>
<h3 align="center">Product Entry</h3>
<s:actionmessage cssClass="alert alert-dismissable alert-success"/>
	<s:form theme="simple" action="poSave" cssClass="form-horizontal" enctype="multipart/form-data" method="POST">
		<s:token/>
	<sj:tabbedpanel id="localtabs" cssClass="list" selectedTab="pro.stage">
		<sj:tab id="tab1" target="proGen" label="PURCHASE ORDER"/>
		<div id="proGen" class="tabdiv">
			<table width="100%" align="center">
					<thead>
						<tr>
							<th colspan="4">Purchase Order</th>
						</tr>
					</thead>
					<tr>
						<td width="20%">CUSTOMER NAME</td>
						<td><s:textfield name="po.customerName"/></td>
						<td>BILLING ADDRESS</td>
						<td><s:textfield name="po.billingAdd"/></td>
					</tr>
					<tr>
						<td>DATE</td>
						<td><sj:datepicker name="po.poDate" cssStyle="width:50%"   size = "30" maxlength="10"  onblur="format_selected_date(this)" changeYear="true"/></td>
						<td>SHIPPING ADDRESS</td>
						<td><s:textfield name="po.shippingAdd"/></td>
					</tr>
					<tr>
						
						<td>PAYMENT TYPE</td>
						<td><s:textfield name="po.paymentType"/></td>
						<td>CREDIT TERM</td>
						<td><s:textfield name="po.creditTerm" /></td>
					</tr>
					<tr>
						<td>CURRENCY</td>
						<td><s:textfield name="po.currency"/></td>
						<td>SALES PERSON NAME</td>
						<td><s:textfield name="po.salePerson"/></td>
					</tr>
					<tr>
						<td>EST DELIVERY DATE</td>
						<td><sj:datepicker name="po.deliveryDate" cssStyle="width:50%"   size = "30" maxlength="10"  onblur="format_selected_date(this)" changeYear="true"/></td>
						<td>SHIPPING DATE</td>
						<td><sj:datepicker name="po.shippingDate" cssStyle="width:50%"   size = "30" maxlength="10"  onblur="format_selected_date(this)" changeYear="true"/></td>
					</tr>
					<tr>
						
						<td>SHIPPING LINE</td>
						<td><s:textfield name="po.shipBy"/></td>
						<td>NUMBER OF itemsS</td>
						<td><s:textfield name="currenaction"/></td>
					</tr>
					<tr>
						<td colspan="4" align="right"><s:submit cssClass="btn" value="NEXT" cssStyle="width : 80px;height : 30px;" action="toPo"></s:submit></td>
					</tr>
				</table>
		</div>
		<s:if test="currenaction == '' || currenaction == null ">
		</s:if>
		<s:else>
			<s:set var="to" value="currenaction"/>
			<s:iterator status="counter" begin="1" end="#to" >
				<sj:tab id="tab" target="%{#counter.index}" label="Item"/>
				<div id="${counter.index }" class="tabdiv">
					<table width="100%" align="center">
					<thead>
						<tr>
							<th colspan="4">Items Information #<s:property value="%{#counter.index+1}"/></th>
						</tr>
					</thead>
					<tr>
						<td width="20%">GOLD KARAT</td>
						<td><s:textfield name="po.items[%{#counter.index}].goldKarat"/></td>
						<td>PRODUCT TYPE</td>
						<td><s:textfield name="po.items[%{#counter.index}].productType"/></td>
					</tr>
					<tr>
						<td width="20%">PRODUCT MATERIAL</td>
						<td><s:textfield name="po.items[%{#counter.index}].productMaterial"/></td>
						<td>PRODUCT REFERENCE</td>
						<td><s:textfield name="po.itemss[%{#counter.index}].productReference"/></td>
					</tr>
					<tr>
						<td width="20%">PRODUC STONE CODE</td>
						<td><s:textfield name="po.items[%{#counter.index}].productStoneCode"/></td>
						<td>PRODUCT DESCRIPTION</td>
						<td><s:textfield name="po.items[%{#counter.index}].productDescription"/></td>
					</tr>
					<tr>
						<td width="20%">RING SIZE</td>
						<td><s:textfield name="po.items[%{#counter.index}].ringSize"/></td>
						<td>PRODUCT QUALITY</td>
						<td><s:textfield name="po.items[%{#counter.index}].quality"/></td>
					</tr>
					<tr>
						<td width="20%">UNIT PRICE</td>
						<td><s:textfield name="po.items[%{#counter.index}].unitPrice"/></td>
						<td>NET PRICE</td>
						<td><s:textfield name="po.items[%{#counter.index}].netPrice"/></td>
					</tr>
					<tr>
						<td width="20%">STAMPING</td>
						<td><s:textfield name="po.items[%{#counter.index}].stamping"/></td>
						<td>PHOTO</td>
						<td><s:file name="sf.file" cssStyle="width:80%;"/></td>
					</tr>
					<tr>
						<td width="20%">Note</td>
						<td colspan="3"><s:textfield name="po.items[%{#counter.index}].productNote"/></td>
					</tr>
					</table>
				</div>
			</s:iterator>
		</s:else>
	</sj:tabbedpanel>
	<div align="center">
			<br>
				<s:submit cssClass="btn"></s:submit>
			<br>
	</div>
	</s:form>
</body>
</html>