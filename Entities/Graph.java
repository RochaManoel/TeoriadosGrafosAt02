package Entities;

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
    

}
