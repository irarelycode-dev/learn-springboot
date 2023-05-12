package learnhibernate;

import java.util.*;
import learnhibernate.domain.Book;
import learnhibernate.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Order(1)
    @Test
    void bookTestRepository(){
        long count=bookRepository.count();
        assertThat(count).isEqualTo(0);
    }

    @Commit
    @Order(2)
    @Test
    void contextLoads(){
        long countBefore=bookRepository.count();
        bookRepository.save(new Book("My book","12345","Self"));
        long count=bookRepository.count();
        assertThat(countBefore).isLessThan(count);
    }

    @Order(3)
    @Test
    void testRollback(){
        long count=bookRepository.count();
        assertThat(count).isEqualTo(1);
    }

}
