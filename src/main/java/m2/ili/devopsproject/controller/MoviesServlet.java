package m2.ili.devopsproject.controller;

import m2.ili.devopsproject.daos.impl.DataSourceProvider;
import m2.ili.devopsproject.daos.impl.MovieDaoImpl;
import m2.ili.devopsproject.entities.Movie;
import m2.ili.devopsproject.service.MovieService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/")
public class MoviesServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(MoviesServlet.class.getName());

    private MovieService movieService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        LOGGER.fine("Initialisation de la MovieServlet");
        super.init(config);
        movieService = new MovieService(new MovieDaoImpl());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("Affichage de la liste des Movies");
        List<Movie> movies = movieService.findAll();
        request.setAttribute("movies",movies);
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }
}

