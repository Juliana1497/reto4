package com.reto.reto3.controller;

import com.reto.reto3.model.AdminModel;
import com.reto.reto3.model.CarModel;
import com.reto.reto3.model.GamaModel;
import com.reto.reto3.service.AdminService;
import com.reto.reto3.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(value = "*")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/all")
    public List<AdminModel> obtener(){
        return adminService.obtener();
    }

    @GetMapping("/{id}")
        public Optional<AdminModel> obtenerPorId(@PathVariable int id){
        return adminService.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody AdminModel admin){
        adminService.guardar(admin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody AdminModel admin){
        adminService.actualizar(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        adminService.eliminar(id);
    }
}
