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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId ;

    @NotNull(message = "It must not be empty")
  // @Column(columnDefinition = "int not null ")
    private Integer categoryId ;

    @NotEmpty(message = "It must not be empty")
    @Size(min = 5 ,message ="You must enter at least 5 characters" )
   // @Column(columnDefinition = "varchar(20) not null ")
    private String title ;

    @NotEmpty(message ="It must not be empty" )
   // @Column(columnDefinition = " varchar not null")
    private String content ;


    @NotNull(message ="It must not be empty" )
  //  @Column(columnDefinition = "int not null ")
    private Integer userId;

    @Pattern(regexp = "YYYY/MM/DD")
    private LocalDate publishDate;

}
