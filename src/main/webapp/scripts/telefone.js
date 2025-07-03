/*
replace(/[^0-9]/g, ""): remove qualquer caractere que não seja número.

maxlength="11": impede que o usuário digite mais do que 11 dígitos.

pattern="[0-9]{10,11}": continua funcionando na validação do formulário

*/

const telefoneInput = document.getElementById("telefone");

  telefoneInput.addEventListener("input", function () {
    // Remove tudo que não for número
    this.value = this.value.replace(/[^0-9]/g, "");
  });