package com.reto.reto3.repository;

import com.reto.reto3.model.AdminModel;
import com.reto.reto3.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarModel,Integer> {
    //Crear metodo para buscar por un atributo en especifico
    List<CarModel> findByBrand(String brand);

    List<CarModel> findByBrandAndYear(String brand, int year);
}
