package edu.study.lab.spring6webapp.service;

import edu.study.lab.spring6webapp.domain.Author;
import edu.study.lab.spring6webapp.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository bookRepository) {
        this.authorRepository = bookRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
