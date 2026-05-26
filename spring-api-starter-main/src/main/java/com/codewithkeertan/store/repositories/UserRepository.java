package com.codewithkeertan.store.repositories;

import com.codewithkeertan.store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
