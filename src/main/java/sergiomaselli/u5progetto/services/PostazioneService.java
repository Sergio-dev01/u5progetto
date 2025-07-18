package sergiomaselli.u5progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sergiomaselli.u5progetto.entities.Postazione;
import sergiomaselli.u5progetto.enums.TipoPostazione;
import sergiomaselli.u5progetto.exceptions.NotFoundException;
import sergiomaselli.u5progetto.repositories.PostazioneRepository;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> findAll() {
        return postazioneRepository.findAll();
    }

    public Postazione findById(Long id) {
        return postazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Postazione save(Postazione p) {
        return postazioneRepository.save(p);
    }

    public List<Postazione> findByTipoPostazioneAndCitta(TipoPostazione tipoPostazione, String citta) {
        return postazioneRepository.findByTipoPostazioneAndEdificioCitta(tipoPostazione, citta);
    }

}

