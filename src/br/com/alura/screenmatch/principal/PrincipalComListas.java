package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {

        Filme meuFilme = new Filme("Carros 2", 2012);
        meuFilme.avalia(8);
        Filme outroFilme = new Filme("Avatar", 2012);
        outroFilme.avalia(10);
        var filmeLeo = new Filme("007 Skyfall", 2018);
        filmeLeo.avalia(9);
        Serie serie = new Serie("The last of us",2022);
        serie.setTemporadas(2);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeLeo);
        lista.add(outroFilme);
        lista.add(meuFilme);
        lista.add(serie);

        for ( Titulo item: lista){
            System.out.println(item.getNome());
            if(item instanceof Filme) {
                Filme filme = (Filme) item;
                System.out.println("Classificacao: " + filme.getClassificacao());
            }else{
                System.out.println("Não é um filme! ");
            }
        }

    List<String> buscaPorArtista = new LinkedList<>( );
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Tom Holland");
        buscaPorArtista.add("Nicoas Cage");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Já ordenado: " + buscaPorArtista);

        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));

        System.out.println("Ordenando por ano");
        System.out.println(lista);


    }
}
