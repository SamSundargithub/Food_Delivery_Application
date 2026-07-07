package com.tap;

import java.io.IOException;

import com.tap.DAO.MenuDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		Integer restaurantId = (Integer)session.getAttribute("restaurantId");
		
		int newRestaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		
		
		if(cart == null || restaurantId != newRestaurantId) {
			cart = new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("restaurantId", newRestaurantId);
		}
		
		String action = req.getParameter("action");
		 
		if(action.equals("add")) {
			addItemtoCart(req,cart);
		}
		else if(action.equals("update")) {
			updateItemtoCart(req,cart);
		}
		else if(action.equals("delete")) {
			deleteItemFromCart(req,cart);
		}
		
		resp.sendRedirect("cart.jsp");
	}

	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {
		int menuId = Integer.parseInt(req.getParameter("menuId"));
	
		cart.removeItem(menuId);
	}

	private void updateItemtoCart(HttpServletRequest req, Cart cart) {
		// TODO Auto-generated method stub
	int menuId = Integer.parseInt(req.getParameter("menuId"));
	int quantity = Integer.parseInt(req.getParameter("quantity"));
	
	cart.updateItem(menuId, quantity);
	}

	private void addItemtoCart(HttpServletRequest req, Cart cart) {

	    int menuId = Integer.parseInt(req.getParameter("menuId"));
	    int quantity = Integer.parseInt(req.getParameter("quantity"));

	    System.out.println("Received menuId = " + menuId);

	    MenuDAOImpl menImp = new MenuDAOImpl();
	    Menu menu = menImp.getMenu(menuId);

	    System.out.println("Menu object = " + menu);

	    if(menu != null) {

	        HttpSession session = req.getSession();
	        session.setAttribute("restaurantId", menu.getRestaurant_id());

	        CartItem citem = new CartItem(
	                menu.getMenu_id(),
	                menu.getRestaurant_id(),
	                menu.getItem_name(),
	                menu.getPrice(),
	                quantity
	        );

	        cart.addItem(citem);

	        System.out.println("Cart size = " + cart.getItems().size());
	        System.out.println(cart.getItems());

	    } else {

	        System.out.println("Menu is NULL!");

	    }
	}
		
		
	}

