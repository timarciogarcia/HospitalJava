/**
 * 
 */

function validargrupovacina(){
	let nome = frmgrupovacinaedicao.nome.value
	if(nome===""){
		alert('Preencha a Nome')
		frmgrupovacinaedicao.nome.focus()
		return false
	} else {
		document.forms["frmgrupovacinaedicao"].submit()
	}
} 

function validargrupovacinanovo(){
	let nome = frmgrupovacinanovo.nome.value
	let tipo = frmgrupovacinanovo.tipo.value
	
	if(tipo=="3"){
		frmgrupovacinanovo.tipo.value=tipo
		document.forms["frmgrupovacinanovo"].submit()
		return true		
	}
	
	if(nome===""){
		alert('Preencha o Nome')
		frmgrupovacinanovo.nome.focus()
		return false
	} else {
		frmgrupovacinanovo.tipo.value=tipo
		document.forms["frmgrupovacinanovo"].submit()
	}
}


