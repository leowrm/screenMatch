package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoExecpion;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        String busca = "";
        Scanner sc = new Scanner(System.in);
        List<Titulo>titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para buscar: ");
            busca = sc.nextLine();
            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=5e40965";
            try {
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                //Titulo tituloOMDB = gson.fromJson(json, Titulo.class);
                TituloOmdb tituloOMDB = gson.fromJson(json, TituloOmdb.class);
                System.out.println(tituloOMDB);
                // try {
                Titulo meuTitulo = new Titulo(tituloOMDB);
                System.out.println("=============================");
                System.out.println("Titulo já convertido");
                System.out.println(meuTitulo);
                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteuceu o erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique a url");
            } catch (ErroDeConversaoDeAnoExecpion e) {
                System.out.println(e.getMensagem());
            }


        }
        System.out.println(titulos);
        FileWriter escrita = new FileWriter("Filemes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("Programa finalizou corretamente!");
    }


}
