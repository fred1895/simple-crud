package io.fred1895.github.democrud;

import model.dto.CourseDto;
import model.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCrudApplication implements CommandLineRunner {

	@Autowired
	private CourseService courseService;

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CourseDto courseDto = new CourseDto();
		courseDto.setDisciplina("Ingles");
		courseDto.setDescricao("Linguagens");

		courseService.saveNewCourse(courseDto);

		CourseDto courseDto2 = new CourseDto();
		courseDto2.setDisciplina("Java");
		courseDto2.setDescricao("Informatica");

		courseService.saveNewCourse(courseDto2);

	}
}
