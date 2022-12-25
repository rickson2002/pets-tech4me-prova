package com.java.tec4pets.petsshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.tec4pets.petsshop.model.Pet;
import com.java.tec4pets.petsshop.repository.PetRepository;

@Service
public class PetServicelmpl implements PetService{
    @Autowired
    private PetRepository repositorio;

    @Override
    public List<Pet> obterTodosOsPets() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Pet> obterPetPorId(String id) {
        return repositorio.findById(id);
    }

    @Override
    public void excluirPetPorId(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Pet cadastarPet(Pet pet) {
        return repositorio.save(pet);
    }

    @Override
    public Optional<Pet> atualizarPetPorId(String id, Pet pet) {
        Optional<Pet> retorno = repositorio.findById(id);

        if (retorno.isPresent()) {
        pet.setId(id);
        return Optional.of(repositorio.save(pet));
    
        }else {
            return Optional.empty();
        }

       
    }
    
}
