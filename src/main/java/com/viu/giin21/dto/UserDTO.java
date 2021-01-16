package com.viu.giin21.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class UserDTO {

    private Integer id;

    @NotNull
    @Size(min = 1, max = 10)
    private String username;

    @NotNull
    @Size(min = 4, max = 8)
    private String password;

    @NotNull
    private String role;
}
