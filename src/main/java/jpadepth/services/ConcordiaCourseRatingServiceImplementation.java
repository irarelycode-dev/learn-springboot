package jpadepth.services;

import jpadepth.entity.manytomany.courses.ConcordiaCourseRating;
import jpadepth.entity.manytomany.courses.ConcordiaCourseRatingKey;
import jpadepth.repositories.manytomany.ConcordiaCourseRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcordiaCourseRatingServiceImplementation implements ConcordiaCourseRatingService {

    @Autowired
    ConcordiaCourseRatingRepository cCourseRatingRepo;

    @Override
    public ConcordiaCourseRating findById(ConcordiaCourseRatingKey id) {
        return cCourseRatingRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(ConcordiaCourseRatingKey id) {
        cCourseRatingRepo.deleteById(id);
    }

    @Override
    public ConcordiaCourseRating save(ConcordiaCourseRating rating) {
        return cCourseRatingRepo.save(rating);
    }


}
