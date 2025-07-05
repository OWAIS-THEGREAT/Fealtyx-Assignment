package com.assignment.fealtyx.utils;

import com.assignment.fealtyx.dto.StudentDTO;
import com.assignment.fealtyx.model.Student;

public class StudentMapper {
    public static Student toEntity(StudentDTO dto, int id) {
        return new Student(id, dto.getName(), dto.getAge(), dto.getEmail());
    }
}