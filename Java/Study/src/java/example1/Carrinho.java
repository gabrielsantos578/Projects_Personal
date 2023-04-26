/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example1;

import java.util.ArrayList;

/**
 *
 * @author Sindicato
 */
public class Carrinho {
    
    private ArrayList<Item> compra;
    
    public Carrinho() {
        this.compra = new ArrayList<>();
    }
    
    public void inserirItem(Item item) {
        this.compra.add(item);
    }
    
    public void removerItem(Item item) {
        this.compra.remove(item);
    }
    
    public void imprimirCompra() {
        
        Double valorTotal = 0.0;
        
        for (Item itemCompra: compra) {
            
            Produto p = itemCompra.getProduto();
            int qtd = itemCompra.getQuantidade();
            
            System.out.println("Produto: ( " + p.getCodigoProduto()+ " ) " + p.getNomeProduto());
            System.out.println("Valor: R$ " + p.getPrecoProduto());
            System.out.println("Quantidade: " + qtd);
            System.out.println("Parcial: R$ " + p.getPrecoProduto() * qtd);
            
            valorTotal += p.getPrecoProduto() * qtd;
            
            System.out.println("---------------------------------------------");
            
        }
        
        System.out.println("");
        System.out.println("O total da sua compra é R$: " + valorTotal);
        System.out.println("");
        
    }
    
    
    
}
