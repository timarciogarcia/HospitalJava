/**
 * 
 */

function validarestado(){
	let uf = frmestadoedicao.uf.value
	let nome = frmestadoedicao.nome.value
	if(uf===""){
		alert('Preencha a UF')
		frmestadoedicao.uf.focus()
		return false
	}else if(nome===""){
		alert('Preencha a Nome')
		frmestadoedicao.nome.focus()
		return false
	} else {
		document.forms["frmestadoedicao"].submit()
	}
} 

function validarestadonovo(){
	let uf = frmestadonovo.uf.value
	let nome = frmestadonovo.nome.value
	let tipo = frmestadonovo.tipo.value
	
	if(tipo=="3"){
		frmestadonovo.tipo.value=tipo
		document.forms["frmestadonovo"].submit()
		return true		
	}
	
	if(uf===""){
		alert('Preencha a UF')
		frmestadonovo.uf.focus()
		return false
	}else if(nome===""){
		alert('Preencha o Nome')
		frmestadonovo.nome.focus()
		return false
	} else {
		frmestadonovo.tipo.value=tipo
		document.forms["frmestadonovo"].submit()
	}
}


