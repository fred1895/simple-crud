package io.fred1895.github.democrud.student_management.config;

import io.fred1895.github.democrud.domain.repositories.StudentRepository;
import io.fred1895.github.democrud.student_management.repositories.StudentRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    public StudentRepository studentRepository() {
        return new StudentRepositoryImpl();
    }
}
