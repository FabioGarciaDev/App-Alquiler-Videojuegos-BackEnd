package com.usa.ciclo3.ciclo3.web;

import com.usa.ciclo3.ciclo3.model.Message;
import com.usa.ciclo3.ciclo3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Url desde donde el controlador va a ser alcanzado
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService messageService;

    //Peticion GET Consultar todo
    @GetMapping("/all")
    public List<Message> getMessages() {
        return messageService.getAll();
    }

    //Peticion GET Consultar con id
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id) {
        return messageService.getMessage(id);
    }

    //Peticion POST Crear
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message m) {
        return messageService.save(m);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message mensaje) {
        return messageService.update(mensaje);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return messageService.deleteMessage(messageId);
    }
}
