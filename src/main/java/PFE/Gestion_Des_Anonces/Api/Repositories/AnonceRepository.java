package PFE.Gestion_Des_Anonces.Api.Repositories;

import PFE.Gestion_Des_Anonces.Api.Models.Anonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnonceRepository extends JpaRepository<Anonce,Long> {
}
