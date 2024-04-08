package com.example.repository;

import com.example.entity.Client;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
