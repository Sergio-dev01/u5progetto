package sergiomaselli.u5progetto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sergiomaselli.u5progetto.entities.Postazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
}


