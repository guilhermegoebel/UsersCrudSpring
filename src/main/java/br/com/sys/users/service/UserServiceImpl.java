package br.com.sys.users.service;


import br.com.sys.users.dto.CreateUserDto;
import br.com.sys.users.dto.UpdateUserDto;
import br.com.sys.users.model.User;
import br.com.sys.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService{
        @Autowired
        private UserRepository userRepository;

        public User createUser(CreateUserDto dto) {

                User user = new User();

                user.setUsername(dto.getUsername());
                user.setEmail(dto.getEmail());
                user.setPassword(dto.getPassword());

                return  this.userRepository.save(user);
        }

        public User getUser(Long id) {
                Optional<User> optionalUser = this.userRepository.findById(id);
                return optionalUser.orElse(null);
        }

        public List<User> getAllUsers(){
                return this.userRepository.findAll();
        }

        public User updateUser(Long id, UpdateUserDto dto){
                User user = this.userRepository.findById(id).orElseThrow(NoSuchElementException::new);

                if(dto.getUsername() != null){
                        user.setUsername(dto.getUsername());
                }

                if(dto.getEmail() != null){
                        user.setEmail(dto.getEmail());
                }

                if(dto.getPassword() != null){
                        user.setPassword(dto.getPassword());
                }

                return this.userRepository.save(user);
        }

        public void deleteUser(Long id){
                userRepository.deleteById(id);
        }
}
