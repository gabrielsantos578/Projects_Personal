/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.br.com.Study.model;

/**
 *
 * @author Sindicato
 */
public class Compra {
    
    private int codigoCompra;
    private Double valorFinal;

    public Compra() {
    }

    public Compra(int codigoCompra, Double valorFinal) {
        this.codigoCompra = codigoCompra;
        this.valorFinal = valorFinal;
    }

    /**
     * @return the codigoCompra
     */
    public int getCodigoCompra() {
        return codigoCompra;
    }

    /**
     * @param codigoCompra the codigoCompra to set
     */
    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    /**
     * @return the valorFinal
     */
    public Double getValorFinal() {
        return valorFinal;
    }

    /**
     * @param valorFinal the valorFinal to set
     */
    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }
    
    
    
}
