//cadastrar um novo usuário
async function cadastrarUsuario() {
    const nome = document.getElementById("nomeCadastro").value;
    const email = document.getElementById("emailCadastro").value;
    const senha = document.getElementById("senhaCadastro").value;

    const response = await fetch(`http://localhost:8080/usuario/cadastrarUsuario`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nome, email, senha })
    });

    const result = await response.text();
    alert(result);
}

//realizar login
async function loginUsuario() {
    const email = document.getElementById("emailLogin").value;
    const senha = document.getElementById("senhaLogin").value;

    const response = await fetch(`http://localhost:8080/usuario/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, senha })
    });

    const result = await response.text();
    alert(result);

    if (result === "Login bem-sucedido.") {
        window.location.href = "/tela1.html"; // Redireciona para a tela1.html
    }

}


// Função para fazer o logout
function mostrarSecao(secaoId) {
    document.getElementById("login").style.display = "none";
    document.getElementById("formularioCadastro").style.display = "none";
    document.getElementById(secaoId).style.display = "block";
}



