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
public class Item {
    
    private int codigoItem;
    private Produto produto;
    private int quantidade;
    private Item item;

    public Item(Produto p, int qtd) {
        this.produto = p;
        this.quantidade = qtd;
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
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
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
    
    
    
}
