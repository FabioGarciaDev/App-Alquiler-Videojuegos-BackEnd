package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    //Metodo que trae todos los elementos de la tabla
    public List<Category> getAll() {
        return (List<Category>) categoryCrudRepository.findAll();  //Se castea findAll a lista (List<Games>)
    }

    //Metodo para traer juego por id
    public Optional<Category> getCategory(int id) {    //Optional maneja los null investigar mas
        return categoryCrudRepository.findById(id);
    }

    //Metodo para guardar un objeto games, tambien sirve para actualizar
    public Category save(Category c) {
        return categoryCrudRepository.save(c);
    }

    //Metodo para borrar un objeto
    public void delete(Category c) {
        categoryCrudRepository.delete(c);
    }
}
/*

 */