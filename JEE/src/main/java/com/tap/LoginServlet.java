package com.tap;
import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.tap.DAO.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/callLoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        
        UserDAOImpl userdao  = new UserDAOImpl();
        User u = userdao.getUserByEmail(email);
        
        if(u == null) {
        	resp.sendRedirect("callRestaurantServlet"); // no user found
        	return;
        }
        String dbpass = u.getPassword();
        
        if(BCrypt.checkpw(password, dbpass)) {
        	session.setAttribute("email", email);
        	session.setAttribute("user_Id", u.getUserId());
        	System.out.println("LOGIN SUCCESS - user_id set to: "+ u.getUserId());
        	userdao.updateUser(u);
        	resp.sendRedirect("callRestaurantServlet");
        }
        else {        	
        	resp.sendRedirect("login.html");
        }

        }
    }
