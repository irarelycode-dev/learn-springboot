package jpadepth.repositories.manytomany.graduatesandmentors;

import jpadepth.entity.manytomany.mentors.RatingsId;
import org.springframework.data.repository.CrudRepository;

public interface MentorRatings extends CrudRepository<MentorRatings, RatingsId> {
}
