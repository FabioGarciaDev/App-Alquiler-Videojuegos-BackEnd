package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.Reports.CountClient;
import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    //Metodo que trae todos los elementos de la tabla
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();  //Se castea findAll a lista (List<Games>)
    }

    //Metodo para traer juego por id
    public Optional<Reservation> getReservation(int id) {    //Optional maneja los null investigar mas
        return reservationCrudRepository.findById(id);
    }

    //Metodo para guardar un objeto games, tambien sirve para actualizar
    public Reservation save(Reservation c) {
        return reservationCrudRepository.save(c);
    }

    //Metodo para borarr reservacion
    public void delete(Reservation reservacion) {
        reservationCrudRepository.delete(reservacion);
    }

    public List<Reservation> ReservacionStatusRepositorio (String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<CountClient> getClientesRepositorio(){
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

}
