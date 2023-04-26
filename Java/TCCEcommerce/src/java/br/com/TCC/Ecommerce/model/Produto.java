/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.model;

import java.sql.Date;

/**
 *
 * @author Sindicato
 */
public class Produto {
    
    private int codigoProduto;
    private String nomeProduto;
    private Double precoProduto;
    private Double quantidadeEstoque;
    private String descricaoProduto;
    private String dataFabricacao;
    private String loteProduto;
    private Marca marca;
    private Categoria categoria;

    public Produto() {
    }

    public Produto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Produto(int codigoProduto, String nomeProduto, Double precoProduto, Double quantidadeEstoque, String descricaoProduto, String dataFabricacao, String loteProduto, Marca marca, Categoria categoria) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.descricaoProduto = descricaoProduto;
        this.dataFabricacao = dataFabricacao;
        this.loteProduto = loteProduto;
        this.marca = marca;
        this.categoria = categoria;
    }

    public Produto(int codigoProduto, String nomeProduto) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
    }
    
    /**
     * @return the codigoProduto
     */
    public int getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(int codigoProduto) {
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
    public Double getPrecoProduto() {
        return precoProduto;
    }

    /**
     * @param precoProduto the precoProduto to set
     */
    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    /**
     * @return the quantidadeEstoque
     */
    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque the quantidadeEstoque to set
     */
    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    /**
     * @return the dataFabricacao
     */
    public String getDataFabricacao() {
        return dataFabricacao;
    }

    /**
     * @param dataFabricacao the dataFabricacao to set
     */
    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    /**
     * @return the loteProduto
     */
    public String getLoteProduto() {
        return loteProduto;
    }

    /**
     * @param loteProduto the loteProduto to set
     */
    public void setLoteProduto(String loteProduto) {
        this.loteProduto = loteProduto;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
     
    
}
