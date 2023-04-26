/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TCC.Ecommerce.controller.Produto;

import br.com.TCC.Ecommerce.dao.GenericDAO;
import br.com.TCC.Ecommerce.dao.ProdutoDAOImpl;
import br.com.TCC.Ecommerce.model.Marca;
import br.com.TCC.Ecommerce.model.Produto;
import br.com.TCC.Ecommerce.model.Categoria;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sindicato
 */
@WebServlet(name = "SalvarProduto", urlPatterns = {"/SalvarProduto"})
public class SalvarProduto extends HttpServlet {

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

        Produto produto = new Produto();
        Marca marca = new Marca();
        Categoria categoria = new Categoria();

        produto.setNomeProduto(request.getParameter("nome"));
        produto.setPrecoProduto(Double.valueOf(request.getParameter("preco")));
        produto.setQuantidadeEstoque(Double.valueOf(request.getParameter("quantidade")));
        produto.setDescricaoProduto(request.getParameter("descricao"));
        produto.setDataFabricacao(request.getParameter("data"));
        produto.setLoteProduto(request.getParameter("lote"));
        marca.setIdMarca(Integer.parseInt(request.getParameter("marca")));
        produto.setMarca(marca);
        categoria.setIdCategoria(Integer.parseInt(request.getParameter("categoria")));
        produto.setCategoria(categoria);
        
        String msg = null;
        
        try {
            GenericDAO dao = new ProdutoDAOImpl();
            if (request.getParameter("codigo").equals("")) {
                if (dao.cadastrar(produto).equals(true)){
                    msg = "Produto " + produto.getNomeProduto() + " cadastrado com sucesso!";
                } else {
                    msg = "Problemas ao cadastrar Produto! Verifique os dados.";
                }
            } else {
                produto.setCodigoProduto(Integer.parseInt(request.getParameter("codigo")));
                if (dao.alterar(produto).equals(true)) {
                    msg = "Produto " + produto.getNomeProduto() + " alterado com sucesso!";
                } else {
                    msg = "Problemas ao alterar Produto! Verifique os dados.";
                }
            }
            
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar/alterar Produto! Erro: " + ex.getMessage());
            msg = "Problemas ao cadastrar/alterar Produto! Erro de conexão: " + ex.getMessage();
            ex.printStackTrace();
            
        } finally {
            request.setAttribute("response", msg);
            request.getRequestDispatcher("produto/salvar.jsp").forward(request, response);
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
