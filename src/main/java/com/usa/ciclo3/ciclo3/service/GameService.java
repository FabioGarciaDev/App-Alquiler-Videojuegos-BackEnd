package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Game;
import com.usa.ciclo3.ciclo3.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll() {
        return gameRepository.getAll();
    }

    public Optional<Game> getGame(int id) {
        return gameRepository.getGames(id);
    }

    public Game save(Game g) {
        if (g.getId() == null) {
            return gameRepository.save(g);
        } else {
            Optional<Game> gaux = gameRepository.getGames(g.getId());
            if (gaux.isEmpty()) {
                return gameRepository.save(g);
            } else {
                return g;
            }
        }
    }

    public Game update(Game juego){
        if(juego.getId()!=null){
            Optional<Game> e=gameRepository.getGames(juego.getId());
            if(!e.isEmpty()){
                if(juego.getName()!=null){
                    e.get().setName(juego.getName());
                }
                if(juego.getDeveloper()!=null){
                    e.get().setDeveloper(juego.getDeveloper());
                }
                if(juego.getYear()!=null){
                    e.get().setYear(juego.getYear());
                }
                if(juego.getDescription()!=null){
                    e.get().setDescription(juego.getDescription());
                }
                if(juego.getCategory()!=null){
                    e.get().setCategory(juego.getCategory());
                }
                gameRepository.save(e.get());
                return e.get();
            }else{
                return juego;
            }
        }else{
            return juego;
        }
    }

    public boolean deleteJuego(int juegoId) {
        Boolean aBoolean = getGame(juegoId).map(juego -> {
            gameRepository.delete(juego);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
