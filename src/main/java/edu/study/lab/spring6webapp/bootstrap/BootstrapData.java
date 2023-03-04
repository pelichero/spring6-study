package edu.study.lab.spring6webapp.bootstrap;

import edu.study.lab.spring6webapp.domain.Author;
import edu.study.lab.spring6webapp.domain.Book;
import edu.study.lab.spring6webapp.repository.AuthorRepository;
import edu.study.lab.spring6webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Felipe");
        author.setLastName("Pelichero");

        Book book = new Book();
        book.setName("Domain Driven Design");
        book.setIsbn("5467687");

        Author savedFelipe = authorRepository.save(author);
        Book savedDDD = bookRepository.save(book);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setName("Java without EJB");
        noEJB.setIsbn("12313");

        Author savedRod = authorRepository.save(rod);
        Book savedNoEJB = bookRepository.save(noEJB);

        savedFelipe.getBooks().add(savedDDD);
        savedRod.getBooks().add(savedNoEJB);

        authorRepository.save(savedFelipe);
        authorRepository.save(savedRod);

        System.out.println(savedFelipe);
        System.out.println(savedRod);

        System.out.println("Books count: "+ bookRepository.count());
        System.out.println("Authors count: "+ authorRepository.count());
    }
}
