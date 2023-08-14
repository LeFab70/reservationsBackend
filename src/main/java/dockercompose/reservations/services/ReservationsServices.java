package dockercompose.reservations.services;

import dockercompose.reservations.entities.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationsServices {
    public List<Reservation> getAllReservations();
    public Optional<Reservation> getReservationById(Long id);
    public void deleteReservation(Long id);
}
