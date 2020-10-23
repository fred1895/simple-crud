package io.fred1895.github.democrud.services;

import io.fred1895.github.democrud.domains.Teacher;
import io.fred1895.github.democrud.resources.exceptions.TeacherNotFoundException;
import io.fred1895.github.democrud.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void saveClient(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public List<Teacher> getClients() {
        return teacherRepository.findAll();
    }

    public Teacher findClientById(Long id) {
        Optional<Teacher> clientOptional = teacherRepository.findById(id);
        return clientOptional.orElseThrow(() -> new TeacherNotFoundException("Cliente com id: " + id + " não encontrado"));
    }

    public void deleteClientById(Long id) {
        teacherRepository.deleteById(id);
    }

    public void update(Long id, Teacher newTeacher) {
        teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setCpf(newTeacher.getCpf());
                    teacher.setNome(newTeacher.getNome());
                    return teacherRepository.save(teacher);
                })
                .orElseThrow(() -> new TeacherNotFoundException("Objeto nao encontrado"));
    }
}
