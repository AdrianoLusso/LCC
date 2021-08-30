/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas.estaticas;

/**
 *
 * @author 54299
 */
public class CeldaHash {
    
    private Object elem;
    private int estado;
    
    //Creador
    
    public CeldaHash()
    {
        elem = null;
        estado = 0;
    }
    
    //Modificadores

    public void setElem(Object elem)
    {
        this.elem = elem;
        if(elem != null)
        {
            estado = 1;
        }
        else
        {
            estado = -1;
        }
    }
    //Observadores
    
    public Object getElem()
    {
        return elem;
    }
    
    public int getEstado()
    {
        return estado;
    }
}
