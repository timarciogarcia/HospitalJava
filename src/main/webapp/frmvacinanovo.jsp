<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="Model.JavaBeans"%>
<%@ page import="Model.JB_Vacina"%>
<%@ page import="Model.JB_Grupovacina"%>
<%@ page import="java.util.ArrayList"%>


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
<title>Manutenção de Vacinas</title>
</head>

<body>
	<div style="width:100%">
		<h4>Nova Vacina</h4>
		<table style="width:100%;">
			<tbody  style="width:100%;">
				<tr>
					<td>
						<label for="nome">Vacina<br>
						<input type="text" name="nome" id="nome" SIZE=75 MAXLENGTH=55></label>
					</td>
					
					<td>					 
					<label for="idraca" class="labeldoselect">Selecione o Grupo</label><br> 
						<select id="Selecaoespecie" onchange="NovaEspecie();">
							<%
								JB_Grupovacina lista = new JB_Grupovacina();
								ArrayList<JB_Grupovacina> meio = lista.GrupovacinaparaForm();
							%>
							<%
								for (int i = 0; i < meio.size(); i++) {
							%>
							<option value="<%=meio.get(i).getIdgrupovacina()%>"><%=meio.get(i).getNome()%></option>
							<%
								}
							%>
					</select>
					</td>
					
					<td>
						<label for="nome">A Vacina esta ?<br> 
						<input type="radio" class="btn-check" name="options-outlined" id="success-outlined" autocomplete="off" checked> 
						<label class="btn btn-outline-success" for="success-outlined">Ativa</label>&nbsp
						<input type="radio" class="btn-check" name="options-outlined" id="danger-outlined" autocomplete="off">
						<label class="btn btn-outline-danger" for="danger-outlined">Inativa</label>
					</label>
					</td>
					
				</tr>
				<tr>
					<td colspan="3">
						<label for="nome">Laboratorio(s)<br>
						<input type="text" name="laboratorio" id="laboratotio" SIZE=100 MAXLENGTH=100><input type="hidden" name="idespecie" id="idespecie" size="1"><input type="hidden" name="nomeespecie" id="nomeespecie" size="1">			
						
						</label>
					</td>

				</tr>
			</tbody>
		</table>
	</div>
	<h5>Protocolo(s)</h5>
	<div  class="divclass">
		<iframe name="my-iframe" src="frmprotocolo.jsp"> 
		<!-- onload='javascript:(function(o){o.style.height=o.contentWindow.document.body.scrollHeight+"px";}(this));' style="height:200px;width:100%;border:none;overflow:hidden;">-->
		</iframe>
		
	</div>
	<table style="width:100%;">
			<tr>
				<td align="right" >
							<input type="button" value="Salvar/Novo" class="Botao1" onclick="validarpatologianovo(frmpatologianovo.tipo.value='2')" title="Salva a Inserção e Continua Nesta Tela">
							<input type="button" value="Salvar" class="Botao1" onclick="validarpatologianovo(frmpatologianovo.tipo.value='1')" title="Salva o Novo Registro">
					<button type="button" class="Botao2" title="Cancela e Volta Para a Lista " onclick="validarpatologianovo(frmpatologianovo.tipo.value='3')">Voltar</button>														
				</td>
			</tr>
	</table>	
</body>

</html>