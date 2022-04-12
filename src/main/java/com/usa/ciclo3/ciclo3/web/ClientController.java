package com.usa.ciclo3.ciclo3.web;

import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Url desde donde el controlador va a ser alcanzado
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {

    @Autowired
    private ClientService clientService;

    //Peticion GET Consultar todo
    @GetMapping("/all")
    public List<Client> getClients() {
        return clientService.getAll();
    }

    //Peticion GET Consultar con id
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("idClient") int id) {
        return clientService.getClient(id);
    }

    //Peticion POST Crear
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client c) {
        return clientService.save(c);
    }

     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client cliente) {
        return clientService.update(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clienteId) {
        return clientService.deleteClient(clienteId);
    }

}
