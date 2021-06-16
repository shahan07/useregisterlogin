package com.javatechie.spring.auth.example.controller;

import com.javatechie.spring.auth.example.entity.User;
import com.javatechie.spring.auth.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String login(){
        return "authenticated successfully" ;
    }

    //@GetMapping("/getUsers")
    //public List<User> getUsers(){
      //  return Stream.of(new User(101,"Ronaldo","cr7@gmail.com","07070707070707"),
        //        new User(102,"Messi","lm10@gmail.com","101010101010")).
          //      collect(Collectors.toList());}


    @PostMapping("/register")
    public String register(@RequestBody User user) {
        repository.save(user);
        return "Hi " + user.getName() + " your Registration process successfully completed";
    }

    @GetMapping("/getAllUsers")
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/findUser/{email}")
    public List<User> findUser(@PathVariable String email) {
        return repository.findByEmail(email);
    }

    @DeleteMapping("/cancel/{id}")
    public List<User> cancelRegistration(@PathVariable int id) {
        repository.deleteById(id);
        return repository.findAll();
    }
}
