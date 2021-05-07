package com.brasileiraoAPI.api;

import com.brasileiraoAPI.models.Equipe;
import com.brasileiraoAPI.models.Jogo;
import com.brasileiraoAPI.repository.EquipeRepository;
import com.brasileiraoAPI.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class Api {

    @Autowired
    public EquipeRepository equipeRepository;

    @Autowired
    public JogoRepository jogoRepository;

    @GetMapping(path = "/equipes")
    public ResponseEntity<List<Equipe>> recuperarTodosOsTimes(){
        List<Equipe> equipes = equipeRepository.findAll();
        if(equipes.isEmpty()){
            return new ResponseEntity<List<Equipe>>(equipes, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Equipe>>(equipes, HttpStatus.OK);
    }

    @GetMapping(path = "/jogos")
    public ResponseEntity<List<Jogo>> recuperarTodosOsJogos(){
        List<Jogo> jogos = jogoRepository.findAll();
        if(jogos.isEmpty()){
            return new ResponseEntity<List<Jogo>>(jogos, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Jogo>>(jogos, HttpStatus.OK);
    }

    @PostMapping(path = "/novoJogo")
    public ResponseEntity<Jogo> inserirNovoJogo(@RequestBody Jogo jogo){
        try {
            jogoRepository.save(jogo);
            return new ResponseEntity<Jogo>(jogo, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Jogo>(jogo, HttpStatus.CONFLICT);
        }
    }

    @PatchMapping(path = "/editarJogo")
    public ResponseEntity<Jogo> editarJogo(@RequestBody Jogo jogo){
       Optional<Jogo> jogoNoBancoOptional = jogoRepository.findById(jogo.get_id());

       if(jogoNoBancoOptional.isPresent()) {
           Jogo jogoNoBanco = jogoNoBancoOptional.get();
           jogoNoBanco.setDataEHora(jogo.getDataEHora());
           jogoNoBanco.setEquipeMandante_id(jogo.getEquipeMandante_id());
           jogoNoBanco.setEquipeVisitante_id(jogo.getEquipeVisitante_id());
           jogoNoBanco.setLocal(jogo.getLocal());
           jogoNoBanco.setMomentos(jogo.getMomentos());
           jogoNoBanco.setPontosTimeMandante(jogo.getPontosTimeMandante());
           jogoNoBanco.setPontosTimeVisitante(jogo.getPontosTimeVisitante());
           jogoRepository.save(jogoNoBanco);
           return new ResponseEntity<Jogo>(jogoNoBanco, HttpStatus.OK);
       }
        return new ResponseEntity<Jogo>(jogo, HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/momento/{_id}")
    public ResponseEntity<String> adicionarMomentos(@RequestBody Map<String,String> momento, @PathVariable("_id") String _id){
        try {
            Jogo jogo = jogoRepository.findById(_id).get();
            jogo.getMomentos().add(momento);
            jogoRepository.save(jogo);
            return new ResponseEntity<String>("Momento adicionado com sucesso!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
