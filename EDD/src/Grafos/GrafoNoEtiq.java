/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import lineales.dinamicas.Lista;
import lineales.estaticas.Cola;

/**
 *
 * @author 54299
 */
public class GrafoNoEtiq {
 
    
    /*
    Esta clase implementa un grafo no etiquetado de forma dinamica.
    */
    
    NodoVert inicio;
    
    //Constructor

    public GrafoNoEtiq() {
        inicio = null;
    }
    
    //Modificadores
    
    public boolean insertarVertice(Object elem)
    {
        /*
        Este metodo inserta un vertice con elem en el grafo,en caso de que no exista.
        */
        NodoVert aux = this.ubicarVertice(elem);
        boolean exito = false;
        
        if(aux == null)
        {
            exito = true;
            inicio = new NodoVert(elem,inicio);
        }
        
        return exito;
    }
    
    private NodoVert ubicarVertice(Object elem)
    {
        /*
        Este metodo busca un vertice con elem en el grafo,y lo retorna.En caso de
        no existir,retorna null.
        */
        NodoVert aux = inicio;
        
        while(aux != null && !aux.getElem().equals(elem))
        {
            aux = aux.getSigVert();
        }
        
        return aux;
    }
    
    public boolean insertarArco(Object origen, Object destino)
    {
        /*
        Este metodo inserta un arco entre los vertices con elemento origen y destino.
        El proceso falla si alguno de los vertices no existr, o el arco entre ambos
        ya existe.
        */
          
        NodoVert auxItr = inicio,auxOrigen = null, auxDestino = null;
        boolean exito = false;
        
        //Verifica existen de vertices.
        while(auxItr != null && (auxOrigen == null || auxDestino == null))
        {
            if(auxItr.getElem().equals(origen))
            {
                auxOrigen = auxItr;
            }
            if(auxItr.getElem().equals(destino))
            {
                auxDestino = auxItr;
            }
            
            auxItr = auxItr.getSigVert();
        }
        
        //Si existen los vertices,intenta crear el arco.
        if( auxOrigen != null & auxDestino != null)
        {
            exito = unirVertices(auxOrigen,auxDestino);           
        }
        
        return exito;
    }
    
    private boolean unirVertices(NodoVert org, NodoVert dest)
            
    {
        /*
        Este metodo intenta unir los vertices ingresados por parametro.Retorna un
        bolean dependiendo de si el arco se pudo crear,o ya existia.
        */
        boolean exito = false;
        
        //Se busca un adyascente con referencia al vertice destino.
        NodoAdy aux = ubicarAdyascente(org.getPrimerAdy(),dest);
        
        if(aux == null)
        {
            //Si no se encontro tal adyascente,se unen los vertices.
            exito = true;
            org.setPrimerAdy(new NodoAdy(dest,org.getPrimerAdy()));
            dest.setPrimerAdy(new NodoAdy(org,dest.getPrimerAdy()));
        }      
        
        return exito;
    }
      
    private NodoAdy ubicarAdyascente(NodoAdy aux,NodoVert buscado)
    {
        /*
        Este metodo busca al vertice ingresado por parametro.Aux es el primer
        adyascente de la lista en la que buscar.
        
        Se usa especificamente para insertar un arco.
        */
        while(aux != null && !aux.getVertice().equals(buscado))
        {
            aux = aux.getSigAdy();
        }
        
        return aux;
    }
    
    public boolean eliminarArco(Object origen,Object destino)
    {
        /*
        Este metodo elimina el arco entre los vertices con elem origen y destino,
        si es que tal arco existe.
        */
        
        NodoVert vertOrg = this.ubicarVertice(origen);
        NodoAdy adyDest,previo;
        boolean exito = false;
        
        if(vertOrg != null)
        {
            //Se busca un adyascente destino en la lista del vertice origen.
            //Si existe,es eliminado. 
            adyDest = vertOrg.getPrimerAdy();
            previo = null; 
            
            while(adyDest != null && !exito)
            {
                if(adyDest.getVertice().getElem().equals(destino))
                {
                     eliminarArcoAux(adyDest.getVertice(),origen);
                     
                     if(previo != null)
                     {
                         previo.setSigAdy(adyDest.getSigAdy());
                     }
                     else
                     {
                         vertOrg.setPrimerAdy(adyDest.getSigAdy());
                     }
                     
                     exito = true;
                }
                else
                {
                    previo = adyDest;
                    adyDest = adyDest.getSigAdy();                    
                }
            }
        }
        
        return exito;
    }
    
    private void eliminarArcoAux(NodoVert vertice, Object buscado)
    {
        /*
        Este metodo elimina el nodo adyascente que vincula al vertice destino con
        el vertice origen.
        */
        
        NodoAdy actual = vertice.getPrimerAdy(),previo = null;
        
        while(actual != null && !actual.getVertice().getElem().equals(buscado))
        {
            previo = actual;
            actual = actual.getSigAdy();
        }
        
        if(previo != null)
        {
            previo.setSigAdy(actual.getSigAdy());
        }
        else
        {
            vertice.setPrimerAdy(actual.getSigAdy());
        }
    }
    
    public boolean eliminarVertice(Object elem)
    {
        /*
        Este metodo elimina un vertice del grafo,en caso de ser encontrado.
        */
        NodoVert encontrado;
        NodoAdy actual;
        boolean exito = false; 
        
        if(inicio != null)
        {
            //Se busca el vertice a eliminar,y se lo desconecta.
            encontrado = desconectarVertice(elem);
            
            if(encontrado != null)
            {
                //Si el vertice a eliminar existia,ahora se eliminan todos los 
                //adyascentes con referencia a este mismo.
                
                exito = true;
               
                for(actual = encontrado.getPrimerAdy();actual != null;
                    actual = actual.getSigAdy() )
                {
                    eliminarArcoAux(actual.getVertice(),encontrado.getElem());
                }
            }
        }
           
        return exito;        
    }
    
    private NodoVert desconectarVertice(Object elem)
    {
        /*
        Este metodo busca el vertice con elem,y lo desconecta del grafo.Retorna
        el vertice desconectado para poder seguir operar con sus adyascentes.
        */
        
        NodoVert actual = inicio ,previo = null;
        
        do
        {
            previo = actual;
            actual = actual.getSigVert();
        }while(actual != null && !actual.getElem().equals(elem));
        
        if(actual != null)
        {
            previo.setSigVert(actual.getSigVert());
        }
        
        return actual;
    }
    
    //Observadores
    
    public boolean existeVertice(Object elem)
    {
        /*
        Este metodo verifica si existe un vertice con elem.
        */
        
        return ubicarVertice(elem) != null;
    }
    
    public boolean existeArco(Object origen,Object destino)
    {
        /*
        Este metodo verifica si existe un arco entre vertices con origen y destino.
        */
        
        //Verifica que exista el vertice origen.
        NodoVert encontrado = ubicarVertice(origen);
        NodoAdy actual;
        boolean existe = false;
        
        if(encontrado != null)
        {
            //Si existe en vertice origen,busca un adyascente al vertice destino.
            //Si lo encuentra,el arco buscado existe.
        
            actual = encontrado.getPrimerAdy();
            
            while(actual != null && !actual.getVertice().getElem().equals(destino))
            {
                actual = actual.getSigAdy();
            }
            
            if(actual != null)
            {
                existe = true;
            }
        }
                    
        return existe;
    }
    
    public boolean existeCamino(Object origen,Object destino)
    {
        /*
        Este metodo retorna un boolean dependiendo de si existe un camino entre
        el origen y el destino
        */
        
        boolean exito = false;    
        NodoVert auxOrg = null,auxDest= null, aux = inicio;
        Lista visitados;
        
        //Se buscan los vertices origen y destino en el grafo.
        while((auxOrg == null ||  auxDest == null) && aux != null)
        {
            if(aux.getElem().equals(origen))
            {
                auxOrg = aux;
            }
            if(aux.getElem().equals(destino))
            {
                auxDest = aux;
            }
            
            aux = aux.getSigVert();
        }
        
        if(auxOrg != null && auxDest != null)
        {
            //Existen los vertices origen y destino.Se procede a buscar el camino.
            visitados = new Lista();
            exito = existeCaminoAux(auxOrg,destino,visitados);
        }
        
        return exito;
    }
    
    private boolean existeCaminoAux(NodoVert actual,Object destino,Lista visitados)
    {
        /*
        Este metodo analiza si el vertice actual tiene elemento destino.Si no lo tiene,
        se trata de seguir analizando el resto de vertices accesibles desde actual.
        Retorna un boolean correspondiente a si se logro,o no,encontrar un vertice con
        elemento destino.
        */
        
        boolean exito = false;
        NodoAdy adyActual;
        
        if(actual != null)
        {
            if(actual.getElem().equals(destino))
            {
                //Se encontro camino.
                exito = true;
            }
            else
            {
                //No se encontro camino.Se prueba seguir buscando.
                visitados.insertar(actual.getElem(), visitados.longitud()+1);
                adyActual = actual.getPrimerAdy();
                
                //Se recorre todos los adyascentes
                while(!exito && adyActual != null)
                {
                    //Se analiza solo los adyascentes que no han sido visitados.
                    if(visitados.localizar(adyActual.getVertice().getElem()) < 0)
                    {
                        exito = existeCaminoAux(adyActual.getVertice(),destino,visitados);
                    }
                    
                    adyActual = adyActual.getSigAdy();
                }
            }
        }
        
        return exito;
    }
    
    public boolean esVacio()
    {
        return inicio == null;
    }
    
    //Propios del tipo
    
    @Override
    public GrafoNoEtiq clone()
    {
        GrafoNoEtiq clon = new GrafoNoEtiq();
        Lista verticesClonados = new Lista(),elemento = new Lista();
        
        if(inicio != null)
        {
            clon.inicio = cloneVertices(this.inicio);       
            cloneArcos(this.inicio,clon.inicio,clon);
        }
        
        return clon;
    }
    
    private void cloneArcos(NodoVert actual,NodoVert actualClon,GrafoNoEtiq grafo)
    {
     
        NodoAdy ady;
        
        if(actual != null)
        {
            for(ady = actual.getPrimerAdy();ady != null; ady = ady.getSigAdy())
            {
                actualClon.setPrimerAdy(new NodoAdy(grafo.ubicarVertice(ady.getVertice().getElem()),actualClon.getPrimerAdy()));
            }       
        
        cloneArcos(actual.getSigVert(),actualClon.getSigVert(),grafo);
        }
            
    }
    
    private NodoVert cloneVertices(NodoVert actual)
    {
      NodoVert clonActual = null;
      NodoAdy adyActual;   
      
        if(actual != null)
        {
            clonActual = new NodoVert(actual.getElem(),cloneVertices(actual.getSigVert()));                                                            
        }
        
        return clonActual;     
    }
   
    
    public Lista listarEnProfundidad()
    {
        /*
        Este metodo retorna una lista con recorrido en profundidad del grafo.
        */
        
        NodoVert actual;
        Lista visitados = new Lista();
        
        //Para cada vertice del grafo,si no fue visitado,se inicia 
        //el recorrido en profundidad.
        for(actual = inicio; actual != null; actual = actual.getSigVert())
        {
            if(visitados.localizar(actual.getElem()) < 0)
            {
                profundidadDesde(actual,visitados);
            }            
        }
        
        return visitados;
    }
    
    private void profundidadDesde(NodoVert vertActual,Lista visitados)
    {
        
        NodoAdy adyActual;
        
        //Se inserta el vertice actual como visitado.
        visitados.insertar(vertActual.getElem(), visitados.longitud()+1);
        
        //Para cada adyascente no visitado,se analiza recursivamente.
        for(adyActual = vertActual.getPrimerAdy();adyActual != null;
            adyActual = adyActual.getSigAdy())
        {
            if(visitados.localizar(adyActual.getVertice().getElem()) < 0)
            {
                profundidadDesde(adyActual.getVertice(),visitados);
            }
        }
    }
    
    public Lista listarEnAnchura()
    {
        /*
        Este metodo retorna una lista con recorrido en anchura del grafo
        */
        
        NodoVert actual;
        Lista visitados = new Lista();
        
        for(actual = inicio; actual != null; actual = actual.getSigVert())
        {
            if(visitados.localizar(actual.getElem()) < 0)
            {
                anchuraDesde(actual,visitados);
            }            
        }
        
        return visitados;
    }
    
    private void anchuraDesde(NodoVert vertActual,Lista visitados)
    {
        Cola aux = new Cola();
        NodoAdy adyActual;
        
        //Agrega el vertice ingresado por parametro a la lista y la cola.
        visitados.insertar(vertActual.getElem(), visitados.longitud()+1);
        aux.poner(vertActual);
        
        while(!aux.esVacia())
        {
            vertActual =(NodoVert) aux.obtenerFrente();
            aux.sacar();
            
            //Se analiza los adyascente del vertice frente actual.
            for(adyActual = vertActual.getPrimerAdy();
                adyActual != null;adyActual = adyActual.getSigAdy())
            {
                if(visitados.localizar(adyActual.getVertice().getElem()) < 0)
                {
                    //Si aun no fue visitado este nodo adyascente,se lo visita.
                    visitados.insertar(adyActual.getVertice().getElem(),visitados.longitud()+1);
                    aux.poner(adyActual.getVertice());
                }
            }
        }     
    }
  
    /*
    * La idea es que primero localices el nodo inicial A e inicialices longitudCaminoMaximo en 0 y caminoMaximo como una nueva lista,
*  Luego recorrer en profundidad todos los caminos que parten de A, siempre actualizando alguna variable de longitudCaminoActual y otra lista de caminoActual. 
* Cuando encontras el nodo final B, chequeas si  longitudCaminoMaximo < longitudCaminoActual ----> longitudCaminoMaximo = longitudCaminoActual y tmb actualizas el caminoMaximo
* Cuando terminas de recorrer retornas caminoMaximo
inverso chequeo para el mas corto
    */
    public Lista caminoMasLargo(Object origen,Object destino)
    {
        /*
        Este metodo retorna la lista con el camino mas largo entre el origen y el
        destino,en caso de que el camino exista.
        */
        
        Lista resultado = new Lista();
        NodoVert verticeOrigen = ubicarVertice(origen);
        
        if(verticeOrigen != null)
        {
            
             resultado = encuentraCaminoMasLargo(verticeOrigen,new Lista(),resultado,destino);
        }
        
        return resultado;
    }
    
    private Lista encuentraCaminoMasLargo(NodoVert actual,Lista caminoActual,
            Lista caminoMaximo,Object destino)
    {
        
        NodoAdy adyActual;
        
     
        if(actual != null)
        {
            
            caminoActual.insertar(actual.getElem(), caminoActual.longitud() + 1);

            if(actual.getElem().equals(destino))
            {
                //Si se encuentra el elemento,y el camino actual es mayor que el
                //maximo,pasa a ser el nuevo maximo.
                
                if(caminoActual.longitud() > caminoMaximo.longitud())
                {
                    caminoMaximo = caminoActual.clone();
                }              
            }
            else
            {
                //No se encontro el elemento.Se sigue la busqueda en profundidad.               
            
                 for(adyActual = actual.getPrimerAdy();adyActual != null;
                 adyActual = adyActual.getSigAdy())
                 {
                    if(caminoActual.localizar(adyActual.getVertice().getElem()) < 0)
                    {
                       caminoMaximo = encuentraCaminoMasLargo(adyActual.getVertice(),caminoActual,
                            caminoMaximo,destino);
                        caminoActual.eliminar(caminoActual.longitud());
                    }   
                 }
            }    
        }
        
        return caminoMaximo;
    }
    
    public Lista caminoMasCorto(Object origen,Object destino)
    {
        /*
        Este metodo retorna la lista con el camino mas corto entre el origen y el
        destino,en caso de que el camino exista.
        */
        
        Lista resultado = new Lista();
        NodoVert verticeOrigen = ubicarVertice(origen);
        
        if(verticeOrigen != null)
        {
            
             resultado = encuentraCaminoMasCorto(verticeOrigen,new Lista(),resultado,destino);
        }
        
        return resultado;
    }
    
     private Lista encuentraCaminoMasCorto(NodoVert actual,Lista caminoActual,
            Lista caminoMinimo,Object destino)
    {

        NodoAdy adyActual;
        
         
     
        if(actual != null)
        {
           
            caminoActual.insertar(actual.getElem(), caminoActual.longitud() + 1);
            
            if(actual.getElem().equals(destino))
            {

                //Si se encuentra el elemento,y el camino actual es mayor que el
                //maximo,pasa a ser el nuevo maximo.
                
                if(caminoMinimo.longitud() == 0 || caminoActual.longitud() < caminoMinimo.longitud())
                {
                    caminoMinimo = caminoActual.clone();
                }              
            }
            else
            {
                //No se encontro el elemento.Se sigue la busqueda en profundidad.               
            
                 for(adyActual = actual.getPrimerAdy();adyActual != null;
                 adyActual = adyActual.getSigAdy())
                 {
                    if(caminoActual.localizar(adyActual.getVertice().getElem()) < 0)
                    {
                        caminoMinimo = encuentraCaminoMasCorto(adyActual.getVertice(),caminoActual,
                            caminoMinimo,destino);
                        caminoActual.eliminar(caminoActual.longitud());
                    }   
                 }
            }    
        }
        
        return caminoMinimo;
    }
     
     public String toString()
     {
         String resultado = "";
         
         if(inicio != null)
         {
             resultado = toStringAux(inicio);
         }
         
         return resultado;
     }
     
     private String toStringAux(NodoVert actual)
     {
         
         String resultado = "";
         NodoAdy adyActual;
         
         for(;actual != null;actual = actual.getSigVert())
         {
             resultado += actual.getElem() + " : ";
             for(adyActual = actual.getPrimerAdy();adyActual != null;adyActual = adyActual.getSigAdy())
             {
                 resultado += adyActual.getVertice().getElem() + ", ";
             }
             resultado = resultado.substring(0, resultado.length()-2);
             resultado += "\n";
         }
         
         return resultado;
     }
}
