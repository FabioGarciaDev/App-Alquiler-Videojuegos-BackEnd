package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    //Metodo que trae todos los elementos de la tabla
    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    //Metodo para traer cliente por id
    public Optional<Client> getClient(int id) {    //Optional maneja los null investigar mas
        return clientCrudRepository.findById(id);
    }

    //Metodo para guardar un objeto cliente, tambien sirve para actualizar
    public Client save(Client c) {
        return clientCrudRepository.save(c);
    }

    //Metodo para borarr cliente
    public void delete(Client cliente) {
        clientCrudRepository.delete(cliente);
    }

}
