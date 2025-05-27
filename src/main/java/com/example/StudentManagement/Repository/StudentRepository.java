package com.example.StudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagement.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
    
}
