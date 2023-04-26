/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.dao;

import br.com.TCC.Ecommerce.model.Item;
import br.com.TCC.Ecommerce.model.Venda;
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
public class VendaDAOImpl implements GenericDAO {

    private Connection conn;

    public VendaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {

        Venda venda = (Venda) object;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO venda(nomeCliente, cpfCliente, dataVenda, valorFinal) VALUES (?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, venda.getNomeCliente());
            stmt.setString(2, venda.getCpfCliente());
            stmt.setString(3, venda.getDataVenda());
            stmt.setDouble(4, venda.getValorTotal());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Venda! Erro: " + ex.getMessage());
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

        String sql = "SELECT * FROM venda ORDER BY nomeCliente;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCodigoVenda(rs.getInt("codigoVenda"));
                venda.setNomeCliente(rs.getString("nomeCliente"));
                venda.setCpfCliente(rs.getString("cpfCliente"));
                venda.setValorTotal(rs.getDouble("valorFinal"));
                venda.setDataVenda(rs.getString("dataVenda"));
                resultado.add(venda);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Vendas! Erro: " + ex.getMessage());
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

        String sql = "DELETE FROM venda WHERE codigoVenda=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Venda! Erro: " + ex.getMessage());
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
        Venda venda = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM venda WHERE codigovenda=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                venda = new Venda();
                venda.setCodigoVenda(rs.getInt("codigoVenda"));
                venda.setNomeCliente(rs.getString("nomeCliente"));
                venda.setCpfCliente(rs.getString("cpfCliente"));
                venda.setValorTotal(rs.getDouble("valorFinal"));
                venda.setDataVenda(rs.getString("dataVenda"));
            }
            return venda;

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Venda! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return venda;
    }

    @Override
    public Boolean alterar(Object object) {

        Venda venda = (Venda) object;
        PreparedStatement stmt = null;

        String sql = "UPDATE venda SET nomeCliente=?, cpfCliente=?, dataVenda=?, valorFinal=? WHERE codigoVenda=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, venda.getNomeCliente());
            stmt.setString(2, venda.getCpfCliente());
            stmt.setString(3, venda.getDataVenda());
            stmt.setDouble(4, venda.getValorTotal());
            stmt.setInt(5, venda.getCodigoVenda());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Venda! Erro: " + ex.getMessage());
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

        Venda venda = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String response = null;
        String sql = "SELECT * FROM venda WHERE " + conditionObject + "=?;";

        try {
            stmt = conn.prepareStatement(sql);
            if (conditionObject.equals("codigoVenda")) {
                stmt.setInt(1, Integer.parseInt(valueCondition));
            } else if (conditionObject.equals("valorFinal")) {
                stmt.setDouble(1, Double.parseDouble(valueCondition));
            } else {
                stmt.setString(1, valueCondition);
            }
            rs = stmt.executeQuery();

            if (atributeObject.equals("valorFinal")) {

                while (rs.next()) {
                    venda = new Venda();
                    venda.setValorTotal(rs.getDouble("valorFinal"));
                }
                response = String.valueOf(venda.getValorTotal());
                return response;

            } else if (atributeObject.equals("codigoVenda")) {

                while (rs.next()) {
                    venda = new Venda();
                    venda.setCodigoVenda(rs.getInt("codigoVenda"));
                }
                response = String.valueOf(venda.getCodigoVenda());
                return response;

            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Venda! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        response = String.valueOf(venda);
        return response;

    }

    @Override
    public List<Object> consultarObjetos(String conditionObject, String valueCondition, String atributeOrder, String order) throws Exception {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;

        if (conditionObject.equals("") && atributeOrder.equals("")) {
            sql = "SELECT v.* FROM venda v;";
        } else if (conditionObject.equals("")) {
            sql = "SELECT v.* FROM venda v ORDER BY " + atributeOrder + " " + order + ";";
        } else if (atributeOrder.equals("")) {
            sql = "SELECT v.* FROM venda v WHERE v." + conditionObject + "=?;";
        } else {
            sql = "SELECT v.* FROM venda v WHERE v." + conditionObject + "=? ORDER BY " + atributeOrder + " " + order + ";";
        }

        try {

            stmt = conn.prepareStatement(sql);
            if (conditionObject.equals("")) {
            } else {
                if (conditionObject.equals("codigoVenda")) {
                    stmt.setInt(1, Integer.parseInt(valueCondition));
                } else if (conditionObject.equals("valorFinal")) {
                    stmt.setDouble(1, Double.parseDouble(valueCondition));
                } else {
                    stmt.setString(1, valueCondition);
                }
            }
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCodigoVenda(rs.getInt("codigoVenda"));
                venda.setNomeCliente(rs.getString("nomeCliente"));
                venda.setCpfCliente(rs.getString("cpfCliente"));
                venda.setDataVenda(rs.getString("dataVenda"));
                venda.setValorTotal(rs.getDouble("valorFinal"));
                resultado.add(venda);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao consultar Vendas! Erro: " + ex.getMessage());
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

        PreparedStatement stmt = null;

        String sql = "UPDATE venda SET " + campoObject + " = ? WHERE codigoVenda = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, Double.parseDouble(valueCampo));
            stmt.setInt(2, Integer.parseInt(valueCondition));
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Venda! Erro: " + ex.getMessage());
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
