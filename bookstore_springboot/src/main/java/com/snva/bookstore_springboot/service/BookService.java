package com.snva.bookstore_springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.snva.bookstore_springboot.entity.Book;

public interface BookService {

    List<Book> getAllBooks();

    Book createBook(@Validated @RequestBody Book book);

    ResponseEntity<Book> getBookById(@PathVariable(value="id") Long bookId) throws Exception;

    ResponseEntity<Book> updateBook(@PathVariable(value="id")Long bookId, @Validated @RequestBody Book bookDetails) throws Exception;

    Map<String,Boolean> deleteBook(@PathVariable(value="id")Long bookId) throws Exception;

}