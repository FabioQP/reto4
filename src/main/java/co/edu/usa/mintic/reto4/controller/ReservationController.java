package co.edu.usa.mintic.reto4.controller;

import co.edu.usa.mintic.reto4.dto.ReservationStatus;
import co.edu.usa.mintic.reto4.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.mintic.reto4.model.Message;
import co.edu.usa.mintic.reto4.model.Reservation;
import co.edu.usa.mintic.reto4.service.MessageService;
import co.edu.usa.mintic.reto4.service.ReservationService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return service.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) { return service.save(reservation); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) { return service.update(reservation); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) { return service.delete(id); }

    @GetMapping("/report-dates/{startDate}/{endDate}")
    public Optional<Long> getReportFromDates(@PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                             @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {


        return service.getReportFromDates(startDate, endDate);
    }

    @GetMapping("/report-status")
    public ReservationStatus getReportStatus() {

        return service.getReportStatus();
    }

    @GetMapping("/report-clients")
    public List<Client> getReportClients() {

        return service.getReportClients();
    }
}
