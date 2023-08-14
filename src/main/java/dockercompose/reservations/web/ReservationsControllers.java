package dockercompose.reservations.web;

import dockercompose.reservations.entities.Reservation;
import dockercompose.reservations.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationsControllers {
    private ReservationRepository reservationRepository;
    @GetMapping("/reservations")
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }
}
