package jpadepth.entity.manytomany.mentors;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Mentors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mentor_name")
    private String name;

    @OneToMany(mappedBy = "mentor")
    List<MentorRatings> mentorRatings=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mentors{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
