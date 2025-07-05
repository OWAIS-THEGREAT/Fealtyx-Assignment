package com.assignment.fealtyx.controller;

import com.assignment.fealtyx.dto.StudentDTO;
import com.assignment.fealtyx.model.Student;
import com.assignment.fealtyx.service.OllamaService;
import com.assignment.fealtyx.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private OllamaService ollamaService;

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody StudentDTO dto) {
        return new ResponseEntity<>(studentService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable int id, @Valid @RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/summary")
    public ResponseEntity<String> getSummary(@PathVariable int id) {
        Student student = studentService.getById(id);
        String summary = ollamaService.getSummary(student);
        return ResponseEntity.ok(summary);
    }
}

