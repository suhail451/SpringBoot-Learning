package com.codewithkeertan.store.repositories;

import com.codewithkeertan.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}