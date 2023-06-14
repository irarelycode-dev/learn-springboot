package jpadepth.repositories.manytomany.graduatesandmentors;

import jpadepth.entity.manytomany.mentors.Graduates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraduateRepository extends CrudRepository<Graduates,Long> {
}
