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
public class Loja {
    
    private int idLoja;
    private Empresa codigoEmpresa;
    private String telefoneLoja;
    private String cepEndereco;
    private String cidadeEndereco;
    private String estadoEndereco;
    private String bairroEndereco;
    private String ruaEndereco;
    private String numEndereco;

    public Loja() {
    }
    
    

    /**
     * @return the idLoja
     */
    public int getIdLoja() {
        return idLoja;
    }

    /**
     * @param idLoja the idLoja to set
     */
    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    /**
     * @return the codigoEmpresa
     */
    public Empresa getCodigoEmpresa() {
        return codigoEmpresa;
    }

    /**
     * @param codigoEmpresa the codigoEmpresa to set
     */
    public void setCodigoEmpresa(Empresa codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    /**
     * @return the telefoneLoja
     */
    public String getTelefoneLoja() {
        return telefoneLoja;
    }

    /**
     * @param telefoneLoja the telefoneLoja to set
     */
    public void setTelefoneLoja(String telefoneLoja) {
        this.telefoneLoja = telefoneLoja;
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
