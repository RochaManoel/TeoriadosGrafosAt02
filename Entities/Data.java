package Entities;

public class Data {
    private Integer verticeInicial;
    private Integer verticeFinal;
    private Double custo;
    private int population;

    public Data(Integer verticeInicial, Integer verticeFinal, Double custo, int population){
        this.verticeInicial = verticeInicial;
        this.verticeFinal = verticeFinal;
        this.custo = custo;
        this.population = population;
    }

    public Integer getVerticeInicial() {
        return verticeInicial;
    }
    public Integer getVerticeFinal() {
        return verticeFinal;
    }
    public Double getCusto() {
        return custo;
    }
    public int getPopulation() {
        return population;
    }
    
}
