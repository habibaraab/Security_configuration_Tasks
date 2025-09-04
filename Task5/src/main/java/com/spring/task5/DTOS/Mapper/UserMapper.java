package com.spring.task5.DTOS.Mapper;


import com.spring.task5.DTOS.UserRequestDto;
import com.spring.task5.DTOS.UserResponseDto;
import com.spring.task5.Model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toUserResponseDto(User user);


    User toUserEntity(UserRequestDto requestDto);

}
