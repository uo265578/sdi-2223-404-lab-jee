<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="com.uniovi.sdi.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Blog</title>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<c:if test="${sessionScope.user == null}">
  <c:redirect url="/login.jsp"/>
</c:if>

<jsp:useBean id="blog" class="com.uniovi.sdi.Blog"/>
<jsp:setProperty name="blog" property="*"/>

<c:if test="${blog.comentario != null}">
  <jsp:useBean id="productsService" class="com.uniovi.sdi.ProductsService"/>
  <jsp:setProperty name="productsService" property="newComment" value="${blog}"/>
  <c:redirect url="/index.jsp"/>
</c:if>

<div class="container" id="main-container">
  <h2>Agregar comentario al Blog</h2>
  <form class="form-horizontal" method="post" action="blog.jsp">
    <div class="form-group">
      <label class="control-label col-sm-2" for="name">Nombre del usuario:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="name" name="name" required="true" value="${sessionScope.user}"/>
      </div>
    </div>

    <div class="form-group">
      <label class="control-label col-sm-2" for="comentario">Comentario:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="comentario" name="comentario" required="true"/>
      </div>
    </div>

    <div class="form-group">
      <label class="control-label col-sm-2" for="fecha">Fecha:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="fecha" name="fecha" required="true"/>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Agregar</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>
