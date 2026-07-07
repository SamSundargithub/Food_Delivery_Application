package com.tap;

import java.io.IOException;
import java.util.List;

import com.tap.DAO.RestaurantDAOImpl;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callRestaurantServlet")
public class RestaurantServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RestaurantDAOImpl restaurantImpl = new RestaurantDAOImpl();
		List<Restaurant> allRestaurants = restaurantImpl.getAllRestaurants();
		
		
		req.setAttribute("allRestaurants", allRestaurants); // passing all the restaurant info to restaurant.jsp
		RequestDispatcher rd =  req.getRequestDispatcher("restaurant.jsp");
		rd.forward(req, resp);
	}

}
