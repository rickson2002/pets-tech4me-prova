package com.java.tec4pets.petsshop.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.java.tec4pets.petsshop.model.Pet;

public interface PetRepository extends MongoRepository<Pet, String> {

    
    
}
