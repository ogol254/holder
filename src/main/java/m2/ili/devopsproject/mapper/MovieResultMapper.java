package m2.ili.devopsproject.mapper;



import m2.ili.devopsproject.entities.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieResultMapper implements ResultMapper<Movie> {

    private List<Movie> parsed;


    @Override
    public List<Movie> getParsedList() throws SQLException {
        return parsed;
    }


    @Override
    public void parseResultSet(final ResultSet resultSet) throws SQLException {
        parsed = new ArrayList<>();
        while (resultSet.next()) {
            Movie movie = new Movie();
            movie.setId(resultSet.getLong("id"));
            movie.setRank(resultSet.getInt("rank"));
            movie.setRating(resultSet.getInt("rating"));
            movie.setTitle(resultSet.getString("title"));
            movie.setYear(resultSet.getString("year"));
            movie.setNbOfReviews(resultSet.getLong("reviews"));

            parsed.add(movie);
        }
    }
}
