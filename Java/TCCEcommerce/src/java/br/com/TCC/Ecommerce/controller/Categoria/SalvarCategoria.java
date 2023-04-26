/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.controller.Categoria;

import br.com.TCC.Ecommerce.dao.GenericDAO;
import br.com.TCC.Ecommerce.dao.CategoriaDAOImpl;
import br.com.TCC.Ecommerce.model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alunos
 */
@WebServlet(name = "SalvarCategoria", urlPatterns = {"/SalvarCategoria"})
public class SalvarCategoria extends HttpServlet {

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

        Categoria categoria = new Categoria();
        categoria.setNomeCategoria(request.getParameter("nomecategoria"));

        String msg = null;

        try {
            GenericDAO dao = new CategoriaDAOImpl();
            if (request.getParameter("idcategoria").equals("")) {
                if (dao.cadastrar(categoria).equals(true)) {
                    msg = "Categoria " + categoria.getNomeCategoria() + " cadastrada com sucesso!";
                } else {
                    msg = "Problemas ao cadastrar Categoria! Verifique os dados.";
                }
            } else {
                categoria.setIdCategoria(Integer.parseInt(request.getParameter("idcategoria")));
                if (dao.alterar(categoria).equals(true)) {
                    msg = "Categoria " + categoria.getNomeCategoria() + " alterada com sucesso!";
                } else {
                    msg = "Problemas ao alterar Categoria! Verifique os dados.";
                }
            }

        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Categoria! Erro: " + ex.getMessage());
            msg = "Problemas ao cadastrar Categoria! Erro de conexão: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            request.setAttribute("response", msg);
            request.getRequestDispatcher("categoria/salvar.jsp").forward(request, response);
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
