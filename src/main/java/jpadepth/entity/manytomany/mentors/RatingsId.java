package jpadepth.entity.manytomany.mentors;

import jakarta.persistence.Column;

import java.io.Serializable;

public class RatingsId implements Serializable {
    @Column(name = "graduate_id")
    private Long graduateId;

    @Column(name = "mentor_id")
    private Long mentorId;

    public RatingsId(Long graduateId, Long mentorId) {
        this.graduateId = graduateId;
        this.mentorId = mentorId;
    }
}
