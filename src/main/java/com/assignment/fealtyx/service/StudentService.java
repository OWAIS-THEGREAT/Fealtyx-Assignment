package com.assignment.fealtyx.service;

import com.assignment.fealtyx.dto.StudentDTO;
import com.assignment.fealtyx.model.Student;

import java.util.Collection;

public interface StudentService {
    Student create(StudentDTO dto);
    Collection<Student> getAll();
    Student getById(int id);
    Student update(int id, StudentDTO dto);
    void delete(int id);
}
