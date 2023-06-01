package jpadepth.entity.manytomany.courses;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConcordiaCourseRatingKey implements Serializable {
    @Column(name = "student_id")
    Long studentId;

    @Column(name = "course_id")
    Long courseId;

    protected ConcordiaCourseRatingKey() {
    }

    public ConcordiaCourseRatingKey(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConcordiaCourseRatingKey that = (ConcordiaCourseRatingKey) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}