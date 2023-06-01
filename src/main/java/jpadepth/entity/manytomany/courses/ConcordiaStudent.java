package jpadepth.entity.manytomany.courses;

import jakarta.persistence.*;
import jpadepth.entity.Course;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ConcordiaStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CONCORDIA_STUDENT_COURSE", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> likedCourses = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    List<ConcordiaCourseRating> ratings = new ArrayList<>();

    private String name;

    protected ConcordiaStudent() {
    }

    public ConcordiaStudent(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void addRating(ConcordiaCourseRating rating) {
        this.ratings.add(rating);
    }

    public List<ConcordiaCourseRating> getRatings() {
        return ratings;
    }

    @Override
    public String toString() {
        return "ConcordiaStudent{" + "id=" + id + "'name='" + name + '\'' + '}';
    }
}
