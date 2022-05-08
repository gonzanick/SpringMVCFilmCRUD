<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Home</title>
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
		<h2>Welcome to the Film Site</h2>
		<hr>
	</div>

	<div class="row">
		<div class="col">
			<h3>Search For A Film by ID</h3>
			<form action="getFilmData.do" method="GET">
				<input type="text" name="id" placeholder="e.g. 42"/> <input type="submit"
				
					value="Get Film Data" class="sub_button"/>
			</form>
		</div>

		<div class="col">
			<h3>Search For A Film by Keyword</h3>
			<form action="getFilmByKeyword.do" method="GET">
				<input type="text" name="keyword" placeholder="e.g. alien"/> <input type="submit"
					value="Get Film Data" class="sub_button"/>
			</form>
		</div>

		<div class="col">
			<h3>Add A New Film</h3>
			<form action="newFilm.do" method="GET">
				<input type="submit" value="Create New Film" class="sub_button" />
			</form>
		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</div>
</body>
</html>