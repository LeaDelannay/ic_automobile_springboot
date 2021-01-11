package com.epsi.ic_automobile.api.repository;

import com.epsi.ic_automobile.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    List<Client> findByEmailAndToken(String email, String token);
}
