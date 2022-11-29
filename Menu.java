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
                        
                        System.out.println("Digite a Cidade de Origem: ");
                        int rankOne = this.getRankCity() - 1;
                        System.out.println("Digite a Cidade de Chegada: ");
                        int rankTwo = this.getRankCity() - 1;
                        graph.caminhoMinimo(rankOne, rankTwo);

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

    private int getRankCity(){
        int rank = -1;
        boolean control = true;
        while(control){
            String CityOne = this.getName();
            for(City c:this.listCities){
                if(c.getName().equals(CityOne)){
                    control = false;
                    rank = c.getRank();
                }
            }
            if(control){
                System.out.println("Cidade não encontrada, por favor Digite Novamente!");
            }
            else{
                System.out.println("Cidade encontrada com Sucesso!");
            }
        }
        return rank;
    }

    private String getName(){
        String city = "";
        boolean control = true;
        while(control){
            city = sc.nextLine();
            if(city !=""){
                control = false;
            }
        }
        return city;
    }

}
