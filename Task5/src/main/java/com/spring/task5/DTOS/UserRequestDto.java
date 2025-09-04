package com.spring.task5.DTOS;


import com.spring.task5.Enum.Role;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private Role role;
    
    private String email;
    private String password;



}
