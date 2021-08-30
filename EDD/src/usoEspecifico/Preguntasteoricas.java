/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usoEspecifico;

/**
 *
 * @author 54299
 */
public class Preguntasteoricas {
    
    /*
    1. Qué tipo de relación entre elementos define un TDA Mapeo?

    Se define una relacion de uno a uno,o de uno a muchos.Depende de la forma
    que deseemos implementarlo.
    
    2. Cuáles son las operaciones básicas del TDA Mapeo?
    
    Las operaciones basicas son
    
    *asociar
    *desasociar
    *obtenerValor
    *obtenerConjuntoDominio
    *ObtenerConjuntoRango
    
    3. En qué se parecen y en qué se diferencian el TDA Mapeo a Uno y el TDA Diccionario o Tabla de
    Búsqueda?

    Similitudes:
    
    El diccionario tiene un funcionamiento de mapeo a uno en si mismo.
    Se guardan pares (x,y).
    Los metodos de insercion,eliminacion y obtencion de valores propios
    
    Diferencias:
    Los retornos de los metodos que permiten ver todos los valores X(dominios y claves)
    e Y(rangos y datos).
    
    4. Qué tipo de relación hay entre los pares que almacena un TDA Mapeo a Uno y los valores que
    almacena el TDA Diccionario?

    Existen una relacion de uno a uno,donde a cada clave y valor de dominio,solo le puede corresponder
    un dato o valor de rango,respectivamente.
    
    5. ¾Cuándo es una buena elección una Tabla Hash para implementar el TDA Diccionario? ¾Cuándo
    no lo es?
    
    Tabla Hash tiene una tiempo de ejecucion de O(1),haciendolo mas eficiente que un AVL,que lo tiene
    de O(log n).Aun asi, en ciertos casos termina siendo mas eficiente utilizar la implementacion de ABB.
    Esos casos son:
    
    *Cuando la tabla hash tiene un tamanio muy pequenio para la cantidad de pares que se desean guardar.
    *Cuando hay mucha colision en la funcion hash,causando que en hash cerrado,se deba abusar de rehashing,y
    en hash abierto,que se generen listan largas en cada posicion.
    
    6. Si se desea implementar un TDA Diccionario para almacenar los alumnos de una universidad ¾qué
    implementación será más adecuada: Tabla Hash o árbol AVL?
    
    Lo mas conveniente seria utilizar tabla hash,y enfocarse en crear una buena funcion hash de entrada.Dado
    que seguramente la clave sea un nro entero,utilizar una funcion hash con operacion como % sobre X numero,division entera
    y otro tipo de cuentas,permitira generar una buena distibribucion de los pares en la tabla.
    
    7. Dado que ambos son árboles balanceados, es lo mismo usar un árbol AVL que un árbol Heap para
    implementar el TDA Diccionario?
    
    No es lo mismo,heap cuenta con 2 desventajas claves en relacion a un AVL:
    
    *No permite la busqueda ni eliminacion de cualquiera de los elementos almacenados en el arbol.
    Esto se debe a que para encontrar un elemento,puede llegar a ser necesario recorrer casi todo,o todo
    el arbol.Esto es algto que no sucede en un AVL,que es un ABB que se balancea solo.Al ser un ABB,su busqueda
    es de orden O(log n),haciendolo mucho mas eficiente que un heap.
    
    8.¾Sería posible implementar el TDA Cola de Prioridad usando un árbol AVL? Compare la eficiencia
    de las operaciones en dicha implementación con las implementaciones sugeridas en este capítulo
    (Heap y Lista de Colas).
    
    9. Por qué al implementar Cola de Prioridad con árbol Heap es necesario agregar el orden de llegada
    y en la implementación con Lista de Colas no?
    */
}
