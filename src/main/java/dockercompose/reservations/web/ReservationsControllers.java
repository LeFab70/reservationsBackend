package dockercompose.reservations.web;

import dockercompose.reservations.entities.Reservation;
import dockercompose.reservations.repositories.ReservationRepository;
import dockercompose.reservations.services.ReservationsServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationsControllers {
    @Autowired
    private ReservationsServices reservationsServices;

    /////////////// GETTING
    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationsServices.getAllReservations();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id){
        return reservationsServices.getReservationById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteReservationByID(@PathVariable Long id){
         reservationsServices.deleteReservation(id);
    }


    /////////////// Post
    @PostMapping()
    public Reservation createReservation(@RequestBody Reservation reservation){
        return reservationsServices.createReservation(reservation);
    }


    /////////////// Patch
    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id,@RequestBody Reservation reservation){
        return reservationsServices.updateReservation(id,reservation);
    }
}
