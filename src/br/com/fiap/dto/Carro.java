package br.com.fiap.dto;

public class Carro {
    // atributos
    private String placa;
    private String cor;
    private String descricao;
    // construtor vazio
    public Carro(){
    }
    // metodos getters/setters (alt+insert)
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
