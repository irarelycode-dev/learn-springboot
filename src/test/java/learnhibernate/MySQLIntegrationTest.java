package learnhibernate;

import learnhibernate.domain.Book;
import learnhibernate.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ComponentScan(basePackages = {"learnhibernate.bootstrap"})
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    void testMySQL(){
        long countBefore=bookRepository.count();
        assertThat(countBefore).isEqualTo(10);
        System.out.println("*****************count before**************:"+countBefore);
        Book tmp=new Book("Life of pie","12345","Pablo");
        bookRepository.save(tmp);
        long countAfter=bookRepository.count();
        System.out.println("*****************count after**************:"+countAfter);
        assertThat(countAfter).isGreaterThan(countBefore);
        assertThat(countAfter).isEqualTo(11);
    }

}
