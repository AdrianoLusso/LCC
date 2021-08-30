/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas.estaticas;

import static Utiles.Funciones.funcionTres;
import lineales.dinamicas.Lista;

/**
 *
 * @author 54299
 */
public class TablaHash {
    
    private static final int TAMANIO = 10;
    private CeldaHash[] tablaHash;
    private int cant;
    
    //Construtor
    
    public TablaHash()
    {
        int iteracion;
        
        tablaHash = new CeldaHash[TAMANIO];
        cant = 0;
        
        for(iteracion = 0;iteracion < TAMANIO;iteracion++)
        {
            tablaHash[iteracion] = new CeldaHash();
        }
    }
    
    //Modificadores
    
    public boolean insertar(Object elem)
    {
        /*
        Este metodo busca a elem en la tabla hash,si es que aun no pertenece.
        */
        boolean continuar = true,exito = false;
        int intento = 1,posc = elem.hashCode() % TAMANIO,incremento = funcionTres(elem.hashCode(),TAMANIO);       
        do
        {
            //Mientras se considere continuar,y no se supere los TAMANIO cantidad de intentos.
            switch (tablaHash[posc].getEstado()) {
                
                case 0:
                    //Si la casilla esta vacia,se ingresa elemento.No se continua analizando.
                    tablaHash[posc].setElem(elem);
                    cant++;
                    
                    exito = true;
                    continuar = false;
                    break;
 
                case 1:   
                    //Si la casilla esta ocupada,se analiza su elemento.
                    if(tablaHash[posc].getElem().equals(elem))
                    {
                        //Si es el elemento buscado,no se puede insertar,ni se continua buscando.
                        exito = false;
                        continuar = false;
                    }
                    else
                    {
                        //Sino,se continua buscando con rehashing.
                        posc = (posc + incremento * intento++) % TAMANIO;
                    }   break;
 
                default:
                    //Si la casilla fue borrada,se continua buscando con rehasing.
                    posc = (posc + incremento * intento++) % TAMANIO;
                    break;
            }
        }while(continuar && intento <= TAMANIO);
        
        return exito;
    }
    
    public boolean eliminar(Object elem)
    {
        /*
        Este metodo elimina a elem del arreglo,si es que pertenece a este.
        */
        
         boolean continuar = true,exito = false;
        int incremento = funcionTres(elem.hashCode(),TAMANIO),intento = 1,posc = elem.hashCode() % TAMANIO;       
        
        do
        {
            //Mientras se considere continuar,y no se supere los TAMANIO cantidad de intentos.
            switch (tablaHash[posc].getEstado()) {
                
                case 0:
                    //Si la casilla esta vacia,se ingresa elemento.No se continua analizando.
                    exito = false;
                    continuar = false;
                    break;
 
                case 1:   
                    //Si la casilla esta ocupada,se analiza su elemento.
                    if(tablaHash[posc].getElem().equals(elem))
                    {
                        //Si es el elemento buscado,no se puede insertar,ni se continua buscando.
                        tablaHash[posc].setElem(null);
                        cant--;
                        
                        exito = true;
                        continuar = false;
                    }
                    else
                    {
                        //Sino,se continua buscando con rehashing.
                        posc = (posc + incremento * intento++) % TAMANIO;
                    }   break;
 
                default:
                    //Si la casilla fue borrada,se continua buscando con rehasing.
                    posc = (posc + incremento * intento++) % TAMANIO;
                    break;
            }
        }while(continuar && intento <= TAMANIO);
        
        return exito;
    }
    
    //Observadores
    
    public boolean pertenece(Object elem)
    {
        /*
        Este metodo retorna un boolean dependiendo si elem pertenece,o no,a la 
        tablas hash.
        */
        
        boolean exito = true;
        int intento,posc,incremento;
        
        if(cant > 0)
        {
            //Si la tabla no esta vacia,se inicia el proceso.
            intento = 1;
            posc = elem.hashCode() % TAMANIO;
            incremento = funcionTres(elem.hashCode(),TAMANIO);
            
            while (exito && tablaHash[posc].getElem() != elem) 
            {
                //Se busca mientras el elemento no haya sido encontrado,o pueda seguir buscandose.

                if (tablaHash[posc].getEstado() != 0 && intento <= TAMANIO)
                {
                    //Si la celda no esta vacio,y no se supero el TAMANIO cantidad de intentos,se sigue buscando.
                    posc = (posc + incremento * intento++) % TAMANIO;
                } else 
                {
                    //Sino,no puede seguir buscandose,y se considera no encontrado.
                    exito = false;
                }
            }
        }
        else
        {
            //Sino, el proceso falla.
            exito = false;
        }
        
      return exito; 
        
        
    }
    
    public boolean esVacio()
    {
        /*
        Retorna un boolean dependiendo si la tabla hash es,o no, vacia.
        */
        
        return cant == 0;
    }
    
    public Lista listar()
    {
        /*
        Este metodo retorna una lista co
        */
        
        Lista resultado = new Lista();
        int iteracion;
        
        if (cant > 0)
        {
            //Si la tabla no esta vacio,se empieza a listar.
                     
            for (iteracion = TAMANIO - 1; iteracion >= 0; iteracion--) 
            {
                if(tablaHash[iteracion].getElem() != null)
                {
                    //Si la casilla no esta vacia,se lista su elemento.
                    resultado.insertar(tablaHash[iteracion].getElem(), 1);
                }
            }
        }
        return resultado;
    }
}
