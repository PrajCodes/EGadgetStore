# EGadgetStore
A Servlet based web application for buying electronic products

Electronic Store- Web application 

EStore is a Java Servlet based web application using which users can browse through different gadgets and purchase them. This Application follows a model-view-controller architecture. Technologies used to build this application are 
Java Server Pages as the Front End (View)
Java Servlets (Controller)
SQLite Database File (Model)

Functionality
A common header file is included in every jsp file which provides navigation to all the pages in web application. Common footer page included. A slideshow of few products in the welcome page. (working on customizing this slideshow based on users old purchase history.)
Allows user to browse a list of products with their images and name as links to view more details about each product . Details of a product such as name, description, price are displayed and a link to add the product to cart is given.
Users can Add multiple products to a cart , Remove products and can choose quantity and update quantity.
Checkout the products by entering Credit card number and details and place an order
Review orders. Review of all previous orders can be done by entering credit card number.
This web application uses JSTL and EL throughout all jsp pages at the front end to access session objects from the servlets.
Error handling pages Stores data in DataBase file (sqlite db file) Tracks user session as soon as the user logs in. Does not let the user proceed to checkout unless logged in.
I used Prepared Statements for fetching all the data to avoid SQL Injection Attacks I have kept the java code in my jsp minimum by having all pages using JSTL and also using < c: out > to avoid cross side scripting attack. 
