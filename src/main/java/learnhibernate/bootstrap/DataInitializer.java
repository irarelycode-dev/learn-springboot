package learnhibernate.bootstrap;

import learnhibernate.domain.Book;
import learnhibernate.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepo){
        this.bookRepository=bookRepo;
    }

    @Override
    public void run(String... args) throws Exception{
        Book bookDDD=new Book("Domain driven design","123","RandomHouse");
        Book savedDDD=bookRepository.save(bookDDD);

        Book bookSIA=new Book("Spring in action","124","Orielly");
        Book savedSIA=bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book->{
            System.out.println("Book id:"+book.getId());
            System.out.println("Book title:"+book.getTitle());
        });

    }

}
