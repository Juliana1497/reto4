package com.reto.reto3.controller;

import com.reto.reto3.dbo.ReportClientDbo;
import com.reto.reto3.dbo.ReportStatusDbo;
import com.reto.reto3.model.CarModel;
import com.reto.reto3.model.ClientModel;
import com.reto.reto3.model.GamaModel;
import com.reto.reto3.model.ReservationModel;
import com.reto.reto3.service.ClientService;
import com.reto.reto3.service.GamaService;
import com.reto.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(value = "*")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    ClientService clientService;

    //Obtener los datos ordenados descendentemente
    @GetMapping("/all-order")
    public List<ReservationModel> obtenerOrdenados(){
        return reservationService.obtenerOrdenadosPorStartDate();
    }

    @GetMapping("/all")
    public ReportStatusDbo reportStatus(){
        return reservationService.reportStatus();
    }

    @GetMapping("/report-status")
    public List<ReservationModel> obtener(){
        return reservationService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> obtenerPorId(@PathVariable int id){
        return reservationService.obtenerPorId(id);
    }

    @GetMapping("/report-dates/{fechaInicio}/{fechaFinal}")
    public List<ReservationModel> reportDates(@PathVariable String fechaInicio, @PathVariable String fechaFinal) throws ParseException {
        return reservationService.reportDates(fechaInicio, fechaFinal);
    }

    @GetMapping("/report-clients")
    public List<ReportClientDbo> reportClients(){
        return clientService.reportClients();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ReservationModel reservation){
        reservationService.guardar(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody ReservationModel reservation){
        reservationService.actualizar(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        reservationService.eliminar(id);
    }
}
