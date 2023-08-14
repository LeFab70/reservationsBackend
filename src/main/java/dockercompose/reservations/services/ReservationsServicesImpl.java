package dockercompose.reservations.services;

import dockercompose.reservations.entities.Reservation;
import dockercompose.reservations.repositories.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ReservationsServicesImpl implements ReservationsServices{
    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public Reservation createReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    @Override
    public List<Reservation> getAllReservations(){
        return  reservationRepository.findAll();
    }
    @Override
    public Optional<Reservation> getReservationById(Long id){
        return  reservationRepository.findById(id);
    }
    @Override
    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Optional<Reservation> reservationFound=reservationRepository.findById(id);
        if(reservationFound.isPresent()){
            Reservation reservationExisting=reservationFound.get();
            reservationExisting.setPrice(reservationDetails.getPrice());
            reservationExisting.setTitle(reservationDetails.getTitle());
            reservationExisting.setStatus(reservationDetails.getStatus());
            return reservationRepository.save(reservationExisting);
        }
        return null;
    }
}
