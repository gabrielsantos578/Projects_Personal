/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.controller.Venda;

import br.com.TCC.Ecommerce.controller.Venda.*;
import br.com.TCC.Ecommerce.dao.GenericDAO;
import br.com.TCC.Ecommerce.dao.ItemDAOImpl;
import br.com.TCC.Ecommerce.dao.VendaDAOImpl;
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
@WebServlet(name = "ConsultarVenda", urlPatterns = {"/ConsultarVenda"})
public class ConsultarVenda extends HttpServlet {

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

        String condition = request.getParameter("condition");
        String value = request.getParameter("value");
        String atributte = request.getParameter("atributte");
        String order = request.getParameter("order");
        
        String msg = null;
        
        try {
            GenericDAO daoV = new VendaDAOImpl();
            request.setAttribute("vendas", daoV.consultarObjetos(condition, value, atributte, order));
            
            if(condition.equals("")){
                GenericDAO daoI = new ItemDAOImpl();
                request.setAttribute("itens", daoI.consultarObjetos("", "", "codigoVenda", order));
            } else {
                GenericDAO daoVenda = new VendaDAOImpl();
                int idvenda = Integer.parseInt(daoVenda.consultarObjeto("codigoVenda", condition, value));
                GenericDAO daoI = new ItemDAOImpl();
                request.setAttribute("itens", daoI.consultarObjetos("codigoVenda", String.valueOf(idvenda), "nomeProduto", order));
            }
            
        } catch (Exception ex) {
            System.out.println("Problemas ao consultar Vendas! Erro: " + ex);
            msg = "Problemas ao consultar Vendas! Erro: " + ex;
            ex.printStackTrace();
        } finally {
            request.setAttribute("response", msg);
            request.getRequestDispatcher("venda/consultar.jsp").forward(request, response);
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
