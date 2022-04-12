package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Message;
import com.usa.ciclo3.ciclo3.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    //Metodo que trae todos los elementos de la tabla
    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();  //Se castea findAll a lista (List<Games>)
    }

    //Metodo para traer juego por id
    public Optional<Message> getMessage(int id) {    //Optional maneja los null investigar mas
        return messageCrudRepository.findById(id);
    }

    //Metodo para guardar un objeto games, tambien sirve para actualizar
    public Message save(Message c) {
        return messageCrudRepository.save(c);
    }

    //Metodo para borarr mensaje
    public void delete(Message cliente) {
        messageCrudRepository.delete(cliente);
    }

}
