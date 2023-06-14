package jpadepth.services;

import jpadepth.entity.manytomany.mentors.Graduates;
import jpadepth.repositories.manytomany.graduatesandmentors.GraduateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GraduateServiceImplementation implements GraduateService {

    @Autowired
    GraduateRepository repo;

    @Override
    public List<Graduates> getGraduates() {
        List<Graduates> graduates = new ArrayList<>();
        repo.findAll().forEach(graduates::add);
        return graduates;
    }

    @Override
    public Graduates findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void save(Graduates graduate) {
        repo.save(graduate);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
