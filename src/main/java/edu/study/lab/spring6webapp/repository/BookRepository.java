package edu.study.lab.spring6webapp.repository;

import edu.study.lab.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
