package com.assignment.fealtyx.service;

import com.assignment.fealtyx.dto.StudentDTO;
import com.assignment.fealtyx.exception.StudentNotFoundException;
import com.assignment.fealtyx.model.Student;
import com.assignment.fealtyx.repository.StudentRepository;
import com.assignment.fealtyx.utils.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    @Autowired
    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Student create(StudentDTO dto) {
        Student student = StudentMapper.toEntity(dto,0);
        return repo.save(student);
    }

    @Override
    public Collection<Student> getAll() {
        return repo.findAll();
    }

    @Override
    public Student getById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public Student update(int id, StudentDTO dto) {
        getById(id);
        Student student = StudentMapper.toEntity(dto, id);
        repo.update(id, student);
        return student;
    }

    @Override
    public void delete(int id) {
        getById(id);
        repo.deleteById(id);
    }
}

