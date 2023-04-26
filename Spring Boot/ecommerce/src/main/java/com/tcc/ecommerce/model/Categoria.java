package com.tcc.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoriaProduto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @Column(name = "codigoCategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoCategoria;

    @Column(name = "nomeCategoria", nullable = false, unique = true)
    private String nomeCategoria;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Produto> produtos;

}
