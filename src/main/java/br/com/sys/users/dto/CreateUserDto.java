package br.com.sys.users.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
    private String username;
    private String password;
    private String email;
}
