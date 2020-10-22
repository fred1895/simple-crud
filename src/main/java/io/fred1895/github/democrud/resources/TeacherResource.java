package io.fred1895.github.democrud.resources;

import io.fred1895.github.democrud.domains.Teacher;
import io.fred1895.github.democrud.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class TeacherResource {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody Teacher teacher) {
        teacherService.saveClient(teacher);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable Long id) {
        Teacher teacher = teacherService.findClientById(id);
        return ResponseEntity.ok().body(teacher);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllClients() {
        List<Teacher> teachers = teacherService.getClients();
        return ResponseEntity.ok().body(teachers);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        teacherService.deleteClientById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Teacher newTeacher) {
        teacherService.update(id, newTeacher);
    }
}
