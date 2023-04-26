/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Website.controller.Administration.User;

import br.com.Website.dao.GenericDAO;
import br.com.Website.dao.UsuarioDAOImpl;
import br.com.Website.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sindicato
 */
@WebServlet(name = "SaveUser", urlPatterns = {"/SaveUser"})
public class SaveUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-8859-1");

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(request.getParameter("nome"));
        usuario.setEmailUsuario(request.getParameter("email"));
        usuario.setSenhaUsuario(request.getParameter(String.valueOf("senha")));

        String msg = null;
        
        try {
            GenericDAO dao = new UsuarioDAOImpl();
            if (request.getParameter("codigo").equals("")) {
                if (dao.cadastrar(usuario).equals(true)){
                    msg = "Usuario " + usuario.getNomeUsuario() + " cadastrado com sucesso!";
                } else {
                    msg = "Problemas ao cadastrar Usuario! Verifique os dados.";
                }
            } else {
                usuario.setIdUsuario(Integer.parseInt(request.getParameter("idusuario")));
                if (dao.alterar(usuario).equals(true)) {
                    msg = "Usuario " + usuario.getNomeUsuario() + " alterado com sucesso!";
                } else {
                    msg = "Problemas ao alterar Usuario! Verifique os dados.";
                }
            }
            
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Usuario! Erro: " + ex.getMessage());
            msg = "Problemas ao cadastrar Usuario! Erro de conexão: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            request.setAttribute("response", msg);
            request.getRequestDispatcher("ADM/Usuario/Salvar.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
