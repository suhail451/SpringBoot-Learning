package org.learnspringframework.jobboard.service;

import org.learnspringframework.jobboard.dtos.SkillsRequestDto;
import org.learnspringframework.jobboard.dtos.SkillsResponseDto;
import org.learnspringframework.jobboard.entities.Skills;
import org.learnspringframework.jobboard.exceptions.DuplicateSkillException;
import org.learnspringframework.jobboard.exceptions.SkillsNotFoundException;
import org.learnspringframework.jobboard.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {


    private final SkillRepository skillRepository;

    public SkillsService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }


    //    Mappings
    public SkillsResponseDto mapToSkillResponseDto(Skills skill){
        return new SkillsResponseDto(
            skill.getSkillName()
        );
    }

    public Skills mapToSkill(SkillsRequestDto skillsRequestDto){
        return new Skills(
                null,
                skillsRequestDto.getSkillName()
        );
    }


    public List<SkillsResponseDto> getAllSkills() {
        List<Skills> skillsList = skillRepository.findAll();

        List<SkillsResponseDto> skillsResponseDtos = skillsList.stream().map(this::mapToSkillResponseDto).toList();

        if(skillsResponseDtos.isEmpty()){
            throw new SkillsNotFoundException("No any Skill Found Here");
        }

        return skillsResponseDtos;
    }

    public Skills createNewSkill(SkillsRequestDto newSkill) {

        Boolean skillExits = skillRepository.existsSkillsBySkillNameIgnoreCase(newSkill.getSkillName());
        System.out.println(skillExits);
        if(skillExits){
            throw new DuplicateSkillException( newSkill.getSkillName() +" skill is Already Exist");
        }

        Skills skills = mapToSkill(newSkill);
        skillRepository.save(skills);
        return skills;

    }

    public SkillsResponseDto getSkillById(Long id) {
        Skills byId = skillRepository.findById(id).orElseThrow(() -> new SkillsNotFoundException("No any Skill Found Here by Id : "+ id) );
        return mapToSkillResponseDto(byId);
    }

    public void updateSkill(Long id, SkillsRequestDto skillsRequestDto) {

        Skills byId = skillRepository.findById(id).orElseThrow(() -> new SkillsNotFoundException("No any Skill Found Here by Id : "+ id) );

        Boolean skillExist = skillRepository.existsSkillsBySkillNameIgnoreCase(skillsRequestDto.getSkillName());

        if(skillExist){
            throw new DuplicateSkillException( skillsRequestDto.getSkillName() +" skill is Already Exist");
        }

        Skills savedSkills = mapToSkill(skillsRequestDto);
        skillRepository.save(savedSkills);
    }

    public void deleteSkill(Long id) {
        Skills byId = skillRepository.findById(id).orElseThrow(() -> new SkillsNotFoundException("No any Skill Found Here by Id : "+ id) );
        skillRepository.deleteById(byId.getId());
    }
}
