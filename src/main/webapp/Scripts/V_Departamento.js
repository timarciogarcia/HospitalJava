/**
 * 
 */

function validardepartamento(){
	let nome = frmdepartamentoedicao.nome.value
	if(nome===""){
		alert('Preencha a Nome')
		frmdepartamentoedicao.nome.focus()
		return false
	} else {
		document.forms["frmdepartamentoedicao"].submit()
	}
} 

function validardepartamentonovo(){
	let nome = frmdepartamentonovo.nome.value
	let tipo = frmdepartamentonovo.tipo.value
	if(tipo=="3"){
		frmdepartamentonovo.tipo.value=tipo
		document.forms["frmdepartamentonovo"].submit()
		return true		
	}
	
	if(nome===""){
		alert('Preencha o Nome')
		frmdepartamentonovo.nome.focus()
		return false
	} else {
		frmdepartamentonovo.tipo.value=tipo
		document.forms["frmdepartamentonovo"].submit()
	}
}

function confirmardepartamento(idcon,nome) {
	let resposta = confirm("Confirma a exclusão do Departamento " + idcon + " com o nome " + nome + " ?" )
	if(resposta===true){
		//alert(idcon)
		window.location.href="excluirdepartamento?iddepartamento=" + idcon
	}
}

