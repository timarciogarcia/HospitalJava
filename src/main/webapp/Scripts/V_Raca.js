/**
 * 
 */

function validarraca(){
	let nome = frmracaedicao.nome.value
	if(nome===""){
		alert('Preencha a Nome')
		frmracaedicao.nome.focus()
		return false
	} else {
		document.forms["frmracaedicao"].submit()
		return true				
	}
} 

function validarracanovo(){
	let nome = frmracanovo.nome.value
	let tipo = frmracanovo.tipo.value
	let ide  = frmracanovo.idespecie.value
	
	if(tipo=="3"){
		frmracanovo.tipo.value=tipo
		document.forms["frmracanovo"].submit()
		return true		
	}
	
 	if(nome===""){
		alert('Preencha o Nome')
		frmracanovo.nome.focus()
		return false
	} else if (ide==="") {
		alert('Preencha a Espécie')
		frmracanovo.Selecaoespecie.focus()
		return false
	} else {
		frmracanovo.tipo.value=tipo
		document.forms["frmracanovo"].submit()
	}

}

function TrocaEspecie(){
	
	var select = document.getElementById('Selecaoespecie');
	var value1 = select.options[select.selectedIndex].value;
	frmracaedicao.idespecie.value=value1
}

function NovaEspecie(){
	
	var select = document.getElementById('Selecaoespecie');
	var value1 = select.options[select.selectedIndex].value;
	frmracanovo.idespecie.value=value1
}
