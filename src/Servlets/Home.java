package Servlets;

import UserInfo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@WebServlet("/Home")
public class Home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-control", "private, no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");


        if (request.getSession(false).getAttribute("username") !=null){
//            User user = (User) request.getSession(false).getAttribute("username");
//            user.setLastPg(LocalDateTime.now());
            request.getRequestDispatcher("/Home.jsp").forward(request,response);
        }
        else {
            request.setAttribute("fromURI", request.getRequestURI());
            RequestDispatcher dispatch = request.getRequestDispatcher("/Login");
            dispatch.forward(request, response);
        }
    }
}
