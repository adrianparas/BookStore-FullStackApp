package com.snva.bookstore_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snva.bookstore_springboot.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
