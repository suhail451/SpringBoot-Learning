package com.codewithkeertan.store.repositories;

import com.codewithkeertan.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}