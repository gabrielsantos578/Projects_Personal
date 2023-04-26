package com.tcc.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "marcaProduto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marca {

    @Id
    @Column(name = "codigoMarca")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoMarca;

    @Column(name = "nomeMarca", nullable = false, unique = true)
    private String nomeMarca;

    @JsonIgnore
    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY)
    private List<Produto> produtos;

}
