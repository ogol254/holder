package m2.ili.devopsproject.util;



import m2.ili.devopsproject.daos.impl.DataSourceProvider;
import m2.ili.devopsproject.mapper.GeneratedKeysMapper;
import m2.ili.devopsproject.mapper.ResultMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;

public class QueryExecutor {


    public static void executeSelectQuery(String query, ResultMapper mapper, Object... parameters) throws Exception {
        final DataSource dataSource = DataSourceProvider.getDataSource();
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            mapParameters(statement, parameters);
            ResultSet resultSet = statement.executeQuery();
            mapper.parseResultSet(resultSet);
            resultSet.close();
        }
    }

    public static ResultMapper executeUpdateQuery(String query, Object... parameters) throws Exception {
        final DataSource dataSource = DataSourceProvider.getDataSource();
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            ResultMapper<Integer> generatedKeysMapper = new GeneratedKeysMapper();
            mapParameters(statement, parameters);
            statement.executeUpdate();
            final ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeysMapper.parseResultSet(generatedKeys);
            generatedKeys.close();
            return generatedKeysMapper;
        }
    }


    private static void mapParameters(final PreparedStatement statement, final Object[] parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            Object currentParameter = parameters[i];
            if (currentParameter instanceof String) {
                statement.setString(i + 1, String.valueOf(currentParameter));
            }
            if (currentParameter instanceof Integer) {
                statement.setInt(i + 1, (Integer) currentParameter);
            }
            if (currentParameter instanceof Long) {
                statement.setLong(i + 1, (Long) currentParameter);
            }
            if(currentParameter instanceof LocalDate){
                statement.setObject(i+1,currentParameter, Types.DATE);
            }
        }
    }


}
