/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.model;

/**
 *
 * @author Alunos
 */
public class Marca {
    
    private int idMarca;
    private String nomeMarca;
    

    public Marca() {
    }

    public Marca(int idMarca) {
        this.idMarca = idMarca;
    }

    public Marca(int idMarca, String nomeMarca) {
        this.idMarca = idMarca;
        this.nomeMarca = nomeMarca;
    }
    
    
    /**
     * @return the idMarca
     */
    public int getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(int idMarca) {

        if (idMarca > 0) {
            this.idMarca = idMarca;
        } else {
            System.out.println("O código da marca não pode ser negativo.");
        }

    }

    /**
     * @return the nomeMarca
     */
    public String getNomeMarca() {
        return nomeMarca;
    }

    /**
     * @param nomeMarca the nomeMarca to set
     */
    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
    
}
