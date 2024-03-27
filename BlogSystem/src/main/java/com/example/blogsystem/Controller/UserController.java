package com.example.blogsystem.Controller;

import com.example.blogsystem.Api.ApiResponse;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/vi/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/getUser")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.ok().body(new ApiResponse("User added"));

    }
    @PutMapping("/UpdateUser/{id}")
    public ResponseEntity UpdateUser(@PathVariable Integer id, @RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(id,user);

        return ResponseEntity.ok().body(new ApiResponse("User Update"));

    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){

        userService.deleteUser(id);
        return ResponseEntity.ok().body(new ApiResponse("User Deleted"));

    }
    //---------------------------  end CRUD  ---------------------------------

    @GetMapping("/check/{userName}/{password}")
    public ResponseEntity check(@PathVariable String userName ,@PathVariable  String password){
        userService.check(userName, password);
        return ResponseEntity.ok().body(new ApiResponse("users found"));

    }

    @GetMapping("/getUsers/{registrationDate}")
    public ResponseEntity getUsersByRegistrationDate(@PathVariable LocalDate registrationDate ){
        userService.getUsersByRegistrationDate(registrationDate);
        return ResponseEntity.ok().body(new ApiResponse("users found"));

    }
}
