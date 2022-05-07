<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Film</title>
</head>
<body>

	<h2>Add a Film</h2>
	<form action="addFilm.do" method="GET">
		<p>
			<label for="title">Title</label> <input type="text" name="title">
		</p>

		<p>
			<label for="description">Description</label> <input type="text"
				name="description">
		</p>

		<p>
			<label for="releaseYear">Release Year</label> <input type="text"
				name="releaseYear">
		</p>

		<p>
			<label for="rentalDuration">Rental Duration</label> <input
				type="text" name="rentalDuration">
		</p>

		<p>
			<label for="rentalRate">Rental Rate</label> <input type="text"
				name="rentalRate">
		</p>

		<p>
			<label for="length">Length</label> <input type="text" name="length">
		</p>

		<p>
			<label for="replaceCost">Replace Cost</label> <input type="text"
				name="replaceCost">
		</p>

		<p>
			<label for="rating">Rating</label> <input type="text" name="rating">
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
		<br>

	<!-- 	<h2>Categories</h2>
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
		</p> -->

		<input type="submit" value="Submit">




	</form>

</body>
</html>