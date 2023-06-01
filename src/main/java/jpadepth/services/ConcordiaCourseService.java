package jpadepth.services;

import jpadepth.entity.manytomany.courses.ConcordiaCourse;

import java.util.List;

public interface ConcordiaCourseService {
    List<ConcordiaCourse> findAll();

    ConcordiaCourse findById(Long id);

    ConcordiaCourse save(ConcordiaCourse course);

    void deleteById(Long id);
}
