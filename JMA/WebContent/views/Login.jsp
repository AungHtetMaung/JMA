<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script  type="text/javascript" src="./js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="./js/script.js"></script>
<link href="./css/bootstrap.css" rel="stylesheet" />
</head>
<body style="background-color: #108a93;">
<div style="position: absolute;height: 100%;" align="center">
<img src="<%=request.getContextPath()%>/img/1.jpg" alt="Heading" width="100%" height="100%"/>
<div style="top: 50%;position: inherit;width: 30%;height: 22%;" align="center">
	<a href="#" class="topopup">Click Here Trigger</a>

    <div id="toPopup">

        <div class="close"></div>
       	<span class="ecs_tooltip">Press Esc to close <span class="arrow"></span></span>
		<div id="popup_content"> <!--your content start-->
            <p>netus et malesuada fames ac turpis egestas. </p>
            <p align="center"><a href="#" class="livebox">Click Here Trigger</a></p>
        </div> <!--your content end-->

    </div> <!--toPopup end-->

	<div class="loader"></div>
   	<div id="backgroundPopup"></div>

	<div class="loader"></div>
   	<div id="backgroundPopup"></div>
   	
	<s:form action="LoginUser" cssClass="bs-example form-horizontal" theme="simple">
	<table cellspacing="10" cellpadding="10" width="100%" height="100%" style="border-collapse: collapse;">
		<tr>
			<td align="center" style="padding-top: .5em;padding-bottom: .5em;">
					<font size="4"><s:text name="USER NAME"/></font>
			<td align="right">
				<s:textfield name="p.name" cssClass="form-control"></s:textfield>
			</td>
		</tr>
		<tr>
			<td align="center">
				<font size="4"><s:text name="PASSWORD"></s:text></font>
			</td>
			<td align="right">
				<s:password name="p.address" cssClass="form-control" showPassword="true"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<s:submit cssClass="btn"></s:submit>
			</td>
		</tr>
	</table>
	</s:form>
</div>
</div>
</body>
</html>