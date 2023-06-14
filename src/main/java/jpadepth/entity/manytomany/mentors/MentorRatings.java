package jpadepth.entity.manytomany.mentors;

import jakarta.persistence.*;

@Entity
@IdClass(RatingsId.class)
public class MentorRatings {

    @Id
    private Long graduateId;

    @Id
    private Long mentorId;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    @MapsId("graduateId")
    @JoinColumn(name = "graduate_id")
    Graduates graduate;

    @ManyToOne
    @MapsId("mentorId")
    @JoinColumn(name = "mentor_id")
    Mentors mentor;

    public MentorRatings(Long graduateId, Long mentorId, String comments) {
        this.graduateId = graduateId;
        this.mentorId = mentorId;
        this.comments = comments;
    }

    public Long getGraduateId() {
        return graduateId;
    }

    public Long getMentorId() {
        return mentorId;
    }

    public String getComments() {
        return comments;
    }

    public void setGraduate(Graduates graduate) {
        this.graduate = graduate;
    }

    public void setMentor(Mentors mentor) {
        this.mentor = mentor;
    }
}
