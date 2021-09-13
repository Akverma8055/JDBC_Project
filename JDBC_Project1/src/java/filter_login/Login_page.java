/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter_login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Aman
 */
public class Login_page implements Filter {

    FilterConfig fc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        System.out.println("Login PAge filter" + fc.getFilterName());
        if (request.getParameter("log") != null) {
            out.println("<!DOCTYPE html>\n"
                    + "<!--\n"
                    + "To change this license header, choose License Headers in Project Properties.\n"
                    + "To change this template file, choose Tools | Templates\n"
                    + "and open the template in the editor.\n"
                    + "-->\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>TODO supply a title</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "        <!-- Latest compiled and minified CSS -->\n"
                    + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n"
                    + "        <!-- jQuery library -->\n"
                    + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                    + "        <!-- Popper JS -->\n"
                    + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n"
                    + "        <!-- Latest compiled JavaScript -->\n"
                    + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n"
                    + "        <script src=\"js/captcha_val.js\">\n"
                    + "        </script>\n"
                    + "\n"
                    + "        <style>\n"
                    + "            body{\n"
                    + "                background: url('images/background.jpg') center;\n"
                    + "\n"
                    + "            }\n"
                    + "            #mainCaptcha{\n"
                    + "                background: lightblue;\n"
                    + "                font-weight: bold;\n"
                    + "            }\n"
                    + "        </style>\n"
                    + "    </head>\n"
                    + "    <body class=\"no-gutters\" onload=\"Captcha()\">\n"
                    + "\n"
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
                    + "            <input type='submit' class=\"btn btn-primary\" name=\"regis\" value=\"New Registration\" />\n"
                    + "        </nav>\n"
                    + "        <div class=\"container my-4 \">\n"
                    + "            <div class=\"row clearfix\">\n"
                    + "                <div class=\"col-md-6 m-auto align-center\">\n"
                    + "                    <div class=\"card\">\n"
                    + "                        <div class=\"card-header \">\n"
                    + "                            <h3>Login Form</h3>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"card-body\">\n"
                    + "                            <form action=\"check_login_servlet\" method=\"post\">\n"
                    + "                                <div class=\"form-group\">\n"
                    + "                                    <label for=\"Username\" class=\"label\">Username</label>\n"
                    + "                                    <input type=\"text\" name=\"uname\" placeholder=\"username\" class=\"form-control\"/>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"form-group\">\n"
                    + "                                    <label for=\"Password\" class=\"label\">Password</label>\n"
                    + "                                    <input type=\"password\" name=\"pass\" placeholder=\"*****\" class=\"form-control\"/>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"form-inline py-2\">\n"
                    + "                                    <!--<label for=\"captcha\" class=\"label\">Captcha</label><br/>-->\n"
                    + "                                    <input type=\"text\" name=\"\" id=\"txtInput\" required='' class=\"form-control\"/>&nbsp;-&nbsp;\n"
                    + "                                    <input type=\"text\" name=\"\" id=\"mainCaptcha\" class=\"form-control text-center\"/>\n"
                    + "                                </div><br/>\n"
                    + "                                <div class=\"form-group d-flex justify-content-center\">\n"
                    + "                                    <input type=\"submit\" name=\"loginbtn \" onclick=\"ValidCaptcha();\" value=\"Login\"  class=\"btn btn-primary w-25 font-weight-bold\"/>\n"
                    + "                                </div>\n"
                    + "                            </form>\n"
                    + "                        </div>\n"
                    + "                        <span class=\"card-footer\">\n"
                    + "                            <label>Forget password &nbsp;<a href=\"check_email.html\">click here</a></label>\n"
                    + "                        </span>\n"
                    + "\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        this.fc = null;
    }

}
