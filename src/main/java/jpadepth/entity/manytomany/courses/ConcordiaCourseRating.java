package jpadepth.entity.manytomany.courses;

import jakarta.persistence.*;

@Entity
public class ConcordiaCourseRating {
    @EmbeddedId
    ConcordiaCourseRatingKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    ConcordiaStudent student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    ConcordiaCourse course;

    private String comments;

    protected ConcordiaCourseRating() {
    }

    public ConcordiaCourseRating(ConcordiaCourseRatingKey id,  String comments) {
        this.id = id;
        this.comments = comments;
    }

    public ConcordiaStudent getStudent() {
        return student;
    }

    public void setStudent(ConcordiaStudent student) {
        this.student = student;
    }

    public ConcordiaCourse getCourse() {
        return course;
    }

    public void setCourse(ConcordiaCourse course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "ConcordiaCourseRating{" +
                "id=" + id +
                ", comments='" + comments + '\'' +
                '}';
    }
}
