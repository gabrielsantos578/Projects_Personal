/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.dao;

import br.com.TCC.Ecommerce.model.Item;
import br.com.TCC.Ecommerce.model.Produto;
import br.com.TCC.Ecommerce.model.Venda;
import br.com.TCC.Ecommerce.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ItemDAOImpl implements GenericDAO {

    private Connection conn;

    public ItemDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {

        Item item = (Item) object;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO item(codigoVenda, codigoProduto, quantidadeTotal, precoTotal) VALUES (?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, item.getVenda().getCodigoVenda());
            stmt.setInt(2, item.getProduto().getCodigoProduto());
            stmt.setDouble(3, item.getQuantidadeProduto());
            stmt.setDouble(4, item.getValorTotal());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Item! Erro: " + ex.getMessage());
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
    public List<Object> listar() throws Exception {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT i.*, v.nomecliente, p.nomeproduto, p.precoproduto FROM item i INNER JOIN produto p ON i.codigoproduto = p.codigoproduto inner join venda v on i.codigovenda = v.codigovenda order by p.nomeproduto;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setCodigoItens(rs.getInt("idItem"));
                item.setVenda(new Venda(rs.getInt("codigoVenda"), rs.getString("nomeCliente")));
                item.setProduto(new Produto(rs.getInt("codigoProduto"), rs.getString("nomeProduto")));
                item.setQuantidadeProduto(rs.getDouble("quantidadeTotal"));
                item.setValorProduto(rs.getDouble("precoProduto"));
                item.setValorTotal(rs.getDouble("precoTotal"));
                resultado.add(item);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Itens! Erro: " + ex.getMessage());
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

        String sql = "DELETE FROM item WHERE idItem=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Item! Erro: " + ex.getMessage());
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
        Item item = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT i.*, v.nomecliente, p.nomeproduto, p.precoProduto FROM item i INNER JOIN produto p ON i.codigoproduto = p.codigoProduto inner join venda v on i.codigovenda = v.codigovenda WHERE i.iditem=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                item = new Item();
                item.setCodigoItens(rs.getInt("idItem"));
                item.setQuantidadeProduto(rs.getDouble("quantidadeTotal"));
                item.setValorTotal(rs.getDouble("precoTotal"));

                Venda venda = new Venda();
                Produto produto = new Produto();
                try {
                    venda.setCodigoVenda(rs.getInt("codigoVenda"));
                    venda.setNomeCliente(rs.getString("nomeCliente"));
                    produto.setCodigoProduto(rs.getInt("codigoProduto"));
                    produto.setNomeProduto(rs.getString("nomeProduto"));
                    produto.setPrecoProduto(rs.getDouble("precoProduto"));
                } catch (Exception e) {
                    System.out.println("Erro ao carregar a Venda e a Produto! Erro: " + e.getMessage());
                }
                item.setVenda(venda);
                item.setProduto(produto);
            }
            return item;

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Item! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return item;
    }

    @Override
    public Boolean alterar(Object object) {
        Item item = (Item) object;
        PreparedStatement stmt = null;

        String sql = "UPDATE item SET codigoVenda=?, codigoProduto=?, quantidadeTotal=?, precoTotal=? WHERE idItem=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, item.getVenda().getCodigoVenda());
            stmt.setInt(2, item.getProduto().getCodigoProduto());
            stmt.setDouble(3, item.getQuantidadeProduto());
            stmt.setDouble(4, item.getValorTotal());
            stmt.setInt(5, item.getCodigoItens());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Item! Erro: " + ex.getMessage());
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

        Item item = null;
        Venda venda = null;
        Produto produto = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String response = null;
        String sql = "SELECT i.quantidadeTotal, i.precoTotal, v.codigoVenda, p.codigoProduto FROM item i INNER JOIN venda v on i.codigoVenda=v.codigoVenda INNER JOIN produto p ON i.codigoProduto=p.codigoProduto WHERE idItem=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(valueCondition));
            rs = stmt.executeQuery();

            if (atributeObject.equals("quantidadeTotal")) {
                item = new Item();
                while (rs.next()) {
                    item.setQuantidadeProduto(rs.getDouble("quantidadeTotal"));
                }
                response = String.valueOf(item.getQuantidadeProduto());
                return response;

            } else if (atributeObject.equals("precoTotal")) {
                item = new Item();
                while (rs.next()) {
                    item.setValorTotal(rs.getDouble("precoTotal"));
                }
                response = String.valueOf(item.getValorTotal());
                return response;

            } else if (atributeObject.equals("codigoVenda")) {
                venda = new Venda();
                while (rs.next()) {
                    venda.setCodigoVenda(rs.getInt("codigoVenda"));
                }
                response = String.valueOf(venda.getCodigoVenda());
                return response;

            } else if (atributeObject.equals("codigoProduto")) {
                produto = new Produto();
                while (rs.next()) {
                    produto.setCodigoProduto(rs.getInt("codigoProduto"));
                }
                response = String.valueOf(produto.getCodigoProduto());
                return response;

            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Item! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        response = String.valueOf(item);
        return response;

    }

    @Override
    public List<Object> consultarObjetos(String conditionObject, String valueCondition, String atributeOrder, String order) throws Exception {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;

        if (conditionObject.equals("")) {
            sql = "SELECT i.*, v.*, p.* FROM item i INNER JOIN produto p ON i.codigoproduto = p.codigoproduto inner join venda v on i.codigovenda = v.codigovenda ORDER BY i.codigoVenda, i.idItem;";
        } else {
            sql = "SELECT i.*, v.*, p.* FROM item i INNER JOIN produto p ON i.codigoproduto = p.codigoproduto inner join venda v on i.codigovenda = v.codigovenda WHERE i." + conditionObject + "=? ORDER BY i.codigoVenda, i.idItem;";
        }

        try {

            stmt = conn.prepareStatement(sql);
            if (conditionObject.equals("")) {
            } else {
                if (conditionObject.equals("codigoVenda")) {
                    stmt.setInt(1, Integer.parseInt(valueCondition));
                }
            }
            rs = stmt.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setCodigoItens(rs.getInt("idItem"));
                item.setVenda(new Venda(rs.getInt("codigoVenda"), rs.getString("nomeCliente")));
                item.setProduto(new Produto(rs.getInt("codigoProduto"), rs.getString("nomeProduto")));
                item.setQuantidadeProduto(rs.getDouble("quantidadeTotal"));
                item.setValorProduto(rs.getDouble("precoProduto"));
                item.setValorTotal(rs.getDouble("precoTotal"));
                resultado.add(item);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao consultar Items! Erro: " + ex.getMessage());
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
    public Boolean alterarCampo(String campoObject, String valueCampo, String valueCondition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean vendaProduto(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
