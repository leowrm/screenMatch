public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double somaDasAvaliacao;
    int totalAvaliacoes;
    int duracaoEmMinutos;


    void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lancamento: " + anoDeLancamento);
    }

    void avalia(double nota) {
        somaDasAvaliacao += nota;
        totalAvaliacoes++;
    }

    double pegaMedia() {
    return somaDasAvaliacao/totalAvaliacoes;
    }
}