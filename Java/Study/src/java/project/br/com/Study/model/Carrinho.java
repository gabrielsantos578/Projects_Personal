/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.br.com.Study.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Sindicato
 */
public class Carrinho {
    
    private ArrayList<Item> carrinho;
    
    public Carrinho() {
        carrinho = new ArrayList<>();
    }
    
    public void inserirItem(Item item) {
        carrinho.add(item);
    }
    
    public void removerItem(Item item) {
        carrinho.remove(item);
    }
    
    public ArrayList<Item> retornarCarrinho() {        
    	return carrinho;      
    }
    
    public Collection<Item> getItens() {
    	if(carrinho == null) {
    		carrinho = new ArrayList<>();
    	}
    	return carrinho;
     }
    
}
