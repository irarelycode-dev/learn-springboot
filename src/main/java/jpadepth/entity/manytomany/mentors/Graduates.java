package jpadepth.entity.manytomany.mentors;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Graduates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @OneToMany(mappedBy = "graduate")
    List<MentorRatings> mentorRatings=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Graduates{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
