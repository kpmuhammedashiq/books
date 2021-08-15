package com.project.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.books.domain.Book;
import com.project.books.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}
}
