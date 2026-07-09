<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ 
    page import = " java.util.List, com.tap.model.Menu"
     %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EatnEat - Restaurant Menu</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:#f4f4f4;
}

/* Navbar */

.navbar{
    background:#111;          /* Black */
    color:#fff;
    padding:15px 60px;
    display:flex;
    justify-content:space-between;
    align-items:center;
    box-shadow:0 2px 10px rgba(0,0,0,.3);
}

.logo{
    font-size:32px;
    font-weight:bold;
    color:#fff;
}
.nav-links a{
    color:#fff;
    text-decoration:none;
    margin-left:25px;
    font-size:17px;
    font-weight:500;
    transition:.3s;
}

.nav-links a:hover{
    color:#ffb400;   /* Golden hover */
}

/* Restaurant Banner */

.banner{
    height:280px;
    background:url("https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?auto=format&fit=crop&w=1500&q=80");
    background-size:cover;
    background-position:center;
    display:flex;
    justify-content:center;
    align-items:center;
}

.banner-content{
    background:rgba(0,0,0,.6);
    padding:20px 40px;
    border-radius:10px;
    color:white;
    text-align:center;
}

.banner-content h1{
    font-size:42px;
}

.banner-content p{
    margin-top:10px;
    font-size:18px;
}

/* Menu Title */

.title{
    text-align:center;
    margin:40px 0;
    color:#333;
    font-size:35px;
}

/* Menu Grid */

.menu-container{
    width:90%;
    margin:auto;
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(300px,1fr));
    gap:30px;
    padding-bottom:50px;
}

/* Food Card */

.card{
    background:white;
    border-radius:15px;
    overflow:hidden;
    box-shadow:0 5px 15px rgba(0,0,0,.2);
    transition:.3s;
}

.card:hover{
    transform:translateY(-8px);
}

.card img{
    width:100%;
    height:220px;
    object-fit:cover;
}

.details{
    padding:20px;
}

.details h2{
    color:#333;
    margin-bottom:10px;
}

.details p{
    color:#666;
    margin-bottom:15px;
    line-height:1.5;
}

.price{
    color:#e23744;
    font-size:24px;
    font-weight:bold;
    margin-bottom:15px;
}

button{
    width:100%;
    padding:12px;
    background:#e23744;
    color:white;
    border:none;
    border-radius:8px;
    cursor:pointer;
    font-size:17px;
}

button:hover{
    background:#c6202e;
}

/* Footer */

footer{
    background:#222;
    color:white;
    text-align:center;
    padding:20px;
}

</style>

</head>

<body>

<div class="navbar">

<div class="logo">EatnEat</div>

<div class="nav-links">

<a href="cart.jsp">Cart</a>
<a href="login.html">Logout</a>
</div>

</div>

<div class="banner">

<div class="banner-content">

<h1>Restaurant</h1>

<p>South Indian • Chinese • North Indian</p>

</div>

</div>

<h2 class="title">Today's Menu</h2>

<div class="menu-container">

	<%
	List<Menu> allMenuRest = (List<Menu>) request.getAttribute("allMenuRest");
	
	for(Menu m : allMenuRest){
		
		String image = "";
		
		switch(m.getItem_name()){
		
		case "Filter Coffee":
		    image = "menu-images/coffee.png";
		    break;
		    
		case "Idli" :
			image = "menu-images/idly.png";
			break;
			
		case "Poori Masala" :
			image = "menu-images/poori.png";
			break;
			
		case "South Indian Meals" :
			image = "menu-images/southindian.png";
			break;
			
		case "Masala Dosa" :
			image = "menu-images/masaladosa.png";
			break;
			
		default:
		    image = "menu-images/default-image.png";
		}
		%>
		
<div class="card">


<img src="<%= image %>" alt="<%= m.getItem_name() %>">

<div class="details">

<h2><%=m.getItem_name() %></h2>
 
<p><%= m.getDescription() %>.</p>

<div class="price"><%=m.getPrice() %></div>


<form action = "cartServlet">
	<input type = "hidden" name = "menuId" value = <%= m.getMenu_id() %>>
	<input type = "hidden" name = "restaurantId" value = <%= m.getRestaurant_id() %>>
	<input type = "hidden" name = "quantity" value = "1">
	<input type = "hidden" name = "action" value = "add">

	<button>Add to Cart</button>
	</form>

</div>
</div>
	<% 	
	}
		%>
</div>

<footer>

<h3>© 2026 EatnEat | Enjoy Every Bite</h3>

</footer>

</body>
</html>
</body>
</html>
