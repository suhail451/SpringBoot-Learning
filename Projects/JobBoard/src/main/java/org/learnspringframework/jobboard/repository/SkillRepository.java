package org.learnspringframework.jobboard.repository;

import org.learnspringframework.jobboard.entities.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skills, Long> {

     Optional<Skills> findBySkillNameIgnoreCase(String Name);

     Boolean existsSkillsBySkillNameIgnoreCase(String Name);

}
