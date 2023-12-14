package br.com.sys.users.controller;


import br.com.sys.users.dto.CreateUserDto;
import br.com.sys.users.dto.UpdateUserDto;
import br.com.sys.users.model.User;
import br.com.sys.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

        @Autowired
        private UserService userService;

        @PostMapping("/createUser")
        public ResponseEntity<User> createUser(@RequestBody CreateUserDto data) {
                User createdUser = this.userService.createUser(data);
                return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }

        @GetMapping("/getUser/{id}")
        public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
                User user = this.userService.getUser(id);
                return new ResponseEntity<>(user, HttpStatus.OK);
        }

        @GetMapping("getAllUsers")
        public ResponseEntity<List<User>> getAllUsers() {
                List<User> users = this.userService.getAllUsers();
                return new ResponseEntity<>(users, HttpStatus.OK);
        }

        @PutMapping("updateUser/{id}")
        public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserDto dto){
                User updatedUser = this.userService.updateUser(id, dto);
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }

        @DeleteMapping("deleteUser/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
                this.userService.deleteUser(id);
                return new ResponseEntity<>("User Deleted.", HttpStatus.OK);
        }
}
