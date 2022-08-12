package ru.zoran.library.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.zoran.library.dao.BookDAO;
import ru.zoran.library.models.Book;

@Component
public class BookValidator implements Validator {

    private final BookDAO bookDAO;

    @Autowired
    public BookValidator(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        if (bookDAO.show(book.getTitle()).isPresent()){
            errors.rejectValue("title", "This title aready exist");
        }
    }
}
