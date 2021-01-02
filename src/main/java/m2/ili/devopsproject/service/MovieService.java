package m2.ili.devopsproject.service;

import m2.ili.devopsproject.controller.MoviesServlet;
import m2.ili.devopsproject.daos.MovieDao;
import m2.ili.devopsproject.entities.Movie;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MovieService {

    private static final Logger LOGGER = Logger.getLogger(MovieService.class.getName());

    private MovieDao movieDao;


    public MovieService(MovieDao movieDao) {
        LOGGER.info("Initialisation du service MovieService");
        this.movieDao = movieDao;
        init();
    }

    private void init() {
        try {
            movieDao.recreateTable();
            LOGGER.info("Chargement du fichier CSV pour peupler la BDD");
            URI csvUri = Thread.currentThread().getContextClassLoader().getResource("movies-list.csv").toURI();
            List<String> lines = Files.readAllLines(Paths.get(csvUri));
            List<String[]> parsedlines = lines.stream().map(l -> l.split(";")).collect(Collectors.toList());
            for (String[] line : parsedlines) {
                if (!"Rank".equals(line[0])) {
                    movieDao.addMovie(new Movie(
                            Integer.parseInt(line[0]),
                            Integer.parseInt(line[1]),
                            line[2],
                            line[3],
                            Long.parseLong(line[4])
                    ));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Movie> findAll()  {
        try {
            LOGGER.fine("Recuperation en BDD de la liste des Movies");
            return movieDao.listMovies();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
