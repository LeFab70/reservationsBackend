package dockercompose.reservations.services;

import dockercompose.reservations.entities.Reservation;
import dockercompose.reservations.repositories.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationsServicesImpl implements ReservationsServices{
    @Autowired
    private ReservationRepository reservationRepository;
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
}
