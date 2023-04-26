/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.controller.Marca;

import br.com.TCC.Ecommerce.dao.GenericDAO;
import br.com.TCC.Ecommerce.dao.MarcaDAOImpl;
import br.com.TCC.Ecommerce.model.Marca;
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
@WebServlet(name = "SalvarMarca", urlPatterns = {"/SalvarMarca"})
public class SalvarMarca extends HttpServlet {

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

        Marca marca = new Marca();
        marca.setNomeMarca(request.getParameter("nomemarca"));

        String msg = null;
        
        try {
            GenericDAO dao = new MarcaDAOImpl();
            if (request.getParameter("idmarca").equals("")) {
                if (dao.cadastrar(marca).equals(true)){
                    msg = "Marca " + marca.getNomeMarca() + " cadastrada com sucesso!";
                } else {
                    msg = "Problemas ao cadastrar Marca! Verifique os dados.";
                }
            } else {
                marca.setIdMarca(Integer.parseInt(request.getParameter("idmarca")));
                if (dao.alterar(marca).equals(true)) {
                    msg = "Marca " + marca.getNomeMarca() + " alterada com sucesso!";
                } else {
                    msg = "Problemas ao alterar Marca! Verifique os dados.";
                }
            }
            
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Marca! Erro: " + ex.getMessage());
            msg = "Problemas ao cadastrar Marca! Erro de conexão: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            request.setAttribute("response", msg);
            request.getRequestDispatcher("marca/salvar.jsp").forward(request, response);
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
