<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
    
<html lang="pt-br">

<head>

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>Sistema UseVet Versão 1.2</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="Css/Style_FrmLogin.css">

	<script>
		function buscadominio(){
		const dominio = window.document.URL
		FrmLogin.dominio.value=dominio
		}
	</script>

</head>

<body>

  <div id="login-container">

    <h1>Autenticação</h1>
    <form name="FrmLogin" action="Login">

      <input  type="hidden" readonly name="dominio"  id="dominio" value="" placeholder="Seu Dominio sera capturado aqui..." title="Preenchimento Automatico Pelo SIstema">

      <label  for ="usuario">Usuário</label>
      <input  type="text" name="usuario" id="usuario" placeholder="Digite seu Usuário" autocomplete="off" title="Seu Nome de Usuário">
      
      <label  for ="senha">Senha</label>
      <input  type="password" name="senha" id="senha" placeholder="Digite sua senha" onBlur="buscadominio()" title="Sua Senha de Usuário">      
      
      <input  type="button" value="Validar" onclick="V_Login()" class="btn btn-success"  title="Clique Aqui Para Entrar no Sistema">

    </form>

    <script src="Scripts/V_FrmLogin.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </div>

</body>

</html>