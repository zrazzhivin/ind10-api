package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student get(@PathVariable("id") Long id) {
        return studentService.get(id);
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping("{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        studentService.delete(id);
    }

    @GetMapping
    public List<Student> getByAge(@RequestParam("age") int age) {
        return studentService.getByAge(age);
    }
}
