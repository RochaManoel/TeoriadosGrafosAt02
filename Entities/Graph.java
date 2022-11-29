package Entities;

import java.util.ArrayList;

public class Graph {
    private DataBase dataBase = new DataBase();
    private double [][]Grafo = new double[1000][1000];

    public void setDataBase(DataBase dataBase){
        this.dataBase = dataBase;
    }
    
    public DataBase getDataBase() {
        return dataBase;
    }

    private void newGraph(){
        double [][]Grafo = new double[1000][1000];
        for(int i = 0; i<1000;i++){
            for(int j = 0; j <1000;j++){
                if(i==j){Grafo[i][j] = 0;}
                else{Grafo[i][j] = 999;}
            }
        }
        this.Grafo = Grafo;
    }

    private void setGraph(){
        this.newGraph();
        double [][]Grafo = this.Grafo;
        for(Data aresta : this.dataBase.getArestas()){
            Grafo[aresta.getVerticeInicial()-1][aresta.getVerticeFinal()-1] = aresta.getCusto();
        }
        this.Grafo = Grafo;
    }

    public void editGraph(){
        this.setGraph();
        double [][]Grafo = this.Grafo;
        for(int i = 0; i<1000;i++){
            for(int j = 0; j <1000;j++){
                if(Grafo[i][j] != 999){Grafo[j][i] = Grafo[i][j];}
            }
        }
        this.Grafo = Grafo;
    }


    //Algoritmo de Caminho Minimo
    public void caminhoMinimo(int rankOne, int rankTwo){
        double [][] graphNew = this.Grafo;
        /*
        Construção de Uma Matriz de Nó com indicações dos ranks das cidades necessárias para chegar
        Node [][]MATRIZ = new Node[1000][1000];

        for(int count = 0; count < 1000;count++){
            for(int Count = 0; Count < 1000;Count++){
                if(graphNew[count][Count] == 0){
                    MATRIZ[count][Count] = new Node(0);
                }
                else if(graphNew[count][Count] == 999){
                    MATRIZ[count][Count] = new Node(999);
                }
                else{
                    MATRIZ[count][Count] = new Node(count, Count);
                }
            }
        }
        */
        for(int k = 0; k< 1000; k++){
            for(int i = 0; i < 1000; i++){
                for(int j = 0; j < 1000; j++){
                    if(graphNew[i][j] != 0){
                        if(graphNew[i][k] + graphNew[k][j] < graphNew[i][j]){ 
                            graphNew[i][j] = graphNew[i][k] + graphNew [k][j];
                        }
                    }
                }
            }

        }
        if(graphNew[rankOne][rankTwo] == 999){
            System.out.println("\n\nCaminho Não Encontrado!");
        }
        else{
            System.out.println("\n\nValor do Caminho Minimo: " + graphNew[rankOne][rankTwo]);
        }
    }

}
