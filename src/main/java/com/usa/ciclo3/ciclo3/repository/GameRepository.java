
package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Game;
import com.usa.ciclo3.ciclo3.repository.crud.GameCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {

    @Autowired
    private GameCrudRepository gameCrudRepository;

    //Metodo que trae todos los elementos de la tabla
    public List<Game> getAll() {
        return (List<Game>) gameCrudRepository.findAll();  //Se castea findAll a lista (List<Games>)
    }

    //Metodo para traer juego por id
    public Optional<Game> getGames(int id) {    //Optional maneja los null investigar mas
        return gameCrudRepository.findById(id);
    }

    //Metodo para guardar un objeto games, tambien sirve para actualizar
    public Game save(Game p) {
        return gameCrudRepository.save(p);
    }

    //Metodo para borrar game
    public void delete(Game juego) {
        gameCrudRepository.delete(juego);
    }

}
