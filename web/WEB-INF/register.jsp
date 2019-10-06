<%-- 
    Document   : login
    Created on : Oct 4, 2019, 3:16:33 PM
    Author     : 794471
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            Username: <input type="text" name="name">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register Name">
        </form>
    </body>
</html>
