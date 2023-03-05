package edu.study.lab.spring6webapp.service;

import edu.study.lab.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();

}
