<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Films</title>
</head>
<body>
	<h2>The following films have this keyword:</h2>
	<c:choose>
	<c:when test="${! empty films}"> 
	<c:forEach var="film" items="${films}">
			<ul>
			    <li>${film.id}</li> 
				<li>${film.title}</li>
				<li>${film.description}</li>
				<li>${film.releaseYear}</li>
				<li>${film.language}</li>
				<li>${film.rentalDuration}</li>
				<li>${film.rentalRate}</li>
				<li>${film.length}</li>
				<li>${film.replaceCost}</li>
				<li>${film.rating}</li>
				<li>${film.specialFeatures}</li>

			</ul>
			<h3>Actors</h3>
			<c:choose>
				<c:when test="${! empty film.cast }">
					<ul>
						<c:forEach var="actor" items="${film.cast}">
							<li>${actor.firstName} ${actor.lastName}</li>
						</c:forEach>
					</ul>
				</c:when>
			</c:choose>
			<h3>Categories:</h3>
			<c:choose>
				<c:when test="${! empty film.categories }">
					<ul>
						<c:forEach var="category" items="${film.categories}">
							<li>${category}</li>
						</c:forEach>
					</ul>
				</c:when>
			</c:choose>
			<form action="deleteFilm.do">
			<input name="id" type="text" value="${film.id}" hidden="true"></input>
			<input type="submit" value="Delete Film">
			</form>
			
			<form action="editFilm.do">
			<input name="id" type="text" value="${film.id}" hidden="true"></input>
			<input type="submit" value="Edit Film">
			</form>
</c:forEach>
	</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
</c:choose>

</body>
</html>