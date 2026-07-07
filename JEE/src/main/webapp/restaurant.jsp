<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.tap.model.Restaurant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EatnEat - Restaurants</title>
<style>
*{margin:0;padding:0;box-sizing:border-box;font-family:Arial,Helvetica,sans-serif}
body{background:#f6f6f6}
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
.banner{height:260px;background:url('https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?auto=format&fit=crop&w=1600&q=80') center/cover;display:flex;justify-content:center;align-items:center}
.banner h1{background:rgba(0,0,0,.55);color:#fff;padding:18px 40px;border-radius:10px;font-size:48px}
.wrapper{width:88%;max-width:1450px;margin:40px auto}
.heading{text-align:center;margin-bottom:30px}
.heading h2{font-size:44px}
.container{display:flex;flex-direction:column;gap:35px}
.card{display:flex;background:#fff;border-radius:18px;overflow:hidden;box-shadow:0 10px 25px rgba(0,0,0,.12)}
.card img{
    width:55%;
    height:420px;
    object-fit:cover;
    object-position:center;
}
.details{
    width:45%;
    padding:40px;
}
.details h2{font-size:42px;margin-bottom:15px}
.rating{display:inline-block;background:#28a745;color:#fff;padding:8px 16px;border-radius:8px;width:95px;text-align:center;font-size:20px;margin-bottom:20px}
.info{font-size:22px;margin:10px 0;color:#555}
button{margin-top:25px;padding:16px;border:none;border-radius:10px;background:#e23744;color:#fff;font-size:22px;cursor:pointer}
footer{background:#222;color:#fff;text-align:center;padding:20px;margin-top:50px}
@media(max-width:1000px){.card{flex-direction:column}.card img,.details{width:100%}}
</style>
</head>
<body>
<div class="navbar">
<div class="logo">EatnEat</div>
<div class="nav-links">
<a href="index.html">Home</a>
<a href="cart.jsp">Cart</a>
<a href="login.html">Logout</a>
</div>
</div>
<div class="banner"><h1>Explore Restaurants</h1></div>
<div class="wrapper">
<div class="heading"><h2>Our Restaurants</h2></div>
<div class="container">
<%
List<Restaurant> allRestaurants=(List<Restaurant>)request.getAttribute("allRestaurants");
if(allRestaurants!=null){
for(Restaurant restaurant:allRestaurants){
	
	String image = "";

	switch(restaurant.getRestaurant_name()){

	case "A2B":
	    image = "images/A2B.png";
	    break;

	case "SS Hyderabad Biryani":
	    image = "images/SS.png";
	    break;

	case "Dominos":
	    image = "images/Dominos.png";
	    break;

	case "KFC":
	    image = "images/KFC.png";
	    break;

	case "Pizza Hut":
	    image = "images/Pizza_Hut.png";
	    break;

	case "Burger King":
	    image = "images/Burger_King.png";
	    break;

	case "Subway":
	    image = "images/Subway.png";
	    break;

	case "McDonald's":
	    image = "images/McDonalds.png";
	    break;

	case "Barbeque Nation":
	    image = "images/Barbeque.png";
	    break;

	case "Anjappar":
	    image = "images/Anjapar.png";
	    break;

	case "Copper Kitchen":
	    image = "images/Copper_kitchen.png";
	    break;

	case "The Cascade":
	    image = "images/Cascade.png";
	    break;

	case "Salem RR Biryani":
	    image = "images/RR_Biriyani.png";
	    break;

	case "Hotel Saravana Bhavan":
	    image = "images/saravanabhavan.jpeg";
	    break;

	default:
	    image = "images/default.jpg";
	}
%>
<div class="card">

 <img src="<%= image %>" alt="<%= restaurant.getRestaurant_name() %>">
<div class="details">
<h2><%=restaurant.getRestaurant_name()%></h2>

<div class="rating">⭐ <%=restaurant.getRating()%></div>
<p class="info"><b>Cuisine :</b> <%=restaurant.getCuisine_type()%></p>
<p class="info">📍 <b>Location :</b> <%=restaurant.getLocation()%></p>
<p class="info">📞 <b>Phone :</b> <%=restaurant.getPhone()%></p>
<p class="info">🏠 <b>Address :</b> <%=restaurant.getAddress()%></p>
<button onclick="location.href='menu?restaurantID=<%=restaurant.getRestaurant_id()%>&restaurantName=<%=restaurant.getRestaurant_name()%>'">View Menu</button>
</div>
</div>
<% }} else { %>
<h2 style="text-align:center;color:#777;">No Restaurants Available</h2>
<% } %>
</div>
</div>
<footer>© 2026 EatnEat | Fresh Food Delivered Fast 🍔</footer>
</body>
</html>