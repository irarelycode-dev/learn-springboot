package jpadepth.services;

import jpadepth.entity.manytomany.courses.ConcordiaStudent;
import jpadepth.repositories.manytomany.ConcordiaStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConcordiaStudentServiceImplementation implements ConcordiaStudentService {

    @Autowired
    private ConcordiaStudentRepository studentRepo;

    @Override
    public List<ConcordiaStudent> findAll() {
        final List<ConcordiaStudent> students = new LinkedList<>();
        Iterable<ConcordiaStudent> iterable = studentRepo.findAll();
        iterable.forEach(students::add);
        return students;
    }

    @Override
    public ConcordiaStudent findById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public ConcordiaStudent save(ConcordiaStudent student) {
        return studentRepo.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

}
