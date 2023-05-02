package com.library.manager.dao;

import com.library.manager.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryDao extends JpaRepository<BookCategory, Integer> {
}
