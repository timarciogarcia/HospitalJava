<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="Model.JavaBeans"%>
<%@ page import="Model.JB_Departamento"%>
<%@ page import="java.util.ArrayList"%>
<%


ArrayList<JB_Departamento> lista = (ArrayList<JB_Departamento>) request.getAttribute("departamento");
//System.out.println( request.getAttribute("Departamento"));
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
	<script src="Scripts/V_Departamento.js"></script>
	<title>Manutenção de Departamento</title>
</head>

<body>
	<div class="mb-3">
		<h2>Departamentos</h2>
		<table class="table table-hover" width="100%">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>
						<div align="right">
							<button type="button" class="Botao1" title="Novo Registro"
								onclick="location.href='frmdepartamentonovo.jsp'">Novo</button> <button type="button" class="Botao2" title="Emite Relatorio"
								onclick="location.href='reportdepartamento'">Relatorio</button>	<button type="button" class="Botao3" title="Cancela e Volta ao Menu"
								onclick="location.href='Menu'">Menu</button>
						</div>
					</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getIddepartamento()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td  align="right">
						<button type="button" class="BotaoEditar" onclick="location.href='selecionardepartamento?iddepartamento=<%=lista.get(i).getIddepartamento()%>'"  title="Editar/Alterar Esse Registro">Editar</button>
						<button type="button" class="BotaoExcluir" onclick="javascript:confirmardepartamento(<%=lista.get(i).getIddepartamento()%>,'<%=lista.get(i).getNome()%>')"   title="Excluir Esse Registro">Excluir</button>
					</td>
				</tr>
				<%
				}
				%>
				<tr>
					<td colspan=3 align="right">
							<button type="button" class="Botao1" title="Novo Registro"
								onclick="location.href='frmdepartamentonovo.jsp'">Novo</button>
							<button type="button" class="Botao2" title="Emite Relatorio"
								onclick="location.href='reportdepartamento'">Relatorio</button>
							<button type="button" class="Botao3" title="Cancela e Volta ao Menu"
								onclick="location.href='Menu'">Menu</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>

</html>