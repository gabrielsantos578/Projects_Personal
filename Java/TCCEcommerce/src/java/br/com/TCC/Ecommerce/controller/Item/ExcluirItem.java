/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.controller.Item;

import br.com.TCC.Ecommerce.dao.GenericDAO;
import br.com.TCC.Ecommerce.dao.ItemDAOImpl;
import br.com.TCC.Ecommerce.dao.ProdutoDAOImpl;
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
@WebServlet(name = "ExcluirItem", urlPatterns = {"/ExcluirItem"})
public class ExcluirItem extends HttpServlet {

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
        Integer idItem = Integer.parseInt(request.getParameter("iditem"));

        try {

            GenericDAO daoBuscaProdutoItem = new ItemDAOImpl();
            int idproduto = Integer.parseInt(daoBuscaProdutoItem.consultarObjeto("codigoProduto", "", String.valueOf(idItem)));
            GenericDAO daoProduto = new ProdutoDAOImpl();
            Double quantidadeEstoque = Double.parseDouble(daoProduto.consultarObjeto("quantidadeEstoque", "codigoProduto", String.valueOf(idproduto)));
            GenericDAO daoItemProduto = new ItemDAOImpl();
            Double quantidadeItem = Double.parseDouble(daoItemProduto.consultarObjeto("quantidadeTotal", "idItem", String.valueOf(idItem)));
            quantidadeEstoque = quantidadeEstoque + quantidadeItem;
            GenericDAO daoAlterP = new ProdutoDAOImpl();

            if (daoAlterP.alterarCampo("quantidadeEstoque", String.valueOf(quantidadeEstoque), String.valueOf(idproduto)).equals(true)) {

                GenericDAO daoBuscaVendaItem = new ItemDAOImpl();
                int idvenda = Integer.parseInt(daoBuscaVendaItem.consultarObjeto("codigoVenda", "", String.valueOf(idItem)));

                GenericDAO daoVenda = new VendaDAOImpl();
                Double valorVenda = Double.parseDouble(daoVenda.consultarObjeto("valorFinal", "codigoVenda", String.valueOf(idvenda)));

                GenericDAO daoItemVenda = new ItemDAOImpl();
                Double valorItem = Double.parseDouble(daoItemVenda.consultarObjeto("precoTotal", "idItem", String.valueOf(idItem)));

                valorVenda = valorVenda - valorItem;
                GenericDAO daoAlterV = new VendaDAOImpl();

                if (daoAlterV.alterarCampo("valorFinal", String.valueOf(valorVenda), String.valueOf(idvenda)).equals(true)) {

                    GenericDAO dao = new ItemDAOImpl();
                    dao.excluir(idItem);

                }

            }

        } catch (Exception ex) {
            System.out.println("Problemas ao excluir Item! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            request.getRequestDispatcher("ListarItem").forward(request, response);
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
