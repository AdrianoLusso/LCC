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
public class Alumno {
    
    /*
    Esta clase representa objetos alumnos de una escuela.
    */
    
    //atributos
    
    private int legajo;
    private int numeroDni;
    private boolean tipoDni; //TRUE representa el tipo nuevo,FALSE el antiguo.
    private String nombre;
    private String apellido;
    private String ciudadDomicilio;
    private String calleDomicilio;
    private int numeroDomicilio;
    private String telefono;
    private String usuario;
    private int clave;
    
    //constructores
    
    public Alumno(int legajo)
    {
        /*
        Constructor de Alumno solo con campos claves.Usa valores por defecto
        para el resto de atributos.
        
        */
        
        this.legajo = legajo;
        numeroDni = 0;
        tipoDni = true;
        nombre = "NO INGRESADO";
        apellido = "NO INGRESADO";
        ciudadDomicilio = "NO INGRESADO";
        calleDomicilio = "NO INGRESADO";
        numeroDomicilio = 0;
        telefono = "0";
        usuario = "NO INGRESADO";
        clave = 0;       
    }
    
    public Alumno (int legajo, int numeroDni,char tipoDni, String nombre, String apellido,
            String ciudadDomicilio,String calleDomicilio, int numeroDomicilio, String telefono, String usuario, int clave)
    {
        /*
        Constructor de Alumno.       
        */
        
        this.legajo = legajo;
        this.numeroDni = numeroDni;
        
        if(tipoDni == 'n')
        {
            this.tipoDni = true;
        }
        else
        {
            this.tipoDni = false;
        }
        
        this.nombre = nombre;
        this.apellido =apellido;
        this.ciudadDomicilio = ciudadDomicilio;
        this.calleDomicilio = calleDomicilio;
        this.numeroDomicilio = numeroDomicilio;
        this.setTelefono(telefono);
        this.setUsuario(usuario);
        this.clave = clave;      
    }
    
    //Modificadores
    
    public void setNombre(String nomb)
    {
        nombre = nomb.toUpperCase();
    }
    
    public void setApellido(String apll)
    {
        apellido = apll.toUpperCase();
    }
    
    public void setCiudadDomicilio(String ciuDom)
    {
        ciudadDomicilio = ciuDom.toUpperCase();
    }
    
    public void setCalleDomicilio(String callDom)
    {
        calleDomicilio = callDom.toUpperCase();
    }
    
    public void setNumeroDomicilio(int numDom)
    {
        numeroDomicilio = numDom;
    }
    
    public void setTelefono(String telefono)
    {
        if(verificaNumero(telefono) && telefono.length() == 10)
        {
            telefono = telefono;
        }
        else
        {
            telefono = "0";
        }
    }
    
    public void setUsuario(String usu)
    {
        if(verificaEspacios(usu))
        {
            usuario = "NO INGRESADO";
        }
        else
        {
            usuario = usu.trim();
        }
    }
    
    public void setClave(int cla)
    {
        if(cla < 9999 && cla > 1000)
            clave = cla;
        else
        {
            clave = 0;
        }
    }
    
    //observadores
    
    public int getLegajo()
    {
        return legajo;
    }
            
       public int getNumeroDni()
    {
        return numeroDni;
    }         
       
    public String getTipoDni()
    {
        String tipo;
        
        if(tipoDni)
        {
            tipo = "nuevo";
        }
        else
        {
            tipo = "antiguo";
        }
        
        return tipo;
    }
            
    public String getNombre()
    {
        return nombre;
    }
    
    public String getApellido()
    {
        return apellido;
    }
    
    public String getCiudadDomicilio()
    {
        return ciudadDomicilio;
    }
    
    public String getCalleDomicilio()
    {
        return calleDomicilio;
    }
    
    public int getNumeroDomicilio()
    {
        return numeroDomicilio;
    }
    
    public String getTelefono()
    {
        return telefono;
    }
    
    public String getUsuario()
    {
        return usuario;
    }
    
    public boolean equals(Alumno otroAlumno)
    {
        return this.legajo == otroAlumno.getLegajo();
    }
    
    public String toString()
    {
        return nombre + apellido + ", legajo " + legajo;
    }
    
    //propios del tipo
    
    private static boolean verificaEspacios(String usuario)
    {
        /*
        Este metodo verifica si un usuario,ingresado por parametro,tiene espacios
        en medio del mismo usuario.Excluye del analisis a aquellos que puedan eliminarse
        con el metodo trim.
        usuario : representa el usuario a analizar.
        */
        
        boolean tieneEspacios = false;
        int longitud,contador = 1;
        
        longitud = usuario.length();
        
        while(contador < longitud && !tieneEspacios)
        {
            if(usuario.charAt(contador) == ' ')
            {
                tieneEspacios = true;
            }
            else
            {
                contador++;
            }
        }
        return tieneEspacios;
    }
    
    private static boolean verificaNumero (String telefono)
    {
        boolean numeroCorrecto = true;
        int posicionAux = 0;
        
        
        while(posicionAux < telefono.length() && numeroCorrecto)
        {
            if(!Character.isDigit(telefono.charAt(posicionAux++)))
            {
                numeroCorrecto = false;
            }
        }
        
        return numeroCorrecto;
    }
}