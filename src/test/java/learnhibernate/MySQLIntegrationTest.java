package learnhibernate;

import learnhibernate.domain.Book;
import learnhibernate.domain.BookNatural;
import learnhibernate.repositories.BookNaturalRepository;
import learnhibernate.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ComponentScan(basePackages = {"learnhibernate.bootstrap"})
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookNaturalRepository booknaturalRepository;

    @Test
    @Commit
    void testNaturalPrimaryKeyRepository(){
        long countBefore=booknaturalRepository.count();
        assertThat(countBefore).isEqualTo(0);
        BookNatural book=new BookNatural("integration test","integration test-natural key","integration test-primary keys");
        booknaturalRepository.save(book);
        long countAfter= booknaturalRepository.count();
        assertThat(countAfter).isGreaterThan(countBefore);
    }

    @Test
    void testMySQL(){
        long countBefore=bookRepository.count();
        assertThat(countBefore).isEqualTo(0);
        System.out.println("*****************count before**************:"+countBefore);
        Book tmp=new Book("Life of pie","12345","Pablo",223L);
        bookRepository.save(tmp);
        long countAfter=bookRepository.count();
        System.out.println("*****************count after**************:"+countAfter);
        assertThat(countAfter).isGreaterThan(countBefore);
    }

}
