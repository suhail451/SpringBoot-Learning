package org.learnspringframework.jobboard.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SkillsRequestDto {

    @NotBlank(message = "Skill Name is Required")
    @Size(min = 2, message = "Skill Name must be At least 2 Character")
    private String skillName;

    public SkillsRequestDto(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
