const API_URL = "http://localhost:8080"; // Ajuste conforme necessário

// Função para cadastrar um novo usuário
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

// Função para realizar login
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

// Função para listar eventos disponíveis
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