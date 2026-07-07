<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Cart,com.tap.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EatnEat Checkout</title>
<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',Arial,sans-serif;
}

body{
    background:#f5f5f7;
}

/* Navbar */

.nav{
    background:#111;
    color:#fff;
    padding:18px 60px;
    font-size:32px;
    font-weight:bold;
    letter-spacing:1px;
    box-shadow:0 3px 10px rgba(0,0,0,.2);
}

/* Progress */

.progress{
    width:92%;
    margin:25px auto;
    background:#fff;
    border-radius:12px;
    padding:18px;
    display:flex;
    justify-content:center;
    gap:40px;
    font-size:18px;
    font-weight:bold;
    box-shadow:0 3px 10px rgba(0,0,0,.08);
}

/* Main Layout */

.wrapper{
    width:92%;
    margin:20px auto;
    display:grid;
    grid-template-columns:2fr 1fr;
    gap:25px;
    align-items:start;
}

.card{
    background:#fff;
    border-radius:15px;
    padding:28px;
    box-shadow:0 8px 20px rgba(0,0,0,.08);
}

h2{
    color:#e23744;
    margin-bottom:20px;
}

/* Form */

label{
    display:block;
    margin:15px 0 8px;
    font-weight:600;
}

input,
textarea{
    width:100%;
    padding:14px 16px;
    border:2px solid #eee;
    border-radius:10px;
    transition:.3s;
    font-size:15px;
}

textarea{
    resize:none;
    height:110px;
}

input:focus,
textarea:focus{
    border-color:#e23744;
    box-shadow:0 0 8px rgba(226,55,68,.2);
    outline:none;
}

/* Payment */

.pay{
    margin:12px 0;
    font-size:16px;
}

/* Summary */

.item-row,
.bill-row{
    display:flex;
    justify-content:space-between;
    padding:12px 0;
    border-bottom:1px solid #ececec;
}

.bill-row:last-child{
    border-bottom:none;
}

.total{
    font-size:22px;
    font-weight:bold;
    color:#111;
}

/* Coupon */

.coupon{
    display:flex;
    gap:10px;
    margin-top:15px;
}

.coupon input{
    flex:1;
}

.apply-btn{
    background:#ff9800;
    color:white;
    border:none;
    border-radius:10px;
    padding:12px 18px;
    cursor:pointer;
}

.apply-btn:hover{
    background:#f57c00;
}

/* Place Order */

.place{
    width:100%;
    margin-top:25px;
    padding:16px;
    border:none;
    border-radius:12px;
    background:#28a745;
    color:white;
    font-size:20px;
    font-weight:bold;
    cursor:pointer;
    transition:.3s;
}

.place:hover{
    background:#218838;
}

/* Secure */

.secure{
    margin-top:18px;
    text-align:center;
    color:#777;
    font-size:14px;
}

@media(max-width:900px){

.wrapper{
grid-template-columns:1fr;
}

.progress{
flex-direction:column;
gap:15px;
text-align:center;
}
}

.payment-section{
    margin-top:25px;
}

.payment-options{
    display:flex;
    flex-direction:column;
    gap:15px;
}

.payment-card{
    display:flex;
    justify-content:space-between;
    align-items:center;
    background:#fff;
    border:2px solid #ddd;
    border-radius:12px;
    padding:18px 22px;
    cursor:pointer;
    transition:.3s;
}

.payment-card:hover{
    border-color:#e23744;
    box-shadow:0 6px 15px rgba(0,0,0,.1);
}

.payment-left{
    display:flex;
    align-items:center;
    gap:18px;
}

.payment-icon{
    font-size:32px;
}

.payment-title{
    font-size:18px;
    font-weight:bold;
}

.payment-sub{
    font-size:14px;
    color:#666;
    margin-top:5px;
}

.payment-check{
    width:22px;
    height:22px;
    cursor:pointer;
}

.confirm-payment{
    margin-top:25px;
    width:100%;
    padding:16px;
    border:none;
    border-radius:10px;
    background:#111;
    color:white;
    font-size:18px;
    font-weight:bold;
    cursor:pointer;
    transition:.3s;
}

.confirm-payment:hover{
    background:#e23744;
}

</style>
</head>
<body>
<div class="nav">EatnEat Checkout</div>
<%
Cart cart=(Cart)session.getAttribute("cart");
double subtotal=0;
if(cart!=null){
    for(CartItem item:cart.getItems().values()) subtotal+=item.getTotalPrice();
}
double delivery=40;
double gst=subtotal*0.05;
double discount=subtotal>500?50:0;
double grand=subtotal+delivery+gst-discount;
%>
<form action="OrderServlet" method="post">
<div class="wrapper">
<div class="card">
<h2>📍 Delivery Details</h2>

<label>Full Name</label>
<input name="name" required>

<label>Phone Number</label>
<input name="phone" required>

<label>Email</label>
<input type="email" name="email">

<label>Address</label>
<textarea name="address" required></textarea>

<label>Landmark</label>
<input name="landmark">

<label>City</label>
<input name="city">

<label>Pincode</label>
<input name="pincode">
<div class="payment-section">

<h2>💳 Choose Payment Method</h2>

<div class="payment-options">

<label class="payment-card">

<div class="payment-left">

<div class="payment-icon">💵</div>

<div>
<div class="payment-title">Cash on Delivery</div>
<div class="payment-sub">Pay after your order arrives</div>
</div>

</div>

<input type="checkbox"
       class="payment-check"
       name="payment"
       value="COD"
       onclick="selectOnly(this)">

</label>



<label class="payment-card">

<div class="payment-left">

<div class="payment-icon">📱</div>

<div>
<div class="payment-title">UPI</div>
<div class="payment-sub">Google Pay • PhonePe • Paytm</div>
</div>

</div>

<input type="checkbox"
       class="payment-check"
       name="payment"
       value="UPI"
       onclick="selectOnly(this)">

</label>



<label class="payment-card">

<div class="payment-left">

<div class="payment-icon">💳</div>

<div>
<div class="payment-title">Credit / Debit Card</div>
<div class="payment-sub">Visa • MasterCard • RuPay</div>
</div>

</div>

<input type="checkbox"
       class="payment-check"
       name="payment"
       value="CARD"
       onclick="selectOnly(this)">

</label>



<label class="payment-card">

<div class="payment-left">

<div class="payment-icon">🏦</div>

<div>
<div class="payment-title">Net Banking</div>
<div class="payment-sub">All Major Banks</div>
</div>

</div>

<input type="checkbox"
       class="payment-check"
       name="payment"
       value="NETBANKING"
       onclick="selectOnly(this)">

</label>

</div>

<button class="confirm-payment">
	Confirm
</button>

</div>

<h2 style="margin-top:30px;">Delivery Instructions</h2>
<textarea name="instructions" placeholder="Ring the bell once, leave at door, etc."></textarea>

</div>


<div class="card">
<h2>🛒 Order Summary</h2>

<hr style="margin:15px 0;border:1px solid #eee;">


<%
	for(CartItem item : cart.getItems().values()) {
		
	%>

<div class="item-row">
    <span><%= item.getName() %></span>
    <span>x<%= item.getQuantity() %></span>
    <span><%= item.getTotalPrice() %></span>
</div>
<%
	}
	%>


<div class="bill-row"><span>Subtotal</span><span>₹ <%=String.format("%.2f",subtotal)%></span></div>
<div class="bill-row"><span>Delivery Fee</span><span>₹ <%=delivery%></span></div>
<div class="bill-row"><span>GST</span><span>₹ <%=String.format("%.2f",gst)%></span></div>
<div class="bill-row"><span>Discount</span><span>-₹ <%=discount%></span></div>

<h2>🏷 Coupon</h2>
<div class="coupon">
<input name="coupon" placeholder="Enter Coupon Code">
<button type="button" class="apply-btn">
Apply
</button>

</div>

<div class="bill-row" style="font-weight:bold;font-size:20px;">
<span>Grand Total</span>
<span>₹ <%=String.format("%.2f",grand)%></span>
</div>

<input type="hidden" name="grandTotal" value="<%=grand%>">

<br>

<button class="place" type="submit">

🛍 Place Order • ₹ <%=String.format("%.2f",grand)%>

</button>

<div class="secure">

🔒 Safe & Secure Payments

</div>

</div>
</div>
</form>

</body>
</html>
