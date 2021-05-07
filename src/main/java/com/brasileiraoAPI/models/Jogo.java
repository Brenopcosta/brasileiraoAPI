package com.brasileiraoAPI.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(collection = "jogos")
public class Jogo {
    public Jogo(String _id, Equipe equipeMandante, Equipe equipeVisitante, Integer pontosTimeMandante, Integer pontosTimeVisitante, Date dataEHora, String local, List<Map<String, String>> momentos) {
        this._id = _id;
        this.equipeMandante = equipeMandante;
        this.equipeVisitante = equipeVisitante;
        this.pontosTimeMandante = pontosTimeMandante;
        this.pontosTimeVisitante = pontosTimeVisitante;
        this.dataEHora = dataEHora;
        this.local = local;
        this.momentos = momentos;
    }

    @Getter
    @Setter
    @Id
    private String _id;

    @Getter @Setter
    public Equipe equipeMandante;

    @Getter @Setter
    public Equipe equipeVisitante;

    @Getter @Setter
    public Integer pontosTimeMandante;

    @Getter @Setter
    public Integer pontosTimeVisitante;

    @Getter @Setter
    public Date dataEHora;

    @Getter @Setter
    public String local;

    @Getter @Setter
    public List<Map<String,String>> momentos;

}
