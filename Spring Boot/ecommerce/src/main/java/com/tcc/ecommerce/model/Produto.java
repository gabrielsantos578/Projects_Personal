package com.tcc.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @Column(name = "codigoProduto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoProduto;

    @Column(name = "nomeProduto", nullable = false)
    private String nomeProduto;

    @Column(name = "descricaoProduto", nullable = false)
    private String descricaoProduto;

    @Column(name = "loteProduto")
    private String loteProduto;

    @Column(name = "codigoBarraProduto", unique = true)
    private String codigoBarra;

    @Column(name = "dataFabricacaoProduto")
    private LocalDate dataFabricacao;

    @Column(name = "precoProduto", nullable = false, scale = 10, precision = 2)
    private double precoProduto;

    @Column(name = "quantidadeProduto", nullable = false, scale = 10, precision = 3)
    private double quantidadeProduto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_marca", referencedColumnName = "codigoMarca", nullable = false)
    private Marca marca;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigoCategoria", nullable = false)
    private Categoria categoria;

    @JsonIgnore
    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private List<Item> itens;

}
