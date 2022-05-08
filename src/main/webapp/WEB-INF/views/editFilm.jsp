<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Film</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="css.do">

</head>
<body>

	<h2>Edit Film</h2>
	<form action="editFilmCategories.do" method="GET">
		<input type="text" name="id" value="${film.id}" hidden="true">
		<p>
			<label for="title">Title</label> <input type="text" name="title"
				value="${film.title}" id="title_input">
		</p>

		<p>
			<label for="description">Description</label> <input type="text"
				name="description" id="description_input" value="${film.description}">
		</p>

		<p>
			<label for="releaseYear">Release Year</label> <input type="text"
				name="releaseYear" value="${film.releaseYear}">
		</p>

		<p>
			<label for="rentalDuration">Rental Duration</label> <input
				type="text" name="rentalDuration" value="${film.rentalDuration}">
		</p>

		<p>
			<label for="rentalRate">Rental Rate</label> <input type="text"
				name="rentalRate" value="${film.rentalRate}">
		</p>

		<p>
			<label for="length">Length</label> <input type="text" name="length"
				value="${film.length}">
		</p>

		<p>
			<label for="replaceCost">Replace Cost</label> <input type="text"
				name="replaceCost" value="${film.replaceCost}">
		</p>

		<p>
			<label for="rating">Rating</label> <input type="text" name="rating"
				value="${film.rating}">
		</p>

		<h2>Special Features</h2>
		<p>
			<input type="checkbox" name="specialFeatures" value="Trailers">
			<label for="trailers">Trailers</label> <input type="checkbox"
				id="specialFeatures" name="specialFeatures" value="Commentaries">
			<label for="commentaries">Commentaries</label> <input type="checkbox"
				id="specialFeatures" name="specialFeatures" value="Deleted Scenes">
			<label for="deletedScenes">Deleted Scenes</label> <input
				type="checkbox" id="specialFeatures" name="specialFeatures"
				value="Behind The Scenes"> <label for="behindTheScenes">Behind
				The Scenes</label>
		</p>
		<br> <input type="submit" value="Submit" class="sub_button">


	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>