package jpadepth.entity.manytomany.courses;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class ConcordiaCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @ManyToMany(mappedBy = "likedCourses", fetch = FetchType.LAZY)
    List<ConcordiaStudent> likes = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    List<ConcordiaCourseRating> ratings = new ArrayList<>();

    protected ConcordiaCourse() {
    }

    public ConcordiaCourse(String courseName) {
        this.courseName = courseName;
    }

    public List<ConcordiaStudent> getLikes() {
        return likes;
    }

    public List<ConcordiaCourseRating> getRatings() {
        return ratings;
    }

    public void addRatings(ConcordiaCourseRating rating) {
        ratings.add(rating);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ConcordiaCourse{" + "id=" + id + ", courseName='" + courseName + '\'' + ", ratings=" + ratings + '}';
    }
}
