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
public class Cliente {
    
    private int codigoCliente;
    private Usuario idUsuario;
    private String senhaCliente;
    private String nomeCliente;
    private String cpfCliente;
    private String telefoneCliente;
    private String cepEndereco;
    private String cidadeEndereco;
    private String estadoEndereco;
    private String bairroEndereco;
    private String ruaEndereco;
    private String numEndereco;

    public Cliente() {
    }
    
    

    /**
     * @return the codigoCliente
     */
    public int getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
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
     * @return the senhaCliente
     */
    public String getSenhaCliente() {
        return senhaCliente;
    }

    /**
     * @param senhaCliente the senhaCliente to set
     */
    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the cpfCliente
     */
    public String getCpfCliente() {
        return cpfCliente;
    }

    /**
     * @param cpfCliente the cpfCliente to set
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    /**
     * @return the telefoneCliente
     */
    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    /**
     * @param telefoneCliente the telefoneCliente to set
     */
    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    /**
     * @return the cepEndereco
     */
    public String getCepEndereco() {
        return cepEndereco;
    }

    /**
     * @param cepEndereco the cepEndereco to set
     */
    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    /**
     * @return the cidadeEndereco
     */
    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    /**
     * @param cidadeEndereco the cidadeEndereco to set
     */
    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    /**
     * @return the estadoEndereco
     */
    public String getEstadoEndereco() {
        return estadoEndereco;
    }

    /**
     * @param estadoEndereco the estadoEndereco to set
     */
    public void setEstadoEndereco(String estadoEndereco) {
        this.estadoEndereco = estadoEndereco;
    }

    /**
     * @return the bairroEndereco
     */
    public String getBairroEndereco() {
        return bairroEndereco;
    }

    /**
     * @param bairroEndereco the bairroEndereco to set
     */
    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    /**
     * @return the ruaEndereco
     */
    public String getRuaEndereco() {
        return ruaEndereco;
    }

    /**
     * @param ruaEndereco the ruaEndereco to set
     */
    public void setRuaEndereco(String ruaEndereco) {
        this.ruaEndereco = ruaEndereco;
    }

    /**
     * @return the numEndereco
     */
    public String getNumEndereco() {
        return numEndereco;
    }

    /**
     * @param numEndereco the numEndereco to set
     */
    public void setNumEndereco(String numEndereco) {
        this.numEndereco = numEndereco;
    }
    
}
