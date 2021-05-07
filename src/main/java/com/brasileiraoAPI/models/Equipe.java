package com.brasileiraoAPI.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;


@Document(collection = "times")
public class Equipe {

    public Equipe(String _id, String nome, String escudoDoTime_url){
        this._id = _id;
        this.nome = nome;
        this.escudoDoTime_url = escudoDoTime_url;
    }

    @Getter @Setter
    @Id
    public String _id;

    @Getter @Setter
    public String nome;

    @Getter @Setter
    public String escudoDoTime_url;
}
