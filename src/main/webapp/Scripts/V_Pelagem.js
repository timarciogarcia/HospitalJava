/**
 * 
 */

function validarpelagem(){
	let nome = frmpelagemedicao.nome.value
	if(nome===""){
		alert('Preencha a Pelagem')
		frmpelagemedicao.nome.focus()
		return false
	} else {
		document.forms["frmpelagemedicao"].submit()
	}
} 

function validarpelagemnovo(){
	let nome = frmpelagemnovo.nome.value
	let tipo = frmpelagemnovo.tipo.value
	
	if(tipo=="3"){
		frmpelagemnovo.tipo.value=tipo
		document.forms["frmpelagemnovo"].submit()
		return true		
	}
	
	if(nome===""){
		alert('Preencha a Pelagem')
		frmpelagemnovo.nome.focus()
		return false
	} else {
		frmpelagemnovo.tipo.value=tipo
		document.forms["frmpelagemnovo"].submit()
	}
}