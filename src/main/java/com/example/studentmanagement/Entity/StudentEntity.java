package com.example.studentmanagement.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id ;

    private String name;

    private String classRoom;

    private String gender;

}
