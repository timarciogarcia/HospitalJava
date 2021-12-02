<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="Model.JB_Estado"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

	<meta charset="utf-8">

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"	crossorigin="anonymous">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
	<link rel="stylesheet" href="Css/Style_Cadastros.css">

	<title>Estados</title>
</head>
<body>
	<div>
		<h1>Novo Estado</h1>
			<form name="frmestadonovo" action="inserirestado">
				<table width="100%">
				   <tbody>
						<tr>
							<td>
								<label for="uf">Unidade Federativa</label><br>
								<input autofocus type="text" SIZE=3  name="uf" id="uf" MAXLENGTH=2 >
							</td>
						</tr>
						<tr>
							<td>
								<label for="nome">Estado</label><br>
								<input type="text" name="nome" id="nome"  SIZE=55  MAXLENGTH=45 >
								<input type="hidden" name="tipo" id="tipo" value='1' >
							</td>
						</tr>
						<tr>
							<td align="right" >
  								<input type="button" value="Salvar/Novo" class="Botao1" onclick="validarestadonovo(frmestadonovo.tipo.value='2')" title="Salva a Inserção e Continua Nesta Tela">
  								<input type="button" value="Salvar" class="Botao1" onclick="validarestadonovo(frmestadonovo.tipo.value='1')" title="Salva o Novo Registro">
								<button type="button" class="Botao2" title="Cancela e Volta Para a Lista " onclick="validarestadonovo(frmestadonovo.tipo.value='3')">Voltar</button>														
							</td>
						</tr>
						
					</tbody>
				</table>
			</form>
	</div>
	<script>"javascript:frmcontato.uf.focus()""</script>
	<script src="Scripts/validador.js"></script>
</body>
</html>