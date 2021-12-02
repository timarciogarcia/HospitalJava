/**
 * 
 */
function confirmar(idcon,nome) {
	let resposta = confirm("Confirma a exclusão do contato " + idcon + " com o nome " + nome + " ?" )
	if(resposta===true){
		//alert(idcon)
		window.location.href="delete?idcon=" + idcon
	}
}

function confirmarestado(idestado,nome) {
	let resposta = confirm("Confirma a exclusão do estado " + idestado + " com o nome " + nome + " ?" )
	if(resposta===true){
		//alert(idcon)
		window.location.href="deleteestado?idestado=" + idestado
	}
}

function confirmarespecie(idespecie,nome) {
	let resposta = confirm("Confirma a exclusão da especie " + idespecie + " com o nome " + nome + " ?" )
	if(resposta===true){
		//alert(idcon)
		window.location.href="deleteespecie?idespecie=" + idespecie
	}
}

function confirmarraca(idraca,nome) {
	let resposta = confirm("Confirma a exclusão da especie " + idraca + " com o nome " + nome + " ?" )
	if(resposta===true){
		//alert(idcon)
		window.location.href="deleteraca?idraca=" + idraca
	}
}

function confirmarpelagem(idpelagem,nome) {
	let resposta = confirm("Confirma a exclusão da pelagem " + idpelagem + " com o nome " + nome + " ?" )
	if(resposta===true){
		//alert(idcon)
		window.location.href="deletepelagem?idpelagem=" + idpelagem
	}
}

function confirmarpatologia(idpatologia,nome) {
	let resposta = confirm("Confirma a exclusão da Patologia " + idpatologia + " com o nome " + nome + " ?" )
	if(resposta===true){
		//alert(idcon)
		window.location.href="deletepatologia?idpatologia=" + idpatologia
	}
}

function confirmargrupovacina(idgrupovacina,nome) {
	let resposta = confirm("Confirma a exclusão do grupo " + idgrupovacina + " com o nome " + nome + " ?" )
	if(resposta===true){
		//alert(idcon)
		window.location.href="deletegrupovacina?idgrupovacina=" + idgrupovacina
	}
}
