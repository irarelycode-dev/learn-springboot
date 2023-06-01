package jpadepth.repositories.manytomany;

import jpadepth.entity.manytomany.courses.ConcordiaStudent;
import org.springframework.data.repository.CrudRepository;

public interface ConcordiaStudentRepository extends CrudRepository<ConcordiaStudent, Long> {
}
