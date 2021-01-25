package io.fred1895.github.democrud.teacher_management.config;

import io.fred1895.github.democrud.domain.repositories.TeacherRepository;
import io.fred1895.github.democrud.teacher_management.repositories.TeacherRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherConfig {

    @Bean
    public TeacherRepository teacherRepository() {
        return new TeacherRepositoryImpl();
    }
}
