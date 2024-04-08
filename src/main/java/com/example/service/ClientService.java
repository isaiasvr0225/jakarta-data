package com.example.service;

import com.example.dao.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> findAll();

    ClientDto findById(Long id);

    void save(ClientDto clientDto);

    void delete(Long id);
}
