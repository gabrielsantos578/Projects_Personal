/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.model;

/**
 *
 * @author Aluno
 */
public class Item {

    private int codigoItens;
    private Venda Venda;
    private Produto Produto;
    private Double quantidadeProduto;
    private Double valorProduto;
    private Double valorTotal;

    public Item() {
    }

    public Item(int codigoItens, Venda Venda, Produto Produto, Double quantidadeProduto, Double valorProduto, Double valorTotal) {
        this.codigoItens = codigoItens;
        this.Venda = Venda;
        this.Produto = Produto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
        this.valorTotal = valorTotal;
    }

    /**
     * @return the codigoItens
     */
    public int getCodigoItens() {
        return codigoItens;
    }

    /**
     * @param codigoItens the codigoItens to set
     */
    public void setCodigoItens(int codigoItens) {
        this.codigoItens = codigoItens;
    }

    /**
     * @return the Venda
     */
    public Venda getVenda() {
        return Venda;
    }

    /**
     * @param Venda the Venda to set
     */
    public void setVenda(Venda Venda) {
        this.Venda = Venda;
    }

    /**
     * @return the Produto
     */
    public Produto getProduto() {
        return Produto;
    }

    /**
     * @param Produto the Produto to set
     */
    public void setProduto(Produto Produto) {
        this.Produto = Produto;
    }

    /**
     * @return the quantidadeProduto
     */
    public Double getQuantidadeProduto() {
        return quantidadeProduto;
    }

    /**
     * @param quantidadeProduto the quantidadeProduto to set
     */
    public void setQuantidadeProduto(Double quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    /**
     * @return the valorProduto
     */
    public Double getValorProduto() {
        return valorProduto;
    }

    /**
     * @param valorProduto the valorProduto to set
     */
    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }
    
    /**
     * @param valorTotal the valorProduto to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setValorTotal(double p, double q) {
        valorTotal = p * q;
    }
    
}
