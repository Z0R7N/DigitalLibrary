package ru.zoran.library.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.zoran.library.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper  implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("year"));
        return person;
    }
}
