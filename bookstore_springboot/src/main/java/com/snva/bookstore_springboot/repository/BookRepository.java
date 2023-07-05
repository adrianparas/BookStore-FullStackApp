package com.snva.bookstore_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snva.bookstore_springboot.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
