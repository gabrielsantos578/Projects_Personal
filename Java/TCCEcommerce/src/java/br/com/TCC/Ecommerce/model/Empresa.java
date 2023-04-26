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
public class Empresa {
    
   int codigoEmpresa;
   Usuario codigoUsuario;
   String nomeEmpresa;
   String cnpj;

    public Empresa() {
    }

    public Empresa(int codigoEmpresa, Usuario codigoUsuario, String nomeEmpresa, String cnpj) {
        this.codigoEmpresa = codigoEmpresa;
        this.codigoUsuario = codigoUsuario;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
    }

    public int getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(int codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
   
    
}
