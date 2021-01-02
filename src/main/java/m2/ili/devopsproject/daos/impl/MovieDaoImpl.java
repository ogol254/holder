package m2.ili.devopsproject.daos.impl;


import m2.ili.devopsproject.daos.MovieDao;
import m2.ili.devopsproject.entities.Movie;
import m2.ili.devopsproject.mapper.MovieResultMapper;
import m2.ili.devopsproject.mapper.ResultMapper;
import m2.ili.devopsproject.service.MovieService;
import m2.ili.devopsproject.util.QueryExecutor;

import javax.management.Query;
import java.util.List;
import java.util.logging.Logger;

public class MovieDaoImpl implements MovieDao {

    private static final Logger LOGGER = Logger.getLogger(MovieDaoImpl.class.getName());

    @Override
    public List<Movie> listMovies() throws Exception {

        LOGGER.fine("Requete qui recupere tous les Movies de la BDD");
        final ResultMapper mapper = new MovieResultMapper();
        QueryExecutor.executeSelectQuery("SELECT * FROM movie", mapper);
        return mapper.getParsedList();
    }


    @Override
    public Movie addMovie(final Movie movie) throws Exception {
        LOGGER.fine("Requete qui ajoute un Movie en BDD");
        final ResultMapper<Integer> resultMapper = QueryExecutor.executeUpdateQuery("INSERT INTO movie(rank,rating,title,year,reviews) VALUES(?,?,?,?,?)",
                movie.getRank(),
                movie.getRating(),
                movie.getTitle(),
                movie.getYear(),
                movie.getNbOfReviews()
        );
        movie.setId(resultMapper.getParsedList().get(0));
        return movie;
    }

    @Override
    public void recreateTable() throws Exception {
        LOGGER.fine("Requete qui reinitialise la table 'movie'");
        QueryExecutor.executeUpdateQuery("DROP TABLE IF EXISTS movie");
        QueryExecutor.executeUpdateQuery("CREATE TABLE movie (" +
                "id INT NOT NULL AUTO_INCREMENT," +
                "rank INT NOT NULL," +
                "rating INT NOT NULL," +
                "title VARCHAR(100) NOT NULL," +
                "year VARCHAR(5) NOT NULL," +
                "reviews INT NOT NULL," +
                "PRIMARY KEY (id) );");

    }
}
