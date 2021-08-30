/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas.dinamicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 *
 * @LussoAdriano FAI-2908
 * @LarrubiaAntonio FAI - 2073
 */
public class ArbolGen {
    
    private NodoGen raiz;
    
    //Constructores
    
    public ArbolGen()
    {
        raiz = null;
    }
    
    //Modificadores
    
    public boolean insertar(Object elemNuevo, Object elemPadre)
    {
        /*
        Este metodo ingresa un nuevo nodo en el arbol Generico.Retorna un booleano
        si es que logra ingresarlo.
        
        elemNuevo : tipo Object.Valor que tendra el nodo nuevo.
        elemPadre : tipo Object.Valor que deberia tener el nodo padre del nodo con elemNuevo.
        */
        
        boolean exito;
        NodoGen nodoPadre;
        
        if(raiz == null)
        {
            //Si el arbol esta vacio,se crea un nodo raiz,el cual por definicion,no tiene padre.
            raiz = new NodoGen(elemNuevo);
            exito = true;
        }
        else
        {
            //Si no esta vacio,se busca a algun nodo con elemento elemPadre.
            nodoPadre = obtenerNodo(raiz,elemPadre);
            
            if(nodoPadre != null)
            {
                //Si se encuentra el nodo previamente buscado,se le agrega un hijo izquierdo elemento elemNuevo.
                exito = true;
                nodoPadre.setHijoIzquierdo(new NodoGen(elemNuevo,null,nodoPadre.getHijoIzquierdo()));
            }
            else
            {
                //Sino, la insercion no fue exitosa.
                exito = false;
            }
            
        }
        
        return exito;
    }
    
    public NodoGen obtenerNodo(NodoGen actual,Object elemPadre)
    {
        /*
        Este metodo busca un nodo con valor elemPadre.
        
        actual : de tipo NodoGen.Nodo actual que se va analizando.
        */
        
        NodoGen resultado = null;
        
        if(actual.getElem().equals(elemPadre))
        {
            //Si se encuentra nodo padre,se crea un hijo con valor elemNuevo.
            resultado = actual;
        }
        else
        {
            //Si no lo encuentra,sigue buscando en preorden;
            if(actual.getHijoIzquierdo() != null)
            {
                //Si existe hijo izquierdo,busca por ahi.
                resultado = obtenerNodo(actual.getHijoIzquierdo(),elemPadre);
            }
            
            if(resultado == null && actual.getHermanoDerecho() != null)
            {
                //Si existe hermano derecho,y aun no se encontro el valor elemPadre,busca por ahi.
                resultado = obtenerNodo(actual.getHermanoDerecho(),elemPadre);
            }
        }
        
        return resultado;
    }
    
    public void vaciar()
    {
        /*
        Este metodo vacio el arbol.
        */
        this.raiz = null;
    }
    
    //Observadores
    
    public boolean pertenece(Object elemento)
    {
        /*
        Este metodo retorna un boolean,dependiendo si el arbol contiene algun nodo con el 
        elemento igresado por parametro.
        */
        boolean exito;
        
        if(raiz == null)
        {
            //Si el arbol esta vacio,no hay donde buscar.
            exito = false;
        }
        else
        {
            //Si no esta vacio,se inicia la busqueda.
            exito = perteneceAux(raiz,elemento);
        }
        
        return exito;
    }
    
     private boolean perteneceAux(NodoGen actual, Object elemento)
    {
        /*
        Este metodo retorna un boolean dependiendo si se encuentra un nodo en el arbol
        con el valor elemento.
        
        actual : de tipo NodoGen. Nodo actual que se va analizando.
        */
        
        boolean exito = false;
        
        if(actual.getElem().equals(elemento))
        {
            //Si se encuentra elemento,retorna true;         
            exito = true;
        }
        else
        {
            //Si no lo encuentra,sigue buscando en preorden;
            if(actual.getHijoIzquierdo() != null)
            {
                //Si existe hijo izquierdo,busca por ahi.
                exito = perteneceAux(actual.getHijoIzquierdo(),elemento);
            }
            
            if(!exito && actual.getHermanoDerecho() != null)
            {
                //Si existe hermano derecho,y aun no se encontro el elemento,busca por ahi.
                exito = perteneceAux(actual.getHermanoDerecho(), elemento);
            }
        }
        
        return exito;
    }

    
    public boolean esVacio()
    {
        //Este metodo retorna si el arbol es vacio.
     
        return raiz == null;
    }
    
    public Object padre(Object elemHijo)
    {
        /*
        Este metodo retorna el padre del primer nodo con elemento elemHijo.
        */
               
        Object resultado;
        
        if(raiz == null)
        {
            //Si el arbol es vacio,no existen nodos con elemHijo.
            resultado = null;
        }
        else
        {
            //Si no esta vacio,se inicia la busqueda.
            resultado = padreAux(elemHijo,raiz,null);           
        }
        
        return resultado;
    }
    
    private Object padreAux(Object elemHijo,NodoGen actual,NodoGen padreActual)
    {
        /*
        Este metodo recursivo retorna el elemento del padre del primer nodo del
        arbol, cuyo elemento coincida con elemHijo.Si no lo encuentra,retorna null.
        
        actual : tipo NodoGen.El nodo actual que se examina.
        padreActual : tipo NodoGen.El padre del nodo actual que se esta examinando.
        */
        
        Object resultado = null;
        
        if(actual.getElem().equals(elemHijo))
        {
            //Esto sucede si se encuentra un nodo con elemento elemHijo.
            if(padreActual == null)
            {
                //Si no existe el padre del nodo actual,retorna null.
                resultado = null;
            }
            else
            {
                //Si existe,se retorna el elemento del padre.
                resultado = padreActual.getElem();
            }
        }
        else
        {
            //Sino, se sigue la busqueda.
            if(actual.getHijoIzquierdo() != null)
            {
                //Busqueda por hijo izquierdo.
                resultado = padreAux(elemHijo,actual.getHijoIzquierdo(),actual);
            }
            
            if(resultado == null && actual.getHermanoDerecho() != null)
            {
                //Busqueda por hijo derecho,si aun no se ha encontrado el resultado.
                resultado = padreAux(elemHijo,actual.getHermanoDerecho(),padreActual);
            }
        }
        
        return resultado;
    }
    
    public int altura()
    {
        /*
        Este metodo retorna la altura del arbol.
        */
        
        int resultado;
        
        if(raiz == null)
        {
            //Si el arbol es vacio,se retorna -1.
            resultado = -1;
        }
        else
        {
            //Sino, se inicia el calculo.
            resultado = alturaAux(0,raiz);
        }
        
        return resultado;
    }
    
    private int alturaAux(int alturaActual,NodoGen actual)
    {
        /*
        Este metodo recursivo retorna la altura del arbol.
        
        alturaActual : de tipo int.Es el valor de la altura del nodo actual.
        actual : de tipo NodoGen.Es el nodo en el que nos encontramos.
        */
        int resultado,aComparar;        
           
        if(actual.getHijoIzquierdo() != null)
        {
            //Busqueda por hijo izquierdo,con un nivel mayor de altura.
            resultado = alturaAux(alturaActual+1, actual.getHijoIzquierdo());
        }
        else
        {
            //Sino,se retorna la altura actual como resultado temporal.
            resultado = alturaActual;
        }
        
        if(actual.getHermanoDerecho() != null)
        {
            //Busqueda por hermano derecho,con misma altura.
            aComparar = alturaAux(alturaActual,actual.getHermanoDerecho());
                        
            if(resultado < aComparar)
            {
                //Si el resultado temporal es menor al otro valor,se reemplaza ese valor como el nuevo resultado temporal.
                resultado = aComparar;
            }
        }
        
       
        return resultado;
        
    }
    
    public int nivel(Object elem)
    {
        /*
        Este metodo retorna el nivel del primer nodo con elemento elem.
        */
        
        int resultado;
        
        if(raiz == null)
        {
            //Si el arbol es vacio,retorna -1.
            resultado = -1;
        }
        else
        {
            //Sino,se inicia el calculo.
            resultado = nivelAux(0,elem,raiz);
        }
     
        return resultado;
    }
    
    private int nivelAux(int nivelActual,Object elem,NodoGen actual)
    {
        /*
        Este metodo recursivo busca un nodo con elemento elem,y retorna su nivel.
        Si no lo encuentra,retorna -1.
        
        nivelActual : de tipo int.Representa el nivel del nodo actual.
        actual : de tipo NodoGen.Nodo actual que estamos analizando.
        */
        int resultado = -1;
        
        if(actual.getElem().equals(elem))
        {
            //Si se encuentra nodo de elemento elem,retornaremos el nivel actual,como resultado.
            resultado = nivelActual;
        }
        else
        {
            //Sino, se continua la busqueda.
            if(actual.getHijoIzquierdo() != null)
            {
                //Busqueda por hijo izquierdo,con un nivel mayor.
                resultado = nivelAux(nivelActual+1,elem,actual.getHijoIzquierdo());
            }
            
            if(resultado == -1 && actual.getHermanoDerecho() != null)
            {
                //Busqueda por hijo derecho, si no se encontro el resultado.
                resultado = nivelAux(nivelActual,elem,actual.getHermanoDerecho());
            }
        }
        
        return resultado;
    }
    
    public Lista ancestros(Object elem)
    {
        /*
        Este metodo retorna una lista con todos los ancestros de un nodo elemento elem.
        */
        
        Lista resultado = new Lista();
        
        if(raiz != null)
        {
            //Si el arbol no es vacio,se inicia el proceso.
            ancestrosAux(elem,raiz,resultado);
        }
        
        return resultado;
    }
    
    private boolean ancestrosAux(Object elem,NodoGen actual,Lista resultado)
    {
        /*
        Este metodo recursivo busca al primer nodo de elemento elem,y si lo encuentra,
        agrega a la lista resultado a este mismo,y a todos sus ancestros hasta la raiz.
        
        actual : de tipo NodoGen.Nodo actual que se analiza.
        */
        
        boolean exito = false;
        if(actual.getElem().equals(elem))
        {           
            //Si se encuentra nodo con elemento elem,se termina la busqueda.
            exito = true;
        }
        else
        {
            //Sino,se sigue la busqueda.
            if(actual.getHijoIzquierdo() != null)
            {
                //Busqueda por hijo izquierdo.
                exito = ancestrosAux(elem,actual.getHijoIzquierdo(),resultado);
                if(exito)
                {
                    //Si se encontro el elemento,se agrega ancestro.
                    resultado.insertar(actual.getElem(), 1);
                }
            }
            
            if(!exito && actual.getHermanoDerecho() != null)
            {
                //Busqueda por hijo derecho,si no se encontro el elemento.
                exito = ancestrosAux(elem,actual.getHermanoDerecho(),resultado);
            }
        }
        return exito;
    }
    
    //Propios del tipo
    
    public ArbolGen clone()
    {
        /*
        Retorna un arbol clon del arbol original.
        */
        
        ArbolGen clon = new ArbolGen();
        
        if(this.raiz != null)
        {
            clon.raiz = cloneAux(this.raiz);
        }
        
        return clon;
    }
    
    private NodoGen cloneAux(NodoGen actual)
    {
        /*
        Este metodo recursivo va clonando cada elemento del arbol original,e
        insertandolo en el arbol clon.
        
        Actual : de tipo NodoGen. Es el nodo del arbol original en que se esta parado.
        */
        
        NodoGen clonHijo,clonHermano,clonActual = new NodoGen(actual.getElem());
        
        if(actual.getHijoIzquierdo() != null)
        {
            //Busqueda por hijo izquierdo.
            clonHijo = cloneAux(actual.getHijoIzquierdo());
            clonActual.setHijoIzquierdo(clonHijo);
        }
        
        if(actual.getHermanoDerecho() != null)
        {
            //Busqueda por hijo derecho.
            clonHermano = cloneAux(actual.getHermanoDerecho());
            clonActual.setHermanoDerecho(clonHermano);
        }
        
        return clonActual;
    }
    
    public Lista listarPreorden()
    {
        /*
        Este metodo retorna una lista con los elementos del arbol en preorden.
        */
        
        Lista preorden = new Lista();
        
        if(this.raiz != null)
        {
            //Si el arbol no es vacio, se inicia el proceso.
            generaPreorden(this.raiz,preorden,1);
        }
        
        return preorden;
    }
    
    private int generaPreorden(NodoGen actual,Lista preorden,int posc)
    {
        /*
         Este metodo recursivo es el encargado de ir insertando,elemento a elemento,
        los elementos de arbol en la lista preorden.
        
        actual : de tipo NodoGen.Es el nodo actual que analizamos.
        posc : posicion del proximo elemento a insertar en la lista.
        */
        
        //Se inserta raiz.
         preorden.insertar(actual.getElem(),posc++);
        
        //Va al subarbol izquierdo,y repite proceso.
        if(actual.getHijoIzquierdo() != null)
        {
            posc = generaPreorden(actual.getHijoIzquierdo(),preorden,posc);
        }
        
        //Va al subarbol derecho y repite proceso.
        if(actual.getHermanoDerecho() != null)
        {
            posc = generaPreorden(actual.getHermanoDerecho(),preorden,posc);
        }
        
        return posc;
    }
    
    public Lista listarPosorden()
    {
        /*
        Este metodo retorna una lista con lso elementos del arbol en posorden.
        */
        
        Lista posorden = new Lista();
        
        if(this.raiz != null)
        {
            //Si el arbol no es vacio, se inicia el proceso.
            generaPosorden(this.raiz,posorden,1);
        }
        
        return posorden;
    }
    
    private int generaPosorden(NodoGen actual, Lista posorden, int posc)
    {
        /*
         Este metodo recursivo es el encargado de ir insertando,elemento a elemento,
        los elementos de arbol en la lista posorden.
        
        actual : de tipo NodoGen.Es el nodo actual que analizamos.
        posc : posicion del proximo elemento a insertar en la lista.
        */
        
        if(actual.getHijoIzquierdo() != null)
        {
            //Va al subarbol izquierdo,y repite proceso.
            posc = generaPosorden(actual.getHijoIzquierdo(),posorden,posc);
        }
       
        //Insertar la raiz del subarbol actual.
        posorden.insertar(actual.getElem(), posc++);
                       
        if(actual.getHermanoDerecho() != null)
        {
            //Va al subarbol derecho y repite proceso.
            posc = generaPosorden(actual.getHermanoDerecho(),posorden,posc);
        }
        
        
        return posc;
    }
    
    public Lista listarInorden()
    {
        /*
        Este metodo retorna una lista con lso elementos del arbol en inorden.
        */
        
        Lista inorden = new Lista();
        
        if(this.raiz != null)
        {
            //Si el arbol no es vacio,se inicia el proceso.
            generarInorden(this.raiz,null,inorden,1);
        }
        
        return inorden;
    }
    
    private int generarInorden(NodoGen actual,NodoGen padre,Lista inorden,int posc)
    {
        //Va al subarbol izquierdo.Si no existe,inserta elemento de nodo actual.
        if(actual.getHijoIzquierdo() != null)
        {           
            posc = generarInorden(actual.getHijoIzquierdo(),actual,inorden,posc);
        }
        else
        {
        inorden.insertar(actual.getElem(), posc++);
        }
        
        //Si no es null,ingresa elemento del nodo padre del nodo actual.
        if(padre != null)
        {
         inorden.insertar(padre.getElem(),posc++);
        }
        
        //Recorre los subarboles de los hermanos de nodo actual.
        if(actual.getHermanoDerecho() != null)
        {
            posc = generarInorden(actual.getHermanoDerecho(),null,inorden,posc);
        }
        
        return posc;
    }
    
    public Lista listarPorNiveles()
    {
         /*
        Este metodo retorna una lista con los elementos del arbol ordenados por nivel.
        */
        
       Lista porNiveles = new Lista();
       Cola aux = new Cola();
       int itr;
       
       if(this.raiz != null)
       {
           aux.poner(this.raiz);
           itr = 1;
           
           while(!aux.esVacia())
           {
               NodoGen nodo = (NodoGen) aux.obtenerFrente();
               aux.sacar();
               
               porNiveles.insertar(nodo.getElem(), itr++);
               NodoGen hijo = nodo.getHijoIzquierdo();
               while(hijo != null){
                   aux.poner(hijo);
                   hijo = hijo.getHermanoDerecho();
               }
           }
       }
    return porNiveles;
    }   
    
    @Override
    public String toString()
    {
        /*
        Este metodo retorna los elementos del arbol en un String.
        */
        
        String resultado;
        
        if(this.raiz != null)
        {
            //Si el arbol no es vacio,se incia el proceso.
            resultado = generaToString(this.raiz);
        }
        else
        {
            //Sino,se retorna cadena vacia.
            resultado = "";
        }
        
        return resultado;
    }
    
    private String generaToString(NodoGen actual)
    {
        /*
        Este metodo recursivo genera un String con todos los nodos del arbol.
        
        actual : de tipo NodoGen.Nodo actual que estamos analizando.
        */
        
        String resultado = "";
        NodoGen hijo;
        
        if(actual != null)
        {
            resultado += actual.getElem().toString() + " ---> ";
            hijo =actual.getHijoIzquierdo();
            while(hijo != null)
            {
                resultado += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }
            
            hijo = actual.getHijoIzquierdo();
            while(hijo != null)
            {
                resultado += "\n" + generaToString(hijo);
                hijo = hijo.getHermanoDerecho();
            }
            
        }
        return resultado;
    }
    
    public int grado()
    {
        /*
        Este metodo busca el mayor grado encontrado en el arbol generico.
        */
                
        int resultado;
        
        if(this.raiz != null )
        {
            //Si el arbol no es vacio,se analiza al hijo de la raiz.
            if(this.raiz.getHijoIzquierdo() != null)
            {
                //Si la raiz tiene hijo izquierdo,se inicia la busqueda.
                resultado = gradoAux(this.raiz.getHijoIzquierdo(),1);
            }
            else
            {
                //Sino,el arbol tiene grado 0.
                resultado = 0;
            }
        }
        else
        {
            //Sino,el arbol es vacio y tiene grado -1.
            resultado = -1;
        }
        
        return resultado;
    }
    
    public int gradoSubarbol(Object elem)
    {
        /*
        Este metodo recursivo busca  el grado del primer subarbol del arbol,cuya
        raiz sea de elemento elem.
        */
        
        NodoGen nodoSubarbol;
        int resultado = -1 ;
        
        if(this.raiz != null)
        {
            //Si el arbol no es vacio,se busca un nodo con elemento elem.
            nodoSubarbol = obtenerNodo(this.raiz,elem);
            
            if(nodoSubarbol != null)
            {
                //Si se encontro el nodo buscado,se busca a su hijo izquierdo.
                if(nodoSubarbol.getHijoIzquierdo() != null)
                {
                    //Si el nodo buscado tiene hijo izquierdo,se inicia la busqueda.
                     resultado = gradoAux(nodoSubarbol.getHijoIzquierdo(),1);
                }
                else
                {
                    //Sino,el grado es 0.
                    resultado = 0;
                }
            }                                  
        }          
        
        return resultado;
    }
    
    private int gradoAux(NodoGen actual,int resultado)
    {
        /*
        Este metodo recursivo busca el grado de cada nodo padre,lo compara con el mayor
        almacenado hasta el momento, y retorna progresivamente al nuevo mayor grado.
        actual : de tipo NodoGen.Nodo al cual estamos analizando.
        resultado : de tipo int.El mayor grado encontrado hasta el momento.
        */
        int aComparar;
        
        if(actual.getHermanoDerecho() != null)
        {
            resultado = gradoAux(actual.getHermanoDerecho(),resultado+1);
        }
        
        if(actual.getHijoIzquierdo() != null)
        {
            aComparar = gradoAux(actual.getHijoIzquierdo(),1);
            if(aComparar > resultado)
            {
                resultado = aComparar;
            }
        }
        
        return resultado;
    }
    
    public boolean verificarCamino(Lista aVerificar)
    {
        boolean verific;
        
        verific = verificarCaminoAux(this.raiz,aVerificar,1);
        
        return verific;
    }
    
    private boolean verificarCaminoAux(NodoGen actual,Lista aVerificar,int posc)
    {
        /*
        Este metodo recursivo corrobora que la lista aVerificar,tenga un viaje
        desde la raiz hacia otro nodo del arbol.
        
        actual: de tipo NodoGen.Nodo actual a analizar.
        */
        boolean verific;
        
        
        if(posc > aVerificar.longitud())
        {
            verific = true;
        }
        else
        {
            if(actual != null)
            {
                if(actual.getElem() == aVerificar.recuperar(posc))
                {
                    verific = verificarCaminoAux(actual.getHijoIzquierdo(),aVerificar,posc+1);
                    
                }
                else
                {
                    verific = false;
                }
                
                if(!verific)
                {
                    verific = verificarCaminoAux(actual.getHermanoDerecho(),aVerificar,posc);
                }
            }
            else
            {
                System.out.println("nop");
                verific = false;
            }
        }
        
        return verific;
    }
    
    public Lista listarEntreNiveles(int nivelInf,int nivelSup)
    {
        Lista resultado = new Lista();
        
        if(raiz != null && nivelInf > -1 && nivelSup > -1 && nivelInf <= nivelSup)
        {
            listarEntreNivelesAux(this.raiz,null,resultado,1,0,nivelInf,nivelSup);
        }
        
        return resultado;
    }
    
    private int listarEntreNivelesAux(NodoGen actual,NodoGen padre,Lista resultado,
    int posc,int nivelActual,int nivelInf,int nivelSup)
    {
        //Inspirado en inorden
        if(actual.getHijoIzquierdo() != null && nivelActual < nivelSup)
        {           
            posc = listarEntreNivelesAux(actual.getHijoIzquierdo(),
                   actual,resultado,posc,nivelActual+1,nivelInf,nivelSup);
        }
        else if(nivelActual >= nivelInf)
        {
         
        resultado.insertar(actual.getElem(), posc++);
        }
        
        if(padre != null && nivelActual > nivelInf)
        {
         resultado.insertar(padre.getElem(),posc++);
        }
        
        if(actual.getHermanoDerecho() != null)
        {
            posc = listarEntreNivelesAux(actual.getHermanoDerecho(),null,
                    resultado,posc,nivelActual,nivelInf,nivelSup);
        }
        
        return posc;
    }
}

