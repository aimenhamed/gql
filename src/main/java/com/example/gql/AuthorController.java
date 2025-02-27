package com.example.gql;

import java.util.Optional;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {
  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @QueryMapping
  Iterable<Author> authors() {
    return authorRepository.findAll();
  }

  @QueryMapping
  Optional<Author> authorById(@Argument Long id) {
    return authorRepository.findById(id);
  }

  @MutationMapping
  Book addBook(@Argument BookInput book) {
    Author author =
        authorRepository
            .findById(book.authorId())
            .orElseThrow(() -> new IllegalArgumentException("No author found with that id"));
    Book b = new Book(book.title(), book.publisher(), author);
    return bookRepository.save(b);
  }

  record BookInput(String title, String publisher, Long authorId) {}
}
