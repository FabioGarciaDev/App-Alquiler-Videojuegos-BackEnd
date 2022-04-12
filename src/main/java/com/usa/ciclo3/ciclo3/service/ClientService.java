package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client c) {
        if (c.getIdClient() == null) {
            return clientRepository.save(c);
        } else {
            Optional<Client> caux = clientRepository.getClient(c.getIdClient());
            if (caux.isEmpty()) {
                return clientRepository.save(c);
            } else {
                return c;
            }
        }
    }

    public Client update(Client cliente){
        if(cliente.getIdClient()!=null){
            Optional<Client> e= clientRepository.getClient(cliente.getIdClient());
            if(!e.isEmpty()){
                if(cliente.getName()!=null){
                    e.get().setName(cliente.getName());
                }
                if(cliente.getAge()!=null){
                    e.get().setAge(cliente.getAge());
                }
                if(cliente.getPassword()!=null){
                    e.get().setPassword(cliente.getPassword());
                }
                clientRepository.save(e.get());
                return e.get();
            }else{
                return cliente;
            }
        }else{
            return cliente;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
