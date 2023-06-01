package jpadepth.services;

import jpadepth.entity.manytomany.courses.ConcordiaCourseRating;
import jpadepth.entity.manytomany.courses.ConcordiaCourseRatingKey;

import java.util.List;

public interface ConcordiaCourseRatingService {

    ConcordiaCourseRating findById(ConcordiaCourseRatingKey id);

    void deleteById(ConcordiaCourseRatingKey id);

    ConcordiaCourseRating save(ConcordiaCourseRating rating);

}
