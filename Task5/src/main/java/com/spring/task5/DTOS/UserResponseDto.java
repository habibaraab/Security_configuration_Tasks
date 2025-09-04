package com.spring.task5.DTOS;


import com.spring.task5.Enum.Role;
import jdk.jfr.DataAmount;
import lombok.*;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private int id;
    private String name;
    private String email;

    private Role role;
}
