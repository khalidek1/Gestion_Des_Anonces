package PFE.Gestion_Des_Anonces.Api.Repositories;

import PFE.Gestion_Des_Anonces.Api.Models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
}
