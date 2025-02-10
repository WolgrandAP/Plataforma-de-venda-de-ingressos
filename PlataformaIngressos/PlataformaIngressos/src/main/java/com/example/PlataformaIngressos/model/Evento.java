package com.example.PlataformaIngressos.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private double precoIngresso;
    private int quantidadeIngresso;
    private int ingressosDisponiveis;

    @ManyToMany(mappedBy = "eventosComprados")
    private Set<Usuario> participantes = new HashSet<>();

    public Evento() {}

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

    public double getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }

    public int getQuantidadeIngresso() {
        return quantidadeIngresso;
    }

    public void setQuantidadeIngresso(int quantidadeIngresso) {
        this.quantidadeIngresso = quantidadeIngresso;
    }

    public Set<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Usuario> participantes) {
        this.participantes = participantes;
    }

    public int getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }

    public void setIngressosDisponiveis(int ingressosDisponiveis) {
        this.ingressosDisponiveis = ingressosDisponiveis;
    }

    public void venderIngreeso() {
        if (this.getIngressosDisponiveis()>0) {
            this.setIngressosDisponiveis(getIngressosDisponiveis()-1);
        }
    }

    public void adicionarParticipante(Usuario usuario) {
        participantes.add(usuario);
    }
}
