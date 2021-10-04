<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="tarefa==null || tarefa.id == null">
	<s:set name="title" value="%{'Adicionar tarefa'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Editar tarefa'}"/>
</s:else>

<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><s:property value="#title"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:property value="#title"/></h1>
<s:actionerror />
<s:actionmessage />
<s:form action="saveTarefa" method="post">
    <s:textfield name="tarefa.descricao" value="%{tarefa.descricao}" label="Descrição" size="40"/>
    <s:hidden name="tarefa.id" value="%{tarefa.id}"/>
    <s:submit value="%{getText('button.label.submit')}"/>
    <s:submit value="%{getText('button.label.cancel')}" action="index"/>
</s:form>
</body>
</html>