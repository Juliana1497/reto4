package com.reto.reto3.service;

import com.reto.reto3.model.AdminModel;
import com.reto.reto3.model.CarModel;
import com.reto.reto3.model.MessageModel;
import com.reto.reto3.repository.CarRepository;
import com.reto.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<MessageModel> obtener(){
        return messageRepository.findAll();
    }

    public void guardar(MessageModel message){
        messageRepository.save(message);
    }

    public void eliminar(int id){
        messageRepository.deleteById(id);
    }

    public void actualizar(MessageModel message){
        if(messageRepository.existsById(message.getIdMessage())){
            messageRepository.save(message);
        }
    }

    public Optional<MessageModel> obtenerPorId(int id) {
        return messageRepository.findById(id);
    }
}
