package com.example.service;

import com.example.dao.ClientDto;
import com.example.entity.Client;
import com.example.mapper.ClientMapper;
import com.example.repository.ClientRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class ClientServiceImpl implements ClientService{

    ClientRepository clientRepository;

    ClientMapper clientMapper;

    @Inject
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientDto> findAll() {

        return clientRepository.findAll()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findById(Long id) {
        return clientMapper.toDto(clientRepository.findById(id)
                                                    .orElseThrow(() -> new RuntimeException("Client not found")));
    }

    @Override
    public void save(ClientDto clientDto) {
        clientRepository.save(clientMapper.toEntity(clientDto));
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
