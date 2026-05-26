package com.codewithkeertan.store.mappers;

import com.codewithkeertan.store.DTOS.UserDto;
import com.codewithkeertan.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
