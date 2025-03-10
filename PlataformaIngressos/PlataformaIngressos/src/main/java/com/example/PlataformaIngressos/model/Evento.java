package com.example.PlataformaIngressos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String data;
    private String local;
    private String precoIngresso;
    private int ingressosDisponiveis;

    @JsonIgnore
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Compra> participantes = new ArrayList<>();

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(String precoIngresso) {
        this.precoIngresso = precoIngresso;
    }

    public List<Compra> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Compra> participantes) {
        this.participantes = participantes;
    }

    public int getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }

    public void setIngressosDisponiveis(int ingressosDisponiveis) {
        this.ingressosDisponiveis = ingressosDisponiveis;
    }


}
