package m2.ili.devopsproject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultMapper<T> {

    List<T> getParsedList() throws SQLException;

    void parseResultSet(ResultSet resultSet) throws SQLException;
}
