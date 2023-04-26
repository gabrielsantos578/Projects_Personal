package com.tcc.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "itemVenda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @Column(name = "idItem")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_venda", referencedColumnName = "codigoVenda", nullable = false)
    private Venda venda;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_produto", referencedColumnName = "codigoProduto", nullable = false)
    private Produto produto;

    @Column(name = "quantidadeTotal", nullable = false, scale = 10, precision = 3)
    private double quantidadeTotal;

    @Column(name = "precoTotal", nullable = false, scale = 10, precision = 2)
    private double precoTotal;

}
