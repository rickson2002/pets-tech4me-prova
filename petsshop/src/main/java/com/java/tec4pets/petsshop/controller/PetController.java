package com.java.tec4pets.petsshop.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.tec4pets.petsshop.model.Pet;
import com.java.tec4pets.petsshop.repository.PetRepository;


@RestController
@RequestMapping("/pets")
public class PetController {

@Autowired
    private PetRepository repositorio;

@PostMapping
 public Pet cadastarPet(@RequestBody Pet pet){
        return repositorio.save(pet);
 }

    @GetMapping
        public List<Pet> obterPets(){
            return repositorio.findAll();
        }

        @GetMapping("/{id}")
        public Optional<Pet>
         obterPet(@PathVariable String id){
            return repositorio.findById(id);
        }

        @DeleteMapping("/{id}")
        public void excluirPet(@PathVariable String id){
                repositorio.deleteById(id);
        }
                

            @PutMapping("/{id}")
            public Pet atualizarPet(@PathVariable String id, @RequestBody Pet pet){
                pet.setId(id);
                return repositorio.save(pet);
            }




        
}
