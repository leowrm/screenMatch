import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("Carros 2");
        meuFilme.setAnoDeLancamento(2012);
        meuFilme.setDuracaoEmMinutos(195);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

       // meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        meuFilme.avalia(9.9);

      //  System.out.println("Total de avaliações: " + meuFilme.getTotalAvaliacoes());
        //System.out.println("Nota média do filme: " + meuFilme.pegaMedia());

        Serie serie = new Serie();

        serie.setNome("The last of us");
        serie.setAnoDeLancamento(2022);
        serie.exibeFichaTecnica();
        serie.setTemporadas(2);
        serie.setEpisodiosPorTemporada(8);
        serie.setMinutosPorEpisodio(45);

        System.out.println("Duração para completar a série : " + serie.getDuracaoEmMinutos());

        Filme outroFilme = new Filme();
        outroFilme.setNome("Avatar 2");
        outroFilme.setAnoDeLancamento(2012);
        outroFilme.setDuracaoEmMinutos(210);

        CalculadoraDeTempo calculador = new CalculadoraDeTempo();
        calculador.inclui(meuFilme);
        calculador.inclui(outroFilme);
        calculador.inclui(serie);
        System.out.println(calculador.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);
        filtro.filtra(outroFilme);

        Episodio ep = new Episodio();
        ep.setNumero(1);
        ep.setSerie(serie);
        ep.setTotalAvaliacao(349);
        filtro.filtra(ep);



    }
}