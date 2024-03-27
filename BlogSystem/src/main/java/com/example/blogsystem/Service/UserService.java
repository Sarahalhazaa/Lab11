package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user) {
        User user1 = userRepository.findUserByUserId(id);
        if(user==null) {
            throw new ApiException("id not found");
        }
        user1.setUserName(user.getUserName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setRegistrationDate(user.getRegistrationDate());
        userRepository.save(user1);

    }

    public void deleteUser(Integer id) {
        User user = userRepository.findUserByUserId(id);
        if (user == null) {
            throw new ApiException("id not found");
        }
        userRepository.delete(user);
    }
    //---------------------------  end CRUD  ---------------------------------

    public List<User> getUsersByRegistrationDate(LocalDate registrationDate) {

        List<User> user = userRepository.findUsersByRegistrationDate(registrationDate);
        if (user == null) {
            throw new ApiException("not found");
        }
        return user;
    }
    public User check(String userName , String password){
        User  user = userRepository.checkuser(userName , password);
        if (user == null) {
            throw new ApiException("not found");
        }
        return user;
    }
}
