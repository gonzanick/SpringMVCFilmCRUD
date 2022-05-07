<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="addFilm.do" method="GET"> 
   <label for="title">Title</label> <input type="text" name="title">
   <label for="description">Description</label> <input type="text" name="description">
   <label for="releaseYear">Release Year</label> <input type="text" name="releaseYear">
   <label for="rentalDuration">Rental Duration</label> <input type="text" name="rentalDuration">
   <label for="rentalRate">Rental Rate</label> <input type="text" name="rentalRate">
   <label for="length">Length</label> <input type="text" name="length">
   <label for="replaceCost">Replace Cost</label> <input type="text" name="replaceCost">
   <label for="rating">Rating</label> <input type="text" name="rating">
   <label for="specialFeatures">Special Features</label> <input type="text" name="specialFeatures">
   
   <input type="submit" value="Submit">
	

</form>

</body>
</html>