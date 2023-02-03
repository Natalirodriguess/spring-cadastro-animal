package com.cadastro.animaisdomesticos.controllers;


import com.cadastro.animaisdomesticos.entities.Animal;
import com.cadastro.animaisdomesticos.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository repositorio ;  //preciso instanciar toda vez, um novo repositorio.

    @GetMapping(value = "/encontrar-animais")
    public List<Animal> encontrarAnimais(){
        List<Animal> encontrarNoBancoDeDados = repositorio.findAll();
        return encontrarNoBancoDeDados;
    }

    @PostMapping()
    public Animal cadastraAnimal(@RequestBody Animal animal){
        Animal cadastrandoAnimal = repositorio.save(animal);
        return cadastrandoAnimal;
    }

    @GetMapping(value = "/nome")
    public ResponseEntity<Animal> animalPorNome(@RequestParam String nome){
        return new ResponseEntity<Animal>(repositorio.findByNome(nome), HttpStatus.OK);
    }
    
}