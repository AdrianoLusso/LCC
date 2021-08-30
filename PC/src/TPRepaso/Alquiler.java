/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPRepaso;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 *
 * @author 54299
 */
public class Alquiler {
    //QUEDE EN AVERIGUAR EN COMO ENTRAR AL DOC DE DATE PARA CREAR METODO DE RESTA DE DIAS.
    private int codigo;
    private static int ultimoCodigo = 0;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int posicion;
    private Cliente cliente;
    private Barco barco;
    private static int VALORFIJO = 200;
 
    public Alquiler( int cantDias, int posicion, Cliente cliente, Barco barco) {
        this.codigo = ultimoCodigo++;
        this.fechaInicial = LocalDate.now();
        this.fechaFinal = LocalDate.now().plusDays(cantDias);
        this.posicion = posicion;
        this.cliente = cliente;
        this.barco = barco;
    }
    
    public long calcularValor()
    {
        long diasOcupacion = Duration.between(fechaInicial.atStartOfDay(), fechaFinal.atStartOfDay()).toDays();
        int modulo = barco.calcularModulo();
        
        return diasOcupacion * modulo + VALORFIJO;
    }
        
    //Modificadores

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public static void setVALORFIJO(int VALORFIJO) {
        Alquiler.VALORFIJO = VALORFIJO;
    }

    //Observadores

    public int getCodigo() {
        return codigo;
    }
    
    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public int getPosicion() {
        return posicion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Barco getBarco() {
        return barco;
    }

    public static int getVALORFIJO() {
        return VALORFIJO;
    }
    
    //Propios del metodo

    @Override
    public String toString() {
        return "Alquiler{" + "codigo=" + codigo + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + ", posicion=" + posicion + ", cliente=" + cliente + ", barco=" + barco + '}';
    }
    
    
}

