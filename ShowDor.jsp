<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=Windows-1251"
	pageEncoding="Windows-1251"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
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
<h1 style="font-style: italic" align="center"><font color="yellow">Информация о дорогах по государствам</font></h1>
<html:form action="/selectdor">
Государство:&nbsp; <html:select property="gos">
		<html:optionsCollection property="goss" />
	</html:select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<html:submit value="Выполнить запрос" onclick="return doShowPageDor(this.form)" style="background-color: #e0e0e0"/>
	
	<br><br>
<Table border="1" class="table" width="50%" cellpadding="2" cellspacing="0" bordercolor="#0c91f0" >
<tr>
<th class="" align="center" style="font-size:10pt" >Код дороги</th>
<th  class="" align="center" style="font-size:10pt" >Код государства</th>
<th  class="" align="center" style="font-size:10pt" >Сокращённое название дороги</th>
<th  class="" align="center" style="font-size:10pt" >Название дороги</th>
<th  class="" align="center" style="font-size:10pt" >Код ВЦ</th>
<th  class="" align="center" style="font-size:10pt" >Сокращённое название ВЦ</th>
<th  class="" align="center" style="font-size:10pt" >Национальный язык</th>
<th  class="" align="center" style="font-size:10pt" >Внутренний идентификатор станции</th>
</tr>
<logic:iterate id="tableRow" name="tableRows"  >
<tr>
<TD nowrap="nowrap"><bean:write name="tableRow" property="kodd"></bean:write>&nbsp;</TD>
<TD nowrap="nowrap"><bean:write name="tableRow" property="kodg"></bean:write>&nbsp;</TD>
<TD nowrap="nowrap"><bean:write name="tableRow" property="snazvd"></bean:write>&nbsp;</TD>
<TD nowrap="nowrap"><bean:write name="tableRow" property="nazvd"></bean:write>&nbsp;</TD>
<TD nowrap="nowrap"><bean:write name="tableRow" property="vc"></bean:write>&nbsp;</TD>
<TD nowrap="nowrap"><bean:write name="tableRow" property="vc_names"></bean:write>&nbsp;</TD>
<TD nowrap="nowrap"><bean:write name="tableRow" property="pr_nyaz"></bean:write>&nbsp;</TD>
<TD nowrap="nowrap"><bean:write name="tableRow" property="vc_vidstvc"></bean:write>&nbsp;</TD>
</tr>
</logic:iterate>
</Table>
</html:form>
</body>
</html:html>
