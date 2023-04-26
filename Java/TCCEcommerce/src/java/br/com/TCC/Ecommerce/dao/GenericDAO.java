/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.dao;

import java.util.List;

/**
 *
 * @author Alunos
 */
public interface GenericDAO {
    
    public Boolean cadastrar(Object object) throws Exception;  
    
    public List<Object> listar() throws Exception;

    public void excluir(int idObject);

    public Object carregar(int idObject);

    public Boolean alterar(Object object);
    
    public Boolean alterarCampo(String campoObject, String valueCampo, String valueCondition);
    
    public String consultarObjeto(String atributeObject, String conditionObject, String valueCondition) throws Exception;
    
    public List<Object> consultarObjetos(String conditionObject, String valueCondition, String atributeOrder, String order) throws Exception;
    
}
