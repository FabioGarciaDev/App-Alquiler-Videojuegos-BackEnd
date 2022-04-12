package com.usa.ciclo3.ciclo3.web;

import com.usa.ciclo3.ciclo3.Reports.CountClient;
import com.usa.ciclo3.ciclo3.Reports.StatusReservas;
import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Url desde donde el controlador va a ser alcanzado
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    //Peticion GET Consultar todo
    @GetMapping("/all")
    public List<Reservation> getReservations() {
        return reservationService.getAll();
    }

    //Peticion GET Consultar con id
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return reservationService.getReservation(id);
    }

    //Peticion POST Crear
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r) {
        return reservationService.save(r);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservacion) {
        return reservationService.update(reservacion);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return reservationService.deleteReservation(reservationId);
    }

    @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return reservationService.reporteStatusServicio();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
        return reservationService.reporteTiempoServicio(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getClientes(){
        return reservationService.reporteClientesServicio();
    }
}
