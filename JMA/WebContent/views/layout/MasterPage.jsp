<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:importAttribute name="masterCss" />
<tiles:importAttribute name="pageCss" />
<!-- <link type="text/css" href="css/theme_interiorNavigation/ui.all.css" rel="Stylesheet" /> -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/${masterCss}" /> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/${pageCss}" /> 
<s:head />
</head>
<body>

	

	<div id="wrap">
		<div id="header">
		<%-- <tiles:insertAttribute name="header" />  --%>
		 <tiles:insertAttribute name="menu" /> 
		</div>
		 <%-- <div id="menu">
			<tiles:insertAttribute name="menu" />
		</div> --%> 
		<div id="contentarea" spellcheck="true" >	
					
			<div id="box" spellcheck="true" >				
				<tiles:insertAttribute name="body" />
			</div>		
			<div id="nav" spellcheck="true" >
				<tiles:insertAttribute name="nav" />
			</div>	
		</div>		
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>		
	</div>	
</body>
</html>
