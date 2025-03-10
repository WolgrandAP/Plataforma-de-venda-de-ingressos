package com.example.PlataformaIngressos.dto;

import com.example.PlataformaIngressos.model.Evento;

public class EventoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String precoIngresso;
    private int quantidadeIngresso;
    private int ingressosDisponiveis;

    public EventoDTO(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.descricao = evento.getData();
        this.precoIngresso = evento.getPrecoIngresso();
        this.ingressosDisponiveis = evento.getIngressosDisponiveis();
    }

    public EventoDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(String precoIngresso) {
        this.precoIngresso = precoIngresso;
    }

    public int getQuantidadeIngresso() {
        return quantidadeIngresso;
    }

    public void setQuantidadeIngresso(int quantidadeIngresso) {
        this.quantidadeIngresso = quantidadeIngresso;
    }

    public int getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }

    public void setIngressosDisponiveis(int ingressosDisponiveis) {
        this.ingressosDisponiveis = ingressosDisponiveis;
    }
}
