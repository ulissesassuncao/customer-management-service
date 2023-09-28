package com.dxc.customermanagementservice.mapper;

import org.springframework.stereotype.Component;

import com.dxc.customermanagementservice.model.Client;
import com.dxc.customermanagementservice.model.dto.ClientRequestDTO;
import com.dxc.customermanagementservice.model.dto.ClientResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public List<ClientResponseDTO> toListClientResponseDTO(List<Client> clients) {
        return clients.stream()
                .map(this::toClientResponseDTO)
                .collect(Collectors.toList());
    }

    public ClientResponseDTO toClientResponseDTO(Client client) {
        return new ClientResponseDTO(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getBirthDate());
    }

    public Client toClient(ClientRequestDTO clientRequestDTO) {
        return new Client(
                clientRequestDTO.getFirstName(),
                clientRequestDTO.getLastName(),
                clientRequestDTO.getEmail(),
                clientRequestDTO.getCpf(),
                clientRequestDTO.getBirthDate());
    }

    public void updateClientFromDTO(ClientRequestDTO clientRequestDTO, Client client) {
        if (clientRequestDTO.getFirstName() != null) {
            client.setFirstName(clientRequestDTO.getFirstName());
        }
        if (clientRequestDTO.getLastName() != null) {
            client.setLastName(clientRequestDTO.getLastName());
        }
        if (clientRequestDTO.getEmail() != null) {
            client.setEmail(clientRequestDTO.getEmail());
        }
        if (clientRequestDTO.getBirthDate() != null) {
            client.setBirthDate(clientRequestDTO.getBirthDate());
        }
    }
}
