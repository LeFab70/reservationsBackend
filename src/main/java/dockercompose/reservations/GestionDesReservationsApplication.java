package dockercompose.reservations;

import dockercompose.reservations.entities.Reservation;
import dockercompose.reservations.enums.ReservationStatus;
import dockercompose.reservations.repositories.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionDesReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDesReservationsApplication.class, args);
	}

@Bean
	CommandLineRunner commandLineRunner(ReservationRepository reservationRepository){
		return  args -> {
			reservationRepository.save(Reservation.builder().title("res1").price(1200).status(ReservationStatus.CREATED).build());
			reservationRepository.save(Reservation.builder().title("res2").price(1200).status(ReservationStatus.PENDING).build());
			reservationRepository.save(Reservation.builder().title("res3").price(1200).status(ReservationStatus.CONFIRMED).build());
			reservationRepository.save(Reservation.builder().title("res4").price(1200).status(ReservationStatus.PENDING).build());
			reservationRepository.save(Reservation.builder().title("res5").price(1200).status(ReservationStatus.CONFIRMED).build());


		};
	}
}
