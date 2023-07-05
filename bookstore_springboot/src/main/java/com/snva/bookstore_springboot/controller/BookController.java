package com.snva.bookstore_springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snva.bookstore_springboot.entity.Book;
import com.snva.bookstore_springboot.service.BookService;

@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value="id")Long bookId) throws Exception {
        return bookService.getBookById(bookId);
    }

    @PostMapping("/books")
    public Book createBook(@Validated @RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/books/{id}")
	public ResponseEntity<Book> updateEmployee(@PathVariable(value="id")Long bookId,
			@Validated @RequestBody Book bookDetails) throws Exception
	{
		return bookService.updateBook(bookId, bookDetails);
	}
	
	@DeleteMapping("/books/{id}")
	public Map<String,Boolean> deleteEmployee(@PathVariable(value="id") Long bookId)
	throws Exception
	{
		return bookService.deleteBook(bookId);
	}

}
