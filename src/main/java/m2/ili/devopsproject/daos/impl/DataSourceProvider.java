package m2.ili.devopsproject.daos.impl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.logging.Logger;

public class DataSourceProvider {

    private static final Logger LOGGER = Logger.getLogger(DataSourceProvider.class.getName());

    private static final String RESOURCE_NAME = "jdbc/devopsdblocal";




    private static DataSource dataSource;

    public static DataSource getDataSource() throws IOException {


        if (dataSource == null) {
            createDataSource();
        }
        return dataSource;
    }


    private static void createDataSource() throws IOException {
        try {
            LOGGER.info("Recuperation de la datasource du serveur d'application.");
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup(RESOURCE_NAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }


    }
}
