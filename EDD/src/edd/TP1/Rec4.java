/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.TP1;

/**
 *
 * @author 54299
 */
public class Rec4 {
    
    public static void main (String[] args)
    {
        String frase = "estudiante";
        char letra = 'e';
        int ultimaPosc = frase.length() - 1;
        
        System.out.println(poscPrimLetra(frase,letra,0));
        System.out.println(poscUltLetra(frase,letra,ultimaPosc));
        System.out.println(cadenaMasInversa(frase,ultimaPosc));
    }
    
    public static int poscPrimLetra (String frase, char letra,int posc)
    {
        /*
        Este metodo retorna la primera posicion de una letra ingresada por parametro,en un String
        tambien ingresado por parametro.En caso de no existir,se retorna -1.Debe ingresarse
        el parametro posc con el valor 0.
        */     
        
        if(posc == frase.length())
        {
            posc = -1;   
        }
        else if(frase.charAt(posc) != letra)
        {
                posc = poscPrimLetra(frase,letra,++posc);                                            
        }
       
       return posc;                
    }
    
    public static int poscUltLetra (String frase, char letra,int posc)
    {
        /*
        Este metodo retorna la ultima posicion de una letra ingresada por parametro,en un String
        tambien ingresado por parametro.En caso de no existir,se retorna -1.Debe ingresarse
        el parametro posc con el valor frase.lenght - 1.
        */     
        
        
        if(posc == 0)
        {
            posc = -1;   
        }
        else if(frase.charAt(posc) != letra)
        {
            posc = poscUltLetra(frase,letra,--posc);                                            
        }
       
       return posc;
    }
    
    public static String cadenaMasInversa(String frase,int posc)
    {
        frase += frase.charAt(posc);

        if(posc > 0)
        {
            frase = cadenaMasInversa(frase,--posc);
        }
        
        return frase;
    }
}
