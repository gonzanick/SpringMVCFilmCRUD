<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Film</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet" href="css.do">
</head>
<body>
	<div class="container">

		<div class="row">
			<h2 id="site_title">Add a Film</h2>
		</div>

		<div class="row">
			<form action="addFilm.do" method="GET">
				<p>
					<label for="title">Title</label> <input type="text" name="title" id="title_input">
				</p>

				<p>
					<label for="description">Description</label> <input type="text"
						name="description" id="description_input">
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
					<label for="commentaries">Commentaries</label> <input
						type="checkbox" id="specialFeatures" name="specialFeatures"
						value="Deleted Scenes"> <label for="deletedScenes">Deleted
						Scenes</label> <input type="checkbox" id="specialFeatures"
						name="specialFeatures" value="Behind the Scenes"> <label
						for="behindTheScenes">Behind The Scenes</label>
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

				<input type="submit" value="Submit" class="sub_button">




			</form>
		</div>
	</div>

</body>
</html>