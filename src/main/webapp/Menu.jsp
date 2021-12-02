<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- page import="Model.JB_Login" 
	JB_Login objlogin = (JB_Login) request.getAttribute("ObjUsuario");
-->  
<!DOCTYPE html>
<html lang="en">
<head>
<title>Sistema UseVet Versão 1.2</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<Style>
		body { 
		  background-image: url('Imagens/FOTO1.jpg');
		  background-size: cover;
		  font-family: arial,helvetica,serif;
		  font-size: .8em;
		  font-weight: bold;
		  text-transform: uppercase;
		  text-align: left;
		}
	</Style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #f1de32;" style="font-size: 10px;">

  <div class="collapse navbar-collapse" id="navbarNavDropdown">

    <ul class="navbar-nav">

      <li class="nav-item dropdown">
        <a  class="nav-item nav-link"  href="#">Clientes<span class="sr-only">(Página atual)</span></a>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-item nav-link" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Agenda
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="font-size: 1em;">
          <a class="dropdown-item" href="#">Agenda</a>
          <a class="dropdown-item" href="#">Escala</a>
          <a class="dropdown-item" href="#">Configuração</a>
        </div>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-item nav-link"  href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Vendas
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="font-size: 1em;">
          <a class="dropdown-item" href="#">PDV</a>
          <a class="dropdown-item" href="#">Minhas Vendas</a>
          <a class="dropdown-item" href="#">Movimento do Caixa</a>
          <a class="dropdown-item" href="#">Vendas</a>
          <a class="dropdown-item" href="#">Recebimento</a>
          
        </div>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-item nav-link" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Comissões
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="font-size: 1em;">
          <a class="dropdown-item" href="#">Em Aberto</a>
          <a class="dropdown-item" href="#">Extratos</a>
          <a class="dropdown-item" href="#">Minhas Comissões</a>
        </div>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-item nav-link" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size: 1em;">
          Inteligency
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="font-size: 1em;">
          <a class="dropdown-item" href="#">Produtividade</a>
          <a class="dropdown-item" href="#">Vendas</a>
        </div>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-item nav-link" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Consultas
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="font-size: 1em;">
          <a class="dropdown-item" href="#">Débito de Clientes</a>
          <a class="dropdown-item" href="#">Preços</a>
          <a class="dropdown-item" href="#">Aniversários</a>
          <a class="dropdown-item" href="#">Ranking de Clientes</a>          
          <a class="dropdown-item" href="#">Vacinação</a>          
        </div>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-item nav-link" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Cadastros
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="font-size: 1em;">
          <a class="dropdown-item" href="mainespecie">Espécies</a>
          <a class="dropdown-item" href="mainraca">Raças</a>
          <a class="dropdown-item" href="mainpelagem">Pelagem</a>
          <a class="dropdown-item" href="mainpatologia">Patologias</a>          
          <a class="dropdown-item" href="maingrupovacina">Grupo de Vacinas</a>          
          <a class="dropdown-item" href="mainvacina">Vacinas</a>
          <a class="dropdown-item" href="#">Exames</a>
          <a class="dropdown-item" href="#">Documentos</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="estado">Estados</a>
          <a class="dropdown-item" href="maindepartamento">Departamentos</a>
        </div>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-item nav-link" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Internações
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="font-size: 1em;">
          <a class="dropdown-item" href="#">Pacientes Internados</a>
          <a class="dropdown-item" href="#">Mapa de Execução</a>
          <a class="dropdown-item" href="#">Histórico</a>
          <a class="dropdown-item" href="#">Parâmetros Clínicos </a>          
          <a class="dropdown-item" href="#">Modelo de Prescrição</a>
          <a class="dropdown-item" href="#">Quarto(Boxe)</a>
        </div>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-item nav-link" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Financeiro
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="font-size: 1em;">
          <a class="dropdown-item" href="#">Lançamentos</a>
          <a class="dropdown-item" href="#">Contas a Pagar</a>
          <a class="dropdown-item" href="#">Demostrativo</a>
          <a class="dropdown-item" href="#">Fluxo de Caixa</a>          
          <a class="dropdown-item" href="#">Contas e Cartões</a>
          <a class="dropdown-item" href="#">Fornecedores</a>
          <a class="dropdown-item" href="#">Formas de Pagamento</a>
        </div>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-item nav-link" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Estoque e Serviços
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="font-size: 1em;">
          <a class="dropdown-item" href="#">Produtos e Serviçoes</a>
          <a class="dropdown-item" href="#">Compras</a>
          <a class="dropdown-item" href="#">Saídas de Estoque</a>
          <a class="dropdown-item" href="#">Análise de Estoque</a>          
          <a class="dropdown-item" href="#">Inventário</a>
          <a class="dropdown-item" href="#">Grupos de Produtos</a>
          <a class="dropdown-item" href="#">Marcas</a>
        </div>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-item nav-link" href="LogOut" style="font-size: 1em;">Sair<span class="sr-only">(Página atual)</span></a>
      </li>
<!--  <li class="nav-item dropdown" style="align:rigth;">
        <a class="nav-item nav-link" href="#" style="font-size: 1em;"><strong>Usuário:objlogin.getUsuario()</strong></a>
      </li>
 --> 
			  	
    </ul>
  </div>
</nav>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</html>
