package com.tcc.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @Column(name = "idUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "emailUsuario", nullable = false, unique = true)
    private String emailUsuario;

    @Column(name = "senhaUsuario", nullable = false)
    private String senhaUsuario;

    @Column(name = "nomeUsuario", nullable = false)
    private String nomeUsuario;


}
