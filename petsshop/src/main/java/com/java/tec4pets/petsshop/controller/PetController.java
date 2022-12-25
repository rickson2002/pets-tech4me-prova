package com.java.tec4pets.petsshop.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.tec4pets.petsshop.model.Pet;
import com.java.tec4pets.petsshop.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {
@Autowired
private PetService servico;


@PostMapping
 public ResponseEntity<Pet> cadastarPet(@RequestBody Pet pet){
    return new ResponseEntity<>(servico.cadastarPet(pet), HttpStatus.CREATED);
 }

    @GetMapping
        public ResponseEntity<List<Pet>> obterPets(){
            return new ResponseEntity<>(servico.obterTodosOsPets(), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Pet>obterPet(@PathVariable String id){
           Optional<Pet> retorno = servico.obterPetPorId(id);


            if (retorno.isPresent()) {
               return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);

            } else{
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> excluirPet(@PathVariable String id){
               servico.excluirPetPorId(id);
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
                

            @PutMapping("/{id}")
            public ResponseEntity<Pet> atualizarPet(@PathVariable String id, @RequestBody Pet pet){
               Optional<Pet> retorno = servico.atualizarPetPorId(id, pet);

            if (retorno.isPresent()){
               return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
                
            } else { 
               return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
           
        }        
}
