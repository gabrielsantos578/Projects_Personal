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
import br.com.TCC.Ecommerce.model.Item;
import br.com.TCC.Ecommerce.model.Produto;
import br.com.TCC.Ecommerce.model.Venda;
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
@WebServlet(name = "SalvarItem", urlPatterns = {"/SalvarItem"})
public class SalvarItem extends HttpServlet {

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
        Venda venda = new Venda();
        Produto produto = new Produto();

        String msg = null;
        String msgAlerta = null;

        item.setQuantidadeProduto(Double.valueOf(request.getParameter("quantidade")));
        venda.setCodigoVenda(Integer.parseInt(request.getParameter("venda")));
        item.setVenda(venda);
        produto.setCodigoProduto(Integer.parseInt(request.getParameter("produto")));
        String idproduto = String.valueOf(produto.getCodigoProduto());
        item.setProduto(produto);

        try {
            GenericDAO daoP = new ProdutoDAOImpl();
            produto.setPrecoProduto(Double.parseDouble(daoP.consultarObjeto("precoProduto", "codigoproduto", idproduto)));
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar dados do Produto! Erro: " + ex.getMessage());
            msg = "Problemas ao carregar dados do Produto! Erro: " + ex + produto.getPrecoProduto();
            request.setAttribute("response", msg);
            request.getRequestDispatcher("item/salvar.jsp").forward(request, response);
        }

        try {
            GenericDAO dao = new ItemDAOImpl();
            item.setValorTotal(produto.getPrecoProduto(), item.getQuantidadeProduto());

            GenericDAO daoNomeProduto = new ProdutoDAOImpl();
            produto.setNomeProduto((daoNomeProduto.consultarObjeto("nomeProduto", "codigoProduto", idproduto)));

            if (request.getParameter("codigo").equals("")) {

                GenericDAO daoProduto = new ProdutoDAOImpl();
                Double quantidadeEstoque = Double.parseDouble(daoProduto.consultarObjeto("quantidadeEstoque", "codigoProduto", idproduto));
                Double condicao = quantidadeEstoque;

                if (condicao == 0.0) {
                    msg = "Não é possível cadastrar o Item, pois o estoque do Produto " + produto.getNomeProduto() + " está zerado.";
                } else {
                    quantidadeEstoque = quantidadeEstoque - item.getQuantidadeProduto();

                    if (quantidadeEstoque < 0.0) {
                        msg = "Há somente " + (item.getQuantidadeProduto() + quantidadeEstoque) + " no estoque do Produto" + produto.getNomeProduto() + "! Retire " + -(quantidadeEstoque) + " do item da venda.";
                    } else {
                        produto.setQuantidadeEstoque(quantidadeEstoque);

                        GenericDAO daoAlterP = new ProdutoDAOImpl();
                        if (daoAlterP.alterarCampo("quantidadeEstoque", String.valueOf(produto.getQuantidadeEstoque()), idproduto).equals(true)) {

                            GenericDAO daoVenda = new VendaDAOImpl();
                            Double valorVenda = Double.parseDouble(daoVenda.consultarObjeto("valorFinal", "codigoVenda", String.valueOf(item.getVenda().getCodigoVenda())));
                            valorVenda = valorVenda + item.getValorTotal();
                            venda.setValorTotal(valorVenda);

                            GenericDAO daoAlterV = new VendaDAOImpl();
                            if (daoAlterV.alterarCampo("valorFinal", String.valueOf(venda.getValorTotal()), String.valueOf(venda.getCodigoVenda())).equals(true)) {

                                if (dao.cadastrar(item).equals(true)) {
                                    msg = "Item " + produto.getNomeProduto() + " para a venda " + item.getVenda().getCodigoVenda() + " cadastrado com sucesso!";

                                    if (quantidadeEstoque == 0.0) {
                                        msgAlerta = "Atenção! O produto " + produto.getNomeProduto() + " está com estoque vazio.";
                                    }

                                } else {
                                    msg = "Problemas ao cadastrar Item! Verifique os dados.";
                                }
                            } else {
                                msg = "Problemas ao alterar o valor da Venda! Verifique os dados. " + valorVenda + " " + item.getVenda().getCodigoVenda();
                            }
                        } else {
                            msg = "Problemas ao alterar o estoque do Produto! Verifique os dados. " + quantidadeEstoque + " " + item.getProduto().getCodigoProduto();
                        }

                    }
                }

            } else {
                item.setCodigoItens(Integer.parseInt(request.getParameter("codigo")));

                GenericDAO daoProduto = new ProdutoDAOImpl();
                Double quantidadeEstoque = Double.parseDouble(daoProduto.consultarObjeto("quantidadeEstoque", "codigoProduto", idproduto));
                Double condicao = quantidadeEstoque;
                GenericDAO daoItemProduto = new ItemDAOImpl();
                Double quantidadeItem = Double.parseDouble(daoItemProduto.consultarObjeto("quantidadeTotal", "codigoProduto", String.valueOf(item.getCodigoItens())));
                quantidadeEstoque = (quantidadeEstoque + quantidadeItem) - item.getQuantidadeProduto();

                if (quantidadeEstoque >= 0.0) {

                    produto.setQuantidadeEstoque(quantidadeEstoque);

                    GenericDAO daoAlterP = new ProdutoDAOImpl();
                    if (daoAlterP.alterarCampo("quantidadeEstoque", String.valueOf(produto.getQuantidadeEstoque()), idproduto).equals(true)) {

                        GenericDAO daoVenda = new VendaDAOImpl();
                        Double valorVenda = Double.parseDouble(daoVenda.consultarObjeto("valorFinal", "codigoVenda", String.valueOf(item.getVenda().getCodigoVenda())));
                        GenericDAO daoItemVenda = new ItemDAOImpl();
                        Double valorItem = Double.parseDouble(daoItemVenda.consultarObjeto("precoTotal", "idItem", String.valueOf(item.getCodigoItens())));
                        valorVenda = (valorVenda - valorItem) + item.getValorTotal();
                        venda.setValorTotal(valorVenda);

                        GenericDAO daoAlterV = new VendaDAOImpl();
                        if (daoAlterV.alterarCampo("valorFinal", String.valueOf(venda.getValorTotal()), String.valueOf(venda.getCodigoVenda())).equals(true)) {

                            if (dao.alterar(item).equals(true)) {
                                msg = "Item " + produto.getNomeProduto() + " para a venda " + item.getVenda().getCodigoVenda() + " alterado com sucesso!";

                            } else {
                                msg = "Problemas ao alterar Item! Verifique os dados.";                               
                            }

                        } else {
                            msg = "Problemas ao alterar o valor da Venda! Verifique os dados. " + valorVenda + " " + item.getVenda().getCodigoVenda();
                        }
                    } else {
                        msg = "Problemas ao alterar o estoque do Produto! Verifique os dados. " + quantidadeEstoque + " " + item.getProduto().getCodigoProduto();
                    }

                } else if (quantidadeEstoque < 0.0 && condicao == 0.0) {
                    msg = "O estoque do Produto " + produto.getNomeProduto() + " está zerado! Não é possível alterar o Item.";

                } else if (quantidadeEstoque < 0.0) {
                    msg = "Há somente " + condicao + " no estoque do Produto " + produto.getNomeProduto() + ". Retire " + -(quantidadeEstoque) + " do item da venda.";

                }

            }

        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar/alterar Item! Erro: " + ex.getMessage());
            msg = "Problemas ao cadastrar/alterar Item! Erro: " + ex;
            ex.printStackTrace();

        } finally {
            request.setAttribute("response", msg);
            request.setAttribute("alert", msgAlerta);
            request.getRequestDispatcher("item/salvar.jsp").forward(request, response);
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
