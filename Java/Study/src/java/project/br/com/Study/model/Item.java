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
public class Item {
    
    private int codigoItem;
    private Compra compra;
    private Produto produto;
    private Double quantidadeItem;
    private Double valorTotal;

    public Item() {
    }

    public Item(int codigoItem, Compra compra, Produto produto, Double quantidadeItem, Double valorTotal) {
        this.codigoItem = codigoItem;
        this.compra = compra;
        this.produto = produto;
        this.quantidadeItem = quantidadeItem;
        this.valorTotal = valorTotal;
    }

    /**
     * @return the codigoItem
     */
    public int getCodigoItem() {
        return codigoItem;
    }

    /**
     * @param codigoItem the codigoItem to set
     */
    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    /**
     * @return the compra
     */
    public Compra getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidadeItem
     */
    public Double getQuantidadeItem() {
        return quantidadeItem;
    }

    /**
     * @param quantidadeItem the quantidadeItem to set
     */
    public void setQuantidadeItem(Double quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
