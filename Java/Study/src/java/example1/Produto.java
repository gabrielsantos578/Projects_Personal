/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example1;

/**
 *
 * @author Sindicato
 */
public class Produto {
    
    private int codigoProduto;
    private String nomeProduto;
    private Double precoProduto;

    public Produto() {
        this.codigoProduto = 0;
        this.nomeProduto = "";
        this.precoProduto = 0.0;
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
    
    
    
}
