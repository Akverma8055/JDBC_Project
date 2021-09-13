/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgetPass;

import model.store_otp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Email.EmailUtility;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import model.Model_oracle;

/**
 *
 * @author Aman
 */
@WebServlet(name = "TwoStepForgetPassword", urlPatterns = {"/forgetPassword"})
public class TwoStepForgetPassword extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter p = response.getWriter();
        HttpSession hs = request.getSession();
        Model_oracle db = new Model_oracle();
        String secq, ans;
        boolean check = false;
        if (request.getParameter("send") != null) {
            String recipient = request.getParameter("email");
            hs.setAttribute("email", recipient);
//            System.out.println(recipient);
//            db = new Model_oracle();
            try {

                check = db.user_email_veri(recipient);
                if (check == true) {
                    int len = 10;
                    String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    String Small_chars = "abcdefghijklmnopqrstuvwxyz";
                    String numbers = "0123456789";
                    String symbols = "!@#$%^&*_=+-/.?<>)";

                    String values = Capital_chars + Small_chars
                            + numbers + symbols;

                    // Using random method
                    Random rndm_method = new Random();

                    char[] password = new char[len];

                    for (int i = 0; i < len; i++) {
                        // Use of charAt() method : to get character value
                        // Use of nextInt() as it is scanning the value as int
                        password[i]
                                = values.charAt(rndm_method.nextInt(values.length()));

                    }

                    String newpasswordMessage = password.toString();

                    store_otp.setOtp(newpasswordMessage);//////////////////
                    System.out.println(newpasswordMessage);
                    String resultMessage;

                    try {
                        EmailUtility.sendEmail(host, port, user, pass, recipient,
                                newpasswordMessage);

                        resultMessage = "The e-mail was sent successfully";

                        p.println(resultMessage);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        resultMessage = "There were an error: " + ex.getMessage();
                    }
                    RequestDispatcher rd = request.getRequestDispatcher("otp.html");
                    rd.forward(request, response);

                } else {
                    p.println("check Your Email id ??");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (request.getParameter("verify") != null) {
            secq = request.getParameter("secq");
            ans = request.getParameter("ans");
            check = db.user_check_security(secq, ans);
            if (check == true) {
                RequestDispatcher rd = request.getRequestDispatcher("newpassword.html");
                rd.include(request, response);
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TwoStepForgetPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TwoStepForgetPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
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
