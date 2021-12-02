/**
 * 
 */

function validarpatologia(){
	let nome = frmpatologiaedicao.nome.value
	let descricao=frmpatologiaedicao.descricao.value
	if(nome===""){
		alert('Preencha a Nome')
		frmpatologiaedicao.nome.focus()
		return false
	} else if(descricao===""){
		alert('Preencha a Descrição')
		frmpatologiaedicao.descricao.focus()
		return false
	} else {
		document.forms["frmpatologiaedicao"].submit()
	}
} 

function validarpatologianovo(){
	let nome = frmpatologianovo.nome.value
	let descricao=frmpatologianovo.descricao.value
	let tipo = frmpatologianovo.tipo.value
	
	if(tipo=="3"){
		frmpatologianovo.tipo.value=tipo
		document.forms["frmpatologianovo"].submit()
		return true		
	}
	
	if(nome===""){
		alert('Preencha o Nome')
		frmpatologianovo.nome.focus()
		return false
	} else if(descricao===""){
		alert('Preencha a Descrição')
		frmpatologianovo.descricao.focus()
		return false
	} else {
		frmpatologianovo.tipo.value=tipo
		document.forms["frmpatologianovo"].submit()
	}
}


