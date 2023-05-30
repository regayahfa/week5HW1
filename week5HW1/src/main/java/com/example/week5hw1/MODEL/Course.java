package com.example.week5hw1.MODEL;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "not be Empty")
    @Column(columnDefinition = "varchar(20)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName ="id" )
@JsonIgnore
    private Teacher teacher;
}
