package com.example.StudentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    

    @Autowired
    StudentService studentService;


    @GetMapping()
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    // @GetMapping
    // public ResponseEntity<List<Student>> getAllStudents() {
    //     List<Student> students = studentService.getAllStudent();
    //     return ResponseEntity.ok(students);
    // }
    

    @PostMapping() 
    public Student saveStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // @PostMapping
    // public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    //     Student createdStudent = studentService.createStudent(student);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    // }
    

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return student;
    }

    


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id, @RequestBody Student updatedStudent ) {
        Student existingStudent = studentService.getStudentById(id);
        if(existingStudent == null) {
            return ResponseEntity.notFound().build();
        }
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourse(updatedStudent.getCourse());

        Student savedStudent = studentService.createStudent(existingStudent);
        return ResponseEntity.ok(savedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }




    
}
