package com.reto.reto3.service;

import com.reto.reto3.model.AdminModel;
import com.reto.reto3.model.CarModel;
import com.reto.reto3.model.ReservationModel;
import com.reto.reto3.repository.CarRepository;
import com.reto.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<ReservationModel> obtener(){
        return reservationRepository.findAll();
    }
    //Obtener los datos ordenados descendentemente
    public List<ReservationModel> obtenerOrdenadosPorStartDate(){
        return reservationRepository.findAllSortStartDate();
    }

    public void guardar(ReservationModel reservation){
        reservationRepository.save(reservation);
    }

    public void eliminar(int id){
        reservationRepository.deleteById(id);
    }

    public void actualizar(ReservationModel reservation){
        if(reservationRepository.existsById(reservation.getIdReservation())){
            reservationRepository.save(reservation);
        }
    }

    public Optional<ReservationModel> obtenerPorId(int id) {
        return reservationRepository.findById(id);
    }
}
