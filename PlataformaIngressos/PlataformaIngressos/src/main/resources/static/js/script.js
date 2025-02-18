const API_URL = "http://localhost:8080";

//cadastrar um novo usuário
async function cadastrarUsuario() {
    const nome = document.getElementById("nomeCadastro").value;
    const email = document.getElementById("emailCadastro").value;
    const senha = document.getElementById("senhaCadastro").value;

    const response = await fetch(`${API_URL}/usuario/cadastrarUsuario`, {
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

    const response = await fetch(`${API_URL}/usuario/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, senha })
    });

    const result = await response.text();
    alert(result);
}

//listar eventos disponíveis
async function listarEventos() {
    const response = await fetch(`${API_URL}/evento/listarEventos`);
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

    const response = await fetch(`${API_URL}/evento/vender/${eventoId}/comprar/${usuarioId}`, {
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