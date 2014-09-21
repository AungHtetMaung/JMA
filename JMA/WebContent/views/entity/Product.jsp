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
<s:head/>
<sx:head/>
<sj:head/>
</head>
<style type="text/css">
		span{
			color: black;			
		}
	</style>
<body>
<h3 align="center">Product Entry</h3>
	<s:actionmessage cssClass="alert alert-dismissable alert-success"/>
	<s:form theme="simple" enctype="multipart/form-data">
	<table width="100%">
		<tr>
			<td width="50%" align="center">PRODUCT ID</td>
			<td><s:textfield name="pro.Id"></s:textfield></td>
			<td><s:submit action="proque" cssClass="btn"/></td>
		</tr>
	</table></s:form>
	
	<s:form theme="simple" action="productadd" cssClass="form-horizontal" enctype="multipart/form-data" method="POST">
		<s:token/>
	<sj:tabbedpanel id="localtabs" cssClass="list" selectedTab="pro.stage">
		<s:if test="%{pro.stage >= 0}">
		<sj:tab id="tab1" target="proGen" label="Step1" cssStyle="background-color: gray;border-color: gray;font"/>
		</s:if>
		<s:if test="%{pro.stage >= 1}">
		<sj:tab id="tab2" target="proDetail" label="Step2" cssStyle="background-color: gray;border-color: gray;"/>
		</s:if>
		<s:if test="%{pro.stage >= 2}">
		<sj:tab id="tab2" target="proNote" label="Step3" cssStyle="background-color: gray;border-color: gray;" loadingText="LOADING"/>
		</s:if>
		<s:if test="%{pro.stage >= 0}">
		<div id="proGen" class="tabdiv">
			<table width="100%" align="center">
					<thead>
						<tr>
							<th colspan="4">General Information</th>
						</tr>
					</thead>
					<tr>
						<s:hidden name="pro.stage"></s:hidden>
						<s:hidden name="pro.Id"></s:hidden>
						<s:hidden name="pro.note.Id"></s:hidden>
						<s:hidden name="pro.prodetail.Id"></s:hidden>
						<s:hidden name="pro.proprice.Id" />
						<td>CATALOG</td>
						<td><s:textfield name="pro.catalogue" disabled="#current"/></td>
						<td>PRODUCT TYPE</td>
						<td><s:textfield name="pro.type" disabled="#current"/></td>
					</tr>
					<tr>
						<td>MATERIAL</td>
						<td><s:textfield disabled="#current" name="pro.material" /></td>
						<td>PRODUCT REFERENCE</td>
						<td><s:textfield disabled="#current" name="pro.productRef" /></td>
					</tr>
					<tr>
						<td>STONE CODE</td>
						<td><s:textfield disabled="#current" name="pro.stoneCode" /></td>
						<td>ARTICLE</td>
						<td><s:textfield disabled="#current" name="pro.article" /></td>
					</tr>
					<tr>
						<td>PRODUCT PHOTO</td>
						<s:hidden name="pro.photo"/>
						<td><s:file name="file.file" cssClass="btnfile btn-default"></s:file></td>
					</tr>
			</table>
		</div>
		</s:if>
		<s:if test="%{pro.stage >= 1}">
		<div id="proDetail">
			<table width="100%" align="center">
					<thead>
						<tr>
							<th colspan="4">Product Detail</th>
						</tr>
					</thead>
					<tr>
						<td>CASTING WEIGH</td>
						<td><s:textfield name="pro.prodetail.castingWeigh"  disabled="#current"/></td>
						<td>FINISH WEIGH</td>
						<td><s:textfield name="pro.prodetail.finishWeigh" disabled="#current.finishWeigh"/></td>
					</tr>
					<tr>
						<td>STONE NAME</td>
						<td><s:textfield disabled="#current" name="pro.prodetail.stoneName" /></td>
						<td>STEONE SHAPE</td>
						<td><s:textfield disabled="#current" name="pro.prodetail.stoneShape" /></td>
					</tr>
					<tr>
						<td>STONE CLASS</td>
						<td><s:textfield disabled="#current" name="pro.prodetail.stoneClass" /></td>
						<td>STONE SIZE1</td>
						<td><s:textfield disabled="#current" name="pro.prodetail.size1" /></td>
					</tr>
					<tr>
						<td>STONE SIZE2</td>
						<td><s:textfield disabled="#current" name="pro.prodetail.size2" /></td>
						<td>STONE SIZE3</td>
						<td><s:textfield disabled="#current" name="pro.prodetail.size3" /></td>
					</tr>
					<tr>
						<td>BEFORE RECUT WEIGH</td>
						<td><s:textfield disabled="#current" name="pro.prodetail.beforeRecutWeigh" /></td>
						<td>AFTER RECUT WEIGH</td>
						<td><s:textfield disabled="#current" name="pro.prodetail.afterRecutWeigh" /></td>
					</tr>
					<thead>
						<tr>
							<th colspan="4">Pricing</th>
						</tr>
					</thead>
					<tr>
						<td>PRICE U</td>
						<td><s:textfield name="pro.proprice.priceU"  disabled="#current"/></td>
						<td>PRICE A</td>
						<td><s:textfield name="pro.proprice.priceA" disabled="#current"/></td>
					</tr>
					<tr>
						<td>PRICE B</td>
						<td><s:textfield name="pro.proprice.priceB"  disabled="#current"/></td>
						<td>PRICE C</td>
						<td><s:textfield name="pro.proprice.priceC" disabled="#current"/></td>
					</tr>
					<tr>
						<td>PRICE D</td>
						<td><s:textfield name="pro.proprice.priceD"  disabled="#current"/></td>
						<td colspan="2"></td>						
					</tr>
				</table>
		</div>
		</s:if>
		<s:if test="%{pro.stage >= 2}">
		<div id="proNote">
			<table width="100%" align="center">
					<thead>
						<tr>
							<th colspan="4">General Information</th>
						</tr>
					</thead>
					<%-- <tr>
						<td>CREATE DATE</td>
						<td><sj:datepicker name="pro.note.createDate" disabled="#current"/></td>
						<td colspan="2"></td>
					</tr> --%>
					<tr>
						<td>NUMBER OF PARTS</td>
						<td><s:textfield name="pro.note.nopartitem"/></td>
						<td>MATERIAL OF MOLD</td>
						<td><s:textfield name="pro.note.materialMold" /></td>
					</tr>
					<tr>
						<td>DESIGN DATE</td>
						<td><sj:datepicker name="pro.note.disignDate" disabled="#current"/></td>
						<td>MASTER MOLD PIC1</td>
						<s:hidden name="pro.note.mastermoldPic1"/>
						<td width="25%"><s:file name="files.upload" cssClass="btnfile btn-default"></s:file></td>
					</tr>
					<tr>
						<td>MASTER MOLD PIC2</td>
						<s:hidden name="pro.note.mastermoldPic2"/>
						<td width="27%"><s:file name="files.upload" cssClass="btnfile btn-default"></s:file></td>
						<td>MASTER MOLD PIC3</td>
						<s:hidden name="pro.note.mastermoldPic3"/>
						<td width="25%"><s:file name="files.upload" cssClass="btnfile btn-default"></s:file></td>
					</tr>
					<tr>
						<td>RELATIVE REF1</td>
						<td><s:textfield name="pro.note.ref1"/></td>
						<td>RELATIVE REF2</td>
						<td><s:textfield name="pro.note.ref2"/></td>
					</tr>
					<tr>
						<td>RELATIVE REF3</td>
						<td><s:textfield name="pro.note.ref3"/></td>
						<td>DESCRIPTION</td>
						<td><s:textfield name="pro.note.note"/></td>
					</tr>
			</table>
		</div>
		</s:if>
		</sj:tabbedpanel>
		<div align="center">
			<br>
				<s:submit cssClass="btn"></s:submit>
			<br>
		</div>
	</s:form>
	<s:token/>
	<s:debug></s:debug>
</body>
</html>