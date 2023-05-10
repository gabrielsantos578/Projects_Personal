/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DateTimeDAOImpl;
import dao.GenericDAO;
import dao.ListObjectDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DateTime;
import model.ListObject;

/**
 *
 * @author Alunos
 */
@WebServlet(name = "Salvar", urlPatterns = {"/Salvar"})
public class Salvar extends HttpServlet {

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

        /**
         * ************** DATE & TIME ***************
         */
        
        LocalDateTime ldt = LocalDateTime.now();
        DateTime dt = new DateTime();

        String date = String.valueOf(ldt);
        date = date.substring(0, 10);
        String ano = date.substring(0, 4);
        String mes = date.substring(5, 7);
        String dia = date.substring(8, 10);
        date = dia+"/"+mes+"/"+ano;
        dt.setDateTest(date);

        String time = String.valueOf(ldt);
        time = time.substring(11, 19);
        /*String hora = time.substring(11, 13);
        String minuto = time.substring(14, 16);
        String segundo = time.substring(17, 19);
        time = hora+":"+minuto+":"+segundo;*/
        dt.setTimeTest(time);

        
        String msgDT = null;
        try {

            GenericDAO daoDT = new DateTimeDAOImpl();

            if (daoDT.cadastrar(dt).equals(true)) {
                msgDT = "DateTime cadastrada com sucesso!";
            } else {
                msgDT = "Problemas ao cadastrar DateTime! Verifique os dados. D = " +dt.getDateTest()+ " T = "+dt.getTimeTest();
            }

        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar DateTime! Erro: " + ex.getMessage());
            msgDT = "Problemas ao cadastrar DateTime! Erro de conexão: " + ex.getMessage();
            ex.printStackTrace();
        }

        
        
        /**
         * ************** LIST OBJECT ***************
         */
        
        HttpSession sessao = request.getSession();
        List<ListObject> lo = (ArrayList) sessao.getAttribute("alunos");

        
        String msgLO = null;
        try {

            for (int i = 0; i < lo.size(); i++) {

                GenericDAO daoLO = new ListObjectDAOImpl();

                if (daoLO.cadastrar(lo.get(i)).equals(true)) {
                    msgLO = "ListObject "  + lo.get(i).getObjectTest() + " cadastrada com sucesso!";
                } else {
                    msgLO = "Problemas ao cadastrar ListObject! Verifique os dados. O.1 = " + lo.get(0) + " / O.2 = "  + lo.get(1).getObjectTest() + " / O.3 = "  + lo.get(2).getObjectTest();
                }
                
            }

        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar ListObject! Erro: " + ex.getMessage());
            msgLO = "Problemas ao cadastrar ListObject! LO = "+lo.get(0).getObjectTest()+". Erro de conexão: " + ex;
            ex.printStackTrace();
        } 
        
        
        
        /**
         * ************** END ***************
         */
        
        finally {
            request.setAttribute("responseDT", msgDT);
            request.setAttribute("responseLO", msgLO);
            request.getRequestDispatcher("home.jsp").forward(request, response);
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
