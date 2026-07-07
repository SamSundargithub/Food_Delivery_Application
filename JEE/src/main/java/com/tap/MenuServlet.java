package com.tap;

import java.io.IOException;
import java.util.List;

import com.tap.DAO.MenuDAOImpl;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu") 
public class MenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MenuDAOImpl menuImpl = new MenuDAOImpl();
		int restaurantId = Integer.parseInt(req.getParameter("restaurantID"));
		System.out.println(restaurantId);
		List<Menu> allMenuRest = menuImpl.getAllMenusByRestaurant(restaurantId);
		
		req.setAttribute("allMenuRest", allMenuRest);
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
	}
	

}
