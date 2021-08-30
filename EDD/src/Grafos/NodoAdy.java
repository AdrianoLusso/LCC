/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;


/**
 *
 * @author 54299
 */
public class NodoAdy {
    
    /*
    Esta clase representa a los nodos adyascentes creados para ser almacenados
    como un atributo de los nodos vertices,en la implementacion dinamica de grafo.
    */
    
    private NodoVert vertice;
    private NodoAdy sigAdy;
    
    //Constructor

    public NodoAdy(NodoVert vertice, NodoAdy sigAdy) {
        this.vertice = vertice;
        this.sigAdy = sigAdy;
    }
    
    //Modificadores

    public void setVertice(NodoVert vertice) {
        this.vertice = vertice;
    }

    public void setSigAdy(NodoAdy sigAdy) {
        this.sigAdy = sigAdy;
    }
    
    //Observadores

    public NodoVert getVertice() {
        return vertice;
    }

    public NodoAdy getSigAdy() {
        return sigAdy;
    }
    
    
}
