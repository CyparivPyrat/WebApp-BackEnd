package com.library.manager.service;

import com.library.manager.dao.BookCategoryDao;
import com.library.manager.dao.BookDao;
import com.library.manager.dto.BookCategoryDTO;
import com.library.manager.dto.BookDTO;
import com.library.manager.exception.AppsException;
import com.library.manager.model.Book;
import com.library.manager.model.BookCategory;
import com.library.manager.util.CalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookCategoryDao bookCategoryDao;

    @Autowired
    private BookDao bookDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public BookDTO saveBook(BookDTO saveBookDTO) throws AppsException {
        Book book = new Book();

        BookCategory category = this.bookCategoryDao.getReferenceById(saveBookDTO.getBookCategoryID());
        book.setBookCategory(category);

        book.setTitle(saveBookDTO.getTitle());
        book.setAuthor(saveBookDTO.getAuthor());
        book.setNoOfCopies(saveBookDTO.getNoOfCopies());
        book.setLanguage(saveBookDTO.getLanguage());
        book.setPublicationDate(CalendarUtil.getDefaultParsedDateOnly(saveBookDTO.getPublicationDateStr()));
        book.setCreatedDate(new Date());

        book = this.bookDao.saveAndFlush(book);

        return new BookDTO(book);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<BookDTO> getAllBooks() throws AppsException {
        List<Book> bookList = this.bookDao.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();

        bookList.forEach(book -> {
            bookDTOList.add(new BookDTO(book));
        });

        return bookDTOList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public BookDTO updateBook(Integer bookID, BookDTO updateBookDTO) throws AppsException {
        Book book = this.bookDao.getReferenceById(bookID);

        BookCategory category = this.bookCategoryDao.getReferenceById(updateBookDTO.getBookCategoryID());
        book.setBookCategory(category);

        book.setTitle(updateBookDTO.getTitle());
        book.setAuthor(updateBookDTO.getAuthor());
        book.setNoOfCopies(updateBookDTO.getNoOfCopies());
        book.setLanguage(updateBookDTO.getLanguage());
        book.setPublicationDate(CalendarUtil.getDefaultParsedDateOnly(updateBookDTO.getPublicationDateStr()));
        book.setCreatedDate(new Date());

        book = this.bookDao.saveAndFlush(book);

        return new BookDTO(book);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBook(Integer bookID) throws AppsException {
        Book book = this.bookDao.getReferenceById(bookID);

        this.bookDao.delete(book);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public BookCategoryDTO saveBookCategory(BookCategoryDTO saveBookCategoryDTO) throws AppsException {
        BookCategory bookCategory = new BookCategory();

        bookCategory.setSubCategory(saveBookCategoryDTO.getSubCategory());
        bookCategory.setDescription(saveBookCategoryDTO.getDescription());
        bookCategory.setCreatedDate(new Date());

        bookCategory = this.bookCategoryDao.saveAndFlush(bookCategory);

        return new BookCategoryDTO(bookCategory);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<BookCategoryDTO> getAllBookCategories() throws AppsException {
        List<BookCategory> categories = this.bookCategoryDao.findAll();
        List<BookCategoryDTO> bookCategoryDTOList = new ArrayList<>();

        categories.forEach(book -> {
            bookCategoryDTOList.add(new BookCategoryDTO(book));
        });

        return bookCategoryDTOList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public BookCategoryDTO updateBookCategory(Integer bookCategoryID, BookCategoryDTO updateBookCategoryDTO) throws AppsException {
        BookCategory bookCategory = this.bookCategoryDao.getReferenceById(bookCategoryID);

        bookCategory.setSubCategory(updateBookCategoryDTO.getSubCategory());
        bookCategory.setDescription(updateBookCategoryDTO.getDescription());
        bookCategory.setModifiedDate(new Date());

        bookCategory = this.bookCategoryDao.saveAndFlush(bookCategory);

        return new BookCategoryDTO(bookCategory);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBookCategory(Integer bookCategoryID) throws AppsException {
        BookCategory category = this.bookCategoryDao.getReferenceById(bookCategoryID);
        List<Book> bookList = this.bookDao.getBookByBookCategory(category);

        if (bookList.isEmpty()) {
            this.bookCategoryDao.delete(category);
        } else {
            throw new AppsException("This category is already used");
        }
    }
}
