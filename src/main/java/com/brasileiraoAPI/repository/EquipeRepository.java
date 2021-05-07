package com.brasileiraoAPI.repository;

import com.brasileiraoAPI.models.Equipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipeRepository extends MongoRepository<Equipe,String> {
}
