package learnhibernate.bootstrap;

import learnhibernate.domain.AuthorUuid;
import learnhibernate.domain.BookUuid;
import learnhibernate.repositories.AuthorUuidRepository;
import learnhibernate.repositories.BookRepository;
import learnhibernate.repositories.BookUuidRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorUuidRepository authorUuidRepository;
    private final BookUuidRepository bookUuidRepository;

    public DataInitializer(BookRepository bookRepo,AuthorUuidRepository authorUUidRepo,BookUuidRepository bookUUid){
        this.bookRepository=bookRepo;
        this.authorUuidRepository=authorUUidRepo;
        this.bookUuidRepository=bookUUid;
    }

    @Override
    public void run(String... args) throws Exception{
//        Book bookDDD=new Book("Domain driven design","123","RandomHouse");
//        Book savedDDD=bookRepository.save(bookDDD);
//
//        Book bookSIA=new Book("Spring in action","124","Orielly");
//        Book savedSIA=bookRepository.save(bookSIA);

//        System.out.println("Finding all entries");

        bookRepository.findAll().forEach(book->{
            System.out.println("Book id:"+book.getId());
            System.out.println("Book title:"+book.getTitle());
        });

        AuthorUuid authorTmp=new AuthorUuid();
        authorTmp.setFirstName("elon");
        authorTmp.setLastName("musk");
        AuthorUuid savedAuthor=authorUuidRepository.save(authorTmp);
        System.out.println("Saved author UUID:"+savedAuthor.getId());

        BookUuid bookTmp=new BookUuid();
        bookTmp.setTitle("Lost city of gold");
        bookTmp.setPublisher("John wick doe");
        bookTmp.setIsbn("12345");
        BookUuid savedBook=bookUuidRepository.save(bookTmp);
        System.out.println("Saved book uuid:"+savedBook.getId());


    }

}
