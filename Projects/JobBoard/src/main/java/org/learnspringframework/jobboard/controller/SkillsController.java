package org.learnspringframework.jobboard.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.learnspringframework.jobboard.dtos.SkillsRequestDto;
import org.learnspringframework.jobboard.dtos.SkillsResponseDto;
import org.learnspringframework.jobboard.entities.Skills;
import org.learnspringframework.jobboard.service.SkillsService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.LinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Tag(name = "skills", description = "Api for managing Skills Api")
@RestController
@RequestMapping("jobboard/api/skills")
public class SkillsController {

    private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }


    @Operation(summary ="Retrive All",description = "Retrive All The Skills")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "All Set Api is Working as Needed"),
            @ApiResponse(responseCode = "404", description = "Skill not found"),
            @ApiResponse(responseCode = "500", description = "internal Server Error")
    })
    @GetMapping
    public ResponseEntity<List<SkillsResponseDto>> getAllSkills(){
        return ResponseEntity
                .status(HttpStatusCode.valueOf(200))
                .body(skillsService.getAllSkills());
    }

    @Operation(summary ="Save Skill",description = "Save The Skills")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Create Api is Working as Needed"),
            @ApiResponse(responseCode = "409", description = "Skill Skill Already Exist"),
            @ApiResponse(responseCode = "500", description = "internal Server Error")
    })
    @PostMapping
    public ResponseEntity<SkillsRequestDto> createSkills(SkillsRequestDto newSkill){
        Skills newSkill1 = skillsService.createNewSkill(newSkill);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newSkill1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary ="Retrive By Id",description = "Retrive Skill By The Skills")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "All Set Api is Working as Needed"),
            @ApiResponse(responseCode = "404", description = "Skill not found"),
            @ApiResponse(responseCode = "500", description = "internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<SkillsResponseDto>> getSkillById(@PathVariable Long id){
        SkillsResponseDto skillById = skillsService.getSkillById(id);

//        Create by HATEOAS
        EntityModel<SkillsResponseDto> entityModel = EntityModel.of(skillById);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getAllSkills());
        entityModel.add(linkBuilder.withRel("all-skills"));
        linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(JobsPostingsController.class).getJobs("", "","", ""));
        entityModel.add(linkBuilder.withRel("all-users"));

        return ResponseEntity.ok(entityModel);
    }

    @Operation(summary ="Update Skill",description = "Update The whole Skills")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "All Set Update Api is Working as Needed"),
            @ApiResponse(responseCode = "404", description = "Skill not found"),
            @ApiResponse(responseCode = "409", description = "Skill Skill Already Exist"),
            @ApiResponse(responseCode = "500", description = "internal Server Error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<SkillsRequestDto> updateSkills(@PathVariable Long id, @RequestBody SkillsRequestDto skillsRequestDto){
        skillsService.updateSkill(id, skillsRequestDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary ="Delete By Id",description = "Delete Skill By The Skills")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "All Set Delete Api is Working as Needed"),
            @ApiResponse(responseCode = "404", description = "Skill not found"),
            @ApiResponse(responseCode = "500", description = "internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<SkillsRequestDto> deleteSkills(@PathVariable Long id){
        skillsService.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }


}
