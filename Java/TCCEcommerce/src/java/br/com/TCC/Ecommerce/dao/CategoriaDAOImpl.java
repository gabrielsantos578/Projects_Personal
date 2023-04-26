/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.dao;

import br.com.TCC.Ecommerce.model.Categoria;
import br.com.TCC.Ecommerce.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class CategoriaDAOImpl implements GenericDAO {

    private Connection conn;

    public CategoriaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Categoria categoria = (Categoria) object;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO categoria(nomecategoria) VALUES (?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Categoria! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    @Override
    public List<Object> listar() {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT g.* FROM categoria g ORDER BY g.nomecategoria;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("codigocategoria"));
                categoria.setNomeCategoria(rs.getString("nomecategoria"));
                resultado.add(categoria);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Categorias! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public void excluir(int idObject) {

        PreparedStatement stmt = null;

        String sql = "DELETE FROM categoria WHERE codigocategoria=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Categoria! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {

        Categoria categoria = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT g.* FROM categoria g WHERE g.codigocategoria=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("codigocategoria"));
                categoria.setNomeCategoria(rs.getString("nomecategoria"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Categoria! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return categoria;
    }

    @Override
    public Boolean alterar(Object object) {

        Categoria categoria = (Categoria) object;
        PreparedStatement stmt = null;

        String sql = "UPDATE categoria SET nomecategoria=? WHERE codigocategoria=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setInt(2, categoria.getIdCategoria());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Categoria! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    @Override
    public String consultarObjeto(String atributeObject, String conditionObject, String valueCondition) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> consultarObjetos(String conditionObject, String valueCondition, String atributeOrder, String order) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterarCampo(String campoObject, String valueCampo, String valueCondition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
