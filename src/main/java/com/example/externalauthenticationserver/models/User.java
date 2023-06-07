package com.example.externalauthenticationserver.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "grade")
    private int grade;

    @Column(name = "student_number")
    private String studentNumber;

    @Column(name = "department_name ")
    private String departmentName;

    @Column(name = "is_admin")
    private Boolean isAdmin;
}
