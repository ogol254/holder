package m2.ili.devopsproject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneratedKeysMapper implements ResultMapper<Integer> {

    private List<Integer> parsed;


    @Override
    public List<Integer> getParsedList() throws SQLException {
        return parsed;
    }


    @Override
    public void parseResultSet(final ResultSet resultSet) throws SQLException {
        parsed = new ArrayList<>();
        while (resultSet.next()) {
            parsed.add(resultSet.getInt(1));
        }
    }
}
