package com.example.educationalplatform.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @NotNull(message = "Name should be not null")
   @Column(columnDefinition = "varchar(20) not null unique")
   private String name;

    @NotNull(message = "Level should be not null")
    @Pattern(regexp ="\\b(Beginner|Intermediate|Advanced)\\b" , message = "The level must be Beginner, Intermediate or Advanced ")
    @Column(columnDefinition = "varchar(15) not null check(level= 'Beginner' or level = 'Intermediate' or level = 'Advanced')")
    private String level;

    @NotNull(message = "Duration in hours should be not null")
    @Min(value = 2 , message = "Duration should be more than or equal 2 hours")
    @Column(columnDefinition = "int not null")
    private Integer durationInHours;

    @NotNull(message = "Description should be not null")
    @Size(min = 5 , message = "description should be more than or equal 5 letters")
    @Column(columnDefinition = "varchar(256) not null")
    private String description;

    @NotNull(message = "Course presenter should be not null")
    @Column(columnDefinition = "varchar(25) not null")
    private String coursePresenter;

    @NotNull(message = "Number of registered should be not null")
    @PositiveOrZero(message =  "Number of registered should be positive")
    @Column(columnDefinition = "int not null")
    private Integer numberOfRegistered;

}
