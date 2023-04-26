/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.br.com.Study.controller;

import project.br.com.Study.model.Item;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.br.com.Study.dao.GenericDAO;
import project.br.com.Study.dao.ProdutoDAOImpl;
import project.br.com.Study.model.Carrinho;
import project.br.com.Study.model.Produto;

/**
 *
 * @author Sindicato
 */
@WebServlet(name = "SalvarItem", urlPatterns = {"/InserirItem"})
public class AdicionarItemCarrinho extends HttpServlet {

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

        Item item = new Item();

        Produto produto = new Produto();
        produto.setCodigoProduto(Integer.parseInt(request.getParameter("codigoP")));
        produto.setNomeProduto(request.getParameter("nomeP"));
        produto.setPrecoProduto(Double.valueOf(request.getParameter("precoP")));
        item.setProduto(produto);
        
        Double preco = Double.valueOf(request.getParameter("precoP"));
        item.setQuantidadeItem(Double.valueOf(request.getParameter("quantidadeI")));
        item.setValorTotal(item.getQuantidadeItem() * preco);

        Carrinho carrinho = new Carrinho();       
        carrinho.inserirItem(item);
        
        try {
            GenericDAO dao = new ProdutoDAOImpl();
            request.setAttribute("produtos", dao.listar());
        } catch (Exception ex) {
            System.out.println("Problemas ao listar Produto! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }

        request.setAttribute("itens", carrinho.getItens());
        request.getRequestDispatcher("produto/listar.jsp").forward(request, response);

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
