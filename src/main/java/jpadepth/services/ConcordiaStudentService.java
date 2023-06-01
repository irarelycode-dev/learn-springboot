package jpadepth.services;

import jpadepth.entity.manytomany.courses.ConcordiaStudent;

import java.util.*;

public interface ConcordiaStudentService {
    List<ConcordiaStudent> findAll();

    ConcordiaStudent findById(Long id);

    ConcordiaStudent save(ConcordiaStudent student);

    void deleteById(Long id);
}
