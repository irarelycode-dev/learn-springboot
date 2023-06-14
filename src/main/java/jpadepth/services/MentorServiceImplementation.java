package jpadepth.services;

import jpadepth.entity.manytomany.mentors.Mentors;
import jpadepth.repositories.manytomany.graduatesandmentors.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MentorServiceImplementation implements MentorService {

    @Autowired
    MentorRepository mentorRepo;

    @Override
    public List<Mentors> getAllMentors() {
        List<Mentors> mentors = new ArrayList<>();
        mentorRepo.findAll().forEach(mentors::add);
        return mentors;
    }

    @Override
    public Mentors findById(Long id) {
        return mentorRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Mentors mentor) {
        mentorRepo.save(mentor);
    }

    @Override
    public void deleteById(Long id) {
        mentorRepo.deleteById(id);
    }


}
