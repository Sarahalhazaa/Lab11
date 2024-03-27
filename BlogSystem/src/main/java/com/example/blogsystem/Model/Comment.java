package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId ;

    @NotNull(message ="It must not be empty" )
  //  @Column(columnDefinition = "int not null ")
    private Integer postId ;


    @NotNull(message ="It must not be empty" )
   // @Column(columnDefinition = "int not null ")
    private Integer userId;

    @NotEmpty(message ="It must not be empty" )
   // @Column(columnDefinition = " varchar not null")
    private String content ;

    @Pattern(regexp = "YYYY/MM/DD")
    private LocalDate commentDate;

}
