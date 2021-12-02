<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="Model.JavaBeans"%>
<%@ page import="Model.JB_Patologia"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JB_Patologia> lista = (ArrayList<JB_Patologia>) request.getAttribute("patologia");
//System.out.println( request.getAttribute("estados"));
%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="utf-8">
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="Css/Style_Cadastros.css">
	<script src="Scripts/confirmador.js"></script>
	<title>Manutenção de Patologias</title>
</head>

<body>
	<div class="mb-3">
		<h2>Patologias</h2>
		<table class="table table-hover" width="100%">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Descrição</th>
					<th style="align:right;">
							<button type="button" class="Botao1" title="Novo Registro"	onclick="location.href='frmpatologianovo.jsp'">Novo</button> <button type="button" class="Botao2" title="Emite Relatorio" onclick="location.href='reportpatologia'">Relatorio</button> <button type="button" class="Botao3" title="Cancela e Volta ao Menu"	onclick="location.href='Menu'">Menu</button>
					</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td WIDTH="10%"><%=lista.get(i).getIdpatologia()%></td>
					<td WIDTH="20%"><%=lista.get(i).getNome()%></td>
					<td WIDTH="36%"><%=lista.get(i).getDescricao()%></td>
					<td WIDTH="34%" align="right">
						<button type="button" class="BotaoEditar" onclick="location.href='selectpatologia?idpatologia=<%=lista.get(i).getIdpatologia()%>'"  title="Editar/Alterar Esse Registro">Editar</button>
						<button type="button" class="BotaoExcluir" onclick="javascript:confirmarpatologia(<%=lista.get(i).getIdpatologia()%>,'<%=lista.get(i).getNome()%>')"   title="Excluir Esse Registro">Excluir</button>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
			<tr>
				<td colspan=4>
					<div align="right">
						<button type="button" class="Botao1" title="Novo Registro"
							onclick="location.href='frmpatologianovo.jsp'">Novo</button>
						<button type="button" class="Botao2" title="Emite Relatorio"
							onclick="location.href='reportpatologia'">Relatorio</button>
						<button type="button" class="Botao3" title="Cancela e Volta ao Menu"
							onclick="location.href='Menu'">Menu</button>
					</div>

				</td>
			</tr>
		</table>
	</div>
</body>

</html>