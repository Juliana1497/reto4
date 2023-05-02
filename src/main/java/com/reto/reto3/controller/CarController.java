package com.reto.reto3.controller;

import com.reto.reto3.model.CarModel;
import com.reto.reto3.model.GamaModel;
import com.reto.reto3.service.CarService;
import com.reto.reto3.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Car")
@CrossOrigin(value = "*")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/all")
    public List<CarModel> obtener(){
        return carService.obtener();
    }

    @GetMapping("/{id}")
        public Optional<CarModel> obtenerPorId(@PathVariable int id){
        return carService.obtenerPorId(id);
    }

    //Crear metodo para buscar por un atributo en especifico
    @GetMapping("/all/{brand}")
    public List<CarModel> obtenerPorMarca(@PathVariable String brand){
        return carService.obtenerPorMarca(brand);
    }

    @GetMapping("/all-brand-year")
    public List<CarModel> obtenerPorMarcaYAño(@RequestParam String brand, @RequestParam int year ){
        return carService.obtenerPorMarcaYAño(brand, year);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody CarModel car){
        carService.guardar(car);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody CarModel car){
        carService.actualizar(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        carService.eliminar(id);
    }
}
