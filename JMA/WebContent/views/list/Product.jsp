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
<script src="./js/miniSlider.js"></script>
<link href="css/divStyle.css" type="text/css" rel="stylesheet" />
<link href="./css/DropDownDivCart.css" type="text/css" rel="stylesheet" />
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="css/displaytag.css" type="text/css" rel="stylesheet" />	
<link rel='stylesheet prefetch' href="js/magnific-popup/magnific-popup.css">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(function() {
    $('#slider').miniSlider();
  });
</script>
<body>
<s:url id="home" action="products"></s:url>
<s:url id="addcart" action="addtocart"></s:url>
<h3 align="center">PRODUCT LIST</h3>
<a href="${home}"><img alt="HOME" width="2%" height="4%" src="./img/home.png"></a>
			<s:if test="%{#session.cart!=null}">
			<div class="panel panel-default">
			<button class="close"></button>
				<div class="panel-heading">
					<div style="width: 50%;text-align: left;display: inline;" align="left">
						Shopping Cart
					</div>
					<!-- <div style="width: 50%;text-align: right;display: inline;" align="right">
						Shopping Cart
					</div> -->
				</div>
				<div class="panel-body" id="menu_div_cart">				
				<s:iterator value="%{#session.cart}" status="s">
										
					   <li><a href=""><s:property value="Id"/></a>
							<ul class="sub-menu">
								<li><a  href="productremovecart.action?currenaction=${Id}">Remove</a></li>
								<li><a  class="open-popup-link" href="productDetail.action?currenaction=${Id}">View</a></li>
							</ul>
						<li>					
					
				</s:iterator>
				</div>
			</div>
			</s:if>
			<display:table id="i" name="pros" export="true" requestURI="productsexport" pagesize="10" cellpadding="2px;" cellspacing="2px;" style="margin-top:0%;width:100%"> 
				<display:column title="No">${i_rowNum}</display:column> 
				<display:column title="IMAGE" style="width:15%;" media="html">
						        <div id="gallery">
						          <a  class="open-popup-link-img" href="${i.photo}"><img src="${i.photo}"  width="70px" height="80px" align="middle"/></a>
						          <a  class="open-popup-link-img" href="${i.note.mastermoldPic1}"><img src="${i.note.mastermoldPic1}"  width="30px" height="40px" align="middle"/></a>
						          <a  class="open-popup-link-img" href="${i.note.mastermoldPic2}"><img src="${i.note.mastermoldPic2}"  width="30px" height="40px" align="middle"/></a>						 
						        </div>				
				</display:column>
		 		<display:column property="id" title="ID" sortable="true"/>
				<display:column property="catalogue" title="CATALOGUE" sortable="true"/>
				<display:column property="type" title="TYPE" sortable="true"/>
				<display:column property="material" title="MATERIAL" sortable="true"/>
				<display:column property="stoneCode" title="STONE CODE" sortable="true"/>
				<display:column property="article" title="ARTICLE"/>
				<display:column media="html">					
					<a  class="open-popup-link" href="productDetail.action?currenaction=${i.id}">DETAIL</a>					
				</display:column>
				<display:column media="html">
					<a  class="open-popup-link" href="reportProduct.action?currenaction=${i.id}">REPORT</a>					
				</display:column>
				<display:column media="html"><a id="close${i_rowNum }" href="mastercatdelete.action?currenaction=${i.id}/supplier">Delete</a></display:column> 
				<display:column media="html" style="width:5%;" paramId="pro.Id" href="addtocart" paramProperty="id">
					<img width="50%" height="10%" alt="" src="images/cart.ico" />
					<%-- <s:url id="addcart" action="addtocart"><s:param name="i.id" value="${ i.id}"/></s:url> 
					 <a href="${addcart }"> 
					<img width="50%" height="10%" alt="" src="images/cart.ico" />
					</a>  --%>
				</display:column>
				<display:setProperty name="export.excel.filename" value="Product.xls"/>  
			</display:table>
			<s:debug></s:debug>
</body>
</html>