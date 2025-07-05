package com.assignment.fealtyx.repository;

import com.assignment.fealtyx.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class StudentRepository {
    private final Map<Integer, Student> studentMap = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger();

    public Student save(Student student) {
        int id = idCounter.incrementAndGet();
        student.setId(id);
        studentMap.put(id, student);
        return student;
    }

    public Collection<Student> findAll() {
        return studentMap.values();
    }

    public Optional<Student> findById(int id) {
        return Optional.ofNullable(studentMap.get(id));
    }

    public void deleteById(int id) {
        studentMap.remove(id);
    }

    public void update(int id, Student student) {
        student.setId(id);
        studentMap.put(id, student);
    }
}

