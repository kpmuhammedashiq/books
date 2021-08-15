package com.project.books.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.books.domain.Book;
import com.project.books.repository.BookRepository;
import com.project.books.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BookResource {
    private final Logger log = LoggerFactory.getLogger(BookResource.class);

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookService bookService;
    
    /**
     *  GET  /book : get all the books.
     *
     * @return List<Book>
     */
    @GetMapping("books")
    public List<Book> getAllBooks() {
        log.debug("REST request to get all Books");
        return bookService.findAll();
    }

    /**
     *  get the "id" Book.
     *
     * @param id the id of the Book to retrieve.
     * @return ResponseEntity<Book>
     */
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        log.debug("REST request to get Book : {}", id);
        Optional<Book> Book = bookService.findById(id);
        return ResponseEntity.ok()
                .body(Book.get());
    }


    /********************************** admin api end points **********************************/
    /**
     *  Create a new book.
     *
     * @param book - book to be created.
     * @return ResponseEntity<Book>
     */
    @PostMapping("admin/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        log.debug("REST request to save book : {}"+ book);
        Book result = bookService.save(book);
        return ResponseEntity.ok().body(result);
    }

    /**
     *  Update an existing book.
     *
     * @param book - book to be updated.
     * @return ResponseEntity<Book>
     */
    @PutMapping("admin/books")
    public ResponseEntity<Book> updateBook( @RequestBody Book book) {
        log.debug("REST request to update book : {}", book);
        Book result = bookService.save(book);
        return ResponseEntity.ok()
                .body(result);
    }

    
    /**
     *  delete book.
     *
     * @param id - id of the Book to delete.
     * @return ResponseEntity<String>.
     */
    @DeleteMapping("admin/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        log.debug("REST request to delete Book : {}", id);
        bookService.deleteById(id);
        return ResponseEntity.ok()
                .body("Book deleted!!");
    }




}
