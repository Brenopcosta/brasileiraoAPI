package com.brasileiraoAPI.repository;

import com.brasileiraoAPI.models.Jogo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JogoRepository extends MongoRepository<Jogo,String> {
}
