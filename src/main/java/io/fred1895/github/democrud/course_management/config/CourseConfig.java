package io.fred1895.github.democrud.course_management.config;

import io.fred1895.github.democrud.course_management.repositories.CourseRepository;
import io.fred1895.github.democrud.course_management.repositories.CourseRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseConfig {

    @Bean
    public CourseRepository courseRepository() {
        return new CourseRepositoryImpl();
    }

}
