/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.dao;

import br.com.TCC.Ecommerce.model.Categoria;
import br.com.TCC.Ecommerce.model.Marca;
import br.com.TCC.Ecommerce.model.Produto;
import br.com.TCC.Ecommerce.util.ConnectionFactory;
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

        String sql = "INSERT INTO produto(nomeProduto, precoProduto, quantidadeEstoque, descricaoProduto, dataFabricacao, loteProduto, codigoMarca, codigoCategoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getPrecoProduto());
            stmt.setDouble(3, produto.getQuantidadeEstoque());
            stmt.setString(4, produto.getDescricaoProduto());
            stmt.setString(5, produto.getDataFabricacao());
            stmt.setString(6, produto.getLoteProduto());
            stmt.setInt(7, produto.getMarca().getIdMarca());
            stmt.setInt(8, produto.getCategoria().getIdCategoria());
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

        String sql = "SELECT p.*, m.nomemarca, c.nomecategoria FROM produto p INNER JOIN categoria c ON p.codigocategoria = c.codigoCategoria inner join marca m on p.codigomarca = m.codigomarca order by p.nomeproduto;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigoProduto(rs.getInt("codigoProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setPrecoProduto(rs.getDouble("precoProduto"));
                produto.setQuantidadeEstoque(rs.getDouble("quantidadeEstoque"));
                produto.setDescricaoProduto(rs.getString("descricaoProduto"));
                produto.setDataFabricacao(rs.getString("dataFabricacao"));
                produto.setLoteProduto(rs.getString("loteProduto"));
                produto.setMarca(new Marca(rs.getInt("codigoMarca"), rs.getString("nomeMarca")));
                produto.setCategoria(new Categoria(rs.getInt("codigoCategoria"), rs.getString("nomeCategoria")));
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

        String sql = "SELECT p.*, m.nomemarca, c.nomecategoria FROM produto p INNER JOIN categoria c ON p.codigocategoria = c.codigoCategoria inner join marca m on p.codigomarca = m.codigomarca WHERE p.codigoproduto=?;";

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
                produto.setDescricaoProduto(rs.getString("descricaoProduto"));
                produto.setDataFabricacao(rs.getString("dataFabricacao"));
                produto.setLoteProduto(rs.getString("loteProduto"));

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
                produto.setMarca(marca);
                produto.setCategoria(categoria);
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

        String sql = "UPDATE produto SET nomeProduto=?, precoProduto=?, quantidadeEstoque=?, descricaoProduto=?, dataFabricacao=?, loteProduto=?, codigoMarca=?, codigoCategoria=? WHERE codigoProduto=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getPrecoProduto());
            stmt.setDouble(3, produto.getQuantidadeEstoque());
            stmt.setString(4, produto.getDescricaoProduto());
            stmt.setString(5, produto.getDataFabricacao());
            stmt.setString(6, produto.getLoteProduto());
            stmt.setInt(7, produto.getMarca().getIdMarca());
            stmt.setInt(8, produto.getCategoria().getIdCategoria());
            stmt.setInt(9, produto.getCodigoProduto());
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

    @Override
    public String consultarObjeto(String atributeObject, String conditionObject, String valueCondition) throws Exception {

        Produto produto = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String response = null;
        String sql = "SELECT * FROM produto WHERE codigoproduto=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(valueCondition));
            rs = stmt.executeQuery();

            if (atributeObject.equals("quantidadeEstoque")) {

                while (rs.next()) {
                    produto = new Produto();
                    produto.setQuantidadeEstoque(rs.getDouble("quantidadeEstoque"));
                }
                response = String.valueOf(produto.getQuantidadeEstoque());
                return response;

            } else if (atributeObject.equals("nomeProduto")) {

                while (rs.next()) {
                    produto = new Produto();
                    produto.setNomeProduto(rs.getString("nomeProduto"));
                }
                response = String.valueOf(produto.getNomeProduto());
                return response;
                
            } else {
                
                while (rs.next()) {
                    produto = new Produto();
                    produto.setPrecoProduto(rs.getDouble("precoProduto"));
                }
                response = String.valueOf(produto.getPrecoProduto());
                return response;
                
            }

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
        response = String.valueOf(produto);
        return response;

    }

    @Override
    public List<Object> consultarObjetos(String conditionObject, String valueCondition,
            String atributeOrder, String order) throws Exception {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;

        if (conditionObject.equals("") && atributeOrder.equals("")) {
            sql = "SELECT p.*, m.nomemarca, c.nomecategoria FROM produto p INNER JOIN categoria c ON p.codigocategoria = c.codigoCategoria inner join marca m on p.codigomarca = m.codigomarca;";
        } else if (conditionObject.equals("")) {
            sql = "SELECT p.*, m.nomemarca, c.nomecategoria FROM produto p INNER JOIN categoria c ON p.codigocategoria = c.codigoCategoria inner join marca m on p.codigomarca = m.codigomarca ORDER BY " + atributeOrder + " " + order + ";";
        } else if (atributeOrder.equals("")) {
            sql = "SELECT p.*, m.nomemarca, c.nomecategoria FROM produto p INNER JOIN categoria c ON p.codigocategoria = c.codigoCategoria inner join marca m on p.codigomarca = m.codigomarca WHERE p." + conditionObject + "=?;";
        } else {
            sql = "SELECT p.*, m.nomemarca, c.nomecategoria FROM produto p INNER JOIN categoria c ON p.codigocategoria = c.codigoCategoria inner join marca m on p.codigomarca = m.codigomarca WHERE p." + conditionObject + "=? ORDER BY " + atributeOrder + " " + order + ";";
        }

        try {

            stmt = conn.prepareStatement(sql);
            if (conditionObject.equals("")) {
            } else {
                if (conditionObject.equals("codigoProduto") || conditionObject.equals("codigoMarca") || conditionObject.equals("codigoCategoria")) {
                    stmt.setInt(1, Integer.parseInt(valueCondition));
                } else if (conditionObject.equals("precoProduto") || conditionObject.equals("quantidadeEstoque")) {
                    stmt.setDouble(1, Double.parseDouble(valueCondition));
                } else {
                    stmt.setString(1, '%' + valueCondition + '%');
                }
            }
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigoProduto(rs.getInt("codigoProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setPrecoProduto(rs.getDouble("precoProduto"));
                produto.setQuantidadeEstoque(rs.getDouble("quantidadeEstoque"));
                produto.setDescricaoProduto(rs.getString("descricaoProduto"));
                produto.setDataFabricacao(rs.getString("dataFabricacao"));
                produto.setLoteProduto(rs.getString("loteProduto"));
                produto.setMarca(new Marca(rs.getInt("codigoMarca"), rs.getString("nomeMarca")));
                produto.setCategoria(new Categoria(rs.getInt("codigoCategoria"), rs.getString("nomeCategoria")));
                resultado.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao consultar Produtos! Erro: " + ex.getMessage());
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

        Produto produto = new Produto();
        produto.setQuantidadeEstoque(Double.parseDouble(valueCampo));
        produto.setCodigoProduto(Integer.parseInt(valueCondition));
        PreparedStatement stmt = null;

        String sql = "UPDATE produto SET " + campoObject + "=? WHERE codigoProduto=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, produto.getQuantidadeEstoque());
            stmt.setInt(2, produto.getCodigoProduto());
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
