
function V_Login(){
	let usuario = FrmLogin.usuario.value
	let senha = FrmLogin.senha.value
	if (usuario===""){
		//alert('Preencha o Usuario')
		FrmLogin.usuario.focus()
		return false
	} else if (senha===""){
		//alert('Preencha a Senha')
		FrmLogin.senha.focus()
		return false
	} else {
		document.forms["FrmLogin"].submit()
	}
} 