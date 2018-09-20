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
import java.sql.SQLException;
import java.time.LocalDateTime;

//THINGS TO FIX :: error line, login redirect/URI followup

@WebServlet("/Login")
public class Login extends HttpServlet {
    String fromURI;
    int valid;
    User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");

        valid = Testing.checkUnPw(Username, Password);
        if (valid == 1) {
            user = Testing.createUser(Username, Password);
            if (user.isActive()) {
                user.setAttempts(0);
                HttpSession session = request.getSession();
                session.setAttribute("username", user);
                user.setLastPg(LocalDateTime.now());

                if (fromURI != null) {
                    request.getRequestDispatcher(fromURI).forward(request, response);
                    request.removeAttribute("fromURI");
                } else request.getRequestDispatcher("/Home.jsp").forward(request, response);
            } else {
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
    }


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //      if (request.getAttribute("error") != null) {
              fromURI = (String) request.getAttribute("fromURI");
     //         doGet(request, response);
              request.getRequestDispatcher("/Login.jsp").forward(request,response);
     //     }

    }
}
