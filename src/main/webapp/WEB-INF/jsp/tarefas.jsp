<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value='/css/main.css'/>" rel="stylesheet"
	type="text/css" />
<title><s:text name="application.title" /></title>
</head>
<body>
	<div class="titleDiv">
		<s:text name="application.title" />
	</div>

	<s:url id="url" action="inputTarefa" />
	<a href="<s:property value="#url"/>">Adicionar Tarefa</a>
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th><s:text name="Status" /></th>
			<th><s:text name="Descrição" /></th>
			<th>&nbsp;</th>
		</tr>
		<s:iterator value="tarefas" status="status">
			<tr>
				<td class="nowrap"><s:if test="%{finalizado == true}">
            	FEITO
            </s:if>
					<s:else>
            	EM ANDAMENTO
            </s:else></td>

				<td class="nowrap"><s:property value="descricao" /></td>
				<td class="nowrap">
					<s:if test="%{!finalizado == true}">
						<s:url action="finalizarTarefa" id="url">
							<s:param name="tarefa.id" value="id" />
						</s:url>
						<a href="<s:property value="#url"/>">Finalizar</a> &nbsp;&nbsp;&nbsp;
					</s:if>
					<s:else>
						<s:url action="recomecarTarefa" id="url">
							<s:param name="tarefa.id" value="id" />
						</s:url>
						<a href="<s:property value="#url"/>">Reabrir Tarefa</a> &nbsp;&nbsp;&nbsp;
					</s:else> 
					
					<s:url action="inputTarefa" id="url">
						<s:param name="tarefa.id" value="id" />
					</s:url> 
					<a href="<s:property value="#url"/>">Editar</a> &nbsp;&nbsp;&nbsp;
					<s:url action="deleteTarefa" id="url">
						<s:param name="tarefa.id" value="id" />
					</s:url> 
					<a href="<s:property value="#url"/>">Apagar</a></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>