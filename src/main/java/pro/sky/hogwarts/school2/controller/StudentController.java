package pro.sky.hogwarts.school2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.hogwarts.school2.model.Student;
import pro.sky.hogwarts.school2.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("{id}")
    public Student getInfo(@PathVariable long id) {
        return studentService.findStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student); // добали студента в список
    }
    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deletedStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/byAge") // localhost:8080/student/byAge?age=15
    public Collection<Student> byAge(@RequestParam int age) {
        return studentService.filterByAge(age);
    }
    @GetMapping("/byName")
    public  Collection<Student> byName(@RequestParam String name) {
        return studentService.filterByName(name);
    }
    @GetMapping("/byAll")
    public Collection<String> byAll (){
        return studentService.filterAllStudent();
    }
    @GetMapping("/byAgeBetween")
    public  Collection<Student> byAgeBetween(@RequestParam int min, @RequestParam int max) {
        return studentService.filterByAgeBetween(min, max);
    }

}