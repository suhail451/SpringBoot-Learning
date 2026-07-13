package org.learnspringframework.jobboard.dtos;

public class SkillsResponseDto {

    private String skillName;

    public SkillsResponseDto(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
