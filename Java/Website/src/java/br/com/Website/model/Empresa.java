/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Website.model;

/**
 *
 * @author Sindicato
 */
public class Empresa {
    
    private int codigoEmpresa;
    private Usuario idUsuario;
    private String senhaEmpresa;
    private String nomeEmpresa;
    private String cnpjEmpresa;
    private String descricaoEmpresa;

    public Empresa() {
    }
    
    

    /**
     * @return the codigoEmpresa
     */
    public int getCodigoEmpresa() {
        return codigoEmpresa;
    }

    /**
     * @param codigoEmpresa the codigoEmpresa to set
     */
    public void setCodigoEmpresa(int codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    /**
     * @return the idUsuario
     */
    public Usuario getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the senhaEmpresa
     */
    public String getSenhaEmpresa() {
        return senhaEmpresa;
    }

    /**
     * @param senhaEmpresa the senhaEmpresa to set
     */
    public void setSenhaEmpresa(String senhaEmpresa) {
        this.senhaEmpresa = senhaEmpresa;
    }

    /**
     * @return the nomeEmpresa
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * @param nomeEmpresa the nomeEmpresa to set
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    /**
     * @return the cnpjEmpresa
     */
    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    /**
     * @param cnpjEmpresa the cnpjEmpresa to set
     */
    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    /**
     * @return the descricaoEmpresa
     */
    public String getDescricaoEmpresa() {
        return descricaoEmpresa;
    }

    /**
     * @param descricaoEmpresa the descricaoEmpresa to set
     */
    public void setDescricaoEmpresa(String descricaoEmpresa) {
        this.descricaoEmpresa = descricaoEmpresa;
    }
    
}
