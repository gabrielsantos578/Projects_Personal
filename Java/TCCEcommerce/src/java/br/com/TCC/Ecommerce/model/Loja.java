/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.model;

/**
 *
 * @author Sindicato
 */
public class Loja {

    int idLoja;
    Empresa codigoEmpresa;
    String cep;
    String cidade;
    String rua;
    String bairro;
    String numLoja;

    public Loja() {
    }

    public Loja(int idLoja, Empresa codigoEmpresa, String cep, String cidade, String rua, String bairro, String numLoja) {
        this.idLoja = idLoja;
        this.codigoEmpresa = codigoEmpresa;
        this.cep = cep;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numLoja = numLoja;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public Empresa getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Empresa codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumLoja() {
        return numLoja;
    }

    public void setNumLoja(String numLoja) {
        this.numLoja = numLoja;
    }
    

}
