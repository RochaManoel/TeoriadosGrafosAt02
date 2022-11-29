package Entities;

import java.util.ArrayList;

public class Node {
    private ArrayList<Integer> caminho = new ArrayList<>();

    public Node(ArrayList<Integer> caminho, Integer num){
        this.caminho = caminho;
        this.caminho.add(num);
    }

    public Node(Integer inicial, Integer chegada){
        ArrayList<Integer> aux = new ArrayList<>();
        aux.add(inicial);
        aux.add(chegada);
        this.caminho = aux;
    }

    public Node(Integer option){
        if(option == 0 ){
            ArrayList<Integer> aux = new ArrayList<>();
            aux.add(0);
            this.caminho = aux;
        }
        if(option==999){
            ArrayList<Integer> auxiliar = new ArrayList<>();
            auxiliar.add(0);
            this.caminho = auxiliar;
        }
    }

    public ArrayList<Integer> getCaminho() {
        return caminho;
    }

    public void setCaminho(ArrayList<Integer> caminho) {
        this.caminho = caminho;
    }

    public String imprimir(){
        String str = new String();
        for(Integer i : this.caminho){
            str = str+" "+i+" -> ";
        }

        return str;
    }
}
