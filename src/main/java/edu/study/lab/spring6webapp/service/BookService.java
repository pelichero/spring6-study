package edu.study.lab.spring6webapp.service;

import edu.study.lab.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();

}
