package Servlets;

import userinfo.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@WebServlet(name = "Home")
public class home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        if (request.getSession(false)!= null){
            user user = (user) request.getSession().getAttribute("username");
            double min = ChronoUnit.MINUTES.between(user.getLastPg(), LocalDateTime.now());
            if (min <=30){
                user.setLastPg(LocalDateTime.now());
                request.getRequestDispatcher("/Home.jsp").forward(request,response);
            }
            else response.sendRedirect("/Logout");
        }
        else {
            response.sendRedirect("/Login");
        }
    }
}
