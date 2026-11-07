package data;

import model.Pozajmica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PozajmicaRepository extends JpaRepository<Pozajmica, Long> {
}
