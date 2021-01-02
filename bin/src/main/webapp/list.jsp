<%@ page import="m2.ili.devopsproject.entities.Movie, java.util.List" contentType="text/html" pageEncoding="UTF-8" %>
<%! List<Movie> movies; %>
<%movies = (List<Movie>) request.getAttribute("movies"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top 100 Movies</title>
	<style>
		body{
			font-family: Arial;
			margin:0;
			padding:0;
		}
		h1{
			background-color: black;
			color:white;
			margin:0;
			padding:10px;
			text-align: center;
		}
		p{
			text-align: center;
		}
		table{
			margin:20px auto;
			border-collapse: collapse;
			width:80%;
		}
		table td{
			padding:10px;
			border:1px solid grey;
			text-align: center;
			word-wrap: normal;
		}

		table th{
			color:grey;
		}
		table tr:nth-child(even){
			background-color: #ccc;
		}

		table tr td:nth-child(1){width:10%; font-weight: bold;	}
		table tr td:nth-child(2){width:10%;	}
		table tr td:nth-child(3){width:60%;	font-weight: bold;}
		table tr td:nth-child(4){width:10%;	}
		table tr td:nth-child(5){width:10%;	}

	</style>
</head>
<body>
	<h1>TOP 100 MOVIES OF ALL TIME</h1>
	<p><em>Source : <a href="https://www.rottentomatoes.com/top/bestofrt/" target="_blank">Rotten Tomatoes</a> </em></p>
	<table>
		<tr>
			<th>Rank</th>
			<th>Rating</th>
			<th>Name</th>
			<th>Year</th>
			<th>Reviews</th>
		</tr>
		<% for(Movie currentMovie : movies){ %>
		<tr>
			<td><%=currentMovie.getRank() %></td>
			<td><%=currentMovie.getRating() %></td>
			<td><%=currentMovie.getTitle() %></td>
			<td><%=currentMovie.getYear() %></td>
			<td><%=currentMovie.getNbOfReviews() %></td>
		</tr>
		<%} %>
	</table>

</body>
</html>
