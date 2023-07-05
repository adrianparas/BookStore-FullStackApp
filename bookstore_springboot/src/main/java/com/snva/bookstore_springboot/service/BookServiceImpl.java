package com.snva.bookstore_springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.snva.bookstore_springboot.entity.Book;
import com.snva.bookstore_springboot.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(@Validated @RequestBody Book book) {
        return bookRepository.save(book);
    }

    public ResponseEntity<Book> getBookById(@PathVariable(value="id") Long bookId)
        throws Exception {
            Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new Exception("Book not found for id: " + bookId));
            return ResponseEntity.ok().body(book);
    }

    public ResponseEntity<Book> updateBook(@PathVariable(value="id")Long bookId, @Validated @RequestBody Book bookDetails)
        throws Exception {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new Exception("Book not found for id: " + bookId));
        
        book.setAuthor(bookDetails.getAuthor());
        book.setPrice(bookDetails.getPrice());
        book.setTitle(bookDetails.getTitle());

        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    public Map<String,Boolean> deleteBook(@PathVariable(value="id")Long bookId) throws Exception
	{
		Book book = bookRepository.findById(bookId)
				.orElseThrow(()->new Exception("Employee Not found for this id:"+bookId));
		
		bookRepository.delete(book);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}
}
