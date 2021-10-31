package co.edu.usa.mintic.reto4.repository;

import co.edu.usa.mintic.reto4.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.usa.mintic.reto4.model.Reservation;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    @Query(value = "SELECT COUNT(*) FROM reservations r WHERE creation_date between ?1 and ?2", nativeQuery = true)
    Long countReservationByCreationDateIsBetween(
            @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "SELECT COUNT(*) FROM reservations r WHERE status LIKE 'completed'", nativeQuery = true)
    Long countReservationByStatusIsCompleted();

    @Query(value = "SELECT COUNT(*) FROM reservations r WHERE status LIKE 'cancelled'", nativeQuery = true)
    Long countReservationByStatusIsCancelled();

    @Query(value = "SELECT c FROM Client c INNER JOIN Reservation r ON c.idClient = r.client.idClient AND r.status LIKE 'completed'")
    List<Client> getClientsWithReservationsCompleted();
}
