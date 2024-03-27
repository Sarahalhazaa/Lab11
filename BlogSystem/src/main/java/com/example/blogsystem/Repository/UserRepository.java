package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByUserId(Integer id);
    @Query("select a from User a where a.registrationDate=?1")
    List<User> findUsersByRegistrationDate(LocalDate registrationDate);

    @Query("select a from User a where a.userName=?1 and a.password=?2 ")
    User checkuser(String userName , String password);


}
