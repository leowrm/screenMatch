package br.com.alura.screenmatch.excecao;

public class ErroDeConversaoDeAnoExecpion extends RuntimeException {
    private String mensagem;
    public ErroDeConversaoDeAnoExecpion(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
