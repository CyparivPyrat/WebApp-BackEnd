package com.library.manager.controller;

import com.library.manager.constants.AppsConstants;
import com.library.manager.dto.BookCategoryDTO;
import com.library.manager.dto.BookDTO;
import com.library.manager.dto.ResponseDTO;
import com.library.manager.exception.AppsException;
import com.library.manager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/saveBook", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<BookDTO>> saveBook(@RequestBody BookDTO saveBookDTO) {
        ResponseDTO<BookDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            BookDTO bookDTO = this.bookService.saveBook(saveBookDTO);

            response.setResult(bookDTO);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.CREATED;

        } catch (AppsException e) {
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping(value = "/getAllBooks", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<List<BookDTO>>> getAllBooks() {
        ResponseDTO<List<BookDTO>> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            List<BookDTO> allBooks = this.bookService.getAllBooks();

            response.setResult(allBooks);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.OK;

        } catch (AppsException e) {
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @PutMapping("/updateBook/{bookID}")
    public ResponseEntity<ResponseDTO<BookDTO>> updateBook(@PathVariable Integer bookID, @RequestBody BookDTO updateBookDTO) {
        ResponseDTO<BookDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            BookDTO bookDTO = this.bookService.updateBook(bookID, updateBookDTO);

            response.setResult(bookDTO);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.CREATED;

        } catch (AppsException e) {
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @DeleteMapping("/deleteBook/{bookID}")
    public ResponseEntity<ResponseDTO<Boolean>> deleteBook(@PathVariable Integer bookID) {
        ResponseDTO<Boolean> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            this.bookService.deleteBook(bookID);

            response.setResult(true);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.NO_CONTENT;
        } catch (AppsException e) {
            response.setResult(false);
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            response.setAppsErrorMessages(e.getAppsErrorMessages());

            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping(value = "/saveBookCategory", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<BookCategoryDTO>> saveBookCategory(@RequestBody BookCategoryDTO saveBookCategoryDTO) {
        ResponseDTO<BookCategoryDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            BookCategoryDTO bookCategory = this.bookService.saveBookCategory(saveBookCategoryDTO);

            response.setResult(bookCategory);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.CREATED;

        } catch (AppsException e) {
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping(value = "/getAllBookCategories", headers = "Accept=application/json")
    public ResponseEntity<ResponseDTO<List<BookCategoryDTO>>> getAllBookCategories() {
        ResponseDTO<List<BookCategoryDTO>> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            List<BookCategoryDTO> allBookCategories = this.bookService.getAllBookCategories();

            response.setResult(allBookCategories);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.OK;

        } catch (AppsException e) {
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @PutMapping("/updateBookCategory/{bookCategoryID}")
    public ResponseEntity<ResponseDTO<BookCategoryDTO>> updateBookCategory(@PathVariable Integer bookCategoryID, @RequestBody BookCategoryDTO updateBookCategoryDTO) {
        ResponseDTO<BookCategoryDTO> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            BookCategoryDTO bookCategory = this.bookService.updateBookCategory(bookCategoryID, updateBookCategoryDTO);

            response.setResult(bookCategory);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.CREATED;

        } catch (AppsException e) {
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.setAppsErrorMessages(e.getAppsErrorMessages());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @DeleteMapping("/deleteBookCategory/{bookCategoryID}")
    public ResponseEntity<ResponseDTO<Boolean>> deleteBookCategory(@PathVariable Integer bookCategoryID) {
        ResponseDTO<Boolean> response = new ResponseDTO<>();
        HttpStatus httpStatus;

        try {
            this.bookService.deleteBookCategory(bookCategoryID);

            response.setResult(true);
            response.setStatus(AppsConstants.ResponseStatus.SUCCESS);
            httpStatus = HttpStatus.NO_CONTENT;
        } catch (AppsException e) {
            response.setResult(false);
            response.setStatus(AppsConstants.ResponseStatus.FAILED);
            response.setAppsErrorMessages(e.getAppsErrorMessages());

            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(response, httpStatus);
    }
}
