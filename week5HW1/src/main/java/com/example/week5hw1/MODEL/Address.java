package com.example.week5hw1.MODEL;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "")
    private String area;
    @Column(columnDefinition = "varchar(20) not null")
    private String street;
   @NotEmpty
    private Integer buildingNumber;

@OneToOne
@MapsId
    @JsonIgnore
    private Teacher teacher;



}
