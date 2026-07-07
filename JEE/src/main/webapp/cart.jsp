<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Cart,com.tap.model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EatnEat | Cart</title>

<style>
*{margin:0;padding:0;box-sizing:border-box;font-family:Arial,sans-serif;}
body{background:#f5f5f5;}
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
.container{width:90%;margin:30px auto;display:flex;gap:30px;align-items:flex-start;}
.cart-items{flex:3;}
.cart-card{display:flex;background:#fff;border-radius:12px;overflow:hidden;box-shadow:0 5px 12px rgba(0,0,0,.15);margin-bottom:20px;}
.cart-card img{width:180px;height:180px;object-fit:cover;}
.details{padding:20px;flex:1;}
.price{font-size:22px;color:#e23744;font-weight:bold;margin:10px 0;}
.quantity{display:flex;align-items:center;gap:10px;margin:15px 0;}
.quantity form{display:inline;}
.qty-btn{width:35px;height:35px;border:none;border-radius:50%;background:#e23744;color:#fff;font-size:20px;cursor:pointer;}
.qty-btn:hover{background:#c6202e;}
.qty-value{font-size:20px;font-weight:bold;width:30px;text-align:center;}
.remove-btn{padding:10px 18px;border:none;background:#dc3545;color:#fff;border-radius:6px;cursor:pointer;}

.checkout{width:100%;padding:12px;background:#28a745;color:#fff;border:none;border-radius:8px;font-size:18px;cursor:pointer;}
.empty{text-align:center;font-size:24px;padding:80px;}

.summary p{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin:14px 0;
    font-size:18px;
}

.total{
    font-size:24px;
    font-weight:bold;
    color:#222;
}

hr{
    margin:18px 0;
}

.free{
    color:#28a745;
    font-weight:bold;
}

.add-more{
    width:100%;
    padding:14px;
    background:#ff9800;
    color:white;
    border:none;
    border-radius:8px;
    font-size:18px;
    cursor:pointer;
    transition:.3s;
    margin-bottom:15px;
}

.add-more:hover{

    background:#f57c00;

}
</style>
</head>
<body>

<div class="navbar">
<div class="logo">EatnEat</div>
<div class="nav-links">


</div>
</div>

<%
Cart cart=(Cart)session.getAttribute("cart");
Integer restaurantId=(Integer)session.getAttribute("restaurantId");

if(cart!=null && !cart.getItems().isEmpty()){

double grandTotal=0;
%>

<div class="container">

<div class="cart-items">

<%
for(CartItem item:cart.getItems().values()){
grandTotal+=item.getTotalPrice();
%>

<div class="cart-card">

<img src="https://images.unsplash.com/photo-1568901346375-23c9450c58cd?auto=format&fit=crop&w=900&q=80">

<div class="details">

<h2><%=item.getName()%></h2>

<div class="price">₹ <%=item.getPrice()%></div>

<div class="quantity">

<span>Qty :</span>

<form action="cartServlet" method="post">
<input type="hidden" name="menuId" value="<%=item.getMenuId()%>">
<input type="hidden" name="restaurantId" value="<%=restaurantId%>">

<%
if(item.getQuantity()-1<=0){
%>
<input type="hidden" name="action" value="delete">
<%
}else{
%>
<input type="hidden" name="action" value="update">
<input type="hidden" name="quantity" value="<%=item.getQuantity()-1%>">
<%
}
%>

<button class="qty-btn" type="submit">-</button>
</form>

<span class="qty-value"><%=item.getQuantity()%></span>

<form action="cartServlet" method="post">
<input type="hidden" name="menuId" value="<%=item.getMenuId()%>">
<input type="hidden" name="restaurantId" value="<%=restaurantId%>">
<input type="hidden" name="action" value="update">
<input type="hidden" name="quantity" value="<%=item.getQuantity()+1%>">

<button class="qty-btn" type="submit">+</button>
</form>

</div>

<form action="cartServlet" method="post">
<input type="hidden" name="menuId" value="<%=item.getMenuId()%>">
<input type="hidden" name="restaurantId" value="<%=restaurantId%>">
<input type="hidden" name="action" value="delete">

<button class="remove-btn" type="submit">Remove</button>
</form>

</div>

</div>

<%
}
%>
<%
double deliveryCharge = 40.0;
double convenienceFee = 15.0;

if(grandTotal >= 500){
    deliveryCharge = 0.0;    // Free delivery above ₹500
}

double finalAmount = grandTotal + deliveryCharge + convenienceFee;
%>
</div>

<div class="summary">

<h2>Order Summary</h2>

<p>
    <span>Items</span>
    <span><%= cart.getItems().size() %></span>
</p>

<p>
    <span>Items Total</span>
    <span>₹ <%= grandTotal %></span>
</p>

<p>
    <span>Delivery Charge</span>
    <span>
        <% if(deliveryCharge == 0){ %>
            <span style="color:green;">FREE</span>
        <% } else { %>
            ₹ <%= deliveryCharge %>
        <% } %>
    </span>
</p>

<p>
    <span>Convenience Fee</span>
    <span>₹ <%= convenienceFee %></span>
</p>

<hr>

<p class="total">
    <span>Grand Total</span>
    <span>₹ <%= finalAmount %></span>
</p>

<br>

<button class="add-more"
onclick="location.href='menu?restaurantID=<%=restaurantId%>'">
🍔 Add More Items
</button>

<br><br>

<button class="checkout"
onclick="location.href='checkout.jsp'">
Proceed to Checkout
</button>

</div>

</div>

<%
}else{
%>

<div class="empty">
<h2>Your Cart is Empty 🛒</h2>
<br>
<a href="restaurant.jsp">Continue Shopping</a>
</div>

<%
}
%>

</body>
</html>
