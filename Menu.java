import java.util.ArrayList;
import java.util.Scanner;

import Auxiliares.City;
import Auxiliares.Input;
import Entities.Data;
import Entities.DataBase;
import Entities.Graph;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public ArrayList<City> listCities;
    public Graph graph;

    public Menu(){
        boolean control = true;
        int parametroR = 0;
        while(control){
            System.out.println("Digite a Opção Desejada:\n[0] - Fechar Programa\n[1] - Adicionar Parâmetro R\n[2] - Encontrar Caminho Mínimo");
            int option = sc.nextInt();
            switch(option){
                case 0:
                    control = false;
                    System.out.println("Programa Encerrado com Sucesso!");
                    break;
                case 1:
                    this.listCities = new ArrayList<>();

                    //Leitura do Arquivo
                    new Input(this.listCities);

                    //Digitação do Parametro R
                    parametroR = this.getR(parametroR);
                    
                    //Criar base de dados
                    DataBase dBase = new DataBase();
                    
                    //Adicionar a quantidade de vertices e arestas
                    dBase.addVerticesArestas(this.listCities.size(), this.nArestas(parametroR));

                    //Adicionar arestas array
                    dBase.setArestas(this.getArestas(parametroR));

                    //Criar Grafo
                    graph = new Graph();

                    //Adicionar os dados ao Grafo
                    graph.setDataBase(dBase);

                    //Criar Matriz de Grafo
                    graph.editGraph();

                    //Grafo criado com Sucesso!
                    System.out.println("Grafo criado a Partir do Parâmetro "+parametroR);
                    break;
                case 2:
                    if(parametroR == 0){
                        System.out.println("Erro, Grafo não criado, pois o Parâmetro R é igual a 0. Por favor, retorne a Opção 01.");
                    }
                    else{
                        //Entrada das Cidades ou Rank

                        //aplicar Algoritmo de Caminho Minimo

                        //imprimir resultado do Caminho Minimo

                    }
                    break;
                default:
                    System.out.println("Comando Invalido");
                    break;
            }
        }
    }

    private int getR(int r){
        System.out.println("Digite o Valor do Parâmetro R:");
        r = sc.nextInt();
        return r;
    }

    private Integer nArestas(int parametroR){
        int count = 0;
        for(City cityCurrent : this.listCities){
            for(City cityNext : this.listCities){
                double distance = distanceCalculation(cityCurrent, cityNext);
                if(distance != 0 && distance <= parametroR){
                    count++;
                }
            }
        }
        return count;
    }

    public double distanceCalculation(City cityCurrent, City cityNext){
        double x = Math.pow((cityNext.getLatitude() - cityCurrent.getLatitude()),2);
        double y = Math.pow((cityNext.getLongitude() - cityCurrent.getLongitude()),2);
        double result = Math.sqrt(x + y);
        return result;
    }

    private ArrayList<Data> getArestas(int parametroR){
        ArrayList<Data> list = new ArrayList<>();
        for(City cityCurrent : this.listCities){
            for(City cityNext : this.listCities){
                double distance = distanceCalculation(cityCurrent, cityNext);
                if(distance != 0 && distance <= parametroR){
                    int vInicial = cityCurrent.getRank();
                    int vFinal = cityNext.getRank();
                    int population = cityNext.getPopulation();
                    list.add(new Data(vInicial, vFinal, distance, population));
                }
            }
        }
        return list;
    }


}
