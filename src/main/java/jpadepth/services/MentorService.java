package jpadepth.services;

import jpadepth.entity.manytomany.mentors.Mentors;

import java.util.List;

public interface MentorService {

    List<Mentors> getAllMentors();

    Mentors findById(Long id);

    void save(Mentors mentor);

    void deleteById(Long id);

}
