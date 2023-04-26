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
public class Item {
    
    private int idItem;
    private Compra codigoCompra;
    private Produto codigoProduto;
    private String nomeProduto;
    private double precoProduto;
    private int quantidadeProduto;
    private double valorTotal;

    public Item() {
    }
    
    

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the codigoCompra
     */
    public Compra getCodigoCompra() {
        return codigoCompra;
    }

    /**
     * @param codigoCompra the codigoCompra to set
     */
    public void setCodigoCompra(Compra codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    /**
     * @return the codigoProduto
     */
    public Produto getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(Produto codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the precoProduto
     */
    public double getPrecoProduto() {
        return precoProduto;
    }

    /**
     * @param precoProduto the precoProduto to set
     */
    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    /**
     * @return the quantidadeProduto
     */
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    /**
     * @param quantidadeProduto the quantidadeProduto to set
     */
    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
