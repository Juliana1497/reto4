package com.reto.reto3.service;

import com.reto.reto3.model.CarModel;
import com.reto.reto3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<CarModel> obtener(){
        return carRepository.findAll();
    }
    public List<CarModel> obtenerPorMarca(String brand) {
        return carRepository.findByBrand(brand);
    }
    public List<CarModel> obtenerPorMarcaYAño(String brand, int year) {
        return carRepository.findByBrandAndYear(brand, year);
    }

    public void guardar(CarModel car){
        carRepository.save(car);
    }

    public void eliminar(int id){
        carRepository.deleteById(id);
    }

    public void actualizar(CarModel car){
        if(carRepository.existsById(car.getIdCar())){
            CarModel carActual = carRepository.findById(car.getIdCar()).get();
            carActual.setName(car.getName());
            carActual.setBrand(car.getBrand());
            carActual.setYear(car.getYear());
            carActual.setDescription(car.getDescription());
            carRepository.save(carActual);
        }
    }

    public Optional<CarModel> obtenerPorId(int id) {
        return carRepository.findById(id);
    }
}
