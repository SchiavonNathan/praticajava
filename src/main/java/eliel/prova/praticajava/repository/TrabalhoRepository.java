package eliel.prova.praticajava.repository;

import eliel.prova.praticajava.model.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Integer> {
}
