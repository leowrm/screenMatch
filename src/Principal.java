public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.nome = "Carros 2";
        meuFilme.anoDeLancamento = 2012;
        meuFilme.duracaoEmMinutos = 195;

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        meuFilme.avalia(9.9);

        System.out.println(meuFilme.somaDasAvaliacao);
        System.out.println(meuFilme.totalAvaliacoes);
        System.out.println(meuFilme.pegaMedia());
    }
}