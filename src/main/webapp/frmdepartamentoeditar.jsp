<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="Model.JB_Departamento"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

	<meta charset="utf-8">

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"	crossorigin="anonymous">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
	<link rel="stylesheet" href="Css/Style_Cadastros.css">

	<title>Departamentos</title>
</head>

<body>
	<div>
		<h1>Editar Departamento</h1>
			<form name="frmdepartamentoedicao" action="alterardepartamento">
				<table width="100%">
				   <tbody>
						<tr>
							<td>
								<label for="iddepartamento">Código</label><br>
								<input type="text" SIZE=3 name="iddepartamento" id="iddepartamento" readonly value="<%out.print(request.getAttribute("iddepartamento"));%>">
							</td>
						</tr>
						<tr>
							<td>
								<label for="nome">Departamento</label><br>
								<input type="text" name="nome" id="nome"  SIZE=58  MAXLENGTH=45	value="<%out.print(request.getAttribute("nome"));%>">
							</td>
						</tr>
						<tr>
							<td align="right" >
								<input type="button" value="Salvar" class="Botao1" onclick="validardepartamento()" title="Salva as Alterações">
								<button type="button" class="Botao2" title="Cancela e Volta a Tela Anterior" onclick="javascript:window.history.back()">Voltar</button>
															
							</td>
						</tr>
						
					</tbody>
				</table>
			</form>
	</div>
 	<script src="Scripts/V_Departamento.js"></script>
</body>
</html>