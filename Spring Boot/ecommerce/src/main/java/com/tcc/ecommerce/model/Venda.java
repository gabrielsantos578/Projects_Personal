package com.tcc.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "venda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    @Id
    @Column(name = "codigoVenda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoVenda;

    @Column(name = "valorFinal")
    private double valorFinal;

    @Column(name = "dataVenda", nullable = false)
    private LocalDate dataVenda;

    @JsonIgnore
    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY)
    private List<Item> itens;

}
