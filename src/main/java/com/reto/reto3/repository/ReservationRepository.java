package com.reto.reto3.repository;

import com.reto.reto3.model.AdminModel;
import com.reto.reto3.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel,Integer> {

    //Obtener los datos ordenados descendentemente
    @Query(value = "select * from reservation order by start_date  desc", nativeQuery = true)
    List<ReservationModel> findAllSortStartDate();

    //@Query(value = "select count(*) from reservation where status = ?", nativeQuery = true)

    Integer countByStatus(String status);

    List<ReservationModel> findByStartDateBetween(Date fechaInicial, Date fechaFinal);
}
