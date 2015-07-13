<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page isErrorPage="true" %>
<html:html>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=CP1251"
pageEncoding="CP1251"
%>
<META http-equiv="Content-Type" content="text/html; charset=Windows-1251">
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet"
	type="text/css">
<TITLE>Лабораторная работа: Ошибка</TITLE>
</HEAD>
<% if(session==null){ %>
<logic:forward name="noSession"/>
<% } %>
<BODY>
<html:errors/>
<ul>
<% if(exception!=null){%>
<%= exception.getMessage()
 %>
<% } %>
</ul>
<a href="javascript:history.back()">Вернуться назад</a>
</body>
</html:html>
