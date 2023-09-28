package com.dxc.customermanagementservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dxc.customermanagementservice.mapper.ClientMapper;
import com.dxc.customermanagementservice.model.Client;
import com.dxc.customermanagementservice.model.dto.ClientRequestDTO;
import com.dxc.customermanagementservice.model.dto.ClientResponseDTO;
import com.dxc.customermanagementservice.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public List<ClientResponseDTO> getAllClients() {
        return clientMapper.toListClientResponseDTO(clientRepository.findAll());
    }

    public ClientResponseDTO getClientById(Long id) {
        Client client = getClientOrThrow(id);
        return clientMapper.toClientResponseDTO(client);
    }

    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        Client client = clientMapper.toClient(clientRequestDTO);
        return clientMapper.toClientResponseDTO(clientRepository.save(client));
    }

    public void deleteClient(Long id) {
        getClientOrThrow(id);
        clientRepository.deleteById(id);
    }

    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        Client client = getClientOrThrow(id);
        clientMapper.updateClientFromDTO(clientRequestDTO, client);
        return clientMapper.toClientResponseDTO(clientRepository.save(client));
    }

    private Client getClientOrThrow(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

}
