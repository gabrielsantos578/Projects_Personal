/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Website.model;

/**
 *
 * @author Sindicato
 */
public class Compra {
    
    private int codigoCompra;
    private String cpfCliente;
    private int numPedido;
    private String statusPedido;
    private String dataCompra;
    private double valorFinal;

    public Compra() {
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
     * @return the cpfCliente
     */
    public String getCpfCliente() {
        return cpfCliente;
    }

    /**
     * @param cpfCliente the cpfCliente to set
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    /**
     * @return the numPedido
     */
    public int getNumPedido() {
        return numPedido;
    }

    /**
     * @param numPedido the numPedido to set
     */
    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    /**
     * @return the statusPedido
     */
    public String getStatusPedido() {
        return statusPedido;
    }

    /**
     * @param statusPedido the statusPedido to set
     */
    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    /**
     * @return the dataCompra
     */
    public String getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the valorFinal
     */
    public double getValorFinal() {
        return valorFinal;
    }

    /**
     * @param valorFinal the valorFinal to set
     */
    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
    
}
