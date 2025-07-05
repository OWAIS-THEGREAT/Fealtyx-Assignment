package com.assignment.fealtyx.utils;

import com.assignment.fealtyx.model.Student;

public class PromptBuilder {
    public static String buildStudentSummaryPrompt(Student student) {
        return String.format("""
                Generate a brief and professional summary for the following student:
                Name: %s
                Age: %d
                Email: %s
                """, student.getName(), student.getAge(), student.getEmail());
    }
}

