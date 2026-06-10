package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Carros 2", 2012);
        meuFilme.setAnoDeLancamento(2012);
        meuFilme.setDuracaoEmMinutos(195);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

       // meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        meuFilme.avalia(9.9);

      //  System.out.println("Total de avaliações: " + meuFilme.getTotalAvaliacoes());
        //System.out.println("Nota média do filme: " + meuFilme.pegaMedia());

        Serie serie = new Serie("The last of us",22);

        serie.exibeFichaTecnica();
        serie.setTemporadas(2);
        serie.setEpisodiosPorTemporada(8);
        serie.setMinutosPorEpisodio(45);

        System.out.println("Duração para completar a série : " + serie.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar", 2012);
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

        var filmeLeo = new Filme("007 Skyfall", 2018);
        filmeLeo.setAnoDeLancamento(2018);
        filmeLeo.avalia(9);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeLeo);
        listaDeFilmes.add(outroFilme);
        listaDeFilmes.add(meuFilme);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme " + listaDeFilmes.get(0).getNome());
        System.out.println("toString do filme: " + listaDeFilmes.get(0).toString());
        System.out.println(listaDeFilmes);


 
    }
}