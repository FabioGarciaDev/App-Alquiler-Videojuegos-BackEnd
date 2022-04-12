package com.usa.ciclo3.ciclo3.web;

import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Url desde donde el controlador va a ser alcanzado
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Peticion GET Consultar todo
    @GetMapping("/all")
    public List<Category> getCategorys() {
        return categoryService.getAll();
    }

    //Peticion GET Consultar con id
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id) {
        return categoryService.getCategory(id);
    }

    //Peticion POST Crear
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c) {
        return categoryService.save(c);
    }

    //Peticion PUT Modificar
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category categoria) {
        return categoryService.update(categoria);
    }

    //Peticion DELETE Borrar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return categoryService.deleteCategoria(categoriaId);
    }
}
