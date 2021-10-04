<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title><s:text name="Daily Tasks"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="Daily Tasks"/></div>
<h1><s:text name="Gerenciador de Tarefas"/></h1>
<s:url id="url" action="inputEmployee" />
<a href="<s:property value="#url"/>">Adicionar Tarefa</a>
<br/><br/>
<table class="borderAll">
    <tr>
        <th><s:text name="Descrição"/></th>
        <th>&nbsp;</th>
    </tr>
    <s:iterator value="tarefas" status="status">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
            <td class="nowrap"><s:property value="descricao"/></td>
            <td class="nowrap">
                <s:url action="inputTarefa" id="url">
                    <s:param name="tarefa.descricao" value="descricao"/>
                </s:url>
                <a href="<s:property value="#url"/>">Editar</a>
                &nbsp;&nbsp;&nbsp;
                <s:url action="deleteTarefa" id="url">
                    <s:param name="tarefa.id" value="id"/>
                </s:url>
                <a href="<s:property value="#url"/>">Apagar</a>
            </td>
        </tr>
    </s:iterator>
    </table>
</body>
</html>