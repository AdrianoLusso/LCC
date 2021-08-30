/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import edd.TP1.Alumno;
import lineales.estaticas.Cola;

/**
 *
 * @author 54299
 */
public class testCola {
    
    public static void main (String[] args)
    {
        Cola cola,colaClon;
        
        
        cola = new Cola();
        colaClon = new Cola();
        
        
        
        //prueba de poner y esVacia
        colaClon = cola.clone();
        System.out.println(colaClon.toString());
        System.out.println(cola.esVacia());
        System.out.println( cola.poner("auto"));
        System.out.println(cola.esVacia());
        System.out.println(cola.obtenerFrente());
        System.out.println( cola.poner("moto"));
        System.out.println( cola.poner("bici"));
        System.out.println( cola.poner("bici"));
        System.out.println( cola.poner("camion"));
        cola.sacar();
        cola.sacar();
        cola.sacar();
        System.out.println( cola.poner("moto"));
        System.out.println( cola.poner("bici"));
        System.out.println( cola.poner("bici"));
        System.out.println( cola.poner("camion"));
        
        System.out.println(cola.toString());
        colaClon = cola.clone();
        cola.sacar();
        System.out.println(cola.toString());
        System.out.println(colaClon.toString());
        colaClon.vaciar();
        System.out.println(colaClon.toString());

        //Test con TDA estudiante.
        
        Cola colaAlumno = new Cola() ;
        
        System.out.println(colaAlumno.poner(new Alumno(2908,43829385,'n',"Adriano","Lusso","Neuquen","Aconcagua",274,"2996089904","adriLusso",0612)));
        System.out.println(colaAlumno.poner(new Alumno(2934,43576385,'f',"Pepe","Sanco","Mendoza","Wiji",666,"299456345","pepin",6666)));
        System.out.println(colaAlumno.poner(new Alumno(2908,43829385,'n',"Adriano","Lusso","Neuquen","Aconcagua",274,"996089904","adriLusso",0612)));
        System.out.println(colaAlumno.toString());
        System.out.println(colaAlumno.sacar());
        System.out.println(colaAlumno.sacar());
        System.out.println(colaAlumno.esVacia());
        System.out.println(colaAlumno.sacar());
       
        
    }
}
