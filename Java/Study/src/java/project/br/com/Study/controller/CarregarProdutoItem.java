/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.br.com.Study.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.br.com.Study.dao.GenericDAO;
import project.br.com.Study.dao.ProdutoDAOImpl;

/**
 *
 * @author Sindicato
 */
@WebServlet(name = "CarregarProdutoItem", urlPatterns = {"/CarregarProdutoItem"})
public class CarregarProdutoItem extends HttpServlet {

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

        int idproduto = Integer.parseInt(request.getParameter("idproduto"));

        try {
            GenericDAO dao = new ProdutoDAOImpl();
            request.setAttribute("produto", dao.carregar(idproduto));

            try {
                GenericDAO daoP = new ProdutoDAOImpl();
                request.setAttribute("produtos", daoP.listar());
            } catch (Exception ex) {
                System.out.println("Problemas ao listar Produto! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }

            request.getRequestDispatcher("produto/listar.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar dados da ProdutoCTR! Erro: " + ex.getMessage());
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
