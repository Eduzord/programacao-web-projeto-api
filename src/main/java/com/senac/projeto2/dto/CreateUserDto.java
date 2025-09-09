package com.senac.projeto2.dto;

import com.senac.projeto2.entity.RoleName;

public record CreateUserDto(

        String email,
        String password,
        RoleName role

) {
}
