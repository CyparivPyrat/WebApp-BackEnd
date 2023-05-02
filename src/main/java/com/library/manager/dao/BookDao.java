package com.library.manager.dao;

import com.library.manager.model.Book;
import com.library.manager.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

    List<Book> getBookByBookCategory(BookCategory bookCategory);
}
