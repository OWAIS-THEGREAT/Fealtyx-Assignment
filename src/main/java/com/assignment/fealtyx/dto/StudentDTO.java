package com.assignment.fealtyx.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentDTO {
    @NotBlank
    private String name;

    @Min(1)
    private int age;

    @Email
    private String email;
}