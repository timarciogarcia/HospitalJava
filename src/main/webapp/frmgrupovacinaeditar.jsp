<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="Model.JB_Grupovacina"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

	<meta charset="utf-8">

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"	crossorigin="anonymous">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
	<link rel="stylesheet" href="Css/Style_Cadastros.css">

	<title>Grupo de Vacina</title>
</head>

<body>
	<div>
		<h1>Editar Grupo de Vacina</h1>
			<form name="frmgrupovacinaedicao" action="updategrupovacina">
				<table width="100%">
				   <tbody>
						<tr>
							<td>
								<label for="idestado">Código</label><br>
								<input type="text" SIZE=3 name="idgrupovacina" id="idgrupovacina" readonly value="<%out.print(request.getAttribute("idgrupovacina"));%>">
							</td>
						</tr>
						<tr>
							<td>
								<label for="nome">Nome do Grupo</label><br>
								<input type="text" name="nome" id="nome"  SIZE=55  MAXLENGTH=45	value="<%out.print(request.getAttribute("nome"));%>">
							</td>
						</tr>
						<tr>
							<td align="right" >
								<input type="button" value="Salvar" class="Botao1" onclick="validargrupovacina()" title="Salva as Alterações">
								<button type="button" class="Botao2" title="Cancela e Volta a Tela Anterior" onclick="javascript:window.history.back()">Voltar</button>
															
							</td>
						</tr>
						
					</tbody>
				</table>
			</form>
	</div>
	<script src="Scripts/V_Grupovacina.js"></script>
</body>
</html>