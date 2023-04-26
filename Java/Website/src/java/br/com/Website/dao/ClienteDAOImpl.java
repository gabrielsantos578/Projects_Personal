/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Website.dao;

import br.com.Website.model.Cliente;
import br.com.Website.util.ConnectionFactory;
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
public class ClienteDAOImpl implements GenericDAO {

    private Connection conn;

    public ClienteDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Cliente cliente = (Cliente) object;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO cliente(idUsuario, senhaCliente, nomeCliente, cpfCliente, telefoneCliente, \n"
                + "cepEndereco, cidadeEndereco, estadoEndereco, bairroEndereco, ruaEndereco, numEndereco) \n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getIdUsuario().getIdUsuario());
            stmt.setString(2, cliente.getNomeCliente());
            stmt.setDouble(3, cliente.getPrecoCliente());
            stmt.setDouble(4, cliente.getQuantidadeEstoque());
            stmt.setString(5, cliente.getDescricaoCliente());
            stmt.setString(6, cliente.getDataFabricacao());
            stmt.setString(7, cliente.getLoteCliente());
            stmt.setInt(8, cliente.getMarca().getIdMarca());
            stmt.setString(9, cliente.getDescricaoCliente());
            stmt.setString(10, cliente.getDataFabricacao());
            stmt.setString(11, cliente.getLoteCliente());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Cliente! Erro: " + ex.getMessage());
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

        String sql = "SELECT p.*, m.nomemarca, c.nomecategoria FROM cliente p INNER JOIN categoria c ON p.codigocategoria = c.codigoCategoria inner join marca m on p.codigomarca = m.codigomarca order by p.nomecliente;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigoCliente(rs.getInt("codigoCliente"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));
                cliente.setPrecoCliente(rs.getDouble("precoCliente"));
                cliente.setQuantidadeEstoque(rs.getDouble("quantidadeEstoque"));
                cliente.setDescricaoCliente(rs.getString("descricaoCliente"));
                cliente.setDataFabricacao(rs.getString("dataFabricacao"));
                cliente.setLoteCliente(rs.getString("loteCliente"));
                cliente.setMarca(new Marca(rs.getInt("codigoMarca"), rs.getString("nomeMarca")));
                cliente.setCategoria(new Categoria(rs.getInt("codigoCategoria"), rs.getString("nomeCategoria")));
                resultado.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Clientes! Erro: " + ex.getMessage());
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

        String sql = "DELETE FROM cliente WHERE codigoCliente=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Cliente! Erro: " + ex.getMessage());
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

        Cliente cliente = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT p.*, m.nomemarca, c.nomecategoria FROM cliente p INNER JOIN categoria c ON p.codigocategoria = c.codigoCategoria inner join marca m on p.codigomarca = m.codigomarca WHERE p.codigocliente=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigoCliente(rs.getInt("codigoCliente"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));
                cliente.setPrecoCliente(rs.getDouble("precoCliente"));
                cliente.setQuantidadeEstoque(rs.getDouble("quantidadeEstoque"));
                cliente.setDescricaoCliente(rs.getString("descricaoCliente"));
                cliente.setDataFabricacao(rs.getString("dataFabricacao"));
                cliente.setLoteCliente(rs.getString("loteCliente"));

                Marca marca = new Marca();
                Categoria categoria = new Categoria();
                try {
                    marca.setIdMarca(rs.getInt("codigoMarca"));
                    marca.setNomeMarca(rs.getString("nomeMarca"));
                    categoria.setIdCategoria(rs.getInt("codigoCategoria"));
                    categoria.setNomeCategoria(rs.getString("nomeCategoria"));
                } catch (Exception e) {
                    System.out.println("Erro ao carregar a Marca e a Categoria! Erro: " + e.getMessage());
                }
                cliente.setMarca(marca);
                cliente.setCategoria(categoria);
            }
            return cliente;

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Cliente! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return cliente;
    }

    @Override
    public Boolean alterar(Object object) {

        Cliente cliente = (Cliente) object;
        PreparedStatement stmt = null;

        String sql = "UPDATE cliente SET nomeCliente=?, precoCliente=?, quantidadeEstoque=?, descricaoCliente=?, dataFabricacao=?, loteCliente=?, codigoMarca=?, codigoCategoria=? WHERE codigoCliente=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setDouble(2, cliente.getPrecoCliente());
            stmt.setDouble(3, cliente.getQuantidadeEstoque());
            stmt.setString(4, cliente.getDescricaoCliente());
            stmt.setString(5, cliente.getDataFabricacao());
            stmt.setString(6, cliente.getLoteCliente());
            stmt.setInt(7, cliente.getMarca().getIdMarca());
            stmt.setInt(8, cliente.getCategoria().getIdCategoria());
            stmt.setInt(9, cliente.getCodigoCliente());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Cliente! Erro: " + ex.getMessage());
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
