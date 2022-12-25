package com.java.tec4pets.petsshop.service;

import java.util.List;
import java.util.Optional;

import com.java.tec4pets.petsshop.model.Pet;


public interface PetService {
    List<Pet> obterTodosOsPets();
    Optional<Pet>obterPetPorId(String id);
    void excluirPetPorId(String id);
    Pet cadastarPet(Pet pet);
    Optional<Pet> atualizarPetPorId(String id, Pet pet);

}
