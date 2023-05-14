package PFE.Gestion_Des_Anonces.Api.Repositories;

import PFE.Gestion_Des_Anonces.Api.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
