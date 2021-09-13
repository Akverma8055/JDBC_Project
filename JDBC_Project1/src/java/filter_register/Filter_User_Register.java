/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter_register;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import model.Model_oracle;

/**
 *
 * @author Aman
 */
public class Filter_User_Register implements Filter {

    FilterConfig fc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String fname, lname, email, dob, state, uname, pass, cpass, secq, ans;
        int count;
        System.out.println("User Register Filter == " + fc.getFilterName());
        if (request.getParameter("registerbtn") != null) {

            try {
                Model_oracle db = new Model_oracle();

                fname = request.getParameter("fname");
                lname = request.getParameter("lname");
                email = request.getParameter("email");
                dob = request.getParameter("dob");
                uname = request.getParameter("uname");
                pass = request.getParameter("pass");
                cpass = request.getParameter("cpass");
                secq = request.getParameter("secq");
                ans = request.getParameter("ans");
                state = request.getParameter("state");

                count = db.user_register(fname, lname, email, dob, uname, pass, cpass, secq, ans, state);
                if (count > 0) {
                    //  System.out.println("Record inserted");
                    RequestDispatcher rd = request.getRequestDispatcher("/login.html");
                    rd.forward(request, response);
                    chain.doFilter(request, response);
                } else {
                    System.out.println("Not Insert ???");
                }

                //
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else {
            //  chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        this.fc = null;
    }

}
