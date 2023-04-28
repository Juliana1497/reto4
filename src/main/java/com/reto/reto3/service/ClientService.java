package com.reto.reto3.service;

import com.reto.reto3.model.AdminModel;
import com.reto.reto3.model.CarModel;
import com.reto.reto3.model.ClientModel;
import com.reto.reto3.repository.CarRepository;
import com.reto.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientModel> obtener(){
        return clientRepository.findAll();
    }

    public void guardar(ClientModel client){
        clientRepository.save(client);
    }

    public void eliminar(int id){
        clientRepository.deleteById(id);
    }

    public void actualizar(ClientModel client){
        if(clientRepository.existsById(client.getIdClient())){
            clientRepository.save(client);
        }
    }

    public Optional<ClientModel> obtenerPorId(int id) {
        return clientRepository.findById(id);
    }
}
