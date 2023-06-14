package jpadepth.repositories.manytomany.graduatesandmentors;

import jpadepth.entity.manytomany.mentors.Mentors;
import org.springframework.data.repository.CrudRepository;

public interface MentorRepository extends CrudRepository<Mentors, Long> {
}
