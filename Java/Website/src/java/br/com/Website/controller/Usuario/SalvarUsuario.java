/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Website.controller.Usuario;

import br.com.Website.dao.GenericDAO;
import br.com.Website.dao.UsuarioDAOImpl;
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
@WebServlet(name = "SalvarUsuario", urlPatterns = {"/SalvarUsuario"})
public class SalvarUsuario extends HttpServlet {

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

        Venda venda = new Venda();
        venda.setNomeCliente(request.getParameter("nome"));
        venda.setCpfCliente(request.getParameter("cpf"));
        venda.setDataVenda(request.getParameter("data"));
        if(request.getParameter("valor").equals("")){
            venda.setValorTotal(0.0);
        } else {
            venda.setValorTotal(Double.parseDouble(request.getParameter("valor")));
        }

        String msg = null;

        try {
            GenericDAO dao = new UsuarioDAOImpl();
            if (request.getParameter("codigo").equals("")) {
                if (dao.cadastrar(venda).equals(true)){
                    msg = "Venda para o cliente " + venda.getNomeCliente() + " cadastrada com sucesso!";
                } else {
                    msg = "Problemas ao cadastrar Venda! Verifique os dados." + venda.getNomeCliente();
                }
            } else {
                venda.setCodigoVenda(Integer.parseInt(request.getParameter("codigo")));
                venda.setValorTotal(Double.parseDouble(request.getParameter("valor")));
                if (dao.alterar(venda).equals(true)) {
                    msg = "Venda para o cliente " + venda.getNomeCliente() + " alterada com sucesso!";
                } else {
                    msg = "Problemas ao alterar Venda! Verifique os dados.";
                }
            }
            
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar/alterar Venda! Erro: " + ex.getMessage());
            msg = "Problemas ao cadastrar/alterar Venda! Erro de conexão: " + ex.getMessage();
            ex.printStackTrace();
            
        } finally {
            request.setAttribute("response", msg);
            request.getRequestDispatcher("venda/salvar.jsp").forward(request, response);
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
