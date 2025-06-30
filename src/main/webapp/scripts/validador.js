/**
 *  Validação de formulário
 * @author estudo
 */

function validar() {
	let nome = frmContato.nome.value; // variavel nome = do formulário chamado frmContato, no campo nome o valor.
	let telefone = frmContato.telefone.value;
	let email = frmContato.email.value;

	if (nome === "") { // se o campo nome estiver vazio:
		alert("Preencha o campo nome");
		frmContato.nome.focus(); // POSICIONA O MOUSE NOVAMENTE SOBRE O CAMPO NOME.
		return false; // SE O USUARIO NÃO PREENCHER A INFORMAÇÃO, O FORMULÁRIO NÃO ENVIARÁ AS INFORMAÇÕES PARA CAMADA CONTROLLER
	}
	else if (telefone === "") {
		alert("Preencha o campo telefone");
		frmContato.telefone.focus();
		return false;
	}
	else if(email === ""){
		alert("Preencha o campo e-mail");
				frmContato.email.focus();
				return false;
	}
	else{
		document.forms["frmContato"].submit();
	}
	
}