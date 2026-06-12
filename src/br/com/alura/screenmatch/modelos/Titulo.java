package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoExecpion;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {


    private String nome;

    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacao;
    private int totalAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloOMDB) {
        this.nome = tituloOMDB.title();
        if(tituloOMDB.year().length() >4 ){
            throw new ErroDeConversaoDeAnoExecpion("Não consegui converter o ano porque tem mais de 4 caracteceres");
        }
        this.anoDeLancamento = Integer.valueOf(tituloOMDB.year());
        this.duracaoEmMinutos = Integer.valueOf(tituloOMDB.runtime().substring(0,2));

    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public String getNome() {
        return nome;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getTotalAvaliacoes(){
        return totalAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome: " + nome);
        System.out.println("Ano de lancamento: " + anoDeLancamento);
    }

    public void avalia(double nota) {
        somaDasAvaliacao += nota;
        totalAvaliacoes++;
    }

    public double pegaMedia() {
        return somaDasAvaliacao/totalAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "\nnome: " + nome  +
                "\nAnoDeLancamento: " + anoDeLancamento
                + "\nDuraçao em minutos:  " + duracaoEmMinutos;
    }
}


