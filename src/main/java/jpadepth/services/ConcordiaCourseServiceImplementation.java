package jpadepth.services;

import jpadepth.entity.manytomany.courses.ConcordiaCourse;
import jpadepth.entity.manytomany.courses.ConcordiaStudent;
import jpadepth.repositories.manytomany.ConcordiaCourseRepository;
import jpadepth.repositories.manytomany.ConcordiaStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ConcordiaCourseServiceImplementation implements ConcordiaCourseService {

    @Autowired
    ConcordiaCourseRepository concordiaCourseRepo;

    @Override
    public List<ConcordiaCourse> findAll() {
        Iterable<ConcordiaCourse> iterable = concordiaCourseRepo.findAll();
        final List<ConcordiaCourse> courses = new LinkedList<>();
        iterable.forEach(courses::add);
        return courses;
    }

    @Override
    public ConcordiaCourse findById(Long id) {
        return concordiaCourseRepo.findById(id).orElse(null);
    }

    @Override
    public ConcordiaCourse save(ConcordiaCourse course) {
        return concordiaCourseRepo.save(course);
    }

    @Override
    public void deleteById(Long id) {
        concordiaCourseRepo.deleteById(id);
    }

}
