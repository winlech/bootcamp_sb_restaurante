package com.example.restaurante;

public class Prato {

    private Long id;
    private double preco;
    private String descricao;
    private int qtd;

    public Prato(Long id, double preco, String descricao, int qtd) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.qtd = qtd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
