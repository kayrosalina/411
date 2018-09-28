package Servlets;

import UserInfo.Testing;
import UserInfo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.*;

//THINGS TO FIX :: error line

@WebServlet("/Login")
public class Login extends HttpServlet {
    String fromURI;
    int valid;
    User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");

        String dbPassword = ""; 
        String email = "";

        boolean userExists = false;
        boolean userCanLogin = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project","root","root");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from login WHERE username = '" + Username +"'");
            if(rs.next())
            {
                userExists = true;
                dbPassword= rs.getString("password");
                email = rs.getString("email");
                if(dbPassword.equals(Password))
                {
                    userCanLogin = true;
                }
            }
            con.close();
        }
        catch(Exception e){
            userExists = false;
            System.out.println(e);
        }


        PrintWriter out = response.getWriter();

        if(userExists && userCanLogin)
        {
            out.print("User exists and can login.  Email is: " + email);
            //request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
        else
        {
            out.print("Cannot login");
            out.print("User = " + Username + " : Pass = " + Password);
            //request.getRequestDispatcher("/Home").forward(request, response);
        }
        out.print(email + "  " + dbPassword);

        //valid = Testing.checkUnPw(Username, Password);
        /*
        if (userExists && userCanLogin) {
            user = Testing.createUser(Username, Password);
            if (user.isActive()) {
                user.setAttempts(0);
                HttpSession session = request.getSession();
                session.setAttribute("username", user);
                user.setLastPg(LocalDateTime.now());

                if (fromURI != null) {
                    request.getRequestDispatcher(fromURI).forward(request, response);
                    request.removeAttribute("fromURI");
                } else request.getRequestDispatcher("/Home").forward(request, response);
            } else if (userExists){
                request.setAttribute("error", "User is inactive.");
                doGet(request, response);
            }

        } else if (valid == 0) {
            request.setAttribute("error", "Incorrect user/password.");
            user.setAttempts(user.getAttempts() + 1);
            if (user.getAttempts() >= 3) {
                user.setActive(false);
                request.setAttribute("error", "You're account is currently inactive.");
            }
            doGet(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.print("User does not exist");
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
        */
    }


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            fromURI = (String) request.getAttribute("fromURI");
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
    }
}
