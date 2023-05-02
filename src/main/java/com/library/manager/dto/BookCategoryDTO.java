package com.library.manager.dto;

import com.library.manager.model.BookCategory;
import com.library.manager.util.CalendarUtil;

public class BookCategoryDTO {

    private Integer bookCategoryID;

    private String subCategory;

    private String description;

    private String createdDateStr;

    public BookCategoryDTO() {
    }

    public BookCategoryDTO(BookCategory category) {
        this.bookCategoryID = category.getBookCategoryID();
        this.subCategory = category.getSubCategory();
        this.description = category.getDescription();

        this.createdDateStr = CalendarUtil.getDefaultFormattedDateTimeMaskNull(category.getCreatedDate());
        this.modifiedDateStr = CalendarUtil.getDefaultFormattedDateTimeMaskNull(category.getModifiedDate());
    }

    private String modifiedDateStr;

    public Integer getBookCategoryID() {
        return bookCategoryID;
    }

    public void setBookCategoryID(Integer bookCategoryID) {
        this.bookCategoryID = bookCategoryID;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
