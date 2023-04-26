/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.br.com.Study.dao;

import project.br.com.Study.model.Produto;
import project.br.com.Study.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sindicato
 */
public class ProdutoDAOImpl implements GenericDAO {

    private Connection conn;

    public ProdutoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Produto produto = (Produto) object;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO produto(nomeProduto, precoProduto, quantidadeEstoque) VALUES (?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getPrecoProduto());
            stmt.setDouble(3, produto.getQuantidadeEstoque());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Produto! Erro: " + ex.getMessage());
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

        String sql = "SELECT * FROM produto ORDER BY nomeproduto;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigoProduto(rs.getInt("codigoProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setPrecoProduto(rs.getDouble("precoProduto"));
                produto.setQuantidadeEstoque(rs.getDouble("quantidadeEstoque"));
                resultado.add(produto);
            }
            
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Produtos! Erro: " + ex.getMessage());
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

        String sql = "DELETE FROM produto WHERE codigoProduto=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Produto! Erro: " + ex.getMessage());
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

        Produto produto = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM produto WHERE codigoproduto=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                produto.setCodigoProduto(rs.getInt("codigoProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setPrecoProduto(rs.getDouble("precoProduto"));
                produto.setQuantidadeEstoque(rs.getDouble("quantidadeEstoque"));
            }
            return produto;

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Produto! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return produto;
    }

    @Override
    public Boolean alterar(Object object) {

        Produto produto = (Produto) object;
        PreparedStatement stmt = null;

        String sql = "UPDATE produto SET nomeProduto=?, precoProduto=?, quantidadeEstoque=? WHERE codigoProduto=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getPrecoProduto());
            stmt.setDouble(3, produto.getQuantidadeEstoque());
            stmt.setInt(4, produto.getCodigoProduto());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Produto! Erro: " + ex.getMessage());
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
    

}
