package Servlets;

import userinfo.user;
import userinfo.usertest;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet(name = "Login")
public class login extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request.setAttribute("username", request.getParameter("login"));
        //request.setAttribute("password", request.getParameter("password"));

        //request.getRequestDispatcher("/welcome.jsp").forward(request,response);
       // HttpServletResponse.setHeader("Location", "/welcome.jsp");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.print("login-name: " + request.getParameter("login") + "Password: " +request.getParameter("password"));

    }
}