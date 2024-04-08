package com.example.gql;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {
  @Id
  @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
  private Long id;

  private String title;

  private String publisher;

  @ManyToOne(fetch = FetchType.LAZY)
  private Author author;

  public Book(String title, String publisher, Author author) {
    this.title = title;
    this.publisher = publisher;
    this.author = author;
  }

  public Book() {}

  public String getTitle() {
    return title;
  }

  public Long getId() {
    return id;
  }

  public String getPublisher() {
    return publisher;
  }

  public Author getAuthor() {
    return author;
  }
}
