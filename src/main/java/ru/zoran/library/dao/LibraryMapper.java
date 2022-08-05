package ru.zoran.library.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.zoran.library.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("year"),
                rs.getInt("person_id"));
        return book;
    }
}
