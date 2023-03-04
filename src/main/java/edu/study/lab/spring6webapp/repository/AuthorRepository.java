package edu.study.lab.spring6webapp.repository;

import edu.study.lab.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
