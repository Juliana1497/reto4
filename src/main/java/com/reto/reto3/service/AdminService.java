package com.reto.reto3.service;

import com.reto.reto3.model.AdminModel;
import com.reto.reto3.model.CarModel;
import com.reto.reto3.repository.AdminRepository;
import com.reto.reto3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<AdminModel> obtener(){
        return adminRepository.findAll();
    }

    public void guardar(AdminModel admin){
        adminRepository.save(admin);
    }

    public void eliminar(int id){
        adminRepository.deleteById(id);
    }

    public void actualizar(AdminModel admin){
        if(adminRepository.existsById(admin.getIdAdmin())){
            adminRepository.save(admin);
        }
    }

    public Optional<AdminModel> obtenerPorId(int id) {
        return adminRepository.findById(id);
    }
}
