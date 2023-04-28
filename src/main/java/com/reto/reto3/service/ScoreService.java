package com.reto.reto3.service;

import com.reto.reto3.model.AdminModel;
import com.reto.reto3.model.CarModel;
import com.reto.reto3.model.ScoreModel;
import com.reto.reto3.repository.CarRepository;
import com.reto.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    public List<ScoreModel> obtener(){
        return scoreRepository.findAll();
    }

    public void guardar(ScoreModel score){
        scoreRepository.save(score);
    }

    public void eliminar(int id){
        scoreRepository.deleteById(id);
    }

    public void actualizar(ScoreModel score){
        if(scoreRepository.existsById(score.getIdScore())){
            scoreRepository.save(score);
        }
    }

    public Optional<ScoreModel> obtenerPorId(int id) {
        return scoreRepository.findById(id);
    }
}
