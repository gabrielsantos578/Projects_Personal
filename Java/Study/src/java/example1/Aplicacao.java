/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Sindicato
 */
public class Aplicacao {

    public static void main(String[] args) {

        List<Item> carrinho = new ArrayList<>();
        List<Item> carro = new ArrayList<>();

        Produto p1 = new Produto();
        p1.setCodigoProduto(1);
        p1.setNomeProduto("Celular");
        p1.setPrecoProduto(870.00);

        Produto p2 = new Produto();
        p2.setCodigoProduto(2);
        p2.setNomeProduto("Caderno");
        p2.setPrecoProduto(45.70);

        Produto p3 = new Produto();
        p3.setCodigoProduto(3);
        p3.setNomeProduto("Notbook");
        p3.setPrecoProduto(1800.00);

        Produto p4 = new Produto();
        p4.setCodigoProduto(4);
        p4.setNomeProduto("Lapizeira");
        p4.setPrecoProduto(15.00);

        Produto p5 = new Produto();
        p5.setCodigoProduto(5);
        p5.setNomeProduto("Caixinha com grafites");
        p5.setPrecoProduto(3.50);

        Item item1 = new Item(p1, 2);
        Item item2 = new Item(p2, 4);
        Item item3 = new Item(p3, 1);
        Item item4 = new Item(p4, 2);
        Item item5 = new Item(p5, 5);

        carrinho.add(item1);
        carrinho.add(item2);
        carrinho.add(item3);
        carrinho.add(item4);
        carrinho.add(item5);

        String teste = String.valueOf(carrinho);

        String objeto = null;
        int begin = 1, end = 21;

        while (objeto != "") {

            objeto = teste.substring(begin, end);
              
            Produto produto = new Produto();
            Item item = new Item(produto, 0);
            item.setCodigoItem(Integer.valueOf(objeto));
            
            carro.add(item);
            
            begin = begin + 24; 
            end = end + 24;

        }


        /*for(int i = 0 ; i < carrinho.size(); i++){
                carro.add(carrinho.get(i));
        }*/
 /*carro.add(String.indexOf(teste));*/

        Double valorTotal = 0.0;

        for (int i = 0; i < carro.size(); i++) {

            System.out.println("Codígo Produto: " + carro.get(i));
            System.out.println("Codígo Produto: " + carro.get(i).getProduto().getCodigoProduto());
            System.out.println("Nome Produto: " + carro.get(i).getProduto().getNomeProduto());
            System.out.println("Preço Produto: " + carro.get(i).getProduto().getPrecoProduto());
            System.out.println("Quantidade Pedida: " + carro.get(i).getQuantidade());
            System.out.println("Preço Total: " + carro.get(i).getProduto().getPrecoProduto() * carro.get(i).getQuantidade());

            System.out.println("---------------------------------------------");

            valorTotal += carro.get(i).getProduto().getPrecoProduto() * carro.get(i).getQuantidade();

        }

        System.out.println("Valor Final: " + valorTotal);
        /*System.out.println("O que retorna: " + carro);*/

    }

}
