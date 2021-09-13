/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author Aman
 */
public class Model_oracle {

    Connection con;
    Statement st;
    ResultSet rs;
    int count;
    String query;
    boolean check = false;

    public Model_oracle() throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
            st = con.createStatement();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
    }

    public int user_register(String fname, String lname, String email, String dob, String uname, String pass, String cpass, String secq, String ans, String state) throws SQLException {
        query = "insert into user_profile values('" + fname + "','" + lname + "','" + email + "','" + dob + "','" + uname + "','" + pass + "','" + cpass + "','" + secq + "','" + ans + "','" + state + "')";
        count = st.executeUpdate(query);
        return count;
    }

    public boolean user_login(String uname, String pass) throws SQLException {
        query = "select * from user_profile where username='" + uname + "'and password='" + pass + "'";
        rs = st.executeQuery(query);
        check = rs.next();
        return check;
    }

    public boolean user_email_veri(String email) throws SQLException {
        query = "select * from user_profile where email='" + email + "'";
        rs = st.executeQuery(query);
        check = rs.next();
        return check;
    }

    public boolean user_check_security(String secq, String ans) throws SQLException {
        query = "select * from user_profile where secq='" + secq + "' and answer ='" + ans + "'";
        rs = st.executeQuery(query);
        check = rs.next();
        return check;
    }

    public int newPassword(String pass, String email) throws SQLException {
        query = "update user_profile set password='" + pass + "' where email='" + email + "'";
        count = st.executeUpdate(query);
        return count;

    }

    public ResultSet view_all() throws SQLException {
        query = "select * from user_profile";
        rs = st.executeQuery(query);
        return rs;
    }

    public boolean check_username(String uname) throws SQLException {
        query = "select * from user_profile where email='" + uname + "'";
        rs = st.executeQuery(query);
        check = rs.next();
        return check;
    }

    public ResultSet fetch_all_records(String uname) throws SQLException {
        query = "select * from user_profile where email='" + uname + "'";
        rs = st.executeQuery(query);
        return rs;
    }

    public int edit_record(String fname, String lname, String email, String dob, String state, String uname) throws SQLException {
        query = "update user_profile set firstname='" + fname + "',lastname='" + lname + "',email='" + email + "',dob='" + dob + "',state='" + state + "' where username='" + uname + "'";
        count = st.executeUpdate(query);
        return count;
    }

    public int delete_record(String uname) throws SQLException {
        query = "delete * from user_profile where username='" + uname + "'";
        count = st.executeUpdate(query);
        return count;
    }

}
