package m2.ili.devopsproject.daos;


import m2.ili.devopsproject.entities.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> listMovies() throws Exception;


    Movie addMovie(Movie movie) throws Exception;

    void recreateTable() throws Exception;
}
