package com.example.gql;

import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GqlApplication {

  public static void main(String[] args) {
    SpringApplication.run(GqlApplication.class, args);
  }

  @Bean
  ApplicationRunner applicationRunner(
      AuthorRepository authorRepository, BookRepository bookRepository) {
    return args -> {
      Author josh = authorRepository.save(new Author(null, "Josh Long"));
      Author tom = authorRepository.save(new Author(null, "Tom Lad"));
      bookRepository.saveAll(
          List.of(
              new Book("Yeet 1", "Aimen", josh),
              new Book("Yeet 22", "Aimen", tom),
              new Book("Yeet 3", "Aimen", null)));
    };
  }
}
