package com.cadastro.animaisdomesticos.repositories;

import com.cadastro.animaisdomesticos.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal,Long> {

    Animal findByNome(String nome);
    Animal findByIdade(Integer idade);
}
