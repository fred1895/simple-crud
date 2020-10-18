package io.fred1895.github.democrud.services;

import io.fred1895.github.democrud.domains.Client;
import io.fred1895.github.democrud.exceptions.ObjectNotFoundException;
import io.fred1895.github.democrud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client findClientById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.orElseThrow(() -> new ObjectNotFoundException("Cliente com id: " + id + " não encontrado"));
    }

    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    public void update(Long id, Client newClient) {
        clientRepository.findById(id)
                .map(client -> {
                    client.setCpf(newClient.getCpf());
                    client.setNome(newClient.getNome());
                    client.setTelefone(newClient.getTelefone());
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }
}
