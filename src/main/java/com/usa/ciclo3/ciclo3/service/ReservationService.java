package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.Reports.CountClient;
import com.usa.ciclo3.ciclo3.Reports.StatusReservas;
import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r) {
        if (r.getIdReservation() == null) {
            return reservationRepository.save(r);
        } else {
            Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
            if (raux.isEmpty()) {
                return reservationRepository.save(r);
            } else {
                return r;
            }
        }
    }

    public Reservation update(Reservation reservacion) {
        if (reservacion.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservation(reservacion.getIdReservation());
            if (!e.isEmpty()) {

                if (reservacion.getStartDate() != null) {
                    e.get().setStartDate(reservacion.getStartDate());
                }
                if (reservacion.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservacion.getDevolutionDate());
                }
                if (reservacion.getStatus() != null) {
                    e.get().setStatus(reservacion.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            } else {
                return reservacion;
            }
        } else {
            return reservacion;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public StatusReservas reporteStatusServicio() {
        List<Reservation> completed = reservationRepository.ReservacionStatusRepositorio("completed");
        List<Reservation> cancelled = reservationRepository.ReservacionStatusRepositorio("cancelled");

        return new StatusReservas(completed.size(), cancelled.size());
    }

    public List<Reservation> reporteTiempoServicio(String datoA, String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
        try {
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (datoUno.before(datoDos)) {
            return reservationRepository.ReservacionTiempoRepositorio(datoUno, datoDos);
        } else {
            return new ArrayList<>();
        }
    }

    public List<CountClient> reporteClientesServicio() {
        return reservationRepository.getClientesRepositorio();
    }
}
