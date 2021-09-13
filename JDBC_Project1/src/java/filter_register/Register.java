/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter_register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Aman
 */
public class Register implements Filter {

    FilterConfig fc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;

        ServletContext sct = request.getServletContext();
        String x, y;
        System.out.println("Register filter " + fc.getFilterName());
        if (request.getParameter("regis") != null) {
            out.println("<html>\n"
                    + "    <head>\n"
                    + "        <title>TODO supply a title</title>\n"
                    + "        <meta charset='UTF-8'>\n"
                    + "        <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n"
                    + "        <!-- Latest compiled and minified CSS -->\n"
                    + "        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>\n"
                    + "        <!-- jQuery library -->\n"
                    + "        <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>\n"
                    + "        <!-- Popper JS -->\n"
                    + "        <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>\n"
                    + "        <!-- Latest compiled JavaScript -->\n"
                    + "        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>\n"
                    + "        <script src=\"js/password_val.js\"></script>\n"
                    + "\n"
                    + "        <style>\n"
                    + "            body{\n"
                    + "                background: url('images/background.jpg') center;\n"
                    + "\n"
                    + "            }\n"
                    + "    </style>\n"
                    + "</head>\n"
                    + "<body class='no-gutters'>\n"
                    + "\n"
                    + "    <nav class='navbar navbar-expand-xxl bg-dark navbar-dark '>\n"
                    + "        <!-- Brand/logo -->\n"
                    + "        <a class='navbar-brand' href='index.html'>Servlet</a>\n"
                    + "\n"
                    + "        <!-- Links -->\n"
                    + "        <!--            <ul class='navbar-nav'>\n"
                    + "                        <li class='nav-item'>\n"
                    + "                            <a class='nav-link' href='#'>Link 1</a>\n"
                    + "                        </li>\n"
                    + "                        <li class='nav-item'>\n"
                    + "                            <a class='nav-link' href='#'>Link 2</a>\n"
                    + "                        </li>\n"
                    + "                        <li class='nav-item'>\n"
                    + "                            <a class='nav-link' href='#'>Link 3</a>\n"
                    + "                        </li>\n"
                    + "                    </ul>-->\n"
                    + "\n"
                    + "    </nav>\n"
                    + "    <div class='container my-4 '>\n"
                    + "        <div class='form-row  no-gutters clearfix'>\n"
                    + "            <div class='col-md-8 m-auto align-center'>\n"
                    + "                <div class='card'>\n"
                    + "                    <div class='card-header '>\n"
                    + "                        <h3>Create an Account</h3>\n"
                    + "                    </div>\n"
                    + "                    <div class='card-body'>\n"
                    + "              ======      <form method=\"post\" action=\"Dashboard\">\n"
                    + "                            <div class='form-row'>\n"
                    + "                                <div class='form-group col-md-6'>\n"
                    + "                                    <label for='firstname'>First Name</label>\n"
                    + "                                    <input type='text' class='form-control' id='fname' name='fname' placeholder='First Name' required=\"\">\n"
                    + "                                </div>\n"
                    + "                                <div class='form-group col-md-6'>\n"
                    + "                                    <label for='lastname'>Last Name</label>\n"
                    + "                                    <input type='text' class='form-control' id='lname' name='lname' placeholder='Last Name' required=\"\">\n"
                    + "                                </div>\n"
                    + "                            </div>\n"
                    + "                            <div class='form-row'>\n"
                    + "                                <div class='form-group col-md-6'>\n"
                    + "                                    <label for='email'>Email</label>\n"
                    + "                                    <input type='email' class='form-control' id='email' name='email' placeholder='Email' required=\"\">\n"
                    + "                                </div>\n"
                    + "                                <div class='form-group col-md-6'>\n"
                    + "                                    <label for='dob'>Date of Birth</label>\n"
                    + "                                    <input type='date' class='form-control' id='dob' name='dob' required=\"\">\n"
                    + "                                </div>\n"
                    + "                            </div>\n"
                    + "                            <div class='form-group'>\n"
                    + "                                <label for='state' required=\"\">State</label>\n"
                    + "                                <select id='state' name='state' class='form-control'>\n"
                    + "                                    <option selected>Choose any State</option>");
            out.println("<option value='Delhi'>Delhi</option>\n"
                    + "                                    <option value='Gujraat'>Gujraat</option>\n"
                    + "                                    <option value='Maharastra'>Maharastra</option>\n"
                    + "                                    <option value='Uttar Pradesh'>Uttar Pradesh</option>");
            out.println("  </select> \n"
                    + "                            </div>\n"
                    + "                            <div class='form-group'>\n"
                    + "                                <label for='username'>User Name</label>\n"
                    + "                                <input type='text' class='form-control' id='uname' name=\"uname\" placeholder='Example@123' pattern='(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}'\n"
                    + "                                           title='Must contain at least one  number and one uppercase and lowercase letter, and at least 8 or more characters' required=\"\">\n"
                    + "                                </div>\n"
                    + "                                <div class='form-row'>\n"
                    + "                                    <div class='form-group col-md-6'>\n"
                    + "                                        <label for='password'>Password</label>\n"
                    + "                                        <input type='password' class='form-control' id='password' name='pass' onchange = \"validatePassword()\" required=\"\">\n"
                    + "                                    </div>\n"
                    + "\n"
                    + "                                    <div class='form-group col-md-6'>\n"
                    + "                                        <label for='conpassword'>Confirm Password</label>\n"
                    + "                                        <input type='password' name='cpass' class='form-control' id='confirm_password' onkeyup=\"validatePassword()\" required=\"\">\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class='form-group'>\n"
                    + "                                    <label for='security'>Security Question</label>\n"
                    + "                                    <select name='secq' class='form-control' required=\"\">\n"
                    + "                                        <option selected>Choose any One</option>");
            Enumeration em = sct.getInitParameterNames();
            while (em.hasMoreElements()) {
                x = em.nextElement().toString();
                out.println("<option value'" + sct.getInitParameter(x) + "'>" + sct.getInitParameter(x) + "</option>");
            }
            out.println(" </select>\n"
                    + "                                </div>\n"
                    + "                                <div class='form-group'>\n"
                    + "                                    <label for='answer' class=''>Answer</label>\n"
                    + "                                    <input type='text' name='ans' class='form-control' required=\"\"/>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"form-group d-flex justify-content-center\">\n"
                    + "                                    <input type=\"submit\" name=\"registerbtn\" value=\"Create an Account\" onclick=\"validatePassword()\" class=\"btn btn-primary w-50 font-weight-bold\"/>\n"
                    + "                                </div>\n"
                    + "                            </form>\n"
                    + "                            <span class='card-footer'>\n"
                    + "                                <label><input type='checkbox' name='accept'/>&nbsp;Term & Condition apply.</label>\n"
                    + "                            </span>\n"
                    + "\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");

        } else {
            out.println("sg");
        }
    }

    @Override
    public void destroy() {
        this.fc = null;
    }

}
