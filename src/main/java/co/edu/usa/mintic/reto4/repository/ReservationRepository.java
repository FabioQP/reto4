package co.edu.usa.mintic.reto4.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.mintic.reto4.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
}
