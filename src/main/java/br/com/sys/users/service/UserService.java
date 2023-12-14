package br.com.sys.users.service;

import br.com.sys.users.dto.CreateUserDto;
import br.com.sys.users.dto.UpdateUserDto;
import br.com.sys.users.model.User;

import java.util.List;

public interface UserService {
        User createUser(CreateUserDto dto);

        User getUser(Long id);

        List<User> getAllUsers();

        User updateUser(Long id, UpdateUserDto dto);

        void deleteUser(Long id);
}
