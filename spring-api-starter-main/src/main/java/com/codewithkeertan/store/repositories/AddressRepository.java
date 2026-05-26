package com.codewithkeertan.store.repositories;

import com.codewithkeertan.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}