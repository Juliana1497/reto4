package com.reto.reto3.controller;

import com.reto.reto3.model.CarModel;
import com.reto.reto3.model.GamaModel;
import com.reto.reto3.model.ScoreModel;
import com.reto.reto3.service.GamaService;
import com.reto.reto3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @GetMapping("/all")
    public List<ScoreModel> obtener(){
        return scoreService.obtener();
    }

    @GetMapping("/{id}")
        public Optional<ScoreModel> obtenerPorId(@PathVariable int id){
        return scoreService.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ScoreModel score){
        scoreService.guardar(score);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody ScoreModel score){
        scoreService.actualizar(score);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        scoreService.eliminar(id);
    }
}