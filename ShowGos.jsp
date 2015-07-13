<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=Windows-1251"
	pageEncoding="Windows-1251"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html:html>
<head>
<title>Лабораторная работа</title>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
<meta name="GENERATOR" content="Rational Application Developer">
</head>
<script language="JavaScript">
function doShowPageDor(thisform){
thisform.submit();
	return true;
}
</script>
<body bgcolor="green">
<h1 style="font-style: italic" align="center"><font color="yellow">Выдача информации о дорогах по государствам</font></h1>
<html:form action="/selectdor">

Государство:&nbsp; <html:select property="gos">
		<html:optionsCollection property="goss" />
	</html:select>

	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button onclick="return doShowPageDor(this.form)" style="background-color: #e0e0e0">Выполнить запрос</button>

	<!--<html:submit value="Выполнить запрос" onclick="return doShowPageDor(this.form)" style="background-color: #e0e0e0"/>-->

</html:form>
</body>
</html:html>
