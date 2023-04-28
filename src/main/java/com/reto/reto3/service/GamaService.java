package com.reto.reto3.service;

import com.reto.reto3.model.AdminModel;
import com.reto.reto3.model.CarModel;
import com.reto.reto3.model.GamaModel;
import com.reto.reto3.repository.CarRepository;
import com.reto.reto3.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {

    @Autowired
    GamaRepository gamaRepository;

    public List<GamaModel> obtener(){
        return gamaRepository.findAll();
    }

    public void guardar(GamaModel car){
        gamaRepository.save(car);
    }

    public void eliminar(int id){
        gamaRepository.deleteById(id);
    }

    public void actualizar(GamaModel gama){
        if(gamaRepository.existsById(gama.getIdGama())){
            gamaRepository.save(gama);
        }
    }

    public Optional<GamaModel> obtenerPorId(int id) {
        return gamaRepository.findById(id);
    }
}
