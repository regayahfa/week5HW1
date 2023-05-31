package com.example.week5hw1.MODEL;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(20)")
    private String name;
   // @NotEmpty
    @Column(columnDefinition = "int")
    private Integer age;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) ")
    private String major;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private Set<Course>courseSet;
}
