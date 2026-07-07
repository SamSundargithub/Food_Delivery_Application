package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import org.mindrot.jbcrypt.BCrypt;

import com.tap.DAO.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callRegisterServlet")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		 String username = req.getParameter("username");
		 String password = req.getParameter("password");
		 String email = req.getParameter("email");
		 String address = req.getParameter("address");
		 String role = req.getParameter("role");
		 String number = req.getParameter("number");
		 
		String hashpw = BCrypt.hashpw(password, BCrypt.gensalt(12));
		
		User u = new User(username, hashpw, email, address, role, number);
		UserDAOImpl userimp = new UserDAOImpl();
		int res = userimp.addUser(u);
		
		if(res == 1) {
			resp.sendRedirect("login.html");
		}
		else {
			resp.sendRedirect("register.html");
		}
		PrintWriter out = resp.getWriter();
		out.print("Registration Successfull.....");
	}

	
}
