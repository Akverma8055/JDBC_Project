/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter_login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Model_oracle;

/**
 *
 * @author Aman
 */
//@WebServlet(name = "check_login_servlet", urlPatterns = {"/check_login_servlet"})
public class check_login_servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @throws java.io.IOException
     */
    int counter;

    @Override
    public void init() throws ServletException {
        counter = 0;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter p = response.getWriter();
        String un, up;
        HttpSession hs = request.getSession();
        boolean check = false;
        try {

            un = request.getParameter("uname");
            up = request.getParameter("pass");
            hs.setAttribute("uname", un);
            Model_oracle db = new Model_oracle();
            check = db.user_login(un, up);
            if (check == true) {
                RequestDispatcher rd=request.getRequestDispatcher("Dashboard");
                rd.include(request, response);

            } else {
                counter = counter + 1;
                System.err.println(counter);
                if (counter == 10) {
                    RequestDispatcher rd = request.getRequestDispatcher("/login.html");
                    rd.include(request, response);
                    p.println("Counter " + counter + "<br>");
                    p.println("// ==UserScript==\n"
                            + "// @name         page blocker\n"
                            + "// @namespace    http://tampermonkey.net/\n"
                            + "// @version      0.1\n"
                            + "// @description  block pages\n"
                            + "// @author       Sᴀᴍ Onᴇᴌᴀ\n"
                            + "// @match        *://*.news_website_1.com/*\n"
                            + "// @match        *://*.news_website_2.com/*\n"
                            + "// @grant        none\n"
                            + "// ==/UserScript==\n"
                            + "\n"
                            + "(() => { //IIFE arrow function\n"
                            + "    'use strict';\n"
                            + "\n"
                            + "    const regexToMatchTLD = /\\.[^.]+$/;\n"
                            + "    const domain = location.hostname.replace(regexToMatchTLD, 'http://localhost:19871/Servlet_Jdbc_example/login.html');; \n"
                            + "    document.body.innerHTML =`\n"
                            + "          <div style=\"direction: ltr; position: fixed; top: 0; z-index: 999999; display: block; width: 100%; height: 100%; background: red\">\n"
                            + "            <p style=\"position: relative; top: 40%; display: block; font-size: 66px; font-weight: bold; color: #fff; margin: 0 auto; text-align: center\">\n"
                            + "              The website ${domain} successfully blocked !\n"
                            + "            </p>\n"
                            + "          </div>\n"
                            + "    `;\n"
                            + "})();");
                }

                RequestDispatcher rd = request.getRequestDispatcher("/login.html");
                rd.include(request, response);
                p.println("invalid User name and password ");
            }
        } catch (IOException | SQLException | ServletException ex) {
            ex.printStackTrace();
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
