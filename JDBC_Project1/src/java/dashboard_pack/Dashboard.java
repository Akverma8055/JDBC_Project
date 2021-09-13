/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard_pack;

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
import model.Model_oracle;

/**
 *
 * @author Aman
 */
public class Dashboard extends HttpServlet {

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
        ResultSet rs;
//        out.println("Welcome Aman Panel");
        try {
            Model_oracle db = new Model_oracle();
            rs = db.view_all();
            out.println("\n"
                    + "        <nav class=\"navbar navbar-expand-xxl bg-dark navbar-dark \">\n"
                    + "            <!-- Brand/logo -->\n"
                    + "            <a class=\"navbar-brand\" href=\"index.html\">Servlet</a>\n"
                    + "\n"
                    + "            <!-- Links -->\n"
                    + "            <!--            <ul class=\"navbar-nav\">\n"
                    + "                            <li class=\"nav-item\">\n"
                    + "                                <a class=\"nav-link\" href=\"#\">Link 1</a>\n"
                    + "                            </li>\n"
                    + "                            <li class=\"nav-item\">\n"
                    + "                                <a class=\"nav-link\" href=\"#\">Link 2</a>\n"
                    + "                            </li>\n"
                    + "                            <li class=\"nav-item\">\n"
                    + "                                <a class=\"nav-link\" href=\"#\">Link 3</a>\n"
                    + "                            </li>\n"
                    + "                        </ul>-->\n"
                    + "\n"
                    + "            <a href=\"Register.html\" class=\"btn btn-primary\" name=\"regis\" value=\"\">New Registration</a>\n"
                    + "        </nav>");
            out.println("<!DOCTYPE html>\n"
                    + "<!--\n"
                    + "To change this license header, choose License Headers in Project Properties.\n"
                    + "To change this template file, choose Tools | Templates\n"
                    + "and open the template in the editor.\n"
                    + "-->\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>TODO supply a title</title>\n"
                    + "        <meta charset='UTF-8'>\n"
                    + "        <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n"
                    + "        <!-- Latest compiled and minified CSS -->\n"
                    + "        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>\n"
                    + "        <!-- jQuery library -->\n"
                    + "        <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>\n"
                    + "       <!-- Latest compiled JavaScript -->\n"
                    + "       <link rel=\"stylesheet\" type=\"text/css\" href=\"css/datatable.css\">\n"
                    + "        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>\n"
                    + "        <script src=\"js/datatable.js\"></script>\n"
                    + "        <script src=\"js/datatable_validation.js\"></script>\n"
                    + "        <style>\n"
                    + "            body{\n"
                    + "                background: url('images/bakground.jpg') center;\n"
                    + "\n"
                    + "            }\n"
                    + "        </style>\n"
                    + "    </head>\n"
                    + "    <body >\n"
                    + "    <div class='container my-3 m-auto' >\n"
                    + "    <div class='row' >\n"
                    + "    <div class='col-md-10 m-auto' >\n"
                    + "    <h3>All Records</h3>\n"
                    + "      <table id=\"myTable\" class='table table-bordered' >\n"
                    + "        <thead>\n"
                    + "          <tr>\n"
                    + "            <th>First Name</th>\n"
                    + "            <th>Last Name</th>\n"
                    + "            <th>Email</th>\n"
                    + "            <th>Username</th>\n"
                    + "            <th>State</th>\n"
                    + "            <th colspan=\"2\">Services</th>\n"
                    + "          </tr>\n"
                    + "        </thead>");

            
            while (rs.next()) {
                out.println(" <tbody>\n"
                        + "          <tr>\n"
                        + "            <td>" + rs.getString("firstname") + "</td>\n"
                        + "            <td>" + rs.getString("lastname") + "</td>\n"
                        + "            <td>" + rs.getString("email") + "</td>\n"
                        + "            <td>" + rs.getString("username") + "</td>\n"
                        + "            <td>" + rs.getString("state") + "</td>\n"
                                
                        + "            <td><a href=\"Edit_user_page?id="+rs.getString("email")+"\" class=\"\">Edit</a>|<a href=\"Delete_record?id="+rs.getString("email")+"\" class=\"\">Delete</a></td>\n"
                        + "          </tr>\n"
                        + "        </tbody>");
            }
            out.println("      </table>\n"
                    + "</div></div></div>\n"
                    + "    </body>\n"
                    + "   \n"
                    + "</html>");
        } catch (Exception e) {
            e.printStackTrace();
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
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
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
