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
    public Jogo(String _id, String equipeMandante_id, String equipeVisitante_id, Integer pontosTimeMandante, Integer pontosTimeVisitante, Date dataEHora, String local, List<Map<String, String>> momentos) {
        this._id = _id;
        this.equipeMandante_id = equipeMandante_id;
        this.equipeVisitante_id = equipeVisitante_id;
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
    public String equipeMandante_id;

    @Getter @Setter
    public String equipeVisitante_id;

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
