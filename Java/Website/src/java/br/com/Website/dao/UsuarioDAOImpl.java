/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Website.dao;

import br.com.Website.model.Usuario;
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
public class UsuarioDAOImpl implements GenericDAO {

    private Connection conn;

    public UsuarioDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {

        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO usuario(nomeUsuario, emailUsuario, senhaUsuario) VALUES (?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getEmailUsuario());
            stmt.setString(3, usuario.getSenhaUsuario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Usuario! Erro: " + ex);
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex);
                ex.printStackTrace();
            }
        }

    }

    @Override
    public List<Object> listar() {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM usuario ORDER BY emailusuario;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNomeUsuario(rs.getString("nomeUsuario"));
                usuario.setEmailUsuario(rs.getString("emailUsuario"));
                usuario.setSenhaUsuario(rs.getString("senhaUsuario"));
                resultado.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Usuarios! Erro: " + ex);
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex);
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public void excluir(int idObject) {

        PreparedStatement stmt = null;

        String sql = "DELETE FROM usuario WHERE codigoUsuario=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Usuario! Erro: " + ex);
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex);
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {

        Usuario usuario = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM usuario WHERE idusuario=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNomeUsuario(rs.getString("nomeUsuario"));
                usuario.setEmailUsuario(rs.getString("emailFabricacao"));
                usuario.setSenhaUsuario(rs.getString("senhaUsuario"));
            }
            return usuario;

        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Usuario! Erro: " + ex);
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex);
                ex.printStackTrace();
            }
        }
        return usuario;
    }

    @Override
    public Boolean alterar(Object object) {

        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;

        String sql = "UPDATE usuario SET nomeUsuario=?, emailUsuario=?, senhaEstoque=? WHERE idUsuario=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getEmailUsuario());
            stmt.setString(3, usuario.getSenhaUsuario());
            stmt.setInt(4, usuario.getIdUsuario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Usuario! Erro: " + ex);
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex);
                ex.printStackTrace();
            }
        }

    }

}
