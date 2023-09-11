import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.setDuracaoMinutos(180);
        meuFilme.exibeFichaTecnica();
        System.out.println("Duração do filme: " + meuFilme.getDuracaoMinutos());

        meuFilme.avalia(8);
        meuFilme.avalia(10);
        meuFilme.avalia(5);
        System.out.println("Total de avaliações: " + meuFilme.getTotalAvaliacoes());
        System.out.println("Média das avaliações: " + meuFilme.exibeMedia());

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        lost.avalia(8);
        lost.avalia(10);
        lost.avalia(10);
        System.out.println("Duração para maratonar Lost: " + lost.getDuracaoMinutos());

        Filme outroFilme = new Filme("Avatar 2", 2023);
        outroFilme.setDuracaoMinutos(200);
        outroFilme.avalia(8);
        outroFilme.avalia(10);
        outroFilme.avalia(10);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);
        filtro.filtra(outroFilme);
        filtro.filtra(lost);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.setDuracaoMinutos(200);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        System.out.println(listaDeFilmes.size());
        System.out.println(listaDeFilmes);

        ArrayList<Serie> listaDeSéries = new ArrayList<>();
        listaDeSéries.add(lost);
        System.out.println(listaDeSéries.size());
        System.out.println(listaDeSéries);
    }
}
