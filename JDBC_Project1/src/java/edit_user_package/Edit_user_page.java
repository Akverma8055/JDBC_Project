/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edit_user_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Edit_user_page extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession hs = request.getSession();
        Boolean check = false;
        ResultSet rs;
        try {
            Model_oracle db = new Model_oracle();
            String sid=request.getParameter("id");  
            System.out.println("check .."+sid);
            check = db.check_username(sid);
            if (check == true) {
                rs = db.fetch_all_records(sid.toString());
               // out.println(hs.getAttribute("uname"));
                while (rs.next()) {
                    out.println(" <form action='edit_record' method='post'>\n"
                            + "            First Name <input type='text' value='" + rs.getString("firstname") + "' name='fname'><br>\n"
                            + "            Last Name <input type='text' value='" + rs.getString("lastname") + "' name='lname'><br>\n"
                            + "            Email  <input type='text'value='" + rs.getString("email") + "'  name='email'><br>\n"
                            + "            D.O.B  <input type='date' value='" + rs.getString("dob") + "' name='dob'><br>\n"
                            + "            State <select name='state' value='" + rs.getString("state") + "'>\n"
                            + "                <option value='Select any State' >Select any State</option>\n"
                            + "                 <option value='UP'>UP</option>\n"
                            + "                  <option value='MP'>MP</option>\n"
                            + "                  <option value='CG'>CG</option>\n"
                            + "            </select><br>\n"
                            + "            User Name <input type='text' value='" + rs.getString("username") + "' readonly=''><br>\n"
                            + "             <input type='submit' value='Update'><input type='reset' value='Clear'>\n"
                            + "        </form>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("update page");
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
            Logger.getLogger(Edit_user_page.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Edit_user_page.class.getName()).log(Level.SEVERE, null, ex);
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
