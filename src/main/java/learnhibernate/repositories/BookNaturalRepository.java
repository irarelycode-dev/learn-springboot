package learnhibernate.repositories;

import learnhibernate.domain.BookNatural;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookNaturalRepository extends JpaRepository<BookNatural,String> {
}
