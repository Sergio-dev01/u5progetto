package sergiomaselli.u5progetto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sergiomaselli.u5progetto.entities.Prenotazione;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByPostazioneIdAndDataPrenotazione(Long postazioneId, LocalDate dataPrenotazione);

}
