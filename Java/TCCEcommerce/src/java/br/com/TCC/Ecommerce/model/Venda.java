/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.model;

/**
 *
 * @author Aluno
 */
public class Venda {

    private int codigoVenda;
    private String nomeCliente;
    private String cpfCliente;
    private Double valorTotal;
    private String dataVenda;

    public Venda() {
    }

    public Venda(int codigoVenda, String nomeCliente, String cpfCliente, Double valorTotal, String dataVenda) {
        this.codigoVenda = codigoVenda;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    public Venda(int codigoVenda, String nomeCliente) {
        this.codigoVenda = codigoVenda;
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the codigoVenda
     */
    public int getCodigoVenda() {
        return codigoVenda;
    }

    /**
     * @param codigoVenda the codigoVenda to set
     */
    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setCalculaValorTotal(double v) {
        valorTotal = valorTotal + v;
    }

    /**
     * @return the dataVenda
     */
    public String getDataVenda() {
        return dataVenda;
    }

    /**
     * @param dataVenda the dataVenda to set
     */
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
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

}
