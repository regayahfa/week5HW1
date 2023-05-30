package com.example.week5hw1.MODEL;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Column(columnDefinition = "int default 0")
    private Integer age;
    @Email
    @Column(columnDefinition = "varchar(20) not null ")
    private String email;
    @Column(columnDefinition = "varchar(4) not null")
    private String salary;

@OneToOne(cascade = CascadeType.ALL,mappedBy = "Teacher")
    @PrimaryKeyJoinColumn
@JsonIgnore
@MapsId
    private Address address;
//    @JsonIgnore

@OneToMany(cascade = CascadeType.ALL ,mappedBy ="course" )
@JoinColumn(name = "course", referencedColumnName = "id")
private Set<Course>courseSet;
}
