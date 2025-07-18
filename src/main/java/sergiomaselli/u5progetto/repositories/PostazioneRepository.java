package sergiomaselli.u5progetto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sergiomaselli.u5progetto.entities.Postazione;
import sergiomaselli.u5progetto.enums.TipoPostazione;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipoPostazioneAndEdificioCitta(TipoPostazione tipoPostazione, String citta);

}


