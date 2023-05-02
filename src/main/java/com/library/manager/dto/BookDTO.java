package com.library.manager.dto;

import com.library.manager.model.Book;
import com.library.manager.util.CalendarUtil;

public class BookDTO {

    private Integer bookID;

    private Integer bookCategoryID;

    private String subCategory;

    private String title;

    private String author;

    private Integer noOfCopies;

    private String language;

    private String publicationDateStr;

    private String createdDateStr;

    private String modifiedDateStr;

    public BookDTO() {
    }

    public BookDTO(Book book) {
        this.bookID = book.getBookID();
        this.bookCategoryID = book.getBookCategory().getBookCategoryID();
        this.subCategory = book.getBookCategory().getSubCategory();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.noOfCopies = book.getNoOfCopies();
        this.language = book.getLanguage();

        this.publicationDateStr = CalendarUtil.getDefaultFormattedDate(book.getPublicationDate());
        this.createdDateStr = CalendarUtil.getDefaultFormattedDateTimeMaskNull(book.getCreatedDate());
        this.modifiedDateStr = CalendarUtil.getDefaultFormattedDateTimeMaskNull(book.getModifiedDate());
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getBookCategoryID() {
        return bookCategoryID;
    }

    public void setBookCategoryID(Integer bookCategoryID) {
        this.bookCategoryID = bookCategoryID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(Integer noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublicationDateStr() {
        return publicationDateStr;
    }

    public void setPublicationDateStr(String publicationDateStr) {
        this.publicationDateStr = publicationDateStr;
    }

    public String getCreatedDateStr() {
        return createdDateStr;
    }

    public void setCreatedDateStr(String createdDateStr) {
        this.createdDateStr = createdDateStr;
    }

    public String getModifiedDateStr() {
        return modifiedDateStr;
    }

    public void setModifiedDateStr(String modifiedDateStr) {
        this.modifiedDateStr = modifiedDateStr;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
}
