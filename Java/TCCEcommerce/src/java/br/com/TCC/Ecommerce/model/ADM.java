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
public class ADM {

    private String Resposta;

    public static String valida(String dado) {

        int dia = Integer.parseInt(dado.substring(0, 2));
        int mes = Integer.parseInt(dado.substring(3, 5));
        int ano = Integer.parseInt(dado.substring(6, 10));
        int validade = 2022 - ano;
        String response = null;

        if (dia == 0 || dia > 31) {
            response = "O dia não pode ser 0 nem maior que 31!";
            
        } else {          
            if (mes == 0 || mes > 12) {
                response = "O mês não pode ser 0 nem maior que 12!";
                
            } else {            
                if (validade > 2) {
                    response = "A validade de um produto não pode superar 2 anos!";
                    
                } else if (ano > 2022) {
                    response = "O ano não pode ser superior a 2022!";
                    
                } else {
                    response = "VALIDADO.";
                }
            }
        }

        return response;
    }

    /**
     * @return the Resposta
     */
    public String getResposta() {
        return Resposta;
    }

    /**
     * @param Resposta the Resposta to set
     */
    public void setResposta(String Resposta) {
        this.Resposta = Resposta;
    }

}
