package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Classificavel{
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalAvaliacoes;
    private int duracaoMinutos;

    public Titulo(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb){
        this.nome = tituloOmdb.title();
        this.anoLancamento = Integer.valueOf(tituloOmdb.year());
        this.duracaoMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0, 2));
    }

    public String getNome() {
        return nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public int getTotalAvaliacoes(){
        return totalAvaliacoes;
    }

//    public void setNome(String nome) {
//        this.nome = nome;
//    }

//    public void setAnoLancamento(int anoLancamento) {
//        this.anoLancamento = anoLancamento;
//    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do título: " + nome);
        System.out.println("Ano de lançamento: " + anoLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalAvaliacoes++;
    }

    public double exibeMedia(){
        return somaDasAvaliacoes / totalAvaliacoes;
    }

    @Override
    public int getClassificacao() {
        return (int) exibeMedia() / 2;
    }

    @Override
    public String toString() {
        return  "nome='" + nome + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", duração= " + duracaoMinutos + " min";
    }
}
