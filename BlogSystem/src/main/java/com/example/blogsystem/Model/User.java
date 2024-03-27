package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId ;

    @NotEmpty(message = "It must not be empty")
    @Size(min = 5,message ="You must enter at least 5 characters" )
   @Column(columnDefinition = "varchar(20) not null unique")
    private String userName ;

    @NotEmpty(message ="It must not be empty" )
   @Column(columnDefinition = " varchar(10) not null")
    private String password ;

    @NotEmpty(message ="It must not be empty" )
    @Email
    @Column(columnDefinition = " varchar(40) not null unique ")
    private String email;

@Pattern(regexp = "YYYY/MM/DD")
    private LocalDate registrationDate;



}
