package br.com.sys.users.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDto {
        private String username;
        private String password;
        private String Email;
}
