package jpadepth.repositories.manytomany;

import jpadepth.entity.manytomany.courses.ConcordiaCourse;
import org.springframework.data.repository.CrudRepository;

public interface ConcordiaCourseRepository extends CrudRepository<ConcordiaCourse, Long> {
}
