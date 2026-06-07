package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classifica;

public class Episodio implements Classifica {
    private int numero;
    private String nome;
    private Serie serie;
    private int totalAvaliacao;

    public int getTotalAvaliacao() {
        return totalAvaliacao;
    }

    public void setTotalAvaliacao(int totalAvaliacao) {
        this.totalAvaliacao = totalAvaliacao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClassificacao() {
        if (totalAvaliacao >= 100){
            return 4;
        }
        return 2;
    }
}

