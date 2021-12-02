/**
 * 
 */

function validarespecie(){
	let nome = frmespecieedicao.nome.value
	if(nome===""){
		alert('Preencha a Nome')
		frmespecieedicao.nome.focus()
		return false
	} else {
		document.forms["frmespecieedicao"].submit()
	}
} 

function validarespecienovo(){
	let nome = frmespecienovo.nome.value
	let tipo = frmespecienovo.tipo.value
	
	if(tipo=="3"){
		frmespecienovo.tipo.value=tipo
		document.forms["frmespecienovo"].submit()
		return true		
	}
	
	if(nome===""){
		alert('Preencha o Nome')
		frmespecienovo.nome.focus()
		return false
	} else {
		frmespecienovo.tipo.value=tipo
		document.forms["frmespecienovo"].submit()
	}
}


