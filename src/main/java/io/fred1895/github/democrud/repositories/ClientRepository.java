package io.fred1895.github.democrud.repositories;

import io.fred1895.github.democrud.domains.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
