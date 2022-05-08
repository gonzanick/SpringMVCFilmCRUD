<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Films</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet" href="css.do">
</head>
<body>
	<div class="container">
		<div class="row" id="site_title">
			<h2 id="site_title">Films</h2>
			<hr>
		</div>
		
		<c:choose>
			<c:when test="${! empty films}">
				<c:forEach var="film" items="${films}">
					
					<div class=row>
						<h3 class="header">${film.title }</h3>
					</div>

					<div class="row">
						<div class="col">
							<h4 class="subHeader">Details</h4>
							<ul>
								<li>${film.id}</li>
								<li class="description">${film.description}</li>
								<li>${film.releaseYear}</li>
								<li>${film.language}</li>
								<li>${film.rentalDuration}</li>
								<li>${film.rentalRate}</li>
								<li>${film.length}</li>
								<li>${film.replaceCost}</li>
								<li>${film.rating}</li>
								<li>${film.specialFeatures}</li>

							</ul>
						</div>
						<div class="col">
							<h4 class="subHeader">Cast</h4>
							<c:choose>
								<c:when test="${! empty film.cast }">
									<ul>
										<c:forEach var="actor" items="${film.cast}">
											<li>${actor.firstName}${actor.lastName}</li>
										</c:forEach>
									</ul>
								</c:when>
							</c:choose>
						</div>
						<div class="col">
							<h4 class="subHeader">Categories</h4>
							<c:choose>
								<c:when test="${! empty film.categories }">
									<ul>
										<c:forEach var="category" items="${film.categories}">
											<li>${category}</li>
										</c:forEach>
									</ul>
			</c:when>
	</c:choose>
	</div>
	</div>
	<div class="row">
	<div class="col-6 edit_and_delete_col">
		<form action="editFilm.do">
			<input name="id" type="text" value="${film.id}" hidden="true"></input>
			<input type="submit" value="Edit Film" class="sub_button">
		</form>
		</div>
		<div class="col-6 edit_and_delete_col">
		<form action="deleteFilm.do">
			<input name="id" type="text" value="${film.id}" hidden="true"></input>
			<input type="submit" value="Delete Film" class="sub_button">
		</form>
		</div>
		<hr>
	</div>
	
	</c:forEach>
	</c:when>
	<c:otherwise>
		<p>No film found</p>
	</c:otherwise>
	</c:choose>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	</div>
</body>
</html>