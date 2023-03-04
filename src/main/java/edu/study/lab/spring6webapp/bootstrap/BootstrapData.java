package edu.study.lab.spring6webapp.bootstrap;

import edu.study.lab.spring6webapp.domain.Author;
import edu.study.lab.spring6webapp.domain.Book;
import edu.study.lab.spring6webapp.domain.Publisher;
import edu.study.lab.spring6webapp.repository.AuthorRepository;
import edu.study.lab.spring6webapp.repository.BookRepository;
import edu.study.lab.spring6webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setAddress("Chicago St. 123");
        publisher.setName("Pelisou Inc.");
        publisher.setZipCode("09090-521");
        publisher.setState("Chicago");

        Publisher publisherSaved = publisherRepository.save(publisher);
        System.out.println("Publishers count: "+publisherRepository.count());

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

        System.out.println("Books count: " + bookRepository.count());
        System.out.println("Authors count: " + authorRepository.count());

        savedDDD.setPublisher(publisherSaved);
        savedNoEJB.setPublisher(publisherSaved);

        bookRepository.save(savedDDD);
        bookRepository.save(savedNoEJB);

        System.out.println(savedDDD);
        System.out.println(savedNoEJB);

        //System.out.println(publisherRepository.findAll());
    }
}
