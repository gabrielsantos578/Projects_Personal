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
public class Cliente {

   int codigoCliente;
   Usuario codigoUsuario;
   String nomeCliente;
   String cpf;
   String cep;
   String cidade;
   String rua;
   String bairro;
   String numCasa;

    public Cliente() {
    }

    public Cliente(int codigoCliente, Usuario codigoUsuario, String nomeCliente, String cpf, String cep, String cidade, String rua, String bairro, String numCasa) {
        this.codigoCliente = codigoCliente;
        this.codigoUsuario = codigoUsuario;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.cep = cep;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numCasa = numCasa;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }
   

}
