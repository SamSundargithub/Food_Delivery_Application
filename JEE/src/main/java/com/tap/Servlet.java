package com.tap;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

      
            PrintWriter out = resp.getWriter();

           
                out.println("<h2>Registration Successful</h2>");
          
            }

  
    }

	/*
	 * doGet : 
	 * 1)Only limited data can pass. 
	 * 2) Data Sent Through URL 
	 * 3)less Secure
	 * 4) Can Bookmark URL
	 * 5) Safe to Refresh
	 * 6) Browser History is Stored. 
	 * 7) File Upload not suitable. 
	 * 8) Speed slightly faster. 9) Used to search, view and fetch data.
	 */

	/*
	 * doPost : 
	 * 1) There is no limitation for data to pass. 
	 * 2) Data sent through request body. 
	 * 3) not visible in URL. 
	 * 4) More Secure. 
	 * 5) Cannot bookmark URL.
	 * 6) Browser asks confirmation for refresh. 
	 * 7) File upload is suitable. 
	 * 8)Speed is slightly slower. 
	 * 9) Browser history is not stored. 
	 * 10) Used to login, register, update and submit data.
	 */