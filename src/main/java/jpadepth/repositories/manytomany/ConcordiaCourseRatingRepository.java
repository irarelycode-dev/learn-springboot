package jpadepth.repositories.manytomany;

import jpadepth.entity.manytomany.courses.ConcordiaCourseRating;
import jpadepth.entity.manytomany.courses.ConcordiaCourseRatingKey;
import org.springframework.data.repository.CrudRepository;

public interface ConcordiaCourseRatingRepository extends CrudRepository<ConcordiaCourseRating, ConcordiaCourseRatingKey> {
}
