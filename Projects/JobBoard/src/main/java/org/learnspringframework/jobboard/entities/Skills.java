package org.learnspringframework.jobboard.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "skill")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skill_name", nullable = false, unique = true)
    private String skillName;

    public Skills(Long id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    public Skills() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
