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

//listar eventos disponíveis
async function listarEventos() {
    const response = await fetch(`http://localhost:8080/evento/listarEventos`);
    const eventos = await response.json();

    const listaEventos = document.getElementById("listaEventos");
    listaEventos.innerHTML = "";

    eventos.forEach(evento => {
        const item = document.createElement("li");
        item.innerHTML = `${evento.nome} - ${evento.data} - ${evento.local} <button onclick="comprarIngresso(${evento.id})">Comprar</button>`;
        listaEventos.appendChild(item);
    });
}

//comprar um ingresso
async function comprarIngresso(eventoId) {
    const usuarioId = 1; // Altere para pegar o ID do usuário autenticado

    const response = await fetch(`http://localhost:8080/evento/vender/${eventoId}/comprar/${usuarioId}`, {
        method: "POST"
    });

    const result = await response.text();
    alert(result);
}

//adicionar eventos aos botões
document.getElementById("btnCadastrar").addEventListener("click", cadastrarUsuario);
document.getElementById("btnLogin").addEventListener("click", loginUsuario);

//carregar eventos ao carregar a página
window.onload = listarEventos;

async function listarEventos() {
    const response = await fetch(`http://localhost:8080/evento/listarEventos`);
    const eventos = await response.json();

    const listaEventos = document.getElementById("listaEventos");
    listaEventos.innerHTML = ""; // Limpa a lista antes de preencher

    eventos.forEach(evento => {
        const item = document.createElement("li");
        item.innerHTML = `${evento.nome} - ${evento.data} - ${evento.local} <button onclick="comprarIngresso(${evento.id})">Comprar</button>`;
        listaEventos.appendChild(item);
    });
}

// Função para comprar ingresso
async function comprarIngresso(eventoId) {
    const usuarioId = localStorage.getItem('usuarioId'); // Recupera o ID do usuário do localStorage

    if (!usuarioId) {
        alert("Por favor, faça login primeiro.");
        return;
    }

    const response = await fetch(`http://localhost:8080/evento/vender/${eventoId}/comprar/${usuarioId}`, {
        method: "POST"
    });

    const result = await response.text();
    alert(result);
}

// Função para fazer o logout
function logout() {
    localStorage.removeItem('usuarioId'); // Limpa o ID do usuário
    window.location.href = "index.html"; // Redireciona para a tela inicial de login
}

// Carregar eventos quando a página for carregada
window.onload = listarEventos;

function mostrarSecao(secaoId) {
    document.getElementById("login").style.display = "none";
    document.getElementById("formularioCadastro").style.display = "none";
    document.getElementById(secaoId).style.display = "block";
}