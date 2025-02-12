document.addEventListener("DOMContentLoaded", function() {
    // Função para carregar os eventos
    function carregarEventos() {
        fetch('/evento/listaEventos')  // URL para pegar eventos da API
            .then(response => response.json())
            .then(data => {
                const eventosLista = document.getElementById("eventos-lista");
                eventosLista.innerHTML = '';  // Limpa a lista antes de adicionar

                data.forEach(evento => {
                    const eventoDiv = document.createElement('div');
                    eventoDiv.classList.add('evento');
                    eventoDiv.innerHTML = `
                        <img src="${evento.imagemUrl}" alt="${evento.nome}">
                        <h3>${evento.nome}</h3>
                        <p>Data: ${evento.data}</p>
                        <button onclick="mostrarDetalhes(${evento.id})">Ver Detalhes</button>
                    `;
                    eventosLista.appendChild(eventoDiv);
                });
            })
            .catch(error => console.error('Erro ao carregar eventos:', error));
    }

    // Função para mostrar detalhes do evento
    function mostrarDetalhes(id) {
        fetch(`/evento/${id}`)  // URL para pegar os detalhes do evento
            .then(response => response.json())
            .then(data => {
                const eventoDetalhes = document.getElementById("evento-detalhes");
                eventoDetalhes.innerHTML = `
                    <h3>${data.nome}</h3>
                    <p>${data.descricao}</p>
                    <p>Data: ${data.data}</p>
                    <p>Preço: R$ ${data.preco}</p>
                    <button onclick="comprarIngresso(${data.id})">Comprar Ingresso</button>
                `;
            })
            .catch(error => console.error('Erro ao carregar detalhes:', error));
    }

    // Função para simular a compra do ingresso
    function comprarIngresso("/{eventoId}/comprar/{usuarioId}") {
        alert(`Ingressos para o evento com ID ${id} comprados!`);
    }

    // Carrega os eventos ao carregar a página
    carregarEventos();
});
