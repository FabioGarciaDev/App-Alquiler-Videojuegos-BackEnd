package com.usa.ciclo3.ciclo3.web;


import com.usa.ciclo3.ciclo3.model.Game;
import com.usa.ciclo3.ciclo3.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Game") //Url desde donde el controlador va a ser alcanzado
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/all")     //Peticion GET Consultar
    public List<Game> getGames() {
        return gameService.getAll();
    }

    @GetMapping("/{id}")       //Peticion GET con id
    public Optional<Game> getGame(@PathVariable("id") int id) {
        return gameService.getGame(id);
    }

    @PostMapping("/save")       //Peticion POST Crear
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody Game g) {
        return gameService.save(g);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Game update(@RequestBody Game finca) {
        return gameService.update(finca);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int juegoId) {
        return gameService.deleteJuego(juegoId);
    }
}
