package Entities;

import java.util.ArrayList;

public class DataBase {
    private Integer nVertices = 0;
    private Integer nArestas = 0;
    private ArrayList<Data> arestas = new ArrayList<>();

    public void addVerticesArestas(Integer nVertices, Integer nArestas){
        this.nVertices = nVertices;
        this.nArestas = nArestas;
    }

    public Integer getnVertices() {
        return nVertices;
    }
    public Integer getnArestas() {
        return nArestas;
    }
    public ArrayList<Data> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Data> arestas) {
        this.arestas = arestas;
    }

}
