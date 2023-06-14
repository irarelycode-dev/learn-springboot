package jpadepth.services;

import jpadepth.entity.manytomany.mentors.Graduates;

import java.util.List;

public interface GraduateService {

    List<Graduates> getGraduates();

    Graduates findById(Long id);

    void save(Graduates graduate);

    void deleteById(Long id);

}
