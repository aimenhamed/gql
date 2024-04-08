package com.example.gql;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Author {
  @Id
  @SequenceGenerator(name = "author_sequence", sequenceName = "author_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
  private Long id;

  private String name;

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
  private List<Book> books = new ArrayList<>();

  public Author(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Author() {}

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public List<Book> getBooks() {
    return books;
  }
}
